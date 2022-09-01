package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_15988123더하기3_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 1000001; i++) {
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
        }

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}
