import java.util.Random;
import java.util.Scanner;

public class ok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte playerCount = getPlayerCount();
        String playerNames[] = getPlayerNames(playerCount);
        int[] playerPosition = new int[playerCount];
        int[] playerMoney = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            playerMoney[i] = 1500;
        }

        for (int i = 0; i < playerCount; i++) {
            while (playerMoney[i] > 0){
                for (int j = 0; j < playerCount; j++) {
                    System.out.println("It is " + playerNames[j] + "'s turn. " + "Press enter to roll the dices");
                    String ifPressedEnter = input.nextLine();
                    if (ifPressedEnter.equals("")){
                        for (int k = 0; k < playerCount; k++) {
                            playerPosition[k] = getDiceRoll();
                            System.out.println(playerNames[j] + " is now on position " + playerPosition[k]);
                        }
                    }
                    mediterraneanAve(playerPosition,playerCount);
                    if (playerMoney[i] == 0){
                        System.out.println(playerNames[i] + " is bankrupt! Game over for them!");
                    }
                }
            }
        }
    }


    public static byte getPlayerCount() {
        Scanner input = new Scanner(System.in);
        byte playerCount;
        do {
            System.out.print("Enter the number of players playing (minimum 2, maximum 4): ");
            playerCount = input.nextByte();
            if (playerCount < 2 || playerCount > 4) {
                System.out.print("Please enter a correct number of players: ");
                playerCount = input.nextByte();
            }
        } while (playerCount < 2 || playerCount > 4);
        return playerCount;
    }

    public static String[] getPlayerNames(byte playerCount) {
        Scanner input = new Scanner(System.in);
        String[] playerNames = new String[playerCount];
        for (int i = 0; i < playerCount; i++) {
            System.out.print("Enter a name for player " + (i + 1) + ": ");
            playerNames[i] = input.next();
        }
        return playerNames;
    }

    public static int getDiceRoll() {
        Random diceOneGenerator = new Random();
        Random diceTwoGenerator = new Random();
        int dice1 = diceOneGenerator.nextInt(6) + 1;
        int dice2 = diceTwoGenerator.nextInt(6) + 1;
        int diceRoll = dice1 + dice2;
        return diceRoll;
    }

    public static boolean[] mediterraneanAve(int playerPosition[], byte playerCount) {
        Scanner input = new Scanner(System.in);
        int ownershipStatus = 1;
        boolean[] mediterraneanAveOwnership = new boolean[playerCount];
        for (int i = 0; i < playerCount; i++) {
            if (playerPosition[i] == 6 && ownershipStatus != 5){
                System.out.println("Do you want to buy mediterranean Avenue for $60? Enter yes or no: ");
                String ifBuying = input.nextLine();
                if (ifBuying.equalsIgnoreCase("yes")){
                    System.out.println("Bought");
                    ownershipStatus = 5;
                    mediterraneanAveOwnership[i] = true;
                }
            }
        }
        // return multiple values maybe fix
        return mediterraneanAveOwnership;
    }
}
