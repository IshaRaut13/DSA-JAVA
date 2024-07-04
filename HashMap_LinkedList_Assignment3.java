import java.util.LinkedList;
import java.util.List;

class Tester {

    public static List<Integer> mergeLists(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> mergedList = new LinkedList<>();
       
        // Pointers for iterating through listOne and listTwo
        int i = 0, j = 0;
        int sizeOne = listOne.size();
        int sizeTwo = listTwo.size();
       
        // Merge the lists into mergedList in sorted order
        while (i < sizeOne && j < sizeTwo) {
            if (listOne.get(i) <= listTwo.get(j)) {
                mergedList.add(listOne.get(i));
                i++;
            } else {
                mergedList.add(listTwo.get(j));
                j++;
            }
        }
       
        // Add remaining elements from listOne, if any
        while (i < sizeOne) {
            mergedList.add(listOne.get(i));
            i++;
        }
       
        // Add remaining elements from listTwo, if any
        while (j < sizeTwo) {
            mergedList.add(listTwo.get(j));
            j++;
        }
       
        return mergedList;
    }

    public static void main(String args[]) {
        List<Integer> listOne = new LinkedList<Integer>();
        listOne.add(10);
        listOne.add(13);
        listOne.add(21);
        listOne.add(42);
        listOne.add(56);
       
        List<Integer> listTwo = new LinkedList<Integer>();
        listTwo.add(15);
        listTwo.add(20);
        listTwo.add(21);
        listTwo.add(85);
        listTwo.add(92);
       
        List<Integer> mergedList = mergeLists(listOne, listTwo);
       
        System.out.println("Merged list:");
        System.out.println(mergedList);
    }
}