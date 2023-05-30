import java.util.*;

public class CurrencyDenomination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of currency denominations:");
        int size = scanner.nextInt();

        int[] denominations = new int[size];
        System.out.println("Enter the currency denominations value:");
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        System.out.println("Enter the amount you want to pay:");
        int amount = scanner.nextInt();

        Map<Integer, Integer> paymentApproach = calculatePaymentApproach(denominations, amount);
        System.out.println("Your payment approach in order to give minimum number of notes will be:");
        for (Map.Entry<Integer, Integer> entry : paymentApproach.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            System.out.println(denomination + ":" + count);
            scanner.close();
        }
    }

    public static Map<Integer, Integer> calculatePaymentApproach(int[] denominations, int amount) {
        Arrays.sort(denominations); // Sort the denominations in ascending order
        Map<Integer, Integer> paymentApproach = new LinkedHashMap<>();

        for (int i = denominations.length - 1; i >= 0; i--) {
            int denomination = denominations[i];
            int count = amount / denomination;

            if (count > 0) {
                paymentApproach.put(denomination, count);
                amount -= count * denomination;
            }
        }

        return paymentApproach;
        
    }
}
