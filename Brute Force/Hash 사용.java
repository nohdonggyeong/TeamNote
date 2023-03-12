import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums, String[] participant, String[] completion) {
            
            // 브루트 포스(완전 탐색)으로는 시간초과에 빠지게 되는 문제에서는 해시를 적용시켜야 한다.
        
            // 주어지는 배열에서 짧은 시간으로 찾아내야하는 문제 : 중복불허 HashSet, 중복허용 HashMap
            // hashset: value를 자바에서 자동으로 임의 지정하며 key에 중복을 배제하고 값을 넣음.
            // hashmap: key와 value를 개발자가 직접 기입하고 키의 중복을 배제함.
            // hash는 키를 이용해서 값을 찾기 때문에 검색 알고리즘에 매우 효율적.
            
            // arraylist: 사용자가 정의한 <제너릭>객체에 맞는 값을 넣어 저장하고 중복 삽입이 가능.
            // 수정 변경시 배열을 새로 생성해서 배열채로 집어넣기에 수정이 상대적으로 느림. 또한 키로 값을 찾을 수 없기에 검색 알고리즘에 매우 느린 속도
            // 단, foreach문에선 arraylist가 더 빠름
        
        
            // HashSet 예제: 중복 없고 검색 빠른 set을 생성
            // intAnswer: 중복 없는 set의 요소 수
            int intAnswer = 0;
            HashSet<Integer> hs = new HashSet<>();
            for(int i =0; i<nums.length; i++) {
                hs.add(nums[i]);                
            }
            intAnswer = hs.size();
            
        
            // HashMap 예제: key값의 개수를 함께 저장
            String strAnswer = "";
            HashMap<String, Integer> hm = new HashMap<>();
            for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
            for (String player : completion) hm.put(player, hm.get(player) - 1);
            for (String key : hm.keySet()) {
                if (hm.get(key) != 0){
                    strAnswer = key;
                }
            }        
            

    }
}

            
