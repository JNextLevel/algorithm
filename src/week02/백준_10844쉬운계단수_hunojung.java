package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_10844쉬운계단수_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0],1);
        dp[0][0] = 0; // 조건 0으로 시작하는건 제외

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {

                if(j==0) {
                    dp[i][j] = dp[i-1][j+1];
                }else if(j==9) {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer+dp[n-1][i])%1000000000;
        }

        System.out.println(answer);
        br.close();
        System.exit(0);
    }
}
