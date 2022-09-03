package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_4963섬의개수_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w==0 && h==0) break;

            int[][] map = new int[h][w]; // 1 , 0
            boolean[][] visited = new boolean[h][w]; // 체크된 부분
            int count = 0; // 섬개수

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1){
                        count++;
                        bfs(map,visited,i,j);
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    static void bfs(int[][] map, boolean[][] visited,int h,int w){
        int[] dh = {0,-1,-1,-1,0,1,1,1};
        int[] dw = {1,1,0,-1,-1,-1,0,1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {h,w});
        visited[h][w] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0;i<8;i++){
                int nh = now[0]+dh[i];
                int nw = now[1]+dw[i];
                if(nh>-1&&nh<map.length&&nw>-1&&nw<map[0].length&&!visited[nh][nw]&&map[nh][nw]==1){
                    q.add(new int[] {nh,nw});
                    visited[nh][nw] = true;
                }
            }
        }
    }
}
