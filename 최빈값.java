import java.util.*;

class Solution {
    public void solution(int[] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int el : array){
            int mapValue = map.getOrDefault(el, 0);
            map.put(el, mapValue + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        for(Map.Entry<Integer, Integer> entry : entryList){
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }
    }
}
