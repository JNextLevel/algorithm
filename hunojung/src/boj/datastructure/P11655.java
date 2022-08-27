package boj.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11655 {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String string = br.readLine();

        for(char c : string.toCharArray()){
            if(c>='a' && c<='z'){
                c+=13;
                if(c>'z') c-=26;
            }else if( c >='A' && c<='Z'){
                c+=13;
                if(c>'Z') c-=26;
            }
            sb.append((char)c);
        }
        System.out.println(sb);

        br.close();
        System.exit(0);
    }
}
