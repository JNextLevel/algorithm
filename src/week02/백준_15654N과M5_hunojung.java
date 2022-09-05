package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15654N과M5_hunojung {
    static StringBuilder sb;
    static int[] arr, temp_arr;
    static boolean[] used;
    static int N,M;
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        temp_arr = new int[M];
        back_tracking(1,0);
        System.out.println(sb);
        br.close();
        System.exit(0);
    }

    static void back_tracking(int start,int idx){
        if(idx == M){
            for(int i=0;i<M;i++){
                sb.append(temp_arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!used[i]){
                used[i] = true;
                temp_arr[idx] = arr[i];
                back_tracking(i,idx+1);
                used[i] = false;
            }
        }
    }
}
