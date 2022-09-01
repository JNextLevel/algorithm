package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_14002가장긴증가하는부분수열4_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 헷갈려서 인덱스 0은 버린다 N+1 까지함
        int[] A = new int[N];
        int[][] dp = new int[N][2]; // 길이, 이전 인덱스 저장

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i][1] = i;
        }

        for (int i = 1; i < N ; i++) {
            for (int j = i-1; j > -1 ; j--) {

                if(A[i] > A[j] && (dp[i][0] < (dp[j][0]+1))){
                    dp[i][0] = dp[j][0]+1;
                    dp[i][1] = j;
                }
            }
        }

        int max_index = 0;
        int max_length = 0;

        for (int i = 0; i < N; i++) {
            if(max_length<dp[i][0]){
                max_index = i;
                max_length = dp[i][0];
            }
        }

        //System.out.println(max_index);

        Stack<Integer> stack = new Stack<>();
        stack.push(A[max_index]);
        while(dp[max_index][1] != max_index){
            max_index = dp[max_index][1];
            stack.push(A[max_index]);
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        System.out.println(max_length+1);
        System.out.println(sb);

        br.close();
        System.exit(0);
        }
}
