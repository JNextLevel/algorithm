package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_2133타일채우기_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        dp[0] = 1; // 4에서 *2하기위해 1 해줌
        if(N>1)dp[2] = 3;
        for (int i = 4; i <= N; i+=2) {
            dp[i] = dp[i-2]*3;

            // l=l , l==l, l===l 등등 계속 새로운 모양이 추가될 수 있음
            for (int j = 4; j <=i ; j+=2) {
                dp[i] += dp[i-j]*2;
            }
        }
        System.out.println(dp[N]);

        br.close();
        System.exit(0);
    }
}
