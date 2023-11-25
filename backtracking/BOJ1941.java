package backtracking;

import java.io.*;
import java.util.*;

// 11월 25일(토) 16:18~

public class BOJ1941 {
    // 출력 : 소문난 칠공주 결성할 경우의 수
    static int ans = 0;
    static char[][] map;

    public static void main(String[] args) throws IOException {

        map = new char[5][5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();

            for (int j = 0; j < 5; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        solution(0, 0);

        System.out.println(ans);

    }// main

    // 가로, 세로 인접
    // 7명 중 이다솜파 4명 이상
    // S(이다솜), Y(임도연)

    static int[][] members = new int[7][2]; // [depth][좌표]

    // 1. 추출(25C7)
    static void solution(int depth, int start) {

        if (depth == 7) {

            // 3. 조건 만족 한다면 카운트
            if (isValid())
                ans++;

            return;
        }

        // 2차원 배열을 1차원 배열로 변경
        // 그 다음 depth 에는 지금 조사 다음 거부터

        int i = start / 5;
        int j = start % 5;

        for (; i < 5; i++) {

            for (; j < 5; j++) {

                members[depth][0] = i;
                members[depth][1] = j;

                int next = 5 * i + j + 1;
                // i * 5 + j
                solution(depth + 1, next);
            }
        }

    }

    static boolean isValid() {
        int sCnt = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'S') {
                    sCnt++;
                }
            }
        }

        // 2-1. 이다솜파(S) 4명 이상
        if (sCnt < 5) {
            return false;
        }

        // 2-2. 연결확인(bfs)
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[7];

        q.offer(0);
        isVisited[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 0; i < 7; i++) {

                if (isVisited[i])
                    continue;

                if (!isInjup(curr, i))
                    continue;

                isVisited[i] = true;
                q.offer(i);
            }
        }

        for (int i = 0; i < 7; i++) {
            if (isVisited[i] == false) {
                return false;
            }
        }

        return true;

    }

    static boolean isInjup(int curr, int i) {
        int cr = members[curr][0];
        int cc = members[curr][1];
        int ir = members[i][0];
        int ic = members[i][1];

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        for (int idx = 0; idx < 4; idx++) {
            if (cr + dr[idx] == ir && cc + dc[idx] == ic) {
                return true;
            }
        }

        return false;
    }

}
