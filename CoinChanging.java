public class CoinChanging {

    public static void main(String[] args) {

        int amount = 1988;

        int[] denominations = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};

        System.out.println("Pakistani Currency Denominations for Rs. " + amount + ":\n");

        for (int note : denominations) {

            if (amount >= note) {

                int count = amount / note;

                amount = amount % note;

                System.out.println("Rs. " + note + " x " + count);
            }
        }
    }
}