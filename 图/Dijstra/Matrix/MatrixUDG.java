package DijkstraMatrix;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by voidhug on 15/11/8.
 * A到B的权值 = B到A的权值
 */
public class MatrixUDG {
    private int mEdgNum;        //边的数量
    private char[] mVexs;       //顶点集合
    private int[][] mMatrix;    //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   //最大值

    /**
     * 创建图（自己输入数据）
     */
    public MatrixUDG() {
        // 输入"顶点数"和"边数"
        System.out.print("input vertex number：");
        int vlen = readInt();
        System.out.print("input edge number");
        int elen = readInt();

        if (vlen < 1 || elen < 1 || (elen > (vlen * (vlen - 1)))) {
            System.out.println("input error: invalid parameters!");
            return ;
        }

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d)：", i);
            mVexs[i] = readChar();
        }

        // 1. 初始化"边"的权值
        mEdgNum = elen;
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (i == j) {
                    mMatrix[i][j] = 0;
                } else {
                    mMatrix[i][j] = INF;
                }
            }
        }

        // 2. 初始化"边"的权值：根据用户的输入进行初始化
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点，结束顶点，权值；
            System.out.printf("edge(%d)：", i);
            char c1 = readChar();       // 读取"起始顶点"
            char c2 = readChar();       // 读取"结束顶点"
            int weight = readInt();     // 读取"权值"

            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            if (p1 == -1 || p2 == -1) {
                System.out.println("input error: invalid edge!");
                return ;
            }

            mMatrix[p1][p2] = weight;
            mMatrix[p2][p1] = weight;
        }
    }

    /**
     * 创建图（用已提供的矩阵）
     *
     * @param vexs 顶点数组
     * @param matrix 矩阵（数据）
     */

    public MatrixUDG(char[] vexs, int[][] matrix) {
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = vexs[i];
        }

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                mMatrix[i][j] = matrix[i][j];
            }
        }

        // 统计"边"
        mEdgNum = 0;
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (mMatrix[i][j] != INF) {
                    mEdgNum++;
                }
            }
        }
    }

    /**
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++) {
            if (mVexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 读取一个输入字符
     */
   private int readInt() {
       Scanner scanner = new Scanner(System.in);
       return scanner.nextInt();
   }

   private char readChar() {
       char ch = '0';
       do {
            try {
                ch = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
       } while (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')));
       return ch;
   }


    /**
     * Dijkstra最短路径
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径
     *
     * @param vs 起始顶点（start vertex）。即，计算"顶点vs"到其他顶点的最短路径
     * @param prev 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点
     * @param dist 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        // flag[i] = true表示"顶点vs"到"顶点i"的最短路径已获取成功
        boolean[] flag = new boolean[mVexs.length];

        // 初始化
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;            // 顶点i的最短路径还没获取到。
            prev[i] = 0;                // 顶点i的前驱顶点为0。
            dist[i] = mMatrix[vs][i];   // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对顶点"vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        // 遍历mVexs.length - 1次；每次找出一个顶点的最短路径。
        int k = 0;
        for (int i = 1; i < mVexs.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找出离vs最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j] == false && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < mVexs.length; j++) {
                int tmp = (mMatrix[k][j] == INF ? INF : (min + mMatrix[k][j]));
                if (flag[j] == false && (tmp < dist[j])) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%c)：\n", mVexs[vs]);
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("  shortest(%c, %c) = %d\n", mVexs[vs], mVexs[i], dist[i]);
        }
    }

   public static void main(String[] args) {
       char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
       int matrix[][] = {
            /*A*/ /*B*/ /*C*/ /*D*/ /*E*/ /*F*/ /*G*/
      /*A*/{  0,   12,  INF,  INF,  INF,   16,   14},
      /*B*/{ 12,    0,   10,  INF,  INF,    7,  INF},
      /*C*/{INF,   10,    0,    3,    5,    6,  INF},
      /*D*/{INF,  INF,    3,    0,    4,  INF,  INF},
      /*E*/{INF,  INF,    5,    4,    0,    2,    8},
      /*F*/{ 16,    7,    6,  INF,    2,    0,    9},
      /*G*/{ 14,  INF,  INF,  INF,    8,    9,    0}
       };
       MatrixUDG pG;

       // 采用已有的图
       pG = new MatrixUDG(vexs, matrix);

       int[] prev = new int[pG.mVexs.length];
       int[] dist = new int[pG.mVexs.length];

       // dijkstra算法获取"第4个顶点"到其他各个顶点的最短位置
       pG.dijkstra(3, prev, dist);
   }
}
