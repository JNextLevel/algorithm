package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_17404RGB거리2_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        int[][] dp = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 집 종류별로 골랐을 경우
        int num1 = solution(arr,0);
        int num2 = solution(arr,1);
        int num3 = solution(arr,2);
        int answer = Math.min(num1,Math.min(num2,num3));
        System.out.println(answer);
        br.close();
        System.exit(0);
    }

    static int solution(int[][] arr,int check){
        int N = arr.length-1;
        int[][] dp = new int[N+1][3];
        for (int i=0;i<3;i++){
            if(i!=check){
                dp[1][i] = 1000001;
            }else{
                dp[1][i] = arr[1][i];
            }
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+arr[i][2];
        }

        int answer = 1000001;
        for (int i = 0; i < 3; i++) {
            if(i==check) continue;

            answer = Math.min(answer,dp[N][i]);
        }
        return answer;
    }
}
