package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_10872팩토리얼_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int p = 1;
        for(int i=1;i<=N;i++){
            p*=i;
        }
        System.out.println(p);
        br.close();
        System.exit(0);
    }
}
