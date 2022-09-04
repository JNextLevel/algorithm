package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15649N과M1_hunojung {
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
        back_tracking(0,new boolean[N+1]);
        System.out.println(sb);
        br.close();
        System.exit(0);
    }

    static void back_tracking(int idx,boolean[] used){
        if(idx == M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            if(!used[i]){
                arr[idx] = i;
                used[i] = true;
                back_tracking(idx+1,used);
                used[i] = false;
            }
        }
    }
}
