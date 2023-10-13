package random;

import java.io.*;
import java.util.*;

public class BOJ16967 {
    static int[][] A;
    static int[][] B;
    static int H, W, X, Y;

    public static void main(String[] args) throws IOException {
        // int[H][W] A
        // int[H+X][W+Y] B
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        H = Integer.parseInt(st.nextToken()); // 2<= H <=300
        W = Integer.parseInt(st.nextToken()); // 2<= W <= 300
        X = Integer.parseInt(st.nextToken()); // 1<= X < H
        Y = Integer.parseInt(st.nextToken()); // 1<= Y < W

        A = new int[H][W];
        B = new int[H + X][W + Y];

        for (int r = 0; r < H + X; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < W + Y; c++) {
                B[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                check(r, c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                sb.append(A[r][c]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void check(int r, int c) {

        if (gyupchu(r, c)) {
            A[r][c] = B[r][c] - A[r - X][c - Y];
        } else {
            A[r][c] = B[r][c];
        }

    }

    static boolean gyupchu(int r, int c) {
        if (r >= X && r < H && c >= Y && c < W) {
            return true;
        } else {
            return false;
        }
    }

}
