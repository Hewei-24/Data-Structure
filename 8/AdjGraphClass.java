class VNode {
    int data;
    ArcNode firstArc;

    public VNode(int data) {
        this.data = data;
        this.firstArc = null;
    }
}

class ArcNode {
    int adjvex;
    int weight;
    ArcNode nextArc;

    public ArcNode(int adjvex, int weight) {
        this.adjvex = adjvex;
        this.weight = weight;
        this.nextArc = null;
    }
}

class AdjGraphClass {
    VNode[] adjlist;
    int n, e;
    final int INF = 65535;

    public void CreateAdjGraph(int[][] a, int n, int e) {
        this.n = n;
        this.e = e;
        adjlist = new VNode[n];
        for (int i = 0; i < n; i++) {
            adjlist[i] = new VNode(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 0 && a[i][j] != INF) {
                    ArcNode arc = new ArcNode(j, a[i][j]);
                    arc.nextArc = adjlist[i].firstArc;
                    adjlist[i].firstArc = arc;
                }
            }
        }
    }

    public void DispAdjGraph() {
        System.out.println("邻接表：");
        for (int i = 0; i < n; i++) {
            System.out.print("[" + i + "]");
            ArcNode p = adjlist[i].firstArc;
            while (p != null) {
                System.out.print(" -> " + p.adjvex + "(" + p.weight + ")");
                p = p.nextArc;
            }
            System.out.println();
        }
    }
}