package hunojung.boj.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P01676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count_two = 0;
        int count_five = 0;
        for(int i=2;i<=N;i++){

            int count_num = i;
            while(count_num%2 == 0 || count_num%5 == 0){
                if(count_num%2 == 0){
                    count_num /=2;
                    count_two ++;
                }
                if(count_num%5 == 0){
                    count_num /=5;
                    count_five ++;
                }
            }
        }

        System.out.println(Math.min(count_two,count_five));

        br.close();
        System.exit(0);
    }
}
