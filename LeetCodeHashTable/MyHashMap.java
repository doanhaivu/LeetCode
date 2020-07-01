package LeetCode.LeetCodeHashTable;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyHashMap {
    int[][] buckets = new int[1000][1000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0 ; j < buckets[0].length; j++) {
                buckets[i][j] = -1;
            }
        }
    }

    public int getBucket(int key) {
        return key%1000;
    }

    public int getIndexInBucket(int key) {
        return key/1000;
    }

    public boolean checkKey(int key) {
        return key >= 0 && key <= 999;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(key);
        if (checkKey(bucket) && checkKey(indexInBucket))
            buckets[bucket][indexInBucket] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(key);
        if (checkKey(bucket) && checkKey(indexInBucket))
            return buckets[bucket][indexInBucket];
        else return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(key);
        if (checkKey(bucket) && checkKey(indexInBucket))
            buckets[bucket][indexInBucket] = -1;
    }

    @Test
    public void test() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        assertThat(hashMap.get(1), is(1));            // returns 1
        assertThat(hashMap.get(3), is(-1));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        assertThat(hashMap.get(2), is(1));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        assertThat(hashMap.get(2), is(-1));            // returns -1 (not found)
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
