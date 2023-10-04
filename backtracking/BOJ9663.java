package backtracking;

import java.io.*;

public class BOJ9663 {
    static int cnt = 0;
    static int[][] queens;
    static int N;
    static final int COL = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 1<= N < 15
        queens = new int[N][1];

        // 한 행에는 한 개의 퀸만 놓을 수 있음
        // 한 행씩 퀸을 놓을 위치 정하기
        find(0);
        System.out.println(cnt);
    }

    static void find(int line) {
        if (line == N) {
            cnt++;
            return;
        }
        boolean gyupchu = false;

        for (int col = 0; col < N; col++) { // 퀸을 놓을 열 정하기
            gyupchu = false;

            // 그 동안 퀸 놓은 곳 확인
            for (int i = 0; i < line; i++) {

                // 열 겹침
                if (queens[i][COL] == col) {
                    gyupchu = true;
                    break;
                }

                // 대각 겹침
                if (daegak(line, col, i, queens[i][COL])) {
                    gyupchu = true;
                    break;
                }

            }

            if (gyupchu)
                continue;

            // 퀸 놓기
            queens[line][0] = col;
            find(line + 1);
        }
    }

    static boolean daegak(int r1, int c1, int r2, int c2) {
        if (Math.abs(r1 - r2) == Math.abs(c1 - c2)) {
            return true;
        } else {
            return false;
        }

    }

}
