package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2309일곱난쟁이_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        boolean search = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if(i==j) continue;

                if(sum-arr[i]-arr[j]==100){
                    search = true;
                    for (int k = 0; k < 9; k++) {
                        if(k==i || k==j) continue;

                        System.out.println(arr[k]);
                    }
                    if(search) break;
                }
                if(search) break;
            }
            if(search) break;
        }

        br.close();
        System.exit(0);
    }
}
