package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1932정수삼각형_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N-1; i > 0; i--) {
            for (int j = i-1; j > -1; j--) {
                arr[i-1][j] += Math.max(arr[i][j],arr[i][j+1]);
            }
        }

        System.out.println(arr[0][0]);

        br.close();
        System.exit(0);
    }
}
