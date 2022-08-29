package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_11656접미사배열_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String[] arr = new String[string.length()];
        for(int i=0;i<string.length();i++){
            arr[i] = string.substring(i,string.length());
        }
        Arrays.sort(arr);
        for (String s : arr){
            System.out.println(s);
        }
        br.close();
        System.exit(0);
    }
}
