package week01;

import java.io.*;
import java.util.*;

public class 백준_1874스택수열_hunojung {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            int number = 1;
            boolean answer = true;
            while(n-->0) {
                int now = Integer.parseInt(br.readLine());
                while(number<=now) {
                    stack.add(number++);
                    sb.append("+").append("\n");
                }

                if(stack.peek() != now) {
                    answer = false;
                    break;
                }else{
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }

            if(!answer) {
                System.out.println("NO");
            }else {
                System.out.println(sb.toString());
            }

            br.close();
            System.exit(0);
        }
    }
