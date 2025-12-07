import java.util.*;

// 边结点类
class EdgeNode {
    int adjvex;     // 邻接顶点下标
    int weight;     // 权值
    EdgeNode next;  // 下一条边

    public EdgeNode(int adjvex, int weight) {
        this.adjvex = adjvex;
        this.weight = weight;
        this.next = null;
    }
}

// 顶点结点类
class VertexNode {
    int data;          // 顶点信息
    EdgeNode first;    // 第一条边

    public VertexNode(int data) {
        this.data = data;
        this.first = null;
    }
}

// 邻接表类
public class AdjGraphClass {
    static final int INF = Integer.MAX_VALUE;
    private VertexNode[] adjList;  // 邻接表
    private int n;                 // 顶点数
    private int e;                 // 边数

    // 创建邻接表图
    public void CreateAdjGraph(int[][] a, int n, int e) {
        this.n = n;
        this.e = e;
        adjList = new VertexNode[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new VertexNode(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i][j] != 0 && a[i][j] != INF) {
                    // 无向图，添加两条边
                    addEdge(i, j, a[i][j]);
                    addEdge(j, i, a[i][j]);
                }
            }
        }
    }

    // 添加边
    private void addEdge(int u, int v, int weight) {
        EdgeNode edge = new EdgeNode(v, weight);
        edge.next = adjList[u].first;
        adjList[u].first = edge;
    }

    // 打印邻接表
    public void DispAdjGraph() {
        System.out.println("邻接表:");
        for (int i = 0; i < n; i++) {
            System.out.print("顶点" + i + ": ");
            EdgeNode p = adjList[i].first;
            while (p != null) {
                System.out.print("-> " + p.adjvex + "(" + p.weight + ") ");
                p = p.next;
            }
            System.out.println();
        }
    }

    // 深度优先遍历（递归）
    private void DFS(int v, boolean[] visited) {
        System.out.print(v + " ");
        visited[v] = true;
        EdgeNode p = adjList[v].first;
        while (p != null) {
            if (!visited[p.adjvex]) {
                DFS(p.adjvex, visited);
            }
            p = p.next;
        }
    }

    // 深度优先遍历（入口）
    public void DFS(int v) {
        boolean[] visited = new boolean[n];
        System.out.print("DFS from " + v + ": ");
        DFS(v, visited);
        System.out.println();
    }

    // 广度优先遍历
    public void BFS(int v) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        System.out.print("BFS from " + v + ": ");
        visited[v] = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            EdgeNode p = adjList[cur].first;
            while (p != null) {
                if (!visited[p.adjvex]) {
                    visited[p.adjvex] = true;
                    queue.offer(p.adjvex);
                }
                p = p.next;
            }
        }
        System.out.println();
    }
}

