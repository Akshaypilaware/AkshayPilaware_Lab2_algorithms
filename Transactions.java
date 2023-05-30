import java.util.Scanner;

public class Transactions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of transaction array:");
        int size = scanner.nextInt();

        int[] transactions = new int[size];
        System.out.println("Enter the values of array:");
        for (int i = 0; i < size; i++) {
            transactions[i] = scanner.nextInt();
        }

        System.out.println("Enter the total number of targets that need to be achieved:");
        int numTargets = scanner.nextInt();
       

        for (int i = 0; i < numTargets; i++) {
            System.out.println("Enter the value of target:");
            int target = scanner.nextInt();

            int numTransactions = findTargetTransactions(transactions, target);
            if (numTransactions > 0) {
                System.out.println("Target achieved after " + numTransactions + " transaction(s)");
            } else {
                System.out.println("Given target is not achieved");
            
            
                scanner.close();
            }
        }
    }

    public static int findTargetTransactions(int[] transactions, int target) {
        int currentSum = 0;
        int numTransactions = 0;

        for (int i = 0; i < transactions.length; i++) {
            currentSum += transactions[i];
            numTransactions++;

            if (currentSum >= target) {
                return numTransactions;
            }
        }

        return -1; // Target not achieved
        
    }
}
