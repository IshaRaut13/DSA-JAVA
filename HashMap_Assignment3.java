import java.util.HashMap;
import java.util.Map;

class Tester {

    public static Map<Character, Integer> findOccurrences(String input) {
        Map<Character, Integer> occurrenceMap = new HashMap<>();
        
        // Traverse the string and count occurrences of each character
        for (char ch : input.toCharArray()) {
            // Increment count if character already exists in map, otherwise add new entry
            occurrenceMap.put(ch, occurrenceMap.getOrDefault(ch, 0) + 1);
        }
        
        return occurrenceMap;
    }
    
    public static void main(String args[]) {
        String input = "occurrence";
        Map<Character, Integer> occurrenceMap = findOccurrences(input);
        
        System.out.println("Occurrences of characters\n=======================");
        for (Map.Entry<Character, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }
}