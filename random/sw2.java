package random;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2 {

    static int[][] cost;
    static int min;
    static int[] pick;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            int N = Integer.parseInt(br.readLine()); // 1 <= N <= 50

            int[][] ability = new int[N][3];
            cost = new int[N][3];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    ability[i][j] = Integer.parseInt(st.nextToken());
                    sum += ability[i][j];
                }

                for (int j = 0; j < 3; j++) {
                    cost[i][j] = sum - ability[i][j];
                }

            } // ability, cost

            if (N < 3) {
                sb.append(-1).append("\n");
                continue;
            }

            pick = new int[3];
            isVisited = new boolean[N];
            pick_three(0, N);
            sb.append(min + "\n");
        }

        System.out.println(sb.toString());
    }

    static void pick_three(int depth, int N) {
        if (depth == 3) {
            int cnt = 0;

            for (int i = 0; i < 3; i++) {
                cnt += cost[pick[i]][i];
            }

            for (int i = 0; i < N; i++) {
                if (isVisited[i] == false) {
                    cnt += Math.min(cost[i][0], Math.min(cost[i][1], cost[i][2]));
                }
            }

            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                pick[depth] = i;
                isVisited[i] = true;
                pick_three(depth + 1, N);
                isVisited[i] = false;
            }
        }
    }

}
