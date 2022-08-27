package boj.datastructure;

import java.io.*;
import java.util.*;

public class P09093
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=T;test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                String word = st.nextToken();
                for(int i=word.length()-1;i>-1;i--){
                    sb.append(word.charAt(i));
                }
                sb.append(" ");
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }
}