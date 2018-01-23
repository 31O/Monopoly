import java.util.Random;
import java.util.Scanner;

public class ok {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to monopoly!");

        byte playerCount = getPlayerCount();
        String playerNames[] = getPlayerNames(playerCount);
        int[] playerPosition = new int[playerCount];
        int[] playerMoney = new int[playerCount];
        int[] mediterraneanAveOwnership = new int[playerCount];
        int[] balticAveOwnership = new int[playerCount];
        int[] orientalAveOwnership = new int[playerCount];
        int[] vermontAveOwnership = new int[playerCount];
        int[] connecticutAveOwnership = new int[playerCount];
        int[] stCharlesOwnership = new int[playerCount];
        int[] statesAveOwnership = new int[playerCount];
        int[] virginiaAveOwnership = new int[playerCount];
        int[] stJamesAveOwnership = new int[playerCount];
        int[] tennesseeAveOwnership = new int[playerCount];
        int[] newYorkAveOwnership = new int[playerCount];
        int[] kentuckyAveOwnership = new int[playerCount];
        int[] indianaAveOwnership = new int[playerCount];
        int[] illinoisAveOwnership = new int[playerCount];
        int[] atlanticAveOwnership = new int[playerCount];
        int[] ventnorAveOwnership = new int[playerCount];
        int[] marvinGardensOwnership = new int[playerCount];
        int[] pacificAveOwnership = new int[playerCount];
        int[] northCarolinaAveOwnership = new int[playerCount];
        int[] pennsylvaniaAveOwnership = new int[playerCount];
        int[] parkPlaceOwnership = new int[playerCount];
        int[] boardWalkOwnership = new int[playerCount];
        boolean[][] propertyHouses = new boolean[40][4];
        boolean[] ifAlreadyPaid = new boolean[40];
        for (int i = 0; i < playerCount; i++) {
            playerMoney[i] = 1500;
        }
        System.out.println("Enter \"build\" when you have a turn to build houses or hotels on owned properties");
        for (int i = 0; i < playerCount; i++) {
            while (playerMoney[i] > 0) {
                for (int j = 0; j < playerCount; j++) {
                    System.out.println("It is " + playerNames[j] + "'s turn. " + "Press enter to roll the dices");
                    String playerTurnInput = input.nextLine();
                    if (playerTurnInput.equals("")) {
                        int dicesRoll = getDiceRoll();
                        playerPosition[j] = dicesRoll;
                        if (playerPosition[j] > 40) {
                            playerPosition[j] -= 40;
                            playerMoney[j] += 200;
                        }
                        System.out.println(playerNames[j] + " has rolled " + dicesRoll + " and is now on position " + playerPosition[j]);
                    } else if (playerTurnInput.equalsIgnoreCase("build")) {
                        System.out.println("On which property do you wish to build a house on?");
                        String buildOnWhichProperty = input.nextLine();
                        if (mediterraneanAveOwnership[j] != 0 && balticAveOwnership[j] != 0 && orientalAveOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "mediterranean avenue":
                                    byte propertyPosition = 2;
                                  //  propertyHouses = housesOwnedChecker(propertyHouses, propertyPosition);
                                    break;
                                case "baltic avenue":
                                    propertyPosition = 4;
                                 //   propertyHouses = housesOwnedChecker(propertyHouses, propertyPosition);
                                    break;
                                case "oriental avenue":
                                    byte okk= 0;
                                    propertyHouses[7][okk] = true;
                                    System.out.println("You have build a house! Number of houses on oriental avenue: " + (okk+1));
                                    okk++;
                                    break;
                                default:
                                    System.out.print("Incorrect name entered!");
                            }
                        } else {
                            System.out.println("You need to own all properties of the same colour first to be able to build on them.");
                        }

                    }
                    switch (playerPosition[j]) {
                        case 2:
                            int propertyPrice = 60;
                            byte propertyPosition = 2;
                            int rentPrice = 2;
                            String propertyName = "Mediterranean avenue";
                            mediterraneanAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, mediterraneanAveOwnership, playerPosition, playerCount, playerNames)[j];
                            int position = positionChecker(mediterraneanAveOwnership, playerCount);  //retrieves the position to properly deduct money after an auction
                            if (!ifAlreadyPaid[2]) {          //prevents the player from paying again when on the same position again
                                playerMoney[position] -= mediterraneanAveOwnership[position];
                                ifAlreadyPaid[2] = true;
                            }

                            if ((mediterraneanAveOwnership[position] != 0 && balticAveOwnership[position] != 0 && orientalAveOwnership[position] != 0) && !propertyHouses[propertyPosition][0]) {
                                rentPrice *= 2;
                            }
                            if (propertyHouses[propertyPosition][0] && !propertyHouses[propertyPosition][1]) {
                                rentPrice += 100;
                            } else if (propertyHouses[propertyPosition][1] && !propertyHouses[propertyPosition][2]) {
                                rentPrice += 200;
                            }

                            if (mediterraneanAveOwnership[j] == 0 && ifAlreadyPaid[2]) {
                                System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[position]);
                                playerMoney[j] -= rentPrice;
                            }
                            break;
                        case 4:
                            propertyPrice = 60;
                            propertyPosition = 4;
                            rentPrice = 4;
                            propertyName = "Baltic Avenue";
                            balticAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, balticAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(balticAveOwnership, playerCount);
                            if (!ifAlreadyPaid[4]) {
                                playerMoney[position] -= balticAveOwnership[position];
                                ifAlreadyPaid[4] = true;
                            }
                            if ((mediterraneanAveOwnership[position] != 0 && balticAveOwnership[position] != 0 && orientalAveOwnership[position] != 0) && !propertyHouses[propertyPosition][0]) {
                                rentPrice *= 2;
                            }
                            if (propertyHouses[propertyPosition][0] && !propertyHouses[propertyPosition][1]) {
                                rentPrice += 100;
                            } else if (propertyHouses[propertyPosition][1] && !propertyHouses[propertyPosition][2]) {
                                rentPrice += 200;
                            }
                            if (balticAveOwnership[j] == 0 && ifAlreadyPaid[4]) {
                                System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[position]);
                                playerMoney[j] -= rentPrice;
                            }
                            break;
                        case 7:
                            propertyPrice = 100;
                            propertyPosition = 7;
                            rentPrice = 6;
                            propertyName = "Oriental Avenue";
                            orientalAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, orientalAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(orientalAveOwnership, playerCount);
                            if (!ifAlreadyPaid[7]) {
                                playerMoney[position] -= orientalAveOwnership[position];
                                ifAlreadyPaid[7] = true;
                            }
                            if ((mediterraneanAveOwnership[position] != 0 && balticAveOwnership[position] != 0 && orientalAveOwnership[position] != 0) && !propertyHouses[propertyPosition][0]) {
                                rentPrice *= 2;
                            }
                            if (propertyHouses[propertyPosition][0] && !propertyHouses[propertyPosition][1]) {
                                rentPrice += 100;
                            }  if (propertyHouses[propertyPosition][1] && !propertyHouses[propertyPosition][2]) {
                                rentPrice = 200;
                            }

                            if (orientalAveOwnership[j] == 0 && ifAlreadyPaid[7]) {
                                System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[position]);
                                playerMoney[j] -= rentPrice;
                            }
                            break;
                            /*
                        case 9:
                            propertyPrice = 100;
                            propertyPosition = 9;
                            rentPrice = 2;
                            propertyName = "Vermont Avenue";
                            vermontAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, vermontAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(vermontAveOwnership, playerCount);
                            if (!ifAlreadyPaid[9]) {
                                playerMoney[position] -= vermontAveOwnership[position];
                                ifAlreadyPaid[9] = true;
                            }
                            if(mediterraneanAveOwnership[j] != 0 && balticAveOwnership[j] != 0 && orientalAveOwnership[j] !=0){
                                rentPrice *= 2;
                            }
                            if (mediterraneanAveOwnership[j] == 0 && ifAlreadyPaid[2] ) {
                                System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[position]);
                                playerMoney[j] -= 2;
                            }
                            break;

                        case 10:
                            propertyPrice = 120;
                            propertyPosition = 10;
                            propertyName = "Connecticut Avenue";
                            connecticutAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, connecticutAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(connecticutAveOwnership, playerCount);
                            if (!ifAlreadyPaid[10]) {
                                playerMoney[position] -= connecticutAveOwnership[position];
                                ifAlreadyPaid[10] = true;
                            }
                            break;
                        case 12:
                            propertyPrice = 140;
                            propertyPosition = 12;
                            propertyName = "St. Charles Place";
                            stCharlesOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, stCharlesOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(stCharlesOwnership, playerCount);
                            if (!ifAlreadyPaid[12]) {
                                playerMoney[position] -= stCharlesOwnership[position];
                                ifAlreadyPaid[12] = true;
                            }
                            break;
                        case 14:
                            propertyPrice = 140;
                            propertyPosition = 14;
                            propertyName = "States avenue";
                            statesAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, statesAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(statesAveOwnership, playerCount);
                            if (!ifAlreadyPaid[14]) {
                                playerMoney[position] -= statesAveOwnership[position];
                                ifAlreadyPaid[14] = true;
                            }
                            break;
                        case 15:
                            propertyPrice = 160;
                            propertyPosition = 14;
                            propertyName = "Virginia Avenue";
                            virginiaAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, virginiaAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(virginiaAveOwnership, playerCount);
                            if (!ifAlreadyPaid[15]) {
                                playerMoney[position] -= virginiaAveOwnership[position];
                                ifAlreadyPaid[15] = true;
                            }
                            break;
                        case 17:
                            propertyPrice = 180;
                            propertyPosition = 17;
                            propertyName = "St. James Place";
                            stJamesAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, stJamesAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(stJamesAveOwnership, playerCount);
                            if (!ifAlreadyPaid[17]) {
                                playerMoney[position] -= stJamesAveOwnership[position];
                                ifAlreadyPaid[17] = true;
                            }
                            break;
                        case 19:
                            propertyPrice = 180;
                            propertyPosition = 19;
                            propertyName = "Tennessee Avenue";
                            tennesseeAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, tennesseeAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(tennesseeAveOwnership, playerCount);
                            if (!ifAlreadyPaid[19]) {
                                playerMoney[position] -= tennesseeAveOwnership[position];
                                ifAlreadyPaid[19] = true;
                            }
                            break;
                        case 20:
                            propertyPrice = 200;
                            propertyPosition = 20;
                            propertyName = "New York Avenue";
                            newYorkAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, newYorkAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(newYorkAveOwnership, playerCount);
                            if (!ifAlreadyPaid[20]) {
                                playerMoney[position] -= newYorkAveOwnership[position];
                                ifAlreadyPaid[20] = true;
                            }
                            break;
                        case 22:
                            propertyPrice = 220;
                            propertyPosition = 22;
                            propertyName = "Kentucky Avenue";
                            kentuckyAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, kentuckyAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(kentuckyAveOwnership, playerCount);
                            if (!ifAlreadyPaid[22]) {
                                playerMoney[position] -= kentuckyAveOwnership[position];
                                ifAlreadyPaid[22] = true;
                            }
                            break;
                        case 24:
                            propertyPrice = 220;
                            propertyPosition = 24;
                            propertyName = "Indiana Avenue";
                            indianaAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, indianaAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(indianaAveOwnership, playerCount);
                            if (!ifAlreadyPaid[24]) {
                                playerMoney[position] -= indianaAveOwnership[position];
                                ifAlreadyPaid[24] = true;
                            }
                            break;
                        case 25:
                            propertyPrice = 240;
                            propertyPosition = 25;
                            propertyName = "Illinois Avenue";
                            illinoisAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, illinoisAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(illinoisAveOwnership, playerCount);
                            if (!ifAlreadyPaid[25]) {
                                playerMoney[position] -= illinoisAveOwnership[position];
                                ifAlreadyPaid[25] = true;
                            }
                            break;
                        case 27:
                            propertyPrice = 260;
                            propertyPosition = 27;
                            propertyName = "Atlantic Avenue";
                            atlanticAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, atlanticAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(atlanticAveOwnership, playerCount);
                            if (!ifAlreadyPaid[27]) {
                                playerMoney[position] -= atlanticAveOwnership[position];
                                ifAlreadyPaid[27] = true;
                            }
                            break;
                        case 28:
                            propertyPrice = 260;
                            propertyPosition = 28;
                            propertyName = "Ventnor Avenue";
                            ventnorAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, ventnorAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(ventnorAveOwnership, playerCount);
                            if (!ifAlreadyPaid[28]) {
                                playerMoney[position] -= ventnorAveOwnership[position];
                                ifAlreadyPaid[28] = true;
                            }
                            break;
                        case 30:
                            propertyPrice = 280;
                            propertyPosition = 30;
                            propertyName = "Marvin Gardens";
                            marvinGardensOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, marvinGardensOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(marvinGardensOwnership, playerCount);
                            if (!ifAlreadyPaid[30]) {
                                playerMoney[position] -= marvinGardensOwnership[position];
                                ifAlreadyPaid[30] = true;
                            }
                            break;
                        case 32:
                            propertyPrice = 300;
                            propertyPosition = 32;
                            propertyName = "Pacific Avenue";
                            pacificAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, pacificAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(pacificAveOwnership, playerCount);
                            if (!ifAlreadyPaid[32]) {
                                playerMoney[position] -= pacificAveOwnership[position];
                                ifAlreadyPaid[32] = true;
                            }
                            break;
                        case 33:
                            propertyPrice = 300;
                            propertyPosition = 33;
                            propertyName = "North Carolina Avenue";
                            northCarolinaAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, northCarolinaAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(northCarolinaAveOwnership, playerCount);
                            if (!ifAlreadyPaid[33]) {
                                playerMoney[position] -= northCarolinaAveOwnership[position];
                                ifAlreadyPaid[33] = true;
                            }
                            break;
                        case 35:
                            propertyPrice = 320;
                            propertyPosition = 35;
                            propertyName = "Pennsylvania  Avenue";
                            pennsylvaniaAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, pennsylvaniaAveOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(pennsylvaniaAveOwnership, playerCount);
                            if (!ifAlreadyPaid[33]) {
                                playerMoney[position] -= pennsylvaniaAveOwnership[position];
                                ifAlreadyPaid[33] = true;
                            }
                            break;
                        case 38:
                            propertyPrice = 350;
                            propertyPosition = 38;
                            propertyName = "Park Place";
                            parkPlaceOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, parkPlaceOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(parkPlaceOwnership, playerCount);
                            if (!ifAlreadyPaid[38]) {
                                playerMoney[position] -= parkPlaceOwnership[position];
                                ifAlreadyPaid[38] = true;
                            }
                            break;
                        case 40:
                            propertyPrice = 400;
                            propertyPosition = 40;
                            propertyName = "Boardwalk";
                            boardWalkOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, boardWalkOwnership, playerPosition, playerCount, playerNames)[j];
                            position = positionChecker(boardWalkOwnership, playerCount);
                            if (!ifAlreadyPaid[40]) {
                                playerMoney[position] -= boardWalkOwnership[position];
                                ifAlreadyPaid[40] = true;
                            }
                            break;
                            */
                    }

                    System.out.println(playerNames[j] + " has $" + playerMoney[j]);
                }
                if (playerMoney[i] == 0) {
                    System.out.println(playerNames[i] + " is bankrupt! Game over for them!");
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

    public static int[] propertyOwnership(byte propertyPosition, String propertyName, int propertyPrice, int j, int propertyOwnership[], int playerPosition[], byte playerCount, String playerNames[]) {
        Scanner input = new Scanner(System.in);
        boolean[] ifOwned = new boolean[40];
        ifOwned[propertyPosition] = ownershipChecker(ifOwned, propertyPosition, propertyOwnership, playerCount)[propertyPosition];

        if (ifOwned[propertyPosition] == false) {
            System.out.print("Do you want to buy " + propertyName + " for $" + propertyPrice + "? Enter yes or no: ");
            String ifBuying = input.nextLine();
            if (ifBuying.equalsIgnoreCase("yes")) {
                ifBuyingYes(propertyPrice, j, propertyOwnership);
            } else if (ifBuying.equalsIgnoreCase("no")) {
                ifBuyingNo(propertyName, j, playerNames, playerCount, propertyOwnership);
            } else {
                System.out.println("Please enter yes or no! ");
                ifBuying = input.nextLine();
                if (ifBuying.equalsIgnoreCase("yes")) {
                    ifBuyingYes(propertyPrice, j, propertyOwnership);
                } else if (ifBuying.equalsIgnoreCase("no")) {
                    ifBuyingNo(propertyName, j, playerNames, playerCount, propertyOwnership);
                }
            }
        }
        return propertyOwnership;
    }

    public static boolean[] ownershipChecker(boolean[] ifOwned, byte position, int propertyOwnership[], byte playerCount) {
        for (int i = 0; i < playerCount; i++) {
            if (propertyOwnership[i] != 0) {
                ifOwned[position] = true;
            }
        }
        return ifOwned;
    }

    public static int[] ifBuyingYes(int propertyPrice, int j, int propertyOwnership[]) {
        propertyOwnership[j] = propertyPrice;
        return propertyOwnership;
    }

    public static int[] ifBuyingNo(String propertyName, int j, String playerNames[], byte playerCount, int propertyOwnership[]) {
        Scanner input = new Scanner(System.in);

        int maxBid = 0;
        int[] auctionBid = new int[playerCount];

        System.out.println(playerNames[j] + " has declined to buy the property. You can now enter your bid to buy it.");
        for (int i = 0; i < playerCount; i++) {
            System.out.print(playerNames[i] + " please enter your bid: ");
            auctionBid[i] = input.nextInt();
            if (auctionBid[i] > maxBid) {
                maxBid = auctionBid[i];
            }
        }
        for (int i = 0; i < playerCount; i++) {
            if (auctionBid[i] == maxBid) {
                propertyOwnership[i] = maxBid;
                System.out.println(playerNames[i] + " offered the highest bid and now owns " + propertyName + ".");
            }
        }
        return propertyOwnership;
    }

    public static int positionChecker(int propertyOwnership[], byte playerCount) {
        int number = 0;
        for (int i = 0; i < playerCount; i++) {
            if (propertyOwnership[i] != 0) {
                number = i;
            }
        }
        return number;
    }
/*
    public static boolean[][] housesOwnedChecker(boolean[][] propertyHouses, byte propertyPosition) {
        for (int k = 0; k < 4; k++) {
            if (!propertyHouses[propertyPosition][k]) {
                propertyHouses[propertyPosition][k] = true;
            }
        }
        return propertyHouses;
    }
    */
}
