package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15652N과M4_hunojung {
    static StringBuilder sb;
    static int[] arr;
    static int N,M;
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        back_tracking(1,0);
        System.out.println(sb);
        br.close();
        System.exit(0);
    }

    static void back_tracking(int start,int idx){
        if(idx == M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<=N;i++){
            arr[idx] = i;
            back_tracking(i,idx+1);
        }
    }
}
