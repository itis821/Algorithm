package backtracking;

import java.io.*;
import java.util.*;

public class BOJ1941 {
    static char[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        ans = 0;

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        comb(0, 0);
        System.out.println(ans);
    }

    static int[] result = new int[7];

    public static void comb(int at, int depth) {
        if (depth == 7) {
            if (isValid1() && isValid2()) {
                ans++;
            }
            return;
        }

        for (int i = at; i < 25; i++) {
            result[depth] = i;
            comb(i + 1, depth + 1);
        }
    }

    public static boolean isValid1() {
        int cnt = 0;

        for (int i = 0; i < 7; i++) {
            int[] curr = one2two(result[i]);
            if (map[curr[0]][curr[1]] == 'S') {
                cnt++;
            }
        }

        if (cnt >= 4) {
            return true;
        }

        return false;
    }

    public static boolean isValid2() {
        int[][] myMap = new int[5][5];
        boolean[][] isVisited = new boolean[5][5];

        for (int i = 0; i < 7; i++) {
            int[] curr = one2two(result[i]);
            myMap[curr[0]][curr[1]] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        int[] f = one2two(result[0]);
        q.offer(new int[] { f[0], f[1] });
        isVisited[f[0]][f[1]] = true;

        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        int count = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
                    continue;

                if (isVisited[nr][nc])
                    continue;

                if (myMap[nr][nc] == 0)
                    continue;

                isVisited[nr][nc] = true;
                q.offer(new int[] { nr, nc });
                count++;
            }
        }

        if (count == 7) {
            return true;
        }
        return false;
    }

    public static int[] one2two(int n) {
        int[] val = new int[2];
        val[0] = n / 5;
        val[1] = n % 5;
        return val;
    }
}
