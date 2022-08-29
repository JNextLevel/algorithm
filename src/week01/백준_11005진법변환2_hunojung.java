package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11005진법변환2_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String answer = function_converter(N,B);
        System.out.println(answer);

        br.close();
        System.exit(0);
    }
    static String function_converter(int N, int B){
        StringBuilder sb = new StringBuilder();

        while(N>0){
            //System.out.println(N+" "+N/B+" "+N%B);
            // 나누고 나머지는 진법변환 반복
            int remain = N%B;
            N /= B;

            if(remain>9){
                sb.append((char)('A'+(remain-10)));
            }else{
                sb.append(remain);
            }

        }
        return sb.reverse().toString();
    }
}
