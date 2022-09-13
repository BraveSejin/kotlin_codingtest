package kit;

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"leo", "kiki", "eden"},new String[]{"kiki", "eden"} );
    }

    private static class Solution {
        public String solution(String[] participant, String[] completion) {

            HashMap<String, Integer> map = new HashMap<>();
            for (String s : participant) {
                Integer val = map.get(s);
                if (val == null)
                    map.put(s, 1);
                else map.put(s, val + 1);
            }

            for (String s : completion) {
                Integer val = map.get(s);
                if (val == null)
                    continue;
                if (val == 1)
                    map.remove(s);
                map.replace(s, val-1);
            }

            String answer = (String) map.keySet().toArray()[0];
            return answer;
        }
    }


}


