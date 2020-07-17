package LeetCode.LeetCodeGraph;

import Common.Utilities;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge:times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        Map<Integer, Integer> distance = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }

        distance.put(K, 0);

        boolean[] visited = new boolean[N+1];

        while(true) {
            int candidateNode = -1;
            int candidateDistance = Integer.MAX_VALUE;

            for (int i = 1; i <=N; i++) {
                if (!visited[i] && distance.get(i) < candidateDistance) {
                    candidateNode = i;
                    candidateDistance = distance.get(i);
                }
            }

            if (candidateNode < 0) break;
            visited[candidateNode] = true;

            if (graph.containsKey(candidateNode)) {
                for (int[] info:graph.get(candidateNode)) {
                    distance.put(info[0], Math.min(distance.get(info[0]), distance.get(candidateNode)+info[1]));
                }
            }
        }

        int ret = 0;
        for (int tmp:distance.values()) {
            if (tmp == Integer.MAX_VALUE)
                return -1;
            ret = Math.max(ret, tmp);
        }
        return ret;
    }

    @Test
    public void test() {
        int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        assertThat(networkDelayTime(times, 4, 2), is(2));
    }
}
