package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_16194카드구매하기2_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.min(dp[i],dp[i-j]+dp[j]);
            }
        }

        System.out.println(dp[n]);

        br.close();
        System.exit(0);
    }
}
