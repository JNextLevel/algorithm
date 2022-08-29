package hunojung.boj.data_structure;

import java.io.*;
import java.util.*;

public class 백준_10845큐_hunojung {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            int last_number = -1;
            while(N-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if(command.equals("push")) {
                    last_number =Integer.parseInt(st.nextToken());
                    q.add(last_number);
                    continue;
                }else if(command.equals("pop")) {
                    if(q.isEmpty()) {
                        sb.append(-1);
                    }else{
                        sb.append(q.poll());
                    }
                }else if(command.equals("size")) {
                    sb.append(q.size());
                }else if(command.equals("empty")){
                    if(q.isEmpty()) {
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                }else if(command.equals("front")) {
                    if(q.isEmpty()) {
                        sb.append(-1);
                    }else{
                        sb.append(q.peek());
                    }
                }else if(command.equals("back")) {
                    if(q.isEmpty()) {
                        sb.append(-1);
                    }else{
                        sb.append(last_number);
                    }
                }

                sb.append("\n");
            }

            System.out.println(sb.toString());

            br.close();
            System.exit(0);
        }
    }
