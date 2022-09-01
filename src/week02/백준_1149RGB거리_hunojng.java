package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1149RGB거리_hunojng {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken())+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = Integer.parseInt(st.nextToken())+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = Integer.parseInt(st.nextToken())+Math.min(dp[i-1][0],dp[i-1][1]);
        }

        System.out.println(Math.min(dp[N][0],Math.min(dp[N][1],dp[N][2])));

        br.close();
        System.exit(0);
    }
}
