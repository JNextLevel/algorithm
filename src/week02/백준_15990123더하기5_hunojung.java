package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_15990123더하기5_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[100001][3];
        dp[1][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int i = 4; i < dp.length; i++) {
            dp[i][0] = (dp[i-1][1]+dp[i-1][2])%1000000009;
            dp[i][1] = (dp[i-2][0]+dp[i-2][2])%1000000009;
            dp[i][2] = (dp[i-3][0]+dp[i-3][1])%1000000009;
        }

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][0]+dp[n][1]+dp[n][2])%1000000009).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}
