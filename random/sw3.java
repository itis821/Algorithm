package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == b) {
                sb.append(0).append("\n");
                continue;
            }

            // a, b 좌표 찾기
            int[][] coord = new int[3][2];
            boolean[] find = new boolean[2];

            for (int n = 1; n <= 141; n++) {
                int start = (n * (n + 1) / 2) - n + 1;

                if (!find[0] && start <= a) {
                    find[0] = true;
                    coord[0][0] = n - 1;
                    coord[0][1] = a - start;
                }

                if (!find[1] && start <= b) {
                    find[1] = true;
                    coord[1][0] = n - 1;
                    coord[1][1] = b - start;
                }

                if (find[0] && find[1]) {
                    break;
                }

            } // for문

            coord[2][0] = Math.abs(coord[1][0] - coord[0][0]);
            coord[2][1] = Math.abs(coord[1][1] - coord[0][1]);

            sb.append(Math.max(coord[2][0], coord[2][1])).append("\n");

        }

        System.out.println(sb.toString());
    }

}
