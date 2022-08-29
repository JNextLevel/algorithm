package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_12128진수2진수_hunojung {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String octal_num = br.readLine();
        // 2진수 맨앞에 0이 올수도 있어서 첫숫자만 조정
        int first_bit = octal_num.charAt(0)-'0';
        int first_num = (first_bit/4)*100+((first_bit%4)/2)*10+first_bit%2;
        sb.append(first_num);

        for(int i=1;i<octal_num.length();i++){
            int one_bit = octal_num.charAt(i)-'0';
            sb.append((one_bit/4)).append((one_bit%4)/2).append(one_bit%2);
        }

        System.out.println(sb);
        br.close();
        System.exit(0);
    }
}
