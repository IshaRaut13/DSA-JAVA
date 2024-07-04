import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Tester {
   
    public static List<Integer> findCommonElements(List<Integer> listOne, List<Integer> listTwo){
        // Use a HashSet to store elements of listOne for quick lookup
        Set<Integer> set = new HashSet<>(listOne);
        // Linked list to store common elements
        List<Integer> commonElements = new LinkedList<>();

        // Iterate through listTwo and add elements that are in both lists to commonElements
        for (Integer element : listTwo) {
            if (set.contains(element)) {
                commonElements.add(element);
            }
        }
       
        return commonElements;
    }
   
    public static void main(String args[]){
        List<Integer> listOne = new LinkedList<Integer>();
        listOne.add(10);
        listOne.add(12);
        listOne.add(21);
        listOne.add(1);
        listOne.add(53);
       
        List<Integer> listTwo = new LinkedList<Integer>();
        listTwo.add(11);
        listTwo.add(21);
        listTwo.add(25);
        listTwo.add(53);
        listTwo.add(47);

        List<Integer> commonElements = findCommonElements(listOne, listTwo);

        System.out.println("Common elements:");
        for (Integer value : commonElements) {
            System.out.print(value + " ");
        }
    }
}