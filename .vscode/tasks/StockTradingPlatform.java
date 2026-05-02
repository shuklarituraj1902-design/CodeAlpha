import java.util.Scanner;

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String stockName = "TCS";
        double stockPrice = 3500;
        int balance = 100000;
        int shares = 0;
        int choice, qty;

        do {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Stock Price");
            System.out.println("2. Buy Shares");
            System.out.println("3. Sell Shares");
            System.out.println("4. Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Stock: " + stockName);
                    System.out.println("Price: Rs." + stockPrice);
                    break;

                case 2:
                    System.out.print("Enter Quantity to Buy: ");
                    qty = sc.nextInt();

                    if(balance >= qty * stockPrice) {
                        shares += qty;
                        balance -= qty * stockPrice;
                        System.out.println("Shares Bought Successfully!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Quantity to Sell: ");
                    qty = sc.nextInt();

                    if(shares >= qty) {
                        shares -= qty;
                        balance += qty * stockPrice;
                        System.out.println("Shares Sold Successfully!");
                    } else {
                        System.out.println("Not Enough Shares!");
                    }
                    break;

                case 4:
                    System.out.println("Balance: Rs." + balance);
                    System.out.println("Owned Shares: " + shares);
                    System.out.println("Total Value: Rs." + (balance + shares * stockPrice));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 5);
    }
}