package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_3085사탕게임_hunojung_푸는중 {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine()
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(i);
            }
        }

        for (int i = 0; i < N; i++) {
            int countC = 0;
            int countP = 0;
            int countZ = 0;
            int countY = 0;
            for (int j = 0; j < N; j++) {

            }
        }

        br.close();
        System.exit(0);
    }
}
