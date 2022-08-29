package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10974모든순열_hunojung {
    static StringBuilder sb;
    static int N;
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] used_num = new boolean[N+1];
        backTracking(arr,used_num,0);
        System.out.print(sb);
        br.close();
        System.exit(0);
    }

    static void backTracking(int[] arr,boolean[] used_num, int idx){
        if(idx == arr.length){
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            if(!used_num[i]){
                arr[idx] = i;
                used_num[i] = true;
                backTracking(arr,used_num,idx+1);
                used_num[i] = false;
            }
        }
    }
}
