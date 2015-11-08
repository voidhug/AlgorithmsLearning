package NoWeight;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by voidhug on 15/11/8.
 */
public class Graph {
    public static final int INFINITY = Integer.MAX_VALUE;
    private HashMap<String, Vertex> vertexMap = new HashMap<String, Vertex>();

    /**
     * 取得对Vertex对象的引用
     */
    private Vertex getVertex(String vertexName) {
        Vertex v = vertexMap.get(vertexName);
        if (v == null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }
        return v;
    }

    /**
     * 将距离初始化
     */
    private void clearAll() {
        for (Iterator<Vertex> itr = vertexMap.values().iterator(); itr.hasNext(); ) {
            itr.next().reset();
        }
    }

    /**
     * 显示实际最短路径
     */
    private void printPath(Vertex dest) {
        if (dest.path != null) {
            printPath(dest.path);
            System.out.print(" to ");
        }
        System.out.print(dest.name);
    }

    /**
     * 添加一条新的边
     */
    public void addEdge(String sourceName, String destName) {
        Vertex v = getVertex(sourceName);
        Vertex w = getVertex(destName);
        v.adj.add(w);
    }


    /**
     * 显示一条路径
     */
    public void printPath(String destName) throws NoSuchElementException {
        System.out.print("To " + destName + ": ");
        Vertex w = vertexMap.get(destName);

        if (w == null) {
            throw new NoSuchElementException("Destination vertex not found");
        } else if (w.dist == INFINITY) {
            System.out.print(destName + " id unreachable!");
        } else {
            printPath(w);
            System.out.println();
        }
    }

    /**
     * 无权最短路径计算
     */
    public void unweighted(String startName) {
        clearAll();
        Vertex start = vertexMap.get(startName);
        if (start == null) {
            throw new NoSuchElementException("Start vertex not found!");
        }
        LinkedList<Vertex> q = new LinkedList<Vertex>();
        q.addLast(start);
        start.dist = 0;

        while (!q.isEmpty()) {
            Vertex v = q.removeFirst();
            for (Iterator<Vertex> itr = v.adj.iterator(); itr.hasNext(); ) {
                Vertex w = itr.next();
                if(w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.path = v;
                    q.addLast(w);
                }
            }
        }
    }
}
