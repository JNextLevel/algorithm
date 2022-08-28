package hunojung.boj.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P06588 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[1000001];
        set_prime(prime);

        String s = "";
        while( (s=br.readLine()) != null && !s.equals("0")){
            int num = Integer.parseInt(s);
            boolean complete_search = false;
            for(int i=3; i<=num/2;i+=2){
                if(prime[i] && prime[num-i]){
                    sb.append(num+" = "+i+" + "+(num-i)).append("\n");
                    complete_search = true;
                    break;
                }
            }
            if(!complete_search) sb.append("Goldbach's conjecture is wrong.").append("\n");
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
