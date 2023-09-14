package backtracking;

import java.util.*;
import java.io.*;

public class BOJ9663 {
    public static int[][] board;
    public static int count = 0;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        solution(0, 0, 0);
        System.out.print(count);
    }

    public static void solution(int n, int row, int col) {
        if (n == N) {
            count++;
            return;
        }

        for (int i = row; i < N; i++) {
            for (int j = col; j < N; j++) {
                if (board[i][j] != 0) // 놓을 수 없는 자리
                    continue;

                fill(i, j);
                solution(n + 1, i + 1, j + 1);
                defill(i, j);
            }
        }
    }

    public static void fill(int row, int col) {

        // 세로
        for (int i = 0; i < N; i++) {
            board[i][col] += 1;
        }

        // 가로
        for (int i = 0; i < N; i++) {
            board[row][i] += 1;
        }

        for(int i = )
        board[row][col] -= 1;
    }

    public static void defill(int row, int col) {
        for (int i = 0; i < N; i++) {
            board[i][col] -= 1;
        }

        for (int i = 0; i < N; i++) {
            board[row][i] -= 1;
        }
        board[row][col] += 1;
    }
}
