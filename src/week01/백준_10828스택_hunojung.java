package week01;

import java.io.*;
import java.util.*;

public class 백준_10828스택_hunojung {
    public static void main (String[]z) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while(N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
                continue;
            }else if(order.equals("pop")){
                if(stack.isEmpty()) {
                    sb.append(-1);
                }else {
                    sb.append(stack.pop());
                }

            }else if(order.equals("size")) {
                sb.append(stack.size());

            }else if(order.equals("empty")) {
                if(stack.isEmpty()) {
                    sb.append(1);
                }else {
                    sb.append(0);
                }

            }else if(order.equals("top")) {
                if(stack.isEmpty()) {
                    sb.append(-1);
                }else {
                    sb.append(stack.peek());
                }
            }

            sb.append("\n");

        }

        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }
}