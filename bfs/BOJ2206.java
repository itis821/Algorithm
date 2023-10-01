package bfs;

import java.util.*;
import java.io.*;

public class BOJ2206 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];

        String line;
        for (int r = 1; r <= N; r++) {
            line = br.readLine();
            for (int c = 1; c <= M; c++) {
                map[r][c] = line.charAt(c - 1) - '0';
            }
        }
    }

}
