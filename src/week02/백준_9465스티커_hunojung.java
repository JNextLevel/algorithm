package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9465스티커_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][2];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    dp[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] += Math.max(dp[i-1][1],dp[i-2][1]);
                dp[i][1] += Math.max(dp[i-1][0],dp[i-2][0]);
            }
            sb.append(Math.max(dp[N][0],dp[N][1])).append("\n");
        }
        System.out.println(sb);
        br.close();
        System.exit(0);
    }
}
