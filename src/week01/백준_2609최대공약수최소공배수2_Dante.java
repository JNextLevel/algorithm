package week01;

import java.util.Scanner;



/*

    2609. 최대공약수와 최소공배수

    문제
    두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

    입력
    첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

    출력
    첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

    예제입력
    24 18

    예제출력
    6
    72

 */

// 유클리드 호제법을 직접 구현한 방법
public class 백준_2609최대공약수최소공배수2_Dante {
    private static int GCD(int a, int b) {
        while (b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        백준_2609최대공약수최소공배수2_Dante T = new 백준_2609최대공약수최소공배수2_Dante();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int g = GCD(a, b);

        System.out.println(g);
        System.out.println(a * b / g);
    }
}
