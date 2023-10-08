package binarysearch;

import java.io.*;
import java.util.*;

class BOJ10816 {

    static int N;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 입력끝

        Arrays.sort(cards);
        StringBuilder output = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = -1;

        for (int i = 0; i < M; i++) {

            // nums[i] 가 있다면 인덱스 없다면 -1 리턴
            if (map.containsKey(nums[i])) {
                output.append(map.get(nums[i])).append(" ");
            } else {
                idx = binarySearch(nums[i]);

                if (idx != -1) { // 인덱스가 있다면
                    // 근처에 몇 개 있는지 탐색
                    int count = counting(idx);

                    // 개수 출력에 추가
                    map.put(nums[i], count);
                    output.append(count).append(" ");

                } else {// 인덱스가 없다면 0을 출력에 추가
                    map.put(nums[i], 0);
                    output.append('0').append(" ");
                }
            }

        }

        System.out.println(output);

    } // main

    static int counting(int idx) {
        int left = idx - 1;
        int right = idx + 1;
        int lc = 0;
        int rc = 0;

        while (left >= 0) {
            if (cards[idx] == cards[left]) {
                lc++;
                left--;
            } else {
                break;
            }
        }

        while (right < N) {
            if (cards[idx] == cards[right]) {
                rc++;
                right++;
            } else {
                break;
            }
        }

        return lc + rc + 1;
    }

    static int binarySearch(int target) {
        int st = 0;
        int en = N - 1;
        int found_idx = -1;

        while (st <= en) {
            int mid = (st + en) / 2;

            if (cards[mid] > target) {
                en = mid - 1;
            } else if (cards[mid] < target) {
                st = mid + 1;
            } else {
                found_idx = mid;
                break;
            }

        }

        return found_idx;
    }
}