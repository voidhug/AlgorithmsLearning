package NoWeight;

/**
 * Created by voidhug on 15/11/8.
 */
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(); //构建图
        graph.addEdge("v1", "v2");
        graph.addEdge("v1", "v4");
        graph.addEdge("v2", "v4");
        graph.addEdge("v2", "v5");
        graph.addEdge("v3", "v1");
        graph.addEdge("v3", "v6");
        graph.addEdge("v4", "v3");
        graph.addEdge("v4", "v5");
        graph.addEdge("v4", "v6");
        graph.addEdge("v4", "v7");
        graph.addEdge("v5", "v7");
        graph.addEdge("v7", "v6");

        //以v3为起点计算无权图的最短路径
        graph.unweighted("v3");
        //打印从v3到各个顶点的最短路径
        System.out.println("The shortest path from v3:");
        for (int i = 1; i <= 7; i++) {
            graph.printPath("v" + i);
        }
    }
}
