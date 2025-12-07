//测试类
public class MathGraphClassDemo{
    static final int INF=Integer.MAX_VALUE;
    public static void main(String[] args){
        MathGraphCLass m = new MathGraphCLass();
        int[][] a = new int[][]{
                {0,8,INF,5,INF},
                {INF,0,3,INF,INF},
                {INF,INF,0,INF,6},
                {INF,INF,9,0,INF},
                {INF,INF,INF,INF,0}
        };
        m.CreatMatGraph(a,5,5);
        m.DisMatGraph();
        m.BFS(0);
        m.DFS(0);
    }
}