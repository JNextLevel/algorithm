package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15650N과M2_hunojung {
    static StringBuilder sb;
    static int N;
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        backTracking(arr,0,0);
        System.out.print(sb);
        br.close();
        System.exit(0);
    }

    static void backTracking(int[] arr,int num, int idx){
        if(idx == arr.length){
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=num+1;i<=N;i++){
            arr[idx] = i;
            backTracking(arr,i,idx+1);
       }
    }
}
