package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_117262xn타일링_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i=2;i<n;i++){
            dp[i] = (dp[i-1]+dp[i-2]*2)%10007;
        }

        System.out.println(dp[n-1]);

        br.close();
        System.exit(0);
    }
}
