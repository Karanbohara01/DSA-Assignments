package org.example.Answer1b;
public class EngineBuilder {
    public static void main(String[] args) {
        // Define engines array and k value
        int[] engines = {1, 2, 3};
        int k = 1;

        // Call the minimumTime function and print the result
        System.out.println(minimumTime(engines, k));
    }

    // Function to calculate the minimum time required
    public static int minimumTime(int[] engines, int k) {
        // Initialize maxTime to 0 and engineers to 1
        int maxTime = 0;
        int engineers = 1;

        // Iterate through the engines array from the end
        for (int i = engines.length - 1; i >= 0; i--) {
            // Get the time required for the current engine
            int time = engines[i];

            // Loop until the required number of engineers is met for this engine
            while (engineers < time) {
                // Determine the split time (how many engineers can work on this engine)
                int splitTime = Math.min(time - engineers, k);
                // Increase the number of engineers by the split time
                engineers += splitTime;
                // Update the maxTime with the maximum of current maxTime and time
                maxTime = Math.max(maxTime, time);
            }
            // Decrease the number of engineers by 1 after finishing work on this engine
            engineers--;
        }
        // Return the maximum time required plus 1 (as the indexing starts from 0)
        return maxTime + 1;
    }
}
