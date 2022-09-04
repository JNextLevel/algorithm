package week02;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_전략망을둘로나누기_hunojung {
    public static void main(String[] args) {
        전력망을둘로나누기 s = new 전력망을둘로나누기();
        int n = 9;
        int[][] arr = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int answer = s.solution(n,arr);
        System.out.println(answer);

        int n2 = 4;
        int[][] arr2 = {{1,2},{2,3},{3,4}};
        int answer2 = s.solution(n2,arr2);
        System.out.println(answer2);

        int n3 = 7;
        int[][] arr3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        int answer3 = s.solution(n3,arr3);
        System.out.println(answer3);

        System.exit(0);
    }
}

class 전력망을둘로나누기{
    public int solution(int n, int[][] wires){
        int answer = n;
        for(int[] wire : wires){

            int linked_top1 = bfs(n,wires,wire[0],wire[1]);
            //int linked_top2 = bfs(n,wires,wire[1],wire[0]);

            answer = Math.min(answer,Math.abs(n-2*linked_top1));
        }
        return answer;
    }

    public int bfs(int n,int[][] wires,int start, int exclude){
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        visited[exclude] = true;

        int linked_top_count = 0;
        Queue <Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            linked_top_count++;

            int now = q.poll();
            for(int[] wire : wires){
                if(wire[0] == now && !visited[wire[1]]){
                    q.add(wire[1]);
                    visited[wire[1]] = true;
                }else if(wire[1] == now && !visited[wire[0]]){
                    q.add(wire[0]);
                    visited[wire[0]] = true;
                }
            }
        }

        return linked_top_count;
    }
}
