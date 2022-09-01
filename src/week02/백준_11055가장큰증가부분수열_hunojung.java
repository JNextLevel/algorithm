package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11055가장큰증가부분수열_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
            dp[i] = arr[i];
        }
        for (int i = 1; i < N; i++) {

            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j] && dp[i] < (dp[j]+arr[i])){
                    dp[i] = dp[j]+arr[i];
                    max = Math.max(max,dp[i]);
                }
            }
            //System.out.print(dp[i]+" ");
        }
        System.out.println(max);

        br.close();
        System.exit(0);
    }
}
