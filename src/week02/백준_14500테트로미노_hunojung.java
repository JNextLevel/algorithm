package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14500테트로미노_hunojung {
    public static void main (String[]z) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = solution(map);
        System.out.println(answer);
        br.close();
        System.exit(0);
    }

    static int solution(int[][] map){
        int N = map.length;
        int M = map[0].length;
        int max = 0;

        //19개
        int[][][] block = {
                // 1자
                {{0,1,2,3},{0,0,0,0}},
                {{0,0,0,0},{0,1,2,3}},
                // ㅁ
                {{0,0,1,1},{0,1,0,1}},
                // ㄱ자
                {{0,1,2,2},{0,0,0,1}},
                {{0,0,0,1},{0,1,2,0}},
                {{0,0,1,2},{0,1,1,1}},
                {{0,1,1,1},{2,2,1,0}},
                // ㄱ 대칭뒤집기
                {{0,1,2,2},{1,1,1,0}},
                {{0,1,1,1},{0,0,1,2}},
                {{0,0,1,2},{0,1,0,0}},
                {{0,0,0,1},{0,1,2,2}},
                // 지그재그
                {{0,1,1,2},{0,0,1,1}},
                {{1,1,0,0},{0,1,1,2}},
                // 지그재그 대칭
                {{0,1,1,2},{1,1,0,0}},
                {{0,0,1,1},{0,1,1,2}},
                //ㅗ
                {{1,1,1,0},{0,1,2,1}},
                {{0,1,1,2},{0,0,1,0}},
                {{0,0,0,1},{0,1,2,1}},
                {{0,1,2,1},{1,1,1,0}}
        };

        // map 좌표 다 돌기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // 19개 종류
                for (int k = 0; k < 19; k++) {
                    int sum = 0;
                    int count_checked_block = 0; // 4칸이 다 포함된경우만 정답 비교

                    for (int l = 0; l < 4; l++) {
                        int h = i+block[k][0][l];
                        int w = j+block[k][1][l];
                        if(h>-1 && h<N && w>-1 && w<M){
                            count_checked_block ++;
                            sum += map[h][w];
                        }else{
                            break;
                        }
                    }

                    if(count_checked_block==4){
                        max = Math.max(max,sum);
                    }
                }
            }
        }

        return max;
    }
}
