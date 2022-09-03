package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1260DFS와BFS_hunojung {
    static StringBuilder sb;
    public static void main (String[]z) throws Exception {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1][n2] = true;
            arr[n2][n1] = true;
        }
        sb.append(V+" ");
        dfs(arr,V,new boolean[N+1]);
        sb.append("\n");

        bfs(arr,V,new boolean[N+1]);

        System.out.println(sb);
        br.close();
        System.exit(0);
    }

    static void bfs(boolean[][] arr,int start, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        sb.append(start+" ");
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=1;i<arr.length;i++){
                if(!visited[i] && arr[now][i]){
                    sb.append(i+" ");
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    static void dfs(boolean[][] arr,int start, boolean[] visited){
        visited[start] = true;

        for (int i = 1; i < arr.length; i++) {
            if(!visited[i] && arr[start][i]){
                sb.append(i+" ");
                dfs(arr,i,visited);
            }
        }
    }
}
