public class AdjGraphClassDemo {
    public static void main(String[] args) {
        AdjGraphClass adj = new AdjGraphClass();
        int INF = 65535;
        int[][] a = new int[][] {
                { 0, 5, INF, 7, 2 },
                { 5, 0, 3, 10, INF },
                { INF, 3, 0, 3, 4 },
                { 7, 10, 3, 0, 8 },
                { 2, INF, 4, 8, 0 }
        };
        adj.CreateAdjGraph(a, 5, 8);
        adj.DispAdjGraph();
    }
}