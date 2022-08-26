package boj.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P01373 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String binary_num = br.readLine();

        if(binary_num.length()%3==2){
            sb.append((binary_num.charAt(0)-'0')*2+(binary_num.charAt(1))-'0');
        }else if(binary_num.length()%3==1){
            sb.append((binary_num.charAt(0)-'0'));
        }

        for(int i=binary_num.length()%3;i<binary_num.length();i+=3){
            sb.append((binary_num.charAt(i)-'0')*4+(binary_num.charAt(i+1)-'0')*2+(binary_num.charAt(i+2)-'0'));
        }

//        System.out.println(binary_to_octal(binary_num));

        System.out.println(sb);
        br.close();
        System.exit(0);
    }

    static String binary_to_octal(String binary_num){
        StringBuilder sb = new StringBuilder();
        // binary_num의 0인덱스부터 시작할건데 2진수 3자리 -> 8진수 1자리니까 계산해서 처음에 조절
        int first_len = binary_num.length()%3;
        int two = (int)Math.pow(2,(first_len-1));
        int add_num = 0;
        int i;
        for(i = 0;i<first_len;i++){
            if(binary_num.charAt(i)!='0') {
                add_num += two;
            }
            two/=2;
        }
        if(add_num!=0)sb.append(add_num);

        for(i=first_len;i<binary_num.length();i+=3){
            two = 4;
            add_num = 0;
            for(int j=i;j<i+3;j++){
                if(binary_num.charAt(j)!='0') {
                    add_num += two;
                }
                two/=2;
            }
            sb.append(add_num);
        }

        return sb.toString();
    }
}
