package random;

import java.io.*;

public class BOJ7682 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                break;
            } else {
                char[][] map = makeTicTacToe(line);
                find(map);
            }
        }

        System.out.println(sb);

    }

    static void find(char[][] map) {

        boolean isValid = true;
        int cntX = 0;
        int cntO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'O') {
                    cntO++;
                } else if (map[i][j] == 'X') {
                    cntX++;
                }
            }
        }

        if (cntO > cntX) {
            sb.append("invalid").append('\n');
            return;
        } else if (cntX > cntO + 1) {
            sb.append("invalid").append('\n');
            return;
        }

        if (isValid) {
            sb.append("valid").append('\n');
            return;
        }

        // 승리가 나온 경우

        isValid = true;

        // 가로
        if (garo(map)) {
            sb.append("valid").append('\n');
            return;
        }

        // 세로3
        if (sero(map)) {
            sb.append("valid").append('\n');
            return;
        }

        // 대각선2
        char main = map[1][1];
        if (main == '.') {
            sb.append("invalid").append('\n');
            return;
        } else if (map[0][0] == main && map[2][2] == main) {
            sb.append("valid").append('\n');
            return;
        } else if (map[0][2] == main && map[2][0] == main) {
            sb.append("valid").append('\n');
            return;
        } else {
            sb.append("invalid").append('\n');
        }
    }

    static char[][] makeTicTacToe(String line) {
        char[][] map = new char[3][3];
        int idx = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = line.charAt(idx++);
            }
        }

        return map;
    }

    static boolean garo(char[][] map) {
        // 1행
        char value = map[0][0];
        if (map[0][1] == value && map[0][2] == value && value != '.') {
            return true;
        }
        // 2행
        value = map[1][0];
        if (map[1][1] == value && map[1][2] == value && value != '.') {
            return true;
        }

        // 3행
        value = map[2][0];
        if (map[2][1] == value && map[2][2] == value && value != '.') {
            return true;
        }

        return false;
    }

    static boolean sero(char[][] map) {
        // 1열
        char value = map[0][0];
        if (map[1][0] == value && map[2][0] == value && value != '.') {
            return true;
        }
        // 2열
        value = map[0][1];
        if (map[1][1] == value && map[2][1] == value && value != '.') {
            return true;
        }
        // 3열
        value = map[0][2];
        if (map[1][2] == value && map[2][2] == value && value != '.') {
            return true;
        }

        return false;
    }

}
