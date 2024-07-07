import java.util.Arrays;

class Tester {

    public static int findMaxActivities(int start[], int finish[]) {
        if (start.length == 0 || finish.length == 0 || start.length != finish.length) {
            return 0; // Edge case: if arrays are empty or sizes don't match
        }

        int n = start.length;
        // Array to store activities as pairs of [start, finish]
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }

        // Sort activities based on finish time (ascending order)
        Arrays.sort(activities, (a, b) -> a[1] - b[1]);

        int maxActivities = 0;
        int lastFinishTime = Integer.MIN_VALUE;

        // Greedily select activities
        for (int i = 0; i < n; i++) {
            if (activities[i][0] >= lastFinishTime) {
                maxActivities++;
                lastFinishTime = activities[i][1];
            }
        }

        return maxActivities;
    }

    public static void main(String[] args) {
        int start[] =  {1, 3, 0, 5, 8, 5}; 
        int finish[] =  {2, 4, 6, 7, 9, 9};
        
        System.out.println("Maximum number of activities: " + findMaxActivities(start, finish)); 
    }
}