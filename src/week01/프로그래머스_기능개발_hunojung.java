package week01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프로그래머스_기능개발_hunojung {

    public static void main(String[] args) throws Exception {
        int[] arr1 = {95, 90, 99, 99, 80, 99};
        int[] arr2 = {1, 1,1,1,1,1};
        int[] result = new 프로그래머스_기능개발_hunojung().solution2(arr1, arr2);
        for(int num : result){
            System.out.print(num+" ");
        }

        System.exit(0);
    }

    // 발표한 풀이 방법
    public int[] solution2(int[] progresses, int[] speeds){
        //progresses 93, 30, 55 speeds 1, 30, 5 answer 2, 1
        //progresses 95, 90, 99, 99, 80, 99 speeds 1, 1,1,1,1,1 answer 1, 3, 2
        int[] need_days = new int[progresses.length];
        List<Integer> list = new ArrayList<>();
        System.out.println("need_days 값 들");
        for(int i=0;i<progresses.length;i++){
            need_days[i] = (100-progresses[i])/(speeds[i]);

            if((100-progresses[i])%speeds[i] != 0)
                need_days[i]+=1;
            System.out.print(need_days[i]+" ");
        }
        System.out.println();

        int idx = 0;
        while(idx<progresses.length){
            int now_day = need_days[idx];
            int count = 1;
            System.out.println("now_day = "+now_day+" idx = "+idx);
            idx++;
            while(idx<progresses.length && now_day >= need_days[idx]){
                System.out.print(need_days[idx]+" ");
                idx++;
                count++;
            }
            System.out.println();
            list.add(count);
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    // 별로인듯..
    public int[] solution(int[] progresses, int[] speeds){
        //progresses 93, 30, 55 speeds 1, 30, 5 answer 2, 1
        //progresses 95, 90, 99, 99, 80, 99 speeds 1, 1,1,1,1,1 answer 1, 3, 2
        //System.out.println("solution 실행");
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            //System.out.println(progresses[i]+" "+speeds[i]);
            q.add(new int[] {progresses[i],speeds[i]});
        }

        Queue<Integer> answer_list = new LinkedList<>();
        int days = 0;
        while(!q.isEmpty()){
            System.out.println("while 실행");
            int count = 1;
            // q에 들어있는 맨 앞 값 꺼내봄
            int[] first_progress = q.poll();
            int now_progress = first_progress[0]+(first_progress[1]*days);
            while(now_progress<100){
                now_progress += first_progress[1];
                days++;
            }

            while(!q.isEmpty()){
                int[] next_progress = q.peek();
                if(next_progress[0]+(next_progress[1]*days)>=100){
                    q.poll();
                    count++;
                }else{
                    break;
                }
            }
            //System.out.println(count);
            answer_list.add(count);
        }

        int[] answer = new int[answer_list.size()];
        for(int i = 0; i<answer.length;i++){
            answer[i] = answer_list.poll();
        }
        return answer;
    }
}
