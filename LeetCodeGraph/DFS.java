package LeetCode.LeetCodeGraph;

import LeetCode.LeetCodeGraph.Graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class DFS extends Graph {

    /**
     * calculating distance from capitol to other vertices
     * @return array: index is distance, value is number of vertices at that distance
     */
    public int[] dfs(int start) {
        Stack<Integer> aStack = new Stack<>();

        boolean[] visited = new boolean[vertexCount];
        visited[start] = true;

        displayVertex(start);

        aStack.push(start);

        int count = 0;
        int[] ret = new int[vertexCount];

        while (!aStack.isEmpty()) {
            int adj = getAdjUnvisited(aStack.peek(), visited);
            if (adj != -1) {
                visited[adj] = true;
                displayVertex(adj);
                aStack.push(adj);
                count++;
                ret[count]++;
            } else {
                aStack.pop();
                count--;
            }
        }

        return ret;
    }

    /**
     * minimum spanning tree
     * print edges in dfs traversal order
     * @return
     * @throws Exception
     */
    public void mst_dfs(int start) {
        Stack<Integer> aStack = new Stack<>();
        aStack.push(start);

        boolean[] visited = new boolean[vertexCount];
        visited[start] = true;

        while (!aStack.isEmpty()) {
            int curr = aStack.peek();
            int adj = getAdjUnvisited(curr, visited);
            if (adj != -1) {
                visited[adj] = true;
                displayVertex(curr);
                displayVertex(adj);
                aStack.push(adj);
                System.out.print(" ");
            } else {
                aStack.pop();
            }
        }
    }

    @Test
    public void testDFS() {
        DFS myGraph = new DFS();

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


        System.out.print("DFS: ");//ABFHCDGIE
        myGraph.dfs(0);
        System.out.println();

        int[] retArr = myGraph.dfs(0);
        System.out.println();
        System.out.println("Capitol Distance: "+ Arrays.toString(retArr));
        System.out.println();
    }

    @Test
    public void testMST() {
        DFS myGraph = new DFS();

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

        myGraph.mst_dfs(0);//AB BC CD DE

    }
}
