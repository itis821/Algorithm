package simulation;

import java.io.*;
import java.util.*;

// BOJ15684
// 사디로 조작 , 골드3
public class BOJ15684 {
    public static void main(String[] args) throws IOException {
        // 두 가로선 연속 x
        // 두 가로선 접하면 x
        // i번 세로선의 결과 -> i
        // 추가해야하는 가로선 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 2 <= N <= 10 (열 수)
        int M = Integer.parseInt(st.nextToken()); // 0 <= M <= (N-1) * H (이미 놓은 선)
        int H = Integer.parseInt(st.nextToken()); // 1 <= H <= 30 (행 수)

        int ans = -1;

        // 가능한 가로선 (N-1) * H
        // 사다리 추상화 boolean[N-1][H]
        boolean[][] sadari = new boolean[N - 1][H];

        for (int i = 0; i < M; i++) {
            // 가로선 입력
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            sadari[row][col] = true;
        }

        // 사다리 결과 확인, 사다리 추가 없음
        if (playSadari(H, N, sadari)) {
            ans = 0;
            System.out.println(ans);
            return;
        }

        // 1 <= (N-1) * H <= 270
        // 사다리 1개 추가
        // 270C1 사다리 1개 추가
        if (addSadari(H, N, sadari)) {
            ans = 1;
            System.out.println(ans);
            return;
        }

        // 사다리 2개 추가
        // 270C2 사다리 2개 추가

        // 사다리 3개 추가
        // 270C3 사디리 3개 추가

        // 그 외

        // 이외 -1 출력
        // boolean[i][j] -> j번째 행에 i와 i+1을 연결하는 사다리
    }

    static boolean playSadari(int H, int N, boolean[][] sadari) {
        boolean result = true;

        // i번째 라인 사다리 출발
        for (int i = 0; i < N; i++) {
            // 현재 위치
            int curr = i;

            // 한 행 씩 이동
            for (int j = 0; j < H; j++) {
                // 현재 위치가 0일 경우
                if (curr == 0) {
                    // 오른쪽에 사다리가 있을 경우
                    if (sadari[j][curr]) {
                        curr = 1;
                    }
                }
                // 현재 위치가 N-1 일 경우
                else if (curr == N - 1) {
                    // 왼쪽에 사다리가 있을 경우
                    if (sadari[j][curr - 1]) {
                        curr = curr - 1;
                    }
                }
                // 현재 위치가 중간일 경우
                else {
                    // 왼쪽에 사다리가 있을 경우
                    if (sadari[j][curr - 1]) {
                        curr = curr - 1;
                    }
                    // 오른쪽에 사다리가 있을 경우
                    else if (sadari[j][curr]) {
                        curr = curr + 1;
                    }
                }
            }

            if (curr != i) {
                result = false;
                break;
            }

        }

        return result;
    }

    static boolean addSadari(int H, int N, boolean[][] sadari) {
        int row = sadari.length;
        int col = sadari[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // 이미 사다리 있는 경우
                if (sadari[i][j])
                    continue;

                // 사다리 연속 조건1
                if (j - 1 >= 0 && sadari[i][j - 1])
                    continue;

                // 사다리 연속 조건2
                if (j + 1 < col && sadari[i][j + 1])
                    continue;

                sadari[i][j] = true;
                if (playSadari(H, N, sadari)) {
                    return true;
                }
                sadari[i][j] = false;

            }
        }

        return false;
    }
}
