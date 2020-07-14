package LeetCode.HackerRank;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IceCreamParlor {

    public int[] whatFlavors(int[] cost, int money) {
        Map<Integer, ArrayList<Integer>> aMap = new HashMap<>();

        int[] ret = new int[2];
        ArrayList<Integer> tmp;
        for (int i = 0; i < cost.length; i++) {
            if (aMap.containsKey(cost[i])) {
                tmp = aMap.get(cost[i]);
            } else {
                tmp = new ArrayList<>();
            }
            tmp.add(i+1);
            aMap.put(cost[i], tmp);
        }
        Iterator<Integer> anIt = aMap.keySet().iterator();

        int firstIndex = 0;
        int secondIndex = 0;
        ArrayList<Integer> firstIndexes;
        ArrayList<Integer> secondIndexes;
        int aValue;
        while(anIt.hasNext()) {
            aValue = anIt.next();
            if (aMap.containsKey(money-aValue)) {
                firstIndexes = aMap.get(aValue);
                secondIndexes = aMap.get(money-aValue);
                for (Integer i:firstIndexes) {
                    for (Integer j:secondIndexes) {
                        if (i != j) {
                            firstIndex = i < j?i:j;
                            secondIndex = i < j?j:i;
                            break;
                        }
                    }
                }

            }

        }
        ret[0] = firstIndex;
        ret[1] = secondIndex;

        System.out.println(ret[0] +" "+ ret[1]);
        return ret;
    }

    @Test
    public void test() {
        int[] cost = new int[] {1, 4, 5, 3, 2};
        int[] expected = new int[] {1, 4};
        assertThat(whatFlavors(cost, 4), is(expected));

        cost = new int[] {2, 2, 4, 3};
        expected = new int[] {1, 2};
        assertThat(whatFlavors(cost, 4), is(expected));
    }
}
