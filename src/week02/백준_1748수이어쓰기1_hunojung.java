package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_1748수이어쓰기1_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        int num = 1;
        int num_len = 1;
        int num_count = 9;

        while(num<=N){
            // 10곱한거보다 작으면 차이면큼 * 각 수자별 길이
            if(num*10 > N){
                answer += (N-num+1)*num_len;
                break;
            // 10씩 증가하니까 같은경우엔 그 길이만 더해주고 끝남
            }else if(num == N){
                answer += num_len;
                break;
            }

            answer += (num_count*num_len);
            num *= 10;
            num_len++;
            num_count *= 10;

        }

        System.out.println(answer);
        br.close();
        System.exit(0);
    }
}
