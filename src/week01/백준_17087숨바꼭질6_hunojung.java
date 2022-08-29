package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_17087숨바꼭질6_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        // 초기위치에서 동생위치까지 거리 구해서 저장
        for(int i=0;i<N;i++){
            arr[i] = Math.abs(Integer.parseInt(st.nextToken())-S);
        }

        int answer = calculate_D(arr);
        System.out.println(answer);
        br.close();
        System.exit(0);
    }
    static int gcd(int num1, int num2){
        if(num1<num2) return gcd(num2,num1);
        return num2==0?num1:gcd(num2,num1%num2);
    }
    static int calculate_D(int[] arr){
        // 1개는 무조건 있으니까 초기값 설정
        int gcd = arr[0];

        // 3개의 최대공약수는 gcd(gcd(num1,num2),num3)로 생각하면 편함
        for(int i=0;i<arr.length;i++){
            gcd = gcd(gcd,arr[i]);
        }

        return gcd;
    }
}
