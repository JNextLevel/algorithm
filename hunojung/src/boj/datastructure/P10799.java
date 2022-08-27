package boj.datastructure;

import java.io.*;
import java.util.*;

public class P10799 {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            int answer = 0;
            for(int i = 0;i<s.length();i++) {
                char c = s.charAt(i);
                if(c=='(') {
                    if(s.charAt(i+1)==')') {
                        answer += stack.size();
                        i++;
                    }else {
                        stack.push(c);
                    }
                }else {
                    stack.pop();
                    answer++;
                }
            }

            System.out.println(answer);

            br.close();
            System.exit(0);
        }
    }