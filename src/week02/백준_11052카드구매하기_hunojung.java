package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11052카드구매하기_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i < N+1; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i],dp[i-j]+dp[j]);
            }
        }
        System.out.println(dp[N]);
        br.close();
        System.exit(0);

    }
}
