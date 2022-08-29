package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9613GCD합_hunojung {
    static StringBuilder sb;
    public static void main(String[] z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr_len = Integer.parseInt(st.nextToken());
            int[] arr = new int[arr_len];
            for(int i=0;i<arr.length;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            gcd_sum(arr);
        }
        System.out.println(sb);
        br.close();
        System.exit(0);
    }

    static int gcd(int num1, int num2){
        if(num1<num2) return gcd(num2,num1);
        return num2==0?num1:gcd(num2,num1%num2);
    }

    static void gcd_sum(int[] arr){
        int len = arr.length;
        // 100개가 다 1000000 일 경우 int 범위 초과
        // 100C2 * 1000000 = 49억5천
        long gcd_sum = 0;
        for(int i=0;i<len;i++){
            for (int j = i+1; j < len; j++) {
                int gcd = gcd(arr[i],arr[j]);
                //System.out.println(arr[i]+" "+arr[j]+" "+gcd);
                gcd_sum+=gcd;
            }
        }
        sb.append(gcd_sum).append("\n");
    }
}