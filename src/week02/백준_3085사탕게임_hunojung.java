package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// https://www.acmicpc.net/board/view/58247
// 예제 많음
public class 백준_3085사탕게임_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            // 가로로 교환
            for (int j = 0; j < N-1; j++) {

                if(arr[i][j] == arr[i][j+1]) continue;

                char temp = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = temp;

                int length = countColor(arr);

                temp = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = temp;

                answer = Math.max(answer,length);
            }

            // 세로로 교환환
           for (int j = 0; j < N-1; j++) {

                if(arr[j][i] == arr[j+1][i]) continue;

                char temp = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = temp;

                int length = countColor(arr);

               temp = arr[j][i];
               arr[j][i] = arr[j+1][i];
               arr[j+1][i] = temp;

                answer = Math.max(answer,length);
            }
        }

        System.out.println(answer);
        br.close();
        System.exit(0);
    }

    static int countColor(char[][] arr){
        int N = arr.length;
        int max_length = 1;

        for (int i = 0; i < N; i++) {
            int count_w = 1;
            int count_h = 1;
            for (int j = 1; j < N; j++) {
                // 가로로 셈
                if(arr[i][j-1] == arr[i][j]){
                    count_w++;
                }else{
                    count_w = 1;
                }

                max_length = Math.max(max_length,count_w);

                // 세로로 셈
                if(arr[j-1][i] == arr[j][i]){
                    count_h++;
                }else{
                    count_h = 1;
                }

                max_length = Math.max(max_length,count_h);
            }
        }

        return max_length;
    }
}
