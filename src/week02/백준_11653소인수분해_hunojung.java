package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_11653소인수분해_hunojung {
    static boolean[] prime;
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        setPrime(N);

//        solutin1(N);
        solution2(N);

        br.close();
        System.exit(0);
    }

    static void solution2(int N){
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++){
            while(N%i==0){
                sb.append(i).append("\n");
                N/=i;
            }
        }
        System.out.println(sb);
    }

    static void solutin1(int N){
        StringBuilder sb = new StringBuilder();
        int now_prime = 2;

        while(N>1 && N>=now_prime){
            if(N%now_prime == 0){
                //System.out.println(now_prime);
                N/=now_prime;
                sb.append(now_prime).append("\n");
            }else{
                now_prime = nextPrime(now_prime);
            }
        }

        System.out.println(sb);
    }

    static int nextPrime(int num){
        int return_num = num+1;
        //System.out.println(num);
        for (int i = num+1; i < prime.length; i++) {
            if(prime[i]){
                return_num = i;
                break;
            }
        }
        return return_num;
    }

    static void setPrime(int N){
        prime = new boolean[N+1];
        Arrays.fill(prime,true);

        for (long i = 2; i <= N; i++) {
            if(!prime[(int)i]) continue;
            //System.out.println(i);
            for (long j = i*i; j <= N ; j+=i) {
                prime[(int)j] = false;
            }
        }
    }
}
