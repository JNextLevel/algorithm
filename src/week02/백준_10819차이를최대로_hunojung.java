package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10819차이를최대로_hunojung {

    static int answer;
    static int[] arr;
    static boolean[] used;
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        used = new boolean[N];
        answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back_tacking(0,0,0);
        System.out.println(answer);
        br.close();
        System.exit(0);
    }

    static void back_tacking(int sum,int before_num,int count){
        if(count == arr.length){
            answer = Math.max(answer,sum);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!used[i]){
                used[i] = true;
                if(count==0)
                    back_tacking(0,arr[i],count+1);
                else
                    back_tacking(sum+Math.abs(before_num-arr[i]),arr[i],count+1);
                used[i] = false;
            }
        }
    }
}
