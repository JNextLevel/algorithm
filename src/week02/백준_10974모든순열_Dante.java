package week02;


import java.util.Scanner;

/*
10974. 모든 수열

알고리즘 분류 : 백트래킹, 브루트포스 알고리즘

문제
-N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

입력)
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

출력)
첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.

예제 입력
3

예제 출력
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1


 */
public class 백준_10974모든순열_Dante {
    static int[] sequence, ch;
    static int n;
    public void DFS(int L) {
        if(L== n){
            for(int x : sequence) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i = 0; i<n; i++){
                if(ch[i]==0){
                    ch[i] = 1;
                    sequence[L] = i+1;
                    DFS(L+1);
                    ch[i] = 0;
                }
            }

        }
    }

    public static void main(String[] args){
        백준_10974모든순열_Dante T = new 백준_10974모든순열_Dante();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        sequence = new int[n];
        ch = new int[n];
        T.DFS(0);
    }
}


