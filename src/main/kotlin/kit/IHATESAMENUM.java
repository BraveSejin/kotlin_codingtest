package kit;


import java.util.*;

class IHATESAMENUM {
    public static void main(String[] args) {

        int[] ans = new Solution().solution(new int[]{1, 1, 3, 3, 0, 1, 1});

        System.out.println(new ArrayList<>() {
            {
                for (int i : ans) add(i);
            }
        });

    }

    private static class Solution {
        public int[] solution(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            for (int i : arr) {
                if (stack.isEmpty() || stack.lastElement() != i) stack.add(i);
                else if (stack.lastElement() == i) continue;
            }
//            int[] answer = stack.stream().mapToInt(it -> it).toArray();
            int [] answer = new int[stack.size()];
            for (int i : stack){
                answer[i] = stack.get(i);
            }

            return answer;
        }
    }
}
