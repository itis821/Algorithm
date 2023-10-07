import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20125 {
    // 머리, 심장, 허리 ,좌우 팔 다리
    // 심장 위에 머리
    // 왼쪽 팔 심장 왼쪽
    //

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 5<= N <=1,000

        char[][] cookies = new char[N + 1][N + 1];

        String line;
        for (int i = 1; i <= N; i++) {
            line = br.readLine();
            for (int j = 1; j <= N; j++) {
                cookies[i][j] = line.charAt(j - 1);
            }
        }

        // 상하좌우
        int[] dr = { -1, +1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        boolean isHeart = true;
        int[] heart = new int[2];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                isHeart = true;

                for (int i = 0; i < 4; i++) {
                    // 범위 검사
                    if (!(r + dr[i] >= 1 && r + dr[i] <= N && c + dc[i] >= 1 && c + dc[i] <= N)) {
                        isHeart = false;
                        break;
                    }

                    // 유효성 검사
                    if (cookies[r + dr[i]][c + dc[i]] != '*') {
                        isHeart = false;
                        break;
                    }

                }

                if (isHeart) {
                    heart[0] = r;
                    heart[1] = c;
                    break;
                }

            }
        }

        // 심장 위치
        System.out.println(heart[0] + " " + heart[1]);

        int hr = heart[0];
        int hc = heart[1];

        // 왼팔
        int tmp_r = heart[0];
        int tmp_c = heart[1]; // col --
        int left_hand_len = 0;
        while (true) {
            tmp_c--;

            if (tmp_c >= 1 && cookies[tmp_r][tmp_c] == '*') {
                left_hand_len++;
            } else {
                break;
            }
        }

        // 오른팔
        tmp_r = heart[0];
        tmp_c = heart[1];
        int right_hand_len = 0;
        while (true) {
            tmp_c++;

            if (tmp_c <= N && cookies[tmp_r][tmp_c] == '*') {
                right_hand_len++;
            } else {
                break;
            }
        }

        // 허리
        tmp_r = heart[0];
        tmp_c = heart[1];
        int huri_len = 0;
        while (true) {
            tmp_r++;

            if (tmp_r <= N && cookies[tmp_r][tmp_c] == '*') {
                huri_len++;
            } else {
                break;
            }
        }

        // 왼다리
        tmp_r = heart[0] + huri_len + 1;
        tmp_c = heart[1] - 1;
        int left_leg_len = 0;
        while (true) {

            if (tmp_r <= N && cookies[tmp_r][tmp_c] == '*') {
                left_leg_len++;
            } else {
                break;
            }

            tmp_r++;
        }

        // 오른다리 길이
        tmp_r = heart[0] + huri_len + 1;
        tmp_c = heart[1] + 1;
        int right_leg_len = 0;
        while (true) {

            if (tmp_r <= N && cookies[tmp_r][tmp_c] == '*') {
                right_leg_len++;
            } else {
                break;
            }

            tmp_r++;
        }

        System.out.println(
                left_hand_len + " " + right_hand_len + " " + huri_len + " " + left_leg_len + " " + right_leg_len);

    }
}
