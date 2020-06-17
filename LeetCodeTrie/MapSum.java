package LeetCode.LeetCodeTrie;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MapSum {
    Trie thisTrie;
    /** Initialize your data structure here. */
    public MapSum() {
        thisTrie = new Trie();
    }

    public void insert(String key, int val) {
        thisTrie.insert(key, val);
    }

    public int sum(String prefix) {
        return thisTrie.sum(prefix);
    }

    @Test
    public void test() {
        MapSum obj = new MapSum();
        //obj.insert("apple", 3);
        //assertThat(obj.sum("ap"), is(3));

        //obj.insert("app", 2);
        //assertThat(obj.sum("ap"), is(5));

        //obj.insert("a",3);
        //System.out.println(obj.sum("ap"));
        //obj.insert("b",2);
        //System.out.println(obj.sum("a"));

        //["MapSum", "insert", "sum", "insert", "sum", "sum", "insert", "sum", "sum"]
        //[[], ["aa",3], ["a"], ["aa",2], ["a"], ["aa"], ["aaa", 3], ["aaa"], ["bbb"]]

        obj.insert("aa",3);
        System.out.println(obj.sum("a"));
        obj.insert("aa",2);
        System.out.println(obj.sum("a"));
        System.out.println(obj.sum("aa"));
        obj.insert("aaa",3);
        System.out.println(obj.sum("aaa"));
        System.out.println(obj.sum("bbb"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
