package week02;


/*
   15651. N과 M(3)

   문제
  - 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    1부터 N까지 자연수 중에서 M개를 고른 수열
    같은 수를 여러 번 골라도 된다.

   입력)
   첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

    출력)
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며,
    각 수열은 공백으로 구분해서 출력해야 한다. 수열은 사전 순으로 증가하는 순서로 출력해야 한다.

    입력예제)
    4 2

    출력 예제)
    1 1
    1 2
    1 3
    1 4
    2 1
    2 2
    2 3
    2 4
    3 1
    3 2
    3 3
    3 4
    4 1
    4 2
    4 3
    4 4

 */
import java.util.Scanner;


public class 백준_15651N과M3_Dante {
    static int n, m;
    static int pm[];
    static StringBuilder sb= new StringBuilder();

    public void DFS(int L) {
        if(L==m){
            for(int i=0; i< m; i++) {
                //System.out.print(x + " ");  이렇게 쓸 경우 "시간초과" 나온다. 해결법 : StringBuilder 혹은 BufferedWriter를 써야한다.
                sb.append(pm[i] + " ");
            }
            sb.append('\n');
        }else{
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);

            }
        }
    }

    public static void main(String[] agrs) {
        백준_15651N과M3_Dante T = new 백준_15651N과M3_Dante();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pm = new int[m];
        T.DFS(0);
        System.out.print(sb);
    }
}


