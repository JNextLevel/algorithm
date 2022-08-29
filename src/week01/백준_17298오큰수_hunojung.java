package week01;

import java.io.*;
import java.util.*;

public class 백준_17298오큰수_hunojung {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Stack<Integer> stack = new Stack<>();
            int[] nums = new int[N];

            for(int i=0;i<N;i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = N-1; i > -1; i--) {
                int now = nums[i];

                while(!stack.isEmpty() && stack.peek()<=now) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    nums[i] = -1;
                }else {
                    nums[i] = stack.peek();
                }

                if(i>0 && nums[i-1] < now) {
                    stack.push(now);
                }
            }

            for (int i = 0; i < N; i++) {
                sb.append(nums[i]);

                if(i<N-1)sb.append(" ");
            }

            System.out.println(sb);

            br.close();
            System.exit(0);
        }
    }
