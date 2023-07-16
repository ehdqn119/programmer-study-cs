import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution_Hash {
    public String solution(String[] participant, String[] completion) {
        String answer = ""; //경주를 완주하지 못한 참가자의 이름을 저장하는 문자열 변수
        HashMap<String, Integer> map = new HashMap<>();//각 참가자를 키 밸류로 저장할 HashMap
        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);
        for (String player : completion)
            map.put(player, map.get(player) - 1);

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()){ //map을 반복하면서 완주하지 못한 참가자를 찾기. 참가자의 횟수가 0이 아닌 경우 해당 참가자 리턴
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        Solution_Sort sol = new Solution_Sort();
        System.out.println(sol.solution(part, comp));
    }
}
