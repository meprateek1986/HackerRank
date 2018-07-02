package dp;

/**
 * This problem is a modified version of knapsack.
 * Given an integer array of weight, a sum and numbersToFind(how any numbers should sum up to the given sum)
 * find out if there are those many number(equal to numbersToFind) of integers which sum up to the given sum.
 *
 * For eg given a weight array and a sum as 23. Find out if there are 4 numbers(numbersToFind) from the given int
 * which sum-up to 23(given sum).
 */
public class SumOfNumbersWithGivenCount {
    public static void main(String[] args) {
        int[] weight = {2, 4, 6, 7, 8};
        int sum = 23;
        int numbersToFind = 4;

        int[][] T = new int[weight.length + 1][sum + 1];

        int currentSum = 0;

        for (int i = 1; i <= weight.length; i++) {
            currentSum += weight[i - 1];
            for (int j = 1; j <= sum; j++) {
                if(weight[i - 1] > j) {
                    T[i][j] = T[i - 1][j];
                } else if(currentSum < j) {
                    T[i][j] = 0;
                } else {
                    T[i][j] = Math.max(T[i - 1][j], T[i - 1][j - weight[i - 1]] + 1);
                }
            }
        }

        System.out.println(T[weight.length][sum] == numbersToFind);
    }
}
