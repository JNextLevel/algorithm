package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_2193이친수_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][2];
        dp[1][1] = 1;

        for (int i = 2; i < N+1; i++) {
            dp[i][0] = dp[i-1][0]+dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0]+dp[N][1]);

        br.close();
        System.exit(0);
    }
}
