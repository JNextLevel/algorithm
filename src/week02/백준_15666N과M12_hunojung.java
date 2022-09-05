package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_15666N과M12_hunojung {
    static StringBuilder sb;
    static int[] arr, temp_arr;
    static int N,M;
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        temp_arr = new int[M];
        back_tracking(0,0);
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
        int before = 0;
        for(int i=start;i<N;i++){
            if(before!=arr[i]) {
                before = arr[i];
                temp_arr[idx] = arr[i];
                back_tracking(i,idx + 1);
            }
        }
    }
}
