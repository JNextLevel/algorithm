package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11576BaseConversion_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        String nums = br.readLine();

        // 10진수로 변환시 최대 2^20 = 1024^2 = 대충 100만
        int ten_num = numstoTen(nums,m,A);
        String answer = tentoB(ten_num,B);
        System.out.println(answer);

        br.close();
        System.exit(0);
    }
    static String tentoB(int ten_num,int B){
        // 그냥 함수 씀..
// 이거 해봐야함
//23 16
//3
//1 2 16
//정답 2 4 5
        StringBuilder sb = new StringBuilder();
        String B_num = Integer.toString(ten_num,B);
//        System.out.println(B_num);
        for(char c:B_num.toCharArray()){
            if(c>='a' && c<='z'){
                sb.append((c-'a'+10)).append(" ");
            }else{
                sb.append(c).append(" ");
            }
        }
        return sb.toString();
    }
    static int numstoTen(String nums, int m, int A){
        StringTokenizer st = new StringTokenizer(nums);
        int temp = (int)Math.pow(A,m-1);
        int answer = 0;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            answer += num*temp;
            temp/=A;
        }
        return answer;
    }
}
