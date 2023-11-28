package simulation;

import java.io.*;
import java.util.*;

class BOJ13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1 line
        int n = Integer.parseInt(st.nextToken()); // 트럭 수 1 <= n <= 1,000
        int w = Integer.parseInt(st.nextToken()); // 다리 길이 1 <= w <= 100
        int L = Integer.parseInt(st.nextToken()); // 다리 최대 하중 10 <= L <= 1,000

        // 2 line
        st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> q = new LinkedList<>();
        List<Integer> bridgeTime = new LinkedList<>();
        List<Integer> bridgeWeight = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int truck = Integer.parseInt(st.nextToken());
            q.offer(truck);
        }

        // logic
        int time = 0;

        while (!q.isEmpty()) {
            time++;

            // 다리에 있는 트럭 한 칸 이동
            for (int i = 0; i < bridgeTime.size(); i++) {
                bridgeTime.set(i, bridgeTime.get(i) + 1);
            }

            // 다리 통과
            for (int i = 0; i < bridgeTime.size(); i++) {
                if (bridgeTime.get(i) > w) {
                    bridgeTime.remove(i);
                    bridgeWeight.remove(i);
                }
            }

            // 현재 다리를 건널 수 있는 무게 확인
            int canWeight = L;
            for (int i = 0; i < bridgeWeight.size(); i++) {
                canWeight -= bridgeWeight.get(i);
            }

            int waitTruck = q.peek();

            // 대기 중 트럭이 통과할 수 있으면
            if (canWeight >= waitTruck) {

                // 다리 진입
                bridgeTime.add(1);
                bridgeWeight.add(q.poll());
            }

        }

        // 다리에 남아있는 트럭 지나가기
        time += w;

        // output
        System.out.println(time);
    }
}