package LeetCode.LeetCodeContest;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomPickWithWeight {

    public int[] weights;

    public RandomPickWithWeight() {
    }

    public int pickIndex() {
        int totalWeight = 0;
        for (int aWeight : weights) {
            totalWeight += aWeight;
        }
        Random rand = new Random();
        int aRand = rand.nextInt(totalWeight)+1;
        //System.out.println("A rand: " + aRand);
        for (int i = 0; i < weights.length; i++) {
            aRand -= weights[i];
            if (aRand <= 0)
                return i;
        }
        return 0;
    }

    @Test
    public void testPickIndex() {
        RandomPickWithWeight rp = new RandomPickWithWeight();
        rp.weights = new int[] {1};

        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());

        rp.weights = new int[] {1, 3};

        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
    }
}
