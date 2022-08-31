package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_117272xn타일링2_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1]; // n까지 해도되는데 n = 1 일때 dp[1]=3 에러나니까 걍 늘려줌;

        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i < n; i++) {
            // i-1 에서 1개짜리 붙인거 + i-2에서 가로붙인거랑 사각형붙인거
            // 왜냐하면 i-1에서 세로붙이면 i-2에서 세로2개 붙인거랑 겹치는경우 있음
            dp[i] = (dp[i-1]+dp[i-2]*2)%10007;
        }
        System.out.println(dp[n-1]);

        br.close();
        System.exit(0);
    }
}
