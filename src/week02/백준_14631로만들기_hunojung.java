package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_14631로만들기_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        for (int i = N-1; i >0 ; i--) {
            if(i*3 <= N){
                dp[i] = Math.min(dp[i*3],Math.min(dp[i*2],dp[i+1]))+1;
            }else if(i*2 <= N){
                dp[i] = Math.min(dp[i*2],dp[i+1])+1;
            }else{
                dp[i] = dp[i+1]+1;
            }
        }

        System.out.println(dp[1]);

        br.close();
        System.exit(0);
    }
}
