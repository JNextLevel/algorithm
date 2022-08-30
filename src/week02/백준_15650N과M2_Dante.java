package week02;

import java.util.Scanner;

public class 백준_15650N과M2_Dante {
    static int n, m;
    static int[] combi;


    private void DFS(int L , int s) {
        if(L==m) { // 완
            for(int x : combi) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i = s; i<=n; i++){
                combi[L] = i;
                DFS(L+1, i+1); // i + 1인 이유는 i 뻗은 수의 + 1
            }
        }
    }

    public static void main(String[] args) {
        백준_15650N과M2_Dante T = new 백준_15650N과M2_Dante();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n개의 물건
        m = sc.nextInt(); // m개 뽑는다.
        combi =new int[m];
        T.DFS(0, 1); // L = level , s = start num
    }
}
