package boj.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17103 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[1000001];
        set_prime(prime);

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            if(prime[2] && prime[num-2]) count++;

            for(int i=3; i<=num/2;i+=2){
                if(prime[i] && prime[num-i]){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

        br.close();
        System.exit(0);
    }

    static void set_prime(boolean[] prime){
        Arrays.fill(prime,true);
        prime[0]=prime[1]=false;
        for(int i=2;i*i<=prime.length;i++){
            if(!prime[i]) continue;

            for(int j=i*2;j<prime.length;j+=i){
                prime[j]=false;
            }
        }
    }
}
