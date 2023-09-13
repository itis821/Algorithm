package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

class BOJ2178 {
    public static void main(String[] args) throws IOException {
        // 최단 경로 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] miro = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        // (0,0) -> (n-1, m-1)
        boolean[][] isVisited = new boolean[n][m];
        Queue<Dot> queue = new LinkedList<>();
        int shortcut = 0;

        // 이동(상하좌우)
        int[] d_row = { -1, 1, 0, 0 };
        int[] d_col = { 0, 0, -1, 1 };

        queue.offer(new Dot(0, 0, 1));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Dot d = queue.poll();

            for (int i = 0; i < 4; i++) {
                int row = d.row + d_row[i];
                int col = d.col + d_col[i];

                // 범위 검사
                boolean bound = (row >= 0 && col >= 0 && row < n && col < m);
                if (!bound)
                    continue;

                // 유효성 검사
                if (miro[row][col] == 0)
                    continue;

                // 중복검사
                if (isVisited[row][col])
                    continue;

                // 방문 처리
                isVisited[row][col] = true;
                queue.offer(new Dot(row, col, d.count + 1));

                if (row == n - 1 && col == m - 1) {
                    shortcut = d.count + 1;
                    break;
                }
            }
        }

        System.out.println(shortcut);
    }

    static class Dot {
        int row;
        int col;
        int count;

        Dot(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}