package NoWeight;

import java.util.LinkedList;

/**
 * Created by voidhug on 15/11/8.
 */
public class Vertex {
    String name; //顶点名称
    LinkedList<Vertex> adj; //相邻顶点
    int dist; //距离
    Vertex path; //最短路径中的前一个顶点

    public Vertex(String name) {
        this.name = name;
        adj = new LinkedList<Vertex>();
        reset();
    }

    public void reset() {
        dist = Graph.INFINITY;
        path = null;
    }
}
