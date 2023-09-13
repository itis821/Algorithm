package recursion;

import java.io.*;
import java.util.*;

public class BOJ1780 {
    static int[] count = { 0, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 끝

        recursion(matrix, n, 0, 0);
        System.out.print(count[0] + "\n" + count[1] + "\n" + count[2]);

    }

    public static void recursion(int[][] matrix, int n, int r, int c) {
        int start = matrix[r][c];
        boolean check = true;

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (matrix[i][j] != start) {
                    check = false;
                    break;
                }
            }
            if (!check)
                break;
        }

        if (check) {
            if (start == -1) {
                count[0]++;
            } else if (start == 0) {
                count[1]++;
            } else if (start == 1) {
                count[2]++;
            }
            return;
        }

        recursion(matrix, n / 3, r, c);
        recursion(matrix, n / 3, r, c + n / 3);
        recursion(matrix, n / 3, r, c + 2 * n / 3);

        recursion(matrix, n / 3, r + n / 3, c);
        recursion(matrix, n / 3, r + n / 3, c + n / 3);
        recursion(matrix, n / 3, r + n / 3, c + 2 * n / 3);

        recursion(matrix, n / 3, r + 2 * n / 3, c);
        recursion(matrix, n / 3, r + 2 * n / 3, c + n / 3);
        recursion(matrix, n / 3, r + 2 * n / 3, c + 2 * n / 3);

    }

}
