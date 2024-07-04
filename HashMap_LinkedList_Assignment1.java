import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Tester {

    public static List<Integer> removeDuplicates(List<Integer> list) {
        // Use a HashSet to track unique elements
        Set<Integer> set = new HashSet<>();
        // Linked list to store unique elements in order
        List<Integer> result = new LinkedList<>();

        for (Integer element : list) {
            if (!set.contains(element)) {
                set.add(element);
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String args[]) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(15);
        list.add(21);
        list.add(15);
        list.add(10);

        List<Integer> updatedList = removeDuplicates(list);

        System.out.println("Linked list without duplicates:");
        for (Integer value : updatedList) {
            System.out.print(value + " ");
        }
    }

}