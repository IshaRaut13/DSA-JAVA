import java.util.HashMap;
import java.util.Map;

class Tester {
    
    public static Map<String, Integer> mergeMaps(Map<String, Integer> mapOne, Map<String, Integer> mapTwo){
        Map<String, Integer> mergedMap = new HashMap<>();
        
        // Add all entries from mapOne to mergedMap
        for (Map.Entry<String, Integer> entry : mapOne.entrySet()) {
            mergedMap.put(entry.getKey(), entry.getValue());
        }
        
        // Merge entries from mapTwo into mergedMap, handling duplicate keys
        for (Map.Entry<String, Integer> entry : mapTwo.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            
            if (mergedMap.containsKey(key)) {
                // Duplicate key found, create new key with "new" prefixed
                mergedMap.put("new" + key, value);
            } else {
                // No duplicate, add directly to mergedMap
                mergedMap.put(key, value);
            }
        }
        
        return mergedMap;
    }

    public static void main(String args[]) {
        Map<String, Integer> mapOne = new HashMap<>();
        mapOne.put("Kelly", 10);
        mapOne.put("Micheal", 20);
        mapOne.put("Ryan", 30);
        
        Map<String, Integer> mapTwo = new HashMap<>();
        mapTwo.put("Jim", 15);
        mapTwo.put("Andy", 45);

        Map<String, Integer> mergedMap = mergeMaps(mapOne, mapTwo);

        System.out.println("Merged Map\n===========");
        for (Map.Entry<String, Integer> entry : mergedMap.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
    }
}