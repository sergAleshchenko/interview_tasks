package algorithms;

import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

/**
 * @author Sergei Aleshchenko
 */
public class GraphGoDeep {

    private final int MAX_VERTS = 10;
    private VertexDeep[] vertexDeepArray;
    private int[][] adjMat;
    private int nVerts;
    private Stack<Integer> stack;


    public GraphGoDeep() {
        vertexDeepArray = new VertexDeep[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        stack = new Stack<>();
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

    public void deepDive() {
        vertexDeepArray[0].setWasVisited(true);
        displayVertex(0);
        stack.push(0);

        while (!stack.empty()) {
            int v = getAdjUnvisitedVertex(stack.peek());

            if (v == -1) {
                stack.pop();
            } else {
                vertexDeepArray[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < nVerts; i++) {
            vertexDeepArray[i].wasVisited = false;
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexDeepArray[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        GraphGoDeep graph = new GraphGoDeep();
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
        graph.deepDive();
    }
}

@Getter
@Setter
class VertexDeep {
    private char label;
    public boolean wasVisited;

    public VertexDeep(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

