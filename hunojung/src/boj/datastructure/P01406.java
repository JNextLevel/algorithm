package boj.datastructure;

import java.io.*;
import java.util.*;

public class P01406 {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            String s = br.readLine();
            Stack<Character> stack_left = new Stack<>();
            Stack<Character> stack_right = new Stack<>();

            for(char c:s.toCharArray())
                stack_left.push(c);

            int M = Integer.parseInt(br.readLine());

            while(M-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("L")) {
                    if(!stack_left.isEmpty()) {
                        stack_right.push(stack_left.pop());
                    }
                }else if(command.equals("D")) {
                    if(!stack_right.isEmpty()) {
                        stack_left.push(stack_right.pop());
                    }
                }else if(command.equals("B")) {
                    if(!stack_left.isEmpty()) {
                        stack_left.pop();
                    }
                }else if(command.equals("P")) {
                    stack_left.push(st.nextToken().charAt(0));
                }
            }

            while(!stack_left.isEmpty()) {
                sb.append(stack_left.pop());
            }

            sb.reverse();

            while(!stack_right.isEmpty()) {
                sb.append(stack_right.pop());
            }


            System.out.println(sb.toString());

            br.close();
            System.exit(0);
        }
    }
