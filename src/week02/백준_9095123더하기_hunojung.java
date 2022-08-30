package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1,2,3 더하기
public class 백준_9095123더하기_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 1 - 1개: 1
        // 2 - 2개: 11, 2
        // 3 - 4개: 111, 12, 21, 3
        // 4 - 7개: 1111, 112, 121, 211, 13, 31, 22
        // 5 - 13개: 1111, 1112, 1121, 1211, 2111, 122, 212, 221, 113, 131, 311, 23, 32

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<12;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        while(T-->0){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
        br.close();
        System.exit(0);
    }

}
