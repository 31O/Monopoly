import java.util.Random;
import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random diceOneGenerator = new Random();
        Random diceTwoGenerator = new Random();

        System.out.println("Welcome to monopoly!");

        System.out.print("Enter the number of players playing (minimum 2, maximum 4): ");
        byte playerCount;
        do {
            playerCount = input.nextByte();
            if (playerCount < 2 || playerCount > 4) {
                System.out.print("Please enter a correct number of players: ");

            }
        } while (playerCount < 2 || playerCount > 4);
        String[] playerNames = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            System.out.print("Enter a name for player " + (i + 1) + ": ");
            playerNames[i] = input.next();
        }
        int[] diceResultArr = new int[playerCount];
        int[] playerMoney = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            playerMoney[i] = 1500;
        }
        int[] playerPosition = new int[playerCount];
        boolean[] mediterraneanAvenueOwnership = new boolean[playerCount];
        int[] mediterraneanAvenueBid = new int[playerCount];
        int maxBid = 0;
        boolean ownershipStatus = false;

        for (int i = 0; i < playerCount; i++) {
            do {
                for (int j = 0; j < playerCount; j++) {
                    System.out.println("It is " + playerNames[j] + "'s turn. Press enter to roll the dice");
                    String ifPressedEnter = input.nextLine();
                    input.nextLine();
                    int diceRoll1 = diceOneGenerator.nextInt(6) + 1;
                    int diceRoll2 = diceTwoGenerator.nextInt(6) + 1;
                    diceResultArr[j] = diceRoll1 + diceRoll2;
                    if (ifPressedEnter.equals("")) {
                        System.out.print(playerNames[j] + " has rolled " + diceResultArr[j]);
                        playerPosition[j] = diceResultArr[j];
                        System.out.println(" and is on position " + playerPosition[j]);
                        mediterraneanAvenue(playerCount, playerPosition, playerNames, playerMoney, mediterraneanAvenueOwnership, mediterraneanAvenueBid, maxBid, ownershipStatus);
                    }
                }
            }
            while (playerMoney[i] > 0);
        }
    }

    public static boolean[] mediterraneanAvenue(byte playerCount, int playerPosition[], String playerNames[], int playerMoney[], boolean[] mediterraneanAvenueOwnership, int[] mediterraneanAvenueBid, int maxBid, boolean ownershipStatus) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < playerCount; i++) {
            if (playerPosition[i] == 6 && ownershipStatus == false) {
                System.out.print(playerNames[i] + ", do you want to buy this property for $60? Enter yes or no: ");
                String ifBuyAvenue = input.nextLine();
                if (ifBuyAvenue.equals("Yes") || ifBuyAvenue.equals("yes")) {
                    mediterraneanAvenueOwnership[i] = true;
                    playerMoney[i] += -60;
                    ownershipStatus = true;
                } else if (ifBuyAvenue.equals("No") || ifBuyAvenue.equals("no")) {
                    System.out.println(playerNames[i]
                            + " has declined to buy mediterranean avenue. Enter your bids for the property.");
                    for (int j = 0; j < playerCount; j++) {
                        System.out.print(playerNames[j] + " please enter your bid: ");
                        mediterraneanAvenueBid[j] = input.nextInt();
                        if (mediterraneanAvenueBid[j] > maxBid) {
                            maxBid = mediterraneanAvenueBid[j];
                        }
                        if (mediterraneanAvenueBid[j] == maxBid) {
                            mediterraneanAvenueOwnership[j] = true;
                            playerMoney[i] += -maxBid;
                            ownershipStatus = true;
                        }
                    }
                }
                for (int j = 0; j < playerCount; j++) {
                    if (mediterraneanAvenueOwnership[j] == true) {
                        System.out.println("The avenue is now owned by " + playerNames[i]);
                    }
                }
            }
        }
        return mediterraneanAvenueOwnership;
    }
}
