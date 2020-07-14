package LeetCode.LeetCodeGraph.Graph;

public class Graph {
    protected final int MAX_VERT = 20;

    protected Vertex vertexList[];
    protected int adjMat[][];
    protected int vertexCount;

    public Graph() {
        vertexList = new Vertex[MAX_VERT];
        adjMat = new int[MAX_VERT][MAX_VERT];

        vertexCount = 0;

        for (int i = 0; i < MAX_VERT; i++) {
            for (int j = 0; j < MAX_VERT; j++) {
                adjMat[i][j] = -1;
            }
        }
    }

    public void addVertex(char label, int weight) {
        vertexList[vertexCount++] = new Vertex(label, weight);
    }

    public void addVertex(char label) {
        vertexList[vertexCount++] = new Vertex(label, 0);
    }

    public boolean addEdge(int start, int end) {
        if (start < 0 || start >= MAX_VERT || end < 0 || end >= MAX_VERT)
            return false;
        adjMat[start][end] = 1;
        return true;
    }

    public void displayVertex(int i) {
        System.out.print(vertexList[i].label);
    }

    public int getAdjUnvisited(int vertex, boolean[] visited) {
        for (int i = 0; i < MAX_VERT; i++) {
            if (adjMat[vertex][i] == 1 && !visited[i])
                return i;
        }
        return -1;
    }
}
