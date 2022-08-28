package hunojung.boj.data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10808 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int[] count = new int[26];
        for(char c : string.toCharArray()){
            count[c-'a']++;
        }

        for(int i=0;i<26;i++){
            System.out.print(count[i]+" ");
        }

        br.close();
        System.exit(0);
    }
}
