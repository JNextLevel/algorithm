package week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_13913숨바꼭질4_hunojung {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N,K);

        br.close();
        System.exit(0);
    }

    static void bfs(int N, int K){
        StringBuilder sb = new StringBuilder();
        int answer = -1;
        // 현재노드, 직전노드
        Map<Integer,Integer> map = new HashMap<>();
        // 현재노드, 이동횟수
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[] {N,0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] == K){
                answer = now[1];
                break;
            }

            if(now[0]>0 && !map.containsKey(now[0]-1)){
                map.put(now[0]-1,now[0]);
                pq.add(new int[] {now[0]-1,now[1]+1});
            }

            if(now[0]<100000 && !map.containsKey(now[0]+1)){
                map.put(now[0]+1,now[0]);
                pq.add(new int[] {now[0]+1,now[1]+1});
            }

            if(now[0] < K && now[0] > 1 && !map.containsKey(now[0]*2)){
                map.put(now[0]*2,now[0]);
                pq.add(new int[] {now[0]*2,now[1]+1});
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(K);

        while(stack.peek() != N){
            stack.push(map.get(stack.peek()));
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        System.out.println(answer);
        System.out.println(sb);
    }
}
