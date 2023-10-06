import java.io.*;
import java.util.*;

class BOJ1446 {

    // N이 12이므로 모든 지름길의 경우의 수를 본다고 해도 2^12로 시간복잡도가 크지 않다.
    // 지름길이 겹치지 않는다면 모두 선택하는게 좋음
    // 줄어드는 거리가 가장 큰 도로를 택하는게 좋지 않나

    static final int START = 0;
    static final int END = 1;
    static final int LEN = 2;

    static int[][] shortArr;
    static boolean[] gyungwu;
    static int N;
    static int D;
    static int shortDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 1<= N <=12
        D = Integer.parseInt(st.nextToken()); // 1<= D <= 10,000

        shortArr = new int[N][3];
        gyungwu = new boolean[N];
        shortDistance = D;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            shortArr[i][START] = Integer.parseInt(st.nextToken());
            shortArr[i][END] = Integer.parseInt(st.nextToken());
            shortArr[i][LEN] = Integer.parseInt(st.nextToken());
        }

        find(0);
        System.out.println(shortDistance);

    }// main

    static void find(int depth) {
        if (depth == N) {
            // 거리 계산
            calcul();
            return;
        }

        for (int i = 0; i <= 1; i++) {
            if (i == 0) {
                gyungwu[depth] = false;
            } else {
                gyungwu[depth] = true;
            }

            find(depth + 1);
        }

    }// find()

    // 지름길 유효하다면 거리 구하기
    static void calcul() {
        int current = 0;
        int guri = 0;
        boolean gyupchu = false;
        LinkedList<int[]> list = new LinkedList<>();

        // 해당되는 지름길 저장
        for (int i = 0; i < N; i++) {
            if (gyungwu[i]) {
                list.add(new int[] { shortArr[i][START], shortArr[i][END], shortArr[i][LEN] });
            }
        }

        // 지름길 정렬
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[] tmp;
        for (int i = 0; i < list.size(); i++) {
            tmp = list.get(i);

            // 지름길의 끝이 고속도로 끝을 넘을 경우
            if (tmp[END] > D) {
                gyupchu = true;
                break;
            }

            // 현재 위치가 지름길 시작전일 경우
            if (current <= tmp[START]) {

                // 현재에서 지름길 까지 가는 거리
                guri += (tmp[START] - current);

                // 지름길 거리
                guri += tmp[LEN];

                // 현재 위치 바꿔주기
                current = tmp[END];

            } else {
                gyupchu = true;
                break;
            }
        }

        // 마지막 지름길부터 고속도로 끝까지 거리
        guri += (D - current);

        if (!gyupchu) {
            shortDistance = Math.min(shortDistance, guri);
        }

    }// calcul()

}
