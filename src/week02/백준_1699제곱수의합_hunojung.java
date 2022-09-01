package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_1699제곱수의합_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            dp[i] = i;
            // j*j == i 인 경우 dp[0]에서 +1 한거라 1이 되는게 맞음
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        System.out.println(dp[N]);

        br.close();
        System.exit(0);
    }

    static boolean isSqure(int N){
        int num = (int)Math.sqrt(N);
        if(num*num == N) return true;
        else return false;
    }
}
