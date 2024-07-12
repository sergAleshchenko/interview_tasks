package algorithms;

import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Sergei Aleshchenko
 */
public class GraphGoWide {
    private final int MAX_VERTS = 10;
    private VertexDeep[] vertexDeepArray;
    private int[][] adjMat;
    private int nVerts;

    private Queue<Integer> queue;

    public GraphGoWide() {
        vertexDeepArray = new VertexDeep[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        queue = new PriorityQueue<>();
    }

    public void addVertex(char lab) {
        vertexDeepArray[nVerts++] = new VertexDeep(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexDeepArray[v].getLabel());
    }

    public void deepWide() {
        vertexDeepArray[0].setWasVisited(true);
        displayVertex(0);
        queue.add(0);
        int v2;

        while (!queue.isEmpty()) {
            int v = queue.remove();

            while ((v2 = getAdjUnvisitedVertex(v)) != -1) {
                vertexDeepArray[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexDeepArray[j].wasVisited) {
                return j; //возвращает первую найденную вершину
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GraphGoWide graph = new GraphGoWide();
        graph.addVertex('A'); //0
        graph.addVertex('B'); //1
        graph.addVertex('C'); //2
        graph.addVertex('D'); //3
        graph.addVertex('E'); //4
        graph.addVertex('F'); //5
        graph.addVertex('G'); //6

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);

        System.out.println("Visits: ");
        graph.deepWide();
    }
}

@Getter
@Setter
class VertexWide {
    private char label;
    public boolean wasVisited;

    public VertexWide(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}
