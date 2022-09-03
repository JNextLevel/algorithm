package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2178미로탐색_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }

        int length = bfs(map);
        System.out.println(length);

        br.close();
        System.exit(0);
    }

    static int bfs(int[][] map){
        int answer = 0;

        int[] dh = {0,1,0,-1};
        int[] dw = {1,0,-1,0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,1});
        map[0][0] = 0;

        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == map.length-1 && now[1] == map[0].length-1){
                answer = now[2];
                break;
            }

            for(int i=0;i<4;i++){
                int nh = now[0]+dh[i];
                int nw = now[1]+dw[i];
                if(nh>-1&&nh<map.length&&nw>-1&&nw<map[0].length&&map[nh][nw]==1){
                    q.add(new int[] {nh,nw,now[2]+1});
                    map[nh][nw] = 0;
                }
            }
        }
        return answer;
    }
}
