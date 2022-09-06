package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10973이전순열_hunojung {
    public static void main(String[] args) throws  Exception{
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
        // 맨앞부분 찾기
        int idx = N-1;
        while(0<idx && arr[idx-1]<arr[idx]) idx--;

        // 맨앞이 0번째면 false
        if(idx==0) return false;

        // 바뀔값보다 작은데 가장 큰거 찾기
        int swap_idx = N-1;
        while(arr[idx-1]<arr[swap_idx]) swap_idx--;
        swap(arr,idx-1,swap_idx);

        int right_idx = N-1;
        while(idx<right_idx){
            swap(arr,idx,right_idx);
            idx++;
            right_idx--;
        }
        return true;
    }

    static void swap(int[] arr,int idx, int idx2){
        int temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;
    }
}
