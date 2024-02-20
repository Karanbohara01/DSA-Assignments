package org.example.Answer2a;

public class ProductionLine {
    // Calculates the minimum number of moves required to equalize the number of
    // dresses
    // among people, if possible.
    // dresses: an array representing the number of dresses each person has
    // Returns the minimum number of moves required to equalize the number of
    // dresses,
    // or -1 if it's not possible to equalize
    public static int minMovesToEqualize(int[] dresses) {
        // Calculate the total number of dresses
        int totalDresses = 0;
        for (int dress : dresses) {
            totalDresses += dress;
        }

        // Get the number of people
        int n = dresses.length;

        // Check if equal distribution is possible
        if (totalDresses % n != 0) {
            return -1; // Not possible to equalize
        }

        // Calculate the target number of dresses each person should have
        int target = totalDresses / n;

        // Initialize moves counter
        int moves = 0;

        // Redistribute dresses to equalize counts
        for (int i = 0; i < n; i++) {
            if (dresses[i] > target) {
                // If a person has more dresses than the target, move excess dresses to the next
                // person
                moves += dresses[i] - target;
                dresses[(i + 1) % n] += dresses[i] - target; // Redistribute excess dresses
                dresses[i] = target; // Set the current person's dresses to the target count
            }
        }

        return moves;
    }

    // Main method to test the minMovesToEqualize function
    public static void main(String[] args) {
        int[] inputDresses = { 1, 0, 5 }; // Example input
        System.out.println("The minimum moves to equalize is " + minMovesToEqualize(inputDresses) + "."); // Print the
        // result
    }
}

