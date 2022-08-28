package hunojung.boj.data_structure;

import java.io.*;
import java.util.*;

public class P17299 {
        public static void main (String[]z) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();


            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Stack<Integer> stack = new Stack<>();
            Map<Integer,Integer> map = new HashMap<>();
            int[] nums = new int[N];

            for(int i=0;i<N;i++){
                nums[i] = Integer.parseInt(st.nextToken());
                map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
            }

            for (int i = N-1; i > -1; i--) {
                int now = nums[i];
                int now_count = map.get(now);

                while(!stack.isEmpty()) {
                    int next_count = map.get(stack.peek());

                    if(now_count >= next_count)
                        stack.pop();
                    else
                        break;
                }

                if(stack.isEmpty()) {
                    nums[i] = -1;
                }else {
                    nums[i] = stack.peek();
                }

                if(i>0) {
                    int count = map.get(nums[i-1]);
                    if(now_count > count)stack.push(now);
                }
            }

            for (int i = 0; i < N; i++) {
                sb.append(nums[i]).append(" ");
            }

            System.out.println(sb);

            br.close();
            System.exit(0);
        }
    }