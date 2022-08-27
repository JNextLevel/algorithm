package boj.datastructure;

import java.io.*;
import java.util.*;

public class P10866 {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            Deque<Integer> dq = new ArrayDeque<>();

            int N = Integer.parseInt(br.readLine());
            while(N-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("push_front")) {
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                }else if(command.equals("push_back")) {
                    dq.addLast(Integer.parseInt(st.nextToken()));
                }else if(command.equals("pop_front")) {
                    if(!dq.isEmpty()) {
                        sb.append(dq.pollFirst()).append("\n");
                    }else {
                        sb.append(-1).append("\n");
                    }
                }else if(command.equals("pop_back")) {
                    if(!dq.isEmpty()) {
                        sb.append(dq.pollLast()).append("\n");
                    }else {
                        sb.append(-1).append("\n");
                    }
                }else if(command.equals("size")) {
                    sb.append(dq.size()).append("\n");
                }else if(command.equals("empty")) {
                    if(dq.isEmpty()) {
                        sb.append(1).append("\n");
                    }else {
                        sb.append(0).append("\n");
                    }
                }else if(command.equals("front")) {
                    if(!dq.isEmpty()) {
                        sb.append(dq.peekFirst()).append("\n");
                    }else {
                        sb.append(-1).append("\n");
                    }
                }else if(command.equals("back")) {
                    if(!dq.isEmpty()) {
                        sb.append(dq.peekLast()).append("\n");
                    }else {
                        sb.append(-1).append("\n");
                    }
                }
            }
            System.out.println(sb.toString());

            br.close();
            System.exit(0);
        }
    }
