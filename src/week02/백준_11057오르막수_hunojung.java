package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_11057오르막수_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 길이 N , 뒤에는 끝나는 숫자
        int[][] dp = new int[N+1][10];

        Arrays.fill(dp[1],1);
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j ; k++) {
                    dp[i][j] = (dp[i][j]+dp[i-1][k])%10007;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum+dp[N][i])%10007;
        }
        System.out.println(sum);
        br.close();
        System.exit(0);
    }
}
