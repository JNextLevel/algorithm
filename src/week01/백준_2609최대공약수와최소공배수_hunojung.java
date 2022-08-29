package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2609최대공약수와최소공배수_hunojung {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int gcd = get_gcd(num1,num2);
        int lcm = num1*num2/gcd;
        System.out.println(gcd);
        System.out.println(lcm);

        br.close();
        System.exit(0);
    }

    static int get_gcd(int num1, int num2){
        if(num1<num2) return get_gcd(num2,num1);

        return num2==0?num1:get_gcd(num2,num1%num2);
    }
}
