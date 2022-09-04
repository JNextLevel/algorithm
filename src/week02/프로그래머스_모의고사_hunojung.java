package week02;


public class 프로그래머스_모의고사_hunojung {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = {1,3,2,4,2};
        모의고사 s = new 모의고사();
        int[] answer = s.solution(arr2);
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
        System.exit(0);
    }
}
class 모의고사{
    public int[] solution(int[] answers){
        int[] scores = new int[3];
        int max_score = 0;
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};

        for(int i=0;i<answers.length;i++){
            if(answers[i] == student1[i%5]){
                scores[0]++;
                max_score = Math.max(max_score,scores[0]);
            }

            if(answers[i] == student2[i%8]){
                scores[1]++;
                max_score = Math.max(max_score,scores[1]);
            }

            if(answers[i] == student3[i%10]){
                scores[2]++;
                max_score = Math.max(max_score,scores[2]);
            }
        }

        int max_student = 0;
        for(int i=0;i<3;i++){
            if(scores[i]==max_score){
                max_student++;
            }
        }

        int[] answer = new int[max_student];
        int idx = 0;
        for(int i=0;i<3;i++){
            if(scores[i]==max_score){
                answer[idx++] = i+1;
            }
        }
        return answer;
    }
}