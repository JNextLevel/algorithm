package hunojung.programmers.algorithm_kit.stack_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
//        int[] answer = new 같은숫자는싫어().solution(new int[] {1,1,3,3,0,1,1});
        int[] answer = new 같은숫자는싫어().solution(new int[] {4,4,4,3,3});
        for(int num : answer) System.out.print(num+" ");
    }

    public int[] solution(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for(int num : arr){
            if(stack.isEmpty() || stack.peek() != num){
                stack.push(num);
            }
        }

        int[] answer = new int[stack.size()];
        for(int i=answer.length-1;i>-1;i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}
