import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tester {
    
    public static List<String> sortSales(Map<String, Integer> sales) {
        // Convert map entries to a list for sorting
        List<Map.Entry<String, Integer>> list = new ArrayList<>(sales.entrySet());
        
        // Sort the list based on sales values in descending order
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        // Extract sorted employee names into a result list
        List<String> sortedEmployees = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedEmployees.add(entry.getKey());
        }
        
        return sortedEmployees;
    }

    public static void main(String args[]) {
        Map<String, Integer> sales = new HashMap<>();
        sales.put("Mathew", 50);
        sales.put("Lisa", 76);
        sales.put("Courtney", 45);
        sales.put("David", 49);
        sales.put("Paul", 49);
        
        List<String> employees = sortSales(sales);
        
        System.out.println("Employees in the decreasing order of their sales\n=====================================");
        for (String employeeName : employees) {
            System.out.println(employeeName);
        }
    }
}