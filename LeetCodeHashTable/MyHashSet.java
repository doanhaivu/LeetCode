package LeetCode.LeetCodeHashTable;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class MyHashSet {
    int[][] buckets = new int[1000][1000];
    /** Initialize your data structure here. */
    public MyHashSet() {
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

    public void add(int key) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(key);
        if (checkKey(bucket) && checkKey(indexInBucket))
            buckets[bucket][indexInBucket] = key;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(key);
        if (checkKey(bucket) && checkKey(indexInBucket))
            buckets[bucket][indexInBucket] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int indexInBucket = getIndexInBucket(key);
        if (checkKey(bucket) && checkKey(indexInBucket))
            return buckets[bucket][indexInBucket] != -1;
        else return false;
    }

    @Test
    public void test() {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        assertThat(hashSet.contains(1), is(true));    // returns true
        assertThat(hashSet.contains(3), is(false));    // returns false (not found)
        hashSet.add(2);
        assertThat(hashSet.contains(2), is(true));    // returns true
        hashSet.remove(2);
        assertThat(hashSet.contains(2), is(false));    // returns false (already removed)
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
