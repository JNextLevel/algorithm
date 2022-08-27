package boj.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int gcd = get_gcd(num1,num2);
            sb.append((num1*num2)/gcd).append("\n");
        }

        System.out.print(sb);
        br.close();
        System.exit(0);
    }
    static int get_gcd(int num1, int num2){
        if(num1<num2) return get_gcd(num2,num1);

        return num2==0?num1:get_gcd(num2,num1%num2);
    }
}
