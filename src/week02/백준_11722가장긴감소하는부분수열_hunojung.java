package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11722가장긴감소하는부분수열_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[i][0]<dp[j][0]){
                    dp[i][1] = Math.max(dp[i][1],dp[j][1]+1);
                    max = Math.max(max,dp[i][1]);
                }
            }
        }

        System.out.println(max+1);

        br.close();
        System.exit(0);
    }
}
