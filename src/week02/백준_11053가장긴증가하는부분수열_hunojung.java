package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11053가장긴증가하는부분수열_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(A[i]>A[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
//            System.out.print(dp[i]+" ");
        }

        System.out.println(max+1);

        br.close();
        System.exit(0);
    }
}
