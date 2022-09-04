package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_6064카잉달력_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(check_date(M,N,x,y)).append("\n");
        }
        System.out.println(sb);
        br.close();
        System.exit(0);
    }

    static int check_date(int M,int N,int x,int y){
        int max_day = M*N/gcd(M,N);

        // x 값 자체는 가만히 있고 y값이 변동되는데
        // 이때 M 만큼 x가 변하면서 실제 y값이 되면 맞음
        while(x <= max_day){
            int day = x%N==0?N:x%N;
            if(day == y){
                return x;
            }
            x+=M;
        }

        return -1;
    }

    static int gcd(int a,int b){
        if(b>a) return gcd(b,a);
        return b==0?a:gcd(b,a%b);
    }
}
