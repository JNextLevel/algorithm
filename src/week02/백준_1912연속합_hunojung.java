package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1912연속합_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum+=arr[i];
            max = Math.max(max,sum);

            if(sum<0) sum = 0;
        }

        System.out.println(max);

        br.close();
        System.exit(0);
    }
}
