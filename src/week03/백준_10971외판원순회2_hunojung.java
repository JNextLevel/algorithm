package week03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_10971외판원순회2_hunojung {

    public static void main(String[]z) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(new Solution().solution(N,arr));

        br.close();
        System.exit(0);
    }
}

class Solution{
    int N,INF = 11000000;
    int[][] arr;
    int[][] dp;
    public int solution(int N,int[][] arr) {
        this.N = N;
        this.arr = arr;
        this.dp = new int[N][1<<N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],INF);
        }

        return dfs(0,1);
    }

    public int dfs(int city,int mask){
        //System.out.println(city+" "+mask);
        if(mask == (1<<N)-1){
            // 이거 있어야 통과됨;
            if(arr[city][0]==0) return INF;

            return arr[city][0];
        }

        if(dp[city][mask] != INF){
            return dp[city][mask];
        }

        for(int i=0;i<N;i++){
            if( (mask & (1<<i)) == 0 && arr[city][i] != 0){

                dp[city][mask] = Math.min(dp[city][mask],dfs(i,mask|(1<<i))+arr[city][i]);
                //System.out.println(map[city][mask]);
            }
        }
        return dp[city][mask];
    }
}
