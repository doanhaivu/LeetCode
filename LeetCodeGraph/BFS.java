package LeetCode.LeetCodeGraph;

import LeetCode.LeetCodeGraph.Graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BFS extends Graph {

    public String bfs(int start) {
        LinkedList<Integer> aQueue = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        StringBuilder bd = new StringBuilder();

        visited[start] = true;
        bd.append(vertexList[start].label);
        aQueue.offer(start);

        while (!aQueue.isEmpty()) {
            int curr = aQueue.pop();
            int adj;
            while ((adj = getAdjUnvisited(curr, visited)) != -1) {
                visited[adj] = true;
                bd.append(vertexList[adj].label);
                aQueue.offer(adj);
            }
        }

        return bd.toString();
    }

    public String mst_bfs(int start) {
        LinkedList<Integer> aQueue = new LinkedList<>();
        boolean[] visited = new boolean[vertexCount];
        StringBuilder bd = new StringBuilder();

        visited[start] = true;
        aQueue.offer(start);

        while (!aQueue.isEmpty()) {
            int curr = aQueue.pop();
            int adj;
            while ((adj = getAdjUnvisited(curr, visited)) != -1) {
                bd.append(vertexList[curr].label);
                bd.append(vertexList[adj].label);
                bd.append(" ");
                visited[adj] = true;
                aQueue.offer(adj);
            }
        }
        return bd.toString();
    }

    @Test
    public void testDFS() {
        BFS myGraph = new BFS();

        myGraph.addVertex('A');//0
        myGraph.addVertex('B');//1
        myGraph.addVertex('C');//2
        myGraph.addVertex('D');//3
        myGraph.addVertex('E');//4
        myGraph.addVertex('F');//5
        myGraph.addVertex('G');//6
        myGraph.addVertex('H');//7
        myGraph.addVertex('I');//8

        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,3);
        myGraph.addEdge(0,4);
        myGraph.addEdge(1,5);
        myGraph.addEdge(5,7);
        myGraph.addEdge(3,6);
        myGraph.addEdge(6,8);

        assertThat(myGraph.bfs(0), is("ABCDEFGHI"));
    }

    @Test
    public void testMST() {
        BFS myGraph = new BFS();

        myGraph.addVertex('A');
        myGraph.addVertex('B');
        myGraph.addVertex('C');
        myGraph.addVertex('D');
        myGraph.addVertex('E');

        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,3);
        myGraph.addEdge(0,4);
        myGraph.addEdge(1,2);
        myGraph.addEdge(1,3);
        myGraph.addEdge(1,4);
        myGraph.addEdge(2,3);
        myGraph.addEdge(2,4);
        myGraph.addEdge(3,4);

        System.out.println(myGraph.mst_bfs(0));//AB AC AD AE
    }
}
