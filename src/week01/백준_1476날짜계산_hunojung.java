package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 날짜 계산
public class 백준_1476날짜계산_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;
        while(E != 1 || S != 1 || M != 1){
            E = E==1?15:E-1;
            S = S==1?28:S-1;
            M = M==1?19:M-1;
            year++;
        }

        System.out.println(year);
        br.close();
        System.exit(0);
    }
}
