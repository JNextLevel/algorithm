package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_10972다음순열_hunjung {
    public static void main(String[] z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(solution(N,arr)){
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i]+" ");
            }
        }else{
            System.out.println(-1);
        }

        br.close();
        System.exit(0);
    }

    static boolean solution(int N, int[] arr){

        int idx = N-1;

        // 일단 맨 앞부분 찾음
        while(0<idx && arr[idx-1]>arr[idx]) idx--;

        // 맨앞이 0번째면 끝임
        if(idx==0) return false;

        // arr[idx] 값보다 큰 가장 작은 숫자임
        int swap_idx = N-1;
        while(arr[idx-1] > arr[swap_idx]) swap_idx--;
        swap(arr,idx-1,swap_idx);

        // 나머지 뒤집어 주기
        int right_idx = N-1;
        while(idx<right_idx){
            swap(arr,idx,right_idx);
            idx++;
            right_idx--;
        }

        return true;
    }

    static void swap(int[] arr,int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
