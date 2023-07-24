package bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int num_tomatos = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        class tomato {
            int x;
            int y;
            tomato(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[][] tomatos = new int[n][m];
        Queue<tomato> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomatos[i][j] = Integer.parseInt(st.nextToken());
                if (tomatos[i][j] == 1) {
                    q.add(new tomato(i, j));
                } else if (tomatos[i][j] == 0) {
                    num_tomatos++;
                }
            }
        }

        tomato current;
        while (!q.isEmpty()) {
            current = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];

                if
                if (tomatos[current.x + dx[i]][current.y + dy[i]] == 0) {

                }
            }

        }

        if (num_tomatos != 0) {
            System.out.println("-1");
        }

    }
}
