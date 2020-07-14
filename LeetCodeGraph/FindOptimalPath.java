package LeetCode.LeetCodeGraph;

import LeetCode.LeetCodeGraph.Graph.DistanceParent;
import LeetCode.LeetCodeGraph.Graph.Graph;
import org.junit.jupiter.api.Test;

public class FindOptimalPath extends Graph {
    protected DistanceParent longestPath[];

    public FindOptimalPath() {
        longestPath = new DistanceParent[MAX_VERT];
    }

    public int getMax(boolean[] visited) {
        int indexMax = 0;
        int maxDistance = -1;

        for (int i = 1; i < vertexCount; i++) {
            if (!visited[i] && longestPath[i].distance > maxDistance) {
                indexMax = i;
                maxDistance = longestPath[i].distance;
            }
        }
        return indexMax;
    }

    public void adjustPath(int currentVertex, int startToCurrent, boolean[] visited) {
        int column = 1;
        while (column < vertexCount) {
            if (visited[column]) {
                column++;
                continue;
            }

            int startToFringe;

            if (adjMat[currentVertex][column] == 1)
                startToFringe = startToCurrent + vertexList[column].weight;
            else
                startToFringe = startToCurrent;

            int longestPathDistance = longestPath[column].distance;

            if (startToFringe > longestPathDistance) {
                longestPath[column].parent = currentVertex;
                longestPath[column].distance = startToFringe;
            }

            column++;
        }
    }

    public void path() {
        boolean[] visited = new boolean[vertexCount];
        visited[0] = true;
        int visitedCount = 1;

        for (int i = 0; i < vertexCount; i++) {
            int tmpDistance;
            if (i == 0)
                tmpDistance = vertexList[0].weight;
            else if (adjMat[0][i] == 1)
                tmpDistance = vertexList[0].weight + vertexList[i].weight;
            else
                tmpDistance = -1;
            longestPath[i] = new DistanceParent(0, tmpDistance);
        }

        int currentVert;
        int startToCurrent;

        while (visitedCount < vertexCount) {
            int indexMax = getMax(visited);
            int maxDistance = longestPath[indexMax].distance;

            if (maxDistance == -1) {
                break;
            } else {
                currentVert = indexMax;
                startToCurrent = longestPath[indexMax].distance;
            }

            visited[currentVert] = true;
            visitedCount++;
            adjustPath(currentVert, startToCurrent, visited);
        }

        displayPath();
    }

    public int displayPath() {
        int maxValue = -1;
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertexList[i].label + "=");
            if (longestPath[i].distance == -1)
                System.out.print("inf");
            else
                System.out.print(longestPath[i].distance);
            char parent = vertexList[longestPath[i].parent].label;
            System.out.print("(via " + parent + "); ");

            if (maxValue < longestPath[i].distance) {
                maxValue = longestPath[i].distance;
            }
        }

        System.out.println();
        System.out.println("Maximized path value: " + maxValue);
        return maxValue;
    }

    @Test
    public void test() {
        FindOptimalPath theGraph = new FindOptimalPath();

        //NOTE 1: the solution assume that the origin vertex is the first vertex to be added
        //to the graph

        //NOTE 2: we can detect cycle if we encounter a node twice when traverse the graph
        //For example, in DFS we use a stack to hold the nodes already visited
        //When we find a neighbor node of a node we currently standing on, and
        //that neighbor node is also existing in stack, the graph is a cycle


        //NOTE 3:
        //Time complexity: O(V^2) with V is number of vertices,
        // since there are nested while loops on nVerts

        //Space complexity: O(V^2) with V is number of vertices,
        // since this implementation use adjacency matrix

        theGraph.addVertex('A',1);//starting vertex
        theGraph.addVertex('B',2);
        theGraph.addVertex('C',2);
        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 2);

        theGraph.path();
    }
}
