package week01;

import java.io.*;
import java.util.*;

public class 백준_1158요세푸스문제_hunojung {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            Queue<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int num = 1;
            while(num<=N)q.add(num++);

            sb.append("<");
            while(!q.isEmpty()) {
                for(int i=0;i<K-1;i++) {
                    q.add(q.poll());
                }
                sb.append(q.poll());
                if(!q.isEmpty()) sb.append(", ");
            }
            sb.append(">");
            System.out.println(sb.toString());

            br.close();
            System.exit(0);
        }
    }
