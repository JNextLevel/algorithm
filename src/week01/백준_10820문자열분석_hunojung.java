package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_10820문자열분석_hunojung {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while(true) {
                String s = br.readLine();
                int smaill = 0;
                int big = 0;
                int num = 0;
                int blank = 0;
                for (char c : s.toCharArray()) {
                    if (c >= 'a' && c <= 'z') {
                        smaill++;
                    } else if (c >= 'A' && c <= 'Z') {
                        big++;
                    } else if (c >= '0' && c <= '9') {
                        num++;
                    } else if (c == ' ') {
                        blank++;
                    }
                }

                System.out.println(smaill + " " + big +" " + num + " " + blank);
            }
        }catch (Exception e){

        }

        br.close();
        System.exit(0);
    }
}
