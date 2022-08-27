package boj.datastructure;

import java.io.*;
import java.util.*;

public class P17413 {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            String s = br.readLine();
            for(int i=0;i<s.length();i++){

                if(s.charAt(i)=='<') {
                    while(s.charAt(i)!='>') {
                        sb.append(s.charAt(i++));
                    }
                    sb.append(s.charAt(i));
                }else if(s.charAt(i)==' ') {
                    sb.append(' ');
                }else{
                    Stack<Character> stack = new Stack<>();
                    while(i<s.length() &&s.charAt(i) != ' ' && s.charAt(i) != '<') {
                        stack.push(s.charAt(i++));
                    }
                    i--;
                    while(!stack.isEmpty()) sb.append(stack.pop());
                }
            }

            System.out.println(sb.toString());

            br.close();
            System.exit(0);
        }
    }
