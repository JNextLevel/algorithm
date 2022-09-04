package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1107리모컨_hunojung {
    static int answer;
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string_n = br.readLine();
        // 숫자가 몇자리인지 체크하려고
        int num_len = string_n.length();
        // 100에서 시작해서 N 까지
        int N = Integer.parseInt(string_n);
        answer = Math.abs(N-100);
        int M = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[10];
        Arrays.fill(button,true);


        if(M>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                button[num] = false;
            }
        }


        brute_force2(N,button);
        //brute_force(N,num_len,"",button);
        System.out.println(answer);

        br.close();
        System.exit(0);
    }

    static void brute_force2(int N,boolean[] button){
        for (int i = 0; i < 1000000; i++) {
            String num = String.valueOf(i);
            boolean contain_broken = false;
            for (int j = 0; j < num.length(); j++) {
                int check_num = num.charAt(j)-'0';
                if(!button[check_num]){
                    contain_broken = true;
                    break;
                }
            }

            if(!contain_broken){
                // 차이만큼 (+,-) 누른수 + 번호 버튼 누른 횟수
                answer = Math.min(answer,Math.abs(N-i)+num.length());
            }
        }
    }

    static void brute_force(int N,int len,String num, boolean[] button){

        if(num.length()>0){
            answer = Math.min(answer,num.length()+Math.abs(N-Integer.parseInt(num)));
            //System.out.println(N+" "+num+" "+answer);

        }

        if(num.length() > len) return;

        for (int i = 0; i < 10; i++) {
            if(button[i]) {
                brute_force(N, len, num + (char)(i + '0'), button);
            }
        }
    }
}
