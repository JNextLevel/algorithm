package hunojung.boj.data_structure;

import java.io.*;

public class 백준_9012괄호_hunojung {
    public static void main (String[]z) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int count = 0;

            String ps = br.readLine();

            for(char c : ps.toCharArray()) {
                if(c=='(') count++;
                else count--;

                if(count<0) break;
            }

            if(count==0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }
}