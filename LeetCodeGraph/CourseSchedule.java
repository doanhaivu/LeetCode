package LeetCode.LeetCodeGraph;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            inDegrees.put(i, 0);
        }

        ArrayList<Integer> tmp;
        for (int i = 0; i < prerequisites.length; i++) {
            if (edges.containsKey(prerequisites[i][0]))
                tmp = edges.get(prerequisites[i][0]);
            else
                tmp = new ArrayList<>();
            tmp.add(prerequisites[i][1]);
            edges.put(prerequisites[i][0], tmp);

            inDegrees.put(prerequisites[i][1], inDegrees.getOrDefault(prerequisites[i][1], 0) + 1);
        }

        LinkedList<Integer> aQueue = new LinkedList<>();
        Iterator<Integer> anIt = inDegrees.keySet().iterator();
        while (anIt.hasNext()) {
            Integer des = anIt.next();
            if (inDegrees.get(des) ==0 ) {
                aQueue.offer(des);
            }
        }

        if (aQueue.size() == 0 && numCourses > 0)
            return false;
        while (!aQueue.isEmpty()) {
            Integer aSource = aQueue.pop();


        }
        return false;
    }

    @Test
    public void test() {
        assertThat(canFinish(2, new int[][]{{1,0}}), is(true));
        assertThat(canFinish(2, new int[][]{{1,0}, {0,1}}), is(false));
    }
}
