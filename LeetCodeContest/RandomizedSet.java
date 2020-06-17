package LeetCode.LeetCodeContest;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RandomizedSet {
    Map<Integer, Integer> thisMap = new HashMap<>();
    List<Integer> thisList = new ArrayList<>();
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!thisMap.containsKey(val)) {
            thisList.add(val);
            thisMap.put(val, thisList.size()-1);
            return true;
        } else {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!thisMap.containsKey(val))
            return false;
        else {
            Integer index = thisMap.remove(val);
            if (index != thisList.size()-1) {
                thisList.set(index, thisList.get(thisList.size()-1));
                thisList.remove((int)thisList.size()-1);
                thisMap.put(thisList.get(index), index);
            } else
                thisList.remove((int)index);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(thisList.size());
        return thisList.get(index);
    }

    @Test
    public void test() {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        assertThat(randomSet.insert(1), is(true));

        // Returns false as 2 does not exist in the set.
        assertThat(randomSet.remove(2), is(false));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        assertThat(randomSet.insert(2), is(true));

        // getRandom should return either 1 or 2 randomly.
        assertThat(randomSet.getRandom(), allOf(greaterThan(0),lessThan(3)));

        // Removes 1 from the set, returns true. Set now contains [2].
        assertThat(randomSet.remove(1),is(true));

        // 2 was already in the set, so return false.
        assertThat(randomSet.insert(2), is(false));

        // Since 2 is the only number in the set, getRandom always return 2.
        assertThat(randomSet.getRandom(), allOf(greaterThan(1),lessThan(3)));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
