package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_7562나이트의이동_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int l = Integer.parseInt(br.readLine());
            boolean[][] map = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowH = Integer.parseInt(st.nextToken());
            int nowW = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int goalH = Integer.parseInt(st.nextToken());
            int goalW = Integer.parseInt(st.nextToken());
            sb.append(bfs(map,nowH,nowW,goalH,goalW)).append("\n");
        }
        System.out.println(sb);
        br.close();
        System.exit(0);
    }

    static int bfs(boolean[][] map, int nowH, int nowW,int goalH, int goalW){
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] dh = {2,1,-1,-2,-2,-1,1,2};
        int[] dw = {1,2,2,1,-1,-2,-2,-1};

        q.add(new int[] {nowH,nowW,0});
        map[nowH][nowW] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == goalH && now[1] == goalW){
                answer = now[2];
                break;
            }

            for(int i=0;i<8;i++){
                int nh = now[0]+dh[i];
                int nw = now[1]+dw[i];
                if(nh>-1&&nh<map.length&&nw>-1&&nw<map[0].length&&!map[nh][nw]){
                    q.add(new int[] {nh,nw,now[2]+1});
                    map[nh][nw] = true;
                }
            }
        }
        return answer;
    }
}
