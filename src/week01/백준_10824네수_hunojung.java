package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10824네수_hunojung {

    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken()+st.nextToken();
        String second = st.nextToken()+st.nextToken();
        double first_num = Double.parseDouble(first);
        double second_num = Double.parseDouble(second);
        System.out.printf("%.0f",(first_num+second_num));
        br.close();
        System.exit(0);
    }
}
