import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Student {
	
    public static Map<String, Double> findMaxMinScorers(Map<String, Double> studentMarks) {
        Map<String, Double> maxMinScorers = new HashMap<>();
        
        if (studentMarks.isEmpty()) {
            return maxMinScorers; // Return an empty map if no students are provided
        }
        
        String maxScorer = null;
        String minScorer = null;
        Double maxScore = Double.MIN_VALUE;
        Double minScore = Double.MAX_VALUE;
        
        // Iterate through the student marks map to find max and min scorers
        for (Entry<String, Double> entry : studentMarks.entrySet()) {
            String studentName = entry.getKey();
            Double marks = entry.getValue();
            
            // Finding maximum scorer
            if (marks > maxScore) {
                maxScore = marks;
                maxScorer = studentName;
            }
            
            // Finding minimum scorer
            if (marks < minScore) {
                minScore = marks;
                minScorer = studentName;
            }
        }
        
        // Populate the result map
        maxMinScorers.put("Top Scorer", maxScore);
        maxMinScorers.put("Low Scorer", minScore);
        
        // If there are ties for maximum or minimum scores, add all students with those scores
        for (Entry<String, Double> entry : studentMarks.entrySet()) {
            String studentName = entry.getKey();
            Double marks = entry.getValue();
            
            if (marks.equals(maxScore) && !studentName.equals(maxScorer)) {
                maxMinScorers.put("Top Scorer", marks); // Adding another top scorer
            }
            
            if (marks.equals(minScore) && !studentName.equals(minScorer)) {
                maxMinScorers.put("Low Scorer", marks); // Adding another low scorer
            }
        }
        
        return maxMinScorers;
    }

}

class Tester {

    public static void main(String args[]) {
        Map<String, Double> studentMarks = new HashMap<>();
        studentMarks.put("Lily", 90.0);
        studentMarks.put("Robin", 68.0);
        studentMarks.put("Marshall", 76.5);
        studentMarks.put("Neil", 67.0);
        studentMarks.put("Ted", 92.0);
        
        Map<String, Double> maxMinScorers = Student.findMaxMinScorers(studentMarks);
        
        System.out.println("Details of Top Scorers & Low Scorers\n====================================");
        for (Entry<String, Double> entry : maxMinScorers.entrySet()) {
            System.out.println(entry.getKey()+" -- "+entry.getValue());
        }
    }
}