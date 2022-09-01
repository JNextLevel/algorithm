package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_2156포도주시식_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if(N>1) dp[2] = arr[1]+arr[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = arr[i]+Math.max(dp[i-2],dp[i-3]+arr[i-1]);
            dp[i] = Math.max(dp[i],dp[i-1]);
        }

        System.out.println(dp[N]);

        br.close();
        System.exit(0);
    }
}
