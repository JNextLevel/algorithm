package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_1935호위표기식2_hunojung {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String expression = br.readLine();

        double[] nums = new double[N];
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<N;i++){
            nums[i] = Double.parseDouble(br.readLine());
        }

        for(char c : expression.toCharArray()){
            if(c >= 'A' && c<='Z'){
                int index = c-'A';
                stack.push(nums[index]);
            }else{
                double second_number= stack.pop();
                double first_number = stack.pop();
                if(c=='+'){
                    stack.push(first_number+second_number);
                }else if(c=='-'){
                    stack.push(first_number-second_number);
                }else if(c=='*'){
                    stack.push(first_number*second_number);
                }else if(c=='/'){
                    stack.push(first_number/second_number);
                }
            }
        }
        double answer = stack.pop();

        System.out.printf("%.2f", answer);

        br.close();
        System.exit(0);
    }
}
