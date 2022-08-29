package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_10809알파벳찾기_hunojung {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int[] position = new int[26];
        Arrays.fill(position,-1);
        for(int i=0;i<string.length();i++){
            char c = string.charAt(i);
            if(position[c-'a']==-1) position[c-'a'] = i;
        }

        for(int i=0;i<26;i++){
            System.out.print(position[i]+" ");
        }

        br.close();
        System.exit(0);
    }
}
