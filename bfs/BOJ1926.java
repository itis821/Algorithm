package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

class BOJ1926 {

    static class Dot {
        int row;
        int col;

        Dot(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Dot> queue = new LinkedList<>();
        Stack<Dot> stack = new Stack<>();
        boolean[][] isVisited = new boolean[n][m];

        int[][] art = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    Dot dot = new Dot(i, j);
                    stack.push(dot);
                }
                art[i][j] = value;
            }
        }
        // 입력 끝 n, m, art[][]

        int count = 0;
        int max_size = 0;

        while (!stack.isEmpty()) {
            Dot dot = stack.pop();
            if (isVisited[dot.row][dot.col])
                continue;

            queue.offer(dot);
            isVisited[dot.row][dot.col] = true;
            count++;

            int size = 0;
            while (!queue.isEmpty()) {
                int[] drow = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
                int[] dcol = { 0, 0, -1, 1 };

                Dot d = queue.poll();
                size++;

                for (int i = 0; i < 4; i++) {
                    int row = d.row + drow[i];
                    int col = d.col + dcol[i];
                    boolean bound = (0 <= row && 0 <= col && row < n && col < m);

                    // 범위 검사
                    if (!bound)
                        continue;

                    // 유효성 검사
                    if (art[row][col] == 0)
                        continue;

                    // 중복검사
                    if (isVisited[row][col] == true)
                        continue;

                    // 방문처리
                    isVisited[row][col] = true;
                    queue.offer(new Dot(row, col));
                }

                if (size > max_size)
                    max_size = size;
            }
        }

        System.out.println(count);
        System.out.println(max_size);
    }
}