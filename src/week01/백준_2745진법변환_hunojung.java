package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2745진법변환_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int answer = function_converter2(N,B);
        System.out.println(answer);
        br.close();
        System.exit(0);
    }
    static int function_converter2(String N, int B){
        int answer = 0;
        for(char c : N.toCharArray()){

            answer *= B;
            // 기본으로 숫자로 변환해봄
            int one_bit_num = c-'0';

            // 문자면 다시 문자에 맞는 숫자로 변환
            if(c>='A' && c<='Z'){
                one_bit_num = c-'A'+10;
            }
            // 더하자
            answer += one_bit_num;
        }

        return answer;
    }
}
