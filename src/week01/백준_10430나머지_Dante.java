package week01;
import java.util.Scanner;

/*
    10430. 나머지

    -문제
    (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
    (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
    세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)

    출력
    첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.

    예제 입력
    5 8 4

    예제 출력
    1
    1
    0
    0
 */
public class 백준_10430나머지_Dante {
    public void solution(int A, int B, int C) {
        int a = (A+B)%C;
        int b = ((A%C) + (B%C))%C;
        int c = (A*B)%C;
        int d = ((A%C) * (B%C))%C;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public static void main(String[] args) {
        백준_10430나머지_Dante T = new 백준_10430나머지_Dante();
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();

        T.solution(num1, num2,num3);


    }
}
