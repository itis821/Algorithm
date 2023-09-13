package bfs;

import java.io.*;
import java.util.*;

public class BOJ7576 {
    static class Tomato {
        int row;
        int col;
        int day;

        Tomato(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken()); // 열
        int n = Integer.parseInt(st.nextToken()); // 행

        int[][] tomatos = new int[n][m];
        int zero_count = 0;
        boolean[][] isVisited = new boolean[n][m];
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {

                tomatos[i][j] = Integer.parseInt(st.nextToken());

                if (tomatos[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                    isVisited[i][j] = true;
                } else if (tomatos[i][j] == 0) {
                    zero_count++;
                }
            }
        }

        if (zero_count == 0) {
            System.out.println("0");
            return;
        }

        // 상하좌우
        int[] d_row = { -1, 1, 0, 0 };
        int[] d_col = { 0, 0, -1, 1 };

        int max = 0;

        while (!queue.isEmpty()) {
            Tomato t = queue.poll();

            for (int i = 0; i < 4; i++) {
                int row = t.row + d_row[i];
                int col = t.col + d_col[i];

                // 범위 검사
                boolean bound = (row >= 0 && col >= 0 && row < n && col < m);
                if (!bound)
                    continue;

                // 유효성 검사
                if (tomatos[row][col] != 0)
                    continue;

                // 중복 검사
                if (isVisited[row][col])
                    continue;

                // 방문 체크
                isVisited[row][col] = true;
                zero_count--;
                queue.offer(new Tomato(row, col, t.day + 1));
                max = t.day + 1;
            }
        }

        if (zero_count != 0)
            System.out.println("-1");
        else
            System.out.println(max);
    }
}
