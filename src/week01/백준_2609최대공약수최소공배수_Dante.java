package week01;


import java.util.Scanner;
/*
    2609. 최대공약수와 최소공배수 (브론즈 1)

    -문제
    두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

    -입력
    첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

    -출력
    첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

    예제입력
    24 18

    예제 출력
    6
    72

 */

//재귀방식
public class 백준_2609최대공약수최소공배수_Dante {

    // 최대공약수 재귀 방식
    public static int gcd(int a, int b) {
        if (b == 0) {  // b가 0 이면 , a는 최대공약수
            return a;
        }else {
            // GCD(a, b) = GCD(b, r)이므로 (r = a % b)
            return gcd(b, a % b); // 1. GCD(24, 18)
            // 2. GCD(18, 6)
            // 3. GCD(6, 0)
            // 1==2==3   -> 끝
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        int d = gcd(a, b);	// 최대공약수

        System.out.println(d);
        System.out.println(a * b / d);

    }
}

