package week02;

public class 프로그래머스_최소직사각형_hunojung {
    public static void main(String[] args) {
        int[][] arr = {{60, 50},{30, 70},{60, 30},{80, 40}};
        int[][] arr2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7},{5, 15}};
        int[][] arr3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        최소직사각형 s = new 최소직사각형();
        int answer = s.solution(arr);
        System.out.println(answer);
        answer = s.solution(arr2);
        System.out.println(answer);
        answer = s.solution(arr3);
        System.out.println(answer);
        System.exit(0);
    }
}

class 최소직사각형{
    public int solution(int[][] sizes){
        int h=0, w=0;
        for(int[] size:sizes){
            h = Math.max(h,Math.max(size[0],size[1]));
            w = Math.max(w,Math.min(size[0],size[1]));
        }
        return h*w;
    }
}
