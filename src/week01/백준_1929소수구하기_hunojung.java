package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1929소수구하기_hunojung {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // 1은 소수 제외

//        solution1(M,N);
        solution2(M,N);

        br.close();
        System.exit(0);
    }

    static void solution2(int M,int N){
        StringBuilder sb = new StringBuilder();
        if(M==1)M++;
        boolean[] noPrime = new boolean[N+1];
        set_prime(noPrime,N);
        for(int i=M;i<=N;i++){
            if(noPrime[i]) continue;

            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static void set_prime(boolean[] noPrime, int N){
        for(int i=2;i*i<=N;i++){
            if(noPrime[i]) continue;

            // 소수의 배수들 처리
            for(int j=i*i;j<=N;j+=i){
                noPrime[j] = true;
            }
        }
    }

    static void solution1(int M,int N){
        StringBuilder sb = new StringBuilder();

        if(M==1) M++;
        for (int i=M;i<=N;i++){
            if(isPrime(i)) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isPrime(int num){
        boolean answer = true;
        // 2가아닌 짝수는 false
        if(num!=2 && num%2==0){
            answer = false;
        }else {
            // 2,3,5,7 까진 넘어가도 됨. 9부터 들어오는 홀수는 포문 돌아감
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
