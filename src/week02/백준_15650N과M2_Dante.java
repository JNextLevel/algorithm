package week02;

import java.util.Scanner;
/*
    15650. N과 M(2)

    문제
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    고른 수열은 오름차순이어야 한다.
    입력
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

    출력
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.


    문제 파악
    1. 조합이다.  조합 참고 https://yudeokrin.github.io/posts/2022-06-06-page3
    2. DFS로 접근하자..

 */
public class 백준_15650N과M2_Dante {
    static int n, m; // DFS에 접근할 수 없기때문에 n, m을 전역변수로 설정
    static int[] combi; // combi도 마찬가지이다.


    private void DFS(int L , int s) {
        if(L==m) { // 레벨이 m이 되면 조합이 완성
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
