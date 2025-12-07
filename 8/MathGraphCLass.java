import java.util.*;

public class MathGraphCLass {
    static final int INF = Integer.MAX_VALUE;
    private int[][] mat;
    private int n;
    private int e;

    public void CreatMatGraph(int [][] a,int n,int e){
        this.n = n;
        this.e = e;
        mat = new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = a[i][j];
            }
        }
    }

    public void DisMatGraph(){
        System.out.println("邻接矩阵：");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == INF){
                    System.out.print("INF\t");
                }else{
                    System.out.print(mat[i][j]+"\t");
                }
            }
            System.out.println();
        }
    }

    //深度优先遍历
    public void DFS(int v,boolean[] visited){
        System.out.print(v+"  ");
        visited[v]=true;
        for(int i=0;i<n;i++){
            if(mat[v][i]!=INF && mat[v][i] !=0 && !visited[i]){
                DFS(i,visited);
            }
        }
    }

    public void DFS(int v){
        boolean [] visited = new boolean[n];
        System.out.print("DFS from"+v+":  ");
        DFS(v,visited);
        System.out.println();
    }

    //广度优先遍历
    public void BFS(int v){
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        System.out.print("BFS from:"+v+":  ");
        visited[v]=true;
        queue.offer(v);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur+" ");
            for(int i=0;i<n;i++){
                if(mat[cur][i]!=INF && mat[cur][i]!=0 && !visited[i]){
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }



}
