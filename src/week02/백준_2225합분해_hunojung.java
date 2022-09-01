package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2225합분해_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }

        // 0~N 숫자는 1개로 표현하는 방법 1개임
        // 0~N 숫자를 2개로 표현하는 방법 N+1 개임
        // 0 > 0+0
        // 1 > 0+1 , 1+0
        // 2 > 0+2, 1+1, 2+0
        // 3 > 0+3, 1+2, 2+1, 3+0
        // ..
        // N > 0+N , 1+(N-1) ... N+0

        // 0~N 숫자를 3개로 표현하는 방법
        // 0 > 0+0+0                                    -- 0 2개로 한거  + 0
        // 1 > 0+0+1, 0+1+0, 1+0+0                      -- 0 2개로한거 + 1 // 1 2개로한거 + 0
        // 2 > 0+0+2, 0+2+0, 2+0+0, 0+1+1, 1+0+1, 1+1+0 -- 0 2개로한거 + 2 // 1 2개로한거 +1 // 2 2개로한거 + 0

        // 우선 숫자 개수 정하기
        for (int k = 2; k <= K; k++) {

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= i ; j++) {
                    dp[i][k] = (dp[i][k]+dp[i-j][k-1])%1000000000;
                }
            }
        }
        System.out.println(dp[N][K]);
        br.close();
        System.exit(0);
    }
}
