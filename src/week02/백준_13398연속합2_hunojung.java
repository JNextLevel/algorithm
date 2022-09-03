package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_13398연속합2_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];

        // >> 방향 이동
        dp[0][0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(arr[i],dp[i-1][0]+arr[i]);
            max = Math.max(max,dp[i][0]);
        }
        // << 방향 이동
        dp[n-1][1] = arr[n-1];
        for (int i = n-2; i >-1; i--) {
            dp[i][1] = Math.max(arr[i],dp[i+1][1]+arr[i]);
            max = Math.max(max,dp[i][1]);
        }

        // 해당 인덱스 제외 양쪽에서 가운데로 오는 방향으로 최댓값 각각 더함
        for (int i = 1; i < n-1; i++) {
            max = Math.max(max, dp[i-1][0]+dp[i+1][1]);
        }

        System.out.println(max);

        br.close();
        System.exit(0);
    }
}
