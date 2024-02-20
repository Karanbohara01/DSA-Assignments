package org.example.Anwer5a;

// Ant Colony Optimization (ACO) algorithm is a metaheuristic approach inspired by the foraging behavior of ants to solve optimization problems. One of the classic problems it addresses is the Traveling Salesman Problem (TSP).

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AntColonyOptimization {
    // Constants
    private static final int NUM_ANTS = 10;
    private static final double ALPHA = 1.0; // Pheromone importance
    private static final double BETA = 2.0; // Distance importance
    private static final double RHO = 0.1; // Evaporation rate
    private static final double Q = 100; // Pheromone deposit factor
    private static final int MAX_ITERATIONS = 1000;

    private int numCities;
    private double[][] distanceMatrix;
    private double[][] pheromoneMatrix;
    private List<Ant> ants;
    private Random random;

    public AntColonyOptimization(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
        this.numCities = distanceMatrix.length;
        this.pheromoneMatrix = new double[numCities][numCities];
        this.ants = new ArrayList<>();
        this.random = new Random();

        // Initialize pheromone matrix
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                pheromoneMatrix[i][j] = 0.01; // Initial pheromone level
            }
        }
    }

    public int[] solve() {
        int[] bestTour = null;
        double bestTourLength = Double.POSITIVE_INFINITY;

        for (int iter = 0; iter < MAX_ITERATIONS; iter++) {
            // Initialize ants
            initializeAnts();

            // Move ants
            for (Ant ant : ants) {
                for (int i = 0; i < numCities - 1; i++) {
                    ant.moveNextCity(pheromoneMatrix, distanceMatrix, ALPHA, BETA, random);
                }
                ant.completeTour(distanceMatrix);

                // Update best tour if necessary
                if (ant.getTourLength() < bestTourLength) {
                    bestTourLength = ant.getTourLength();
                    bestTour = ant.getTour();
                }
            }

            // Update pheromone levels
            updatePheromones();
        }

        return bestTour;
    }

    private void initializeAnts() {
        ants.clear();
        for (int i = 0; i < NUM_ANTS; i++) {
            ants.add(new Ant(numCities));
        }
    }

    private void updatePheromones() {
        // Evaporation
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                pheromoneMatrix[i][j] *= (1 - RHO);
            }
        }

        // Pheromone deposit
        for (Ant ant : ants) {
            double pheromoneToAdd = Q / ant.getTourLength();
            int[] tour = ant.getTour();
            for (int i = 0; i < numCities - 1; i++) {
                pheromoneMatrix[tour[i]][tour[i + 1]] += pheromoneToAdd;
            }
            // Add pheromone for the return to the start city
            pheromoneMatrix[tour[numCities - 1]][tour[0]] += pheromoneToAdd;
        }
    }

    // Ant class representing an ant
    private static class Ant {
        private int numCities;
        private int[] tour;
        private boolean[] visited;
        private double tourLength;

        public Ant(int numCities) {
            this.numCities = numCities;
            this.tour = new int[numCities];
            this.visited = new boolean[numCities];
            this.tourLength = 0;
            // Start from a random city
            int startCity = new Random().nextInt(numCities);
            tour[0] = startCity;
            visited[startCity] = true;
        }

        public void moveNextCity(double[][] pheromoneMatrix, double[][] distanceMatrix,
                                 double alpha, double beta, Random random) {
            int currentCity = tour[numCities - countUnvisitedCities()];
            double[] probabilities = calculateProbabilities(currentCity, pheromoneMatrix, distanceMatrix, alpha, beta);
            int nextCity = selectNextCity(probabilities, random);
            tour[numCities - countUnvisitedCities()] = nextCity;
            visited[nextCity] = true;
            tourLength += distanceMatrix[currentCity][nextCity];
        }

        public void completeTour(double[][] distanceMatrix) {
            int lastCity = tour[numCities - 1];
            int firstCity = tour[0];
            tourLength += distanceMatrix[lastCity][firstCity]; // Return to the start city
        }

        public int[] getTour() {
            return tour;
        }

        public double getTourLength() {
            return tourLength;
        }

        private int countUnvisitedCities() {
            int count = 0;
            for (boolean cityVisited : visited) {
                if (!cityVisited) {
                    count++;
                }
            }
            return count;
        }

        private double[] calculateProbabilities(int currentCity, double[][] pheromoneMatrix,
                                                double[][] distanceMatrix, double alpha, double beta) {
            double[] probabilities = new double[numCities];
            double totalProbability = 0;
            for (int i = 0; i < numCities; i++) {
                if (!visited[i]) {
                    double pheromone = Math.pow(pheromoneMatrix[currentCity][i], alpha);
                    double distance = Math.pow(1.0 / distanceMatrix[currentCity][i], beta);
                    probabilities[i] = pheromone * distance;
                    totalProbability += probabilities[i];
                }
            }
            // Normalize probabilities
            for (int i = 0; i < numCities; i++) {
                if (!visited[i]) {
                    probabilities[i] /= totalProbability;
                }
            }
            return probabilities;
        }

        private int selectNextCity(double[] probabilities, Random random) {
            double randomValue = random.nextDouble();
            double cumulativeProbability = 0;
            for (int i = 0; i < numCities; i++) {
                if (!visited[i]) {
                    cumulativeProbability += probabilities[i];
                    if (randomValue <= cumulativeProbability) {
                        return i;
                    }
                }
            }
            // If probabilities do not sum up to 1, select the first unvisited city
            for (int i = 0; i < numCities; i++) {
                if (!visited[i]) {
                    return i;
                }
            }
            return -1; // Should not reach here
        }
    }

    public static void main(String[] args) {
        // Example usage
        double[][] distanceMatrix = {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };
        AntColonyOptimization aco = new AntColonyOptimization(distanceMatrix);
        int[] bestTour = aco.solve();
        System.out.println("Best tour: ");
        for (int city : bestTour) {
            System.out.print(city + " ");
        }
        System.out.println();
    }
}

