package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2004조합0의개수_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        function_count(N,M);

        // N*(N-1)*...*(N-M+1) / M*(M-1)*...*2*1
        // 시간초과 ㅠ
//        function_count_2_5(N,M);

        br.close();
        System.exit(0);
    }

    static void function_count(int N, int M){
        // 분자에서 N ~ (N-M+1) 사이에 2의 배수를 센다.
        // 그다음 4의 배수를 세면 4는 2가 2번곱해졌지만 2의 배수를 세면서 1번 걸렸기때문에 1번만 세어도 됨.
        // 결론은 2의 배수의 개수 + 4의 배수의 개수 + ... + 개수
        // 5도 마찬가지로
        int count_2 = 0;
        int count_5 = 0;
        for(long i=2; i<=N;i*=2){
            // N~(N-M+1) 의 2의 배수 개수는
            // N까지 2의 배수 - (N-M+1) 까지 2의 배수
            // 분모꺼도 꼽사리 껴서 빼주기
            count_2 += (N/i - (N-M)/i) -M/i;
        }
        for(long i=5; i<=N;i*=5){
            // N~(N-M+1) 의 2의 배수 개수는
            // N까지 2의 배수 - (N-M+1) 까지 2의 배수
            count_5 += (N/i - (N-M)/i) - M/i;
        }
        System.out.println(Math.min(count_2,count_5));
    }

    static void function_count_2_5(int N, int M){
        int count_2 = 0;
        int count_5 = 0;

        for(int i=N;i>N-M;i--){
            int num = i;
            while(num%2==0 || num%5==0){
                if(num%2==0) {
                    num/=2;
                    count_2++;
                }
                if(num%5==0) {
                    num/=5;
                    count_5++;
                }
            }
        }

        for(int i=M;i>0;i--){
            int num = i;
            while(num%2==0 || num%5==0){
                if(num%2==0) {
                    num/=2;
                    count_2--;
                }
                if(num%5==0) {
                    num/=5;
                    count_5--;
                }
            }
        }

        System.out.println(Math.min(count_2,count_5));
    }
}
