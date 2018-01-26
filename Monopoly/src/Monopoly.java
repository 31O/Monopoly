import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;
import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to monopoly!");
        System.out.println("There are several commands you can use during your turn: \n-\"sell\" to sell an unimproved lot" +
                "\n-\"money\" to see the amount of money you've got \n-\"build\" to improve your lot with houses and hotels \n-\"quit\" to end the game \n");

        byte playerCount = getPlayerCount();
        String playerNames[] = getPlayerNames(playerCount);
        int[] playerPosition = new int[playerCount];
        int[] playerMoney = getPlayerMoney(playerCount);
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
        int[] electricCompanyOwnership = new int[playerCount];
        int[] waterWorksOwnership = new int[playerCount];
        int[] readingRailroadOwnership = new int[playerCount];
        int[] pennsylvaniaRailroadOwnership = new int[playerCount];
        int[] boRailroadOwnership = new int[playerCount];
        int[] shortLineRailroadOwnership = new int[playerCount];
        boolean[][] propertyHouses = new boolean[40][4];
        boolean[] hotelOwnership = new boolean[40];
        boolean[] ifAlreadyPaid = new boolean[40];
        boolean[] inJailStatus = new boolean[playerCount];
        byte inJailTurns[] = new byte[playerCount];
        boolean[] jailCardOwned = new boolean[playerCount];
        byte propertySellPosition = 0;
        String[] propertyNames = getPropertyNames();

        for (int i = 0; i < playerCount; i++) {
            while (playerMoney[i] > 0) {

                for (int j = 0; j < playerCount; j++) {
                    int dicesRoll = getDiceRoll();
                    if (playerMoney[j] > 0) {
                        if (!inJailStatus[j]) {
                            System.out.println("It is " + playerNames[j] + "'s turn. " + "Press enter to roll the dices");
                        }
                        String playerTurnInput = input.nextLine();

                        if (playerTurnInput.equalsIgnoreCase("money")) {
                            System.out.println(playerNames[j] + " has $" + playerMoney[j]);
                        }
                        if (playerTurnInput.equalsIgnoreCase("quit")) {
                            quitCommand(playerCount, playerMoney, playerNames);
                            return;
                        }
                        if (playerTurnInput.equalsIgnoreCase("sell")) {
                            System.out.println("Which property do you wish to sell?");
                            String propertyToSell = input.nextLine();
                            for (byte k = 0; k < 40; k++) {
                                if (propertyToSell.equalsIgnoreCase(propertyNames[k])) {
                                    propertySellPosition = k;
                                }
                            }
                            switch (propertyToSell) {
                                case "mediterranean avenue":
                                    propertySeller(propertySellPosition, j, mediterraneanAveOwnership, propertyHouses);
                                    playerMoney[j] += 30;
                                    break;
                                case "baltic avenue":
                                    propertySeller(propertySellPosition, j, balticAveOwnership, propertyHouses);
                                    playerMoney[j] += 30;
                                    break;
                                case "Oriental Avenue":
                                    propertySeller(propertySellPosition, j, orientalAveOwnership, propertyHouses);
                                    playerMoney[j] += 50;
                                    break;
                                case "vermont avenue":
                                    propertySeller(propertySellPosition, j, vermontAveOwnership, propertyHouses);
                                    playerMoney[j] += 50;
                                    break;
                                case "connecticut avenue":
                                    propertySeller(propertySellPosition, j, connecticutAveOwnership, propertyHouses);
                                    playerMoney[j] += 70;
                                    break;
                                case "st charles place":
                                    propertySeller(propertySellPosition, j, stCharlesOwnership, propertyHouses);
                                    playerMoney[j] += 70;
                                    break;
                                case "states avenue":
                                    propertySeller(propertySellPosition, j, statesAveOwnership, propertyHouses);
                                    playerMoney[j] += 90;
                                    break;
                                case "virginia avenue":
                                    propertySeller(propertySellPosition, j, virginiaAveOwnership, propertyHouses);
                                    playerMoney[j] += 90;
                                    break;
                                case "st james place":
                                    propertySeller(propertySellPosition, j, stJamesAveOwnership, propertyHouses);
                                    playerMoney[j] += 110;
                                    break;
                                case "tennessee avenue":
                                    propertySeller(propertySellPosition, j, tennesseeAveOwnership, propertyHouses);
                                    playerMoney[j] += 110;
                                    break;
                                case "new york avenue":
                                    propertySeller(propertySellPosition, j, newYorkAveOwnership, propertyHouses);
                                    playerMoney[j] += 130;
                                    break;
                                case "kentucky avenue":
                                    propertySeller(propertySellPosition, j, kentuckyAveOwnership, propertyHouses);
                                    playerMoney[j] += 130;
                                    break;
                                case "indiana avenue":
                                    propertySeller(propertySellPosition, j, indianaAveOwnership, propertyHouses);
                                    playerMoney[j] += 150;
                                    break;
                                case "illinois avenue":
                                    propertySeller(propertySellPosition, j, illinoisAveOwnership, propertyHouses);
                                    playerMoney[j] += 150;
                                    break;
                                case "atlantic avenue":
                                    propertySeller(propertySellPosition, j, atlanticAveOwnership, propertyHouses);
                                    playerMoney[j] += 170;
                                    break;
                                case "ventnor avenue":
                                    propertySeller(propertySellPosition, j, ventnorAveOwnership, propertyHouses);
                                    playerMoney[j] += 170;
                                    break;
                                case "marvin gardens":
                                    propertySeller(propertySellPosition, j, marvinGardensOwnership, propertyHouses);
                                    playerMoney[j] += 190;
                                    break;
                                case "pacific avenue":
                                    propertySeller(propertySellPosition, j, pacificAveOwnership, propertyHouses);
                                    playerMoney[j] += 190;
                                    break;
                                case "north carolina avenue":
                                    propertySeller(propertySellPosition, j, northCarolinaAveOwnership, propertyHouses);
                                    playerMoney[j] += 210;
                                    break;
                                case "pennsylvania avenue":
                                    propertySeller(propertySellPosition, j, pennsylvaniaAveOwnership, propertyHouses);
                                    playerMoney[j] += 210;
                                    break;
                                case "park place":
                                    propertySeller(propertySellPosition, j, parkPlaceOwnership, propertyHouses);
                                    playerMoney[j] += 230;
                                    break;
                                case "boardwalk":
                                    propertySeller(propertySellPosition, j, boardWalkOwnership, propertyHouses);
                                    playerMoney[j] += 230;
                                    break;
                                default:
                                    System.out.println("Incorrect name!");
                            }
                        }

                        if (playerTurnInput.equalsIgnoreCase("build")) {
                            System.out.println("On which property do you wish to build a house/hotel on?");
                            String buildOnWhichProperty = input.nextLine();

                            // ifs that contain the switch cases check if all the same coloured properties are owned

                            if (mediterraneanAveOwnership[j] != 0 && balticAveOwnership[j] != 0 &&
                                    (buildOnWhichProperty.equalsIgnoreCase(propertyNames[2]) || buildOnWhichProperty.equalsIgnoreCase(propertyNames[4]))) {
                                switch (buildOnWhichProperty) {
                                    case "mediterranean avenue":
                                        byte propertyPositionCase1 = 2;
                                        if ((propertyHouses[2][0] && !propertyHouses[4][0]) ||     //requires the houses to be spread across the monopoly evenly
                                                (propertyHouses[2][1] && !propertyHouses[4][1]) || //switches with only 2 cases don't call a method with the check, rest do
                                                (propertyHouses[2][2] && !propertyHouses[4][2]) ||
                                                (propertyHouses[2][3] && !propertyHouses[4][3])) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase1]) {          //everytime a player lands on this case he is taxed $50 until he owns a hotel
                                                playerMoney[j] -= 50;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                            propertyHouses = housesCreator(propertyPositionCase1, propertyHouses);
                                        }
                                        break;
                                    case "baltic avenue":
                                        byte propertyPositionCase2 = 4;
                                        if ((!propertyHouses[2][0] && propertyHouses[4][0]) ||
                                                (!propertyHouses[2][1] && propertyHouses[4][1]) ||
                                                (!propertyHouses[2][2] && propertyHouses[4][2]) ||
                                                (!propertyHouses[2][3] && propertyHouses[4][3])) {

                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase2]) {
                                                playerMoney[j] -= 50;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                            propertyHouses = housesCreator(propertyPositionCase2, propertyHouses);
                                        }
                                        break;
                                    default:
                                        System.out.print("Incorrect name entered!");
                                }
                            } else if (orientalAveOwnership[j] != 0 && vermontAveOwnership[j] != 0 && connecticutAveOwnership[j] != 0 &&
                                    (buildOnWhichProperty.equalsIgnoreCase(propertyNames[7]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[9]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[10]))) {
                                switch (buildOnWhichProperty) {
                                    case "Oriental Avenue":
                                        byte propertyPositionCase1 = 7;
                                        byte propertyPositionCase2 = 9;
                                        byte propertyPositionCase3 = 10;
                                        byte caseNumber = 1;
                                        boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase1]) {
                                                playerMoney[j] -= 50;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                            propertyHouses = housesCreator(propertyPositionCase1, propertyHouses);
                                        }
                                        break;
                                    case "vermont avenue":
                                        propertyPositionCase1 = 7;
                                        propertyPositionCase2 = 9;
                                        propertyPositionCase3 = 10;
                                        caseNumber = 2;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase2]) {
                                                playerMoney[j] -= 50;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                            propertyHouses = housesCreator(propertyPositionCase2, propertyHouses);
                                        }
                                        break;
                                    case "connecticut avenue":
                                        propertyPositionCase1 = 7;
                                        propertyPositionCase2 = 9;
                                        propertyPositionCase3 = 10;
                                        caseNumber = 3;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase3]) {
                                                playerMoney[j] -= 50;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                            propertyHouses = housesCreator(propertyPositionCase3, propertyHouses);
                                        }
                                        break;
                                    default:
                                        System.out.print("Incorrect name entered!");
                                }
                            } else if (stCharlesOwnership[j] != 0 && statesAveOwnership[j] != 0 && virginiaAveOwnership[j] != 0 &&
                                    (buildOnWhichProperty.equalsIgnoreCase(propertyNames[12]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[14]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[15]))) {
                                switch (buildOnWhichProperty) {
                                    case "st charles place":
                                        byte propertyPositionCase1 = 12;
                                        byte propertyPositionCase2 = 14;
                                        byte propertyPositionCase3 = 15;
                                        byte caseNumber = 1;
                                        boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase1]) {
                                                playerMoney[j] -= 100;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                            propertyHouses = housesCreator(propertyPositionCase1, propertyHouses);
                                        }
                                        break;
                                    case "states avenue":
                                        propertyPositionCase1 = 12;
                                        propertyPositionCase2 = 14;
                                        propertyPositionCase3 = 15;
                                        caseNumber = 2;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase2]) {
                                                playerMoney[j] -= 100;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                            propertyHouses = housesCreator(propertyPositionCase2, propertyHouses);
                                        }
                                        break;
                                    case "virginia avenue":
                                        propertyPositionCase1 = 12;
                                        propertyPositionCase2 = 14;
                                        propertyPositionCase3 = 15;
                                        caseNumber = 3;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase3]) {
                                                playerMoney[j] -= 100;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                            propertyHouses = housesCreator(propertyPositionCase3, propertyHouses);
                                        }
                                        break;
                                    default:
                                        System.out.print("Incorrect name entered!");
                                }
                            } else if (stJamesAveOwnership[j] != 0 && tennesseeAveOwnership[j] != 0 && newYorkAveOwnership[j] != 0 &&
                                    (buildOnWhichProperty.equalsIgnoreCase(propertyNames[17]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[19]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[20]))) {
                                switch (buildOnWhichProperty) {
                                    case "st james place":
                                        byte propertyPositionCase1 = 17;
                                        byte propertyPositionCase2 = 19;
                                        byte propertyPositionCase3 = 20;
                                        byte caseNumber = 1;
                                        boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase1]) {
                                                playerMoney[j] -= 100;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                            propertyHouses = housesCreator(propertyPositionCase1, propertyHouses);
                                        }
                                        break;
                                    case "tennessee avenue":
                                        propertyPositionCase1 = 17;
                                        propertyPositionCase2 = 19;
                                        propertyPositionCase3 = 20;
                                        caseNumber = 2;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase2]) {
                                                playerMoney[j] -= 100;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                            propertyHouses = housesCreator(propertyPositionCase2, propertyHouses);
                                        }
                                        break;
                                    case "new york avenue":
                                        propertyPositionCase1 = 17;
                                        propertyPositionCase2 = 19;
                                        propertyPositionCase3 = 20;
                                        caseNumber = 3;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase3]) {
                                                playerMoney[j] -= 100;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                            propertyHouses = housesCreator(propertyPositionCase3, propertyHouses);
                                        }
                                        break;
                                    default:
                                        System.out.print("Incorrect name entered!");
                                }
                            } else if (kentuckyAveOwnership[j] != 0 && indianaAveOwnership[j] != 0 && illinoisAveOwnership[j] != 0 &&
                                    (buildOnWhichProperty.equalsIgnoreCase(propertyNames[22]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[24]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[25]))) {
                                switch (buildOnWhichProperty) {
                                    case "kentucky avenue":
                                        byte propertyPositionCase1 = 22;
                                        byte propertyPositionCase2 = 24;
                                        byte propertyPositionCase3 = 25;
                                        byte caseNumber = 1;
                                        boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase1]) {
                                                playerMoney[j] -= 150;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                            propertyHouses = housesCreator(propertyPositionCase1, propertyHouses);
                                        }
                                        break;
                                    case "indiana avenue":
                                        propertyPositionCase1 = 22;
                                        propertyPositionCase2 = 24;
                                        propertyPositionCase3 = 25;
                                        caseNumber = 2;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase2]) {
                                                playerMoney[j] -= 150;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                            propertyHouses = housesCreator(propertyPositionCase2, propertyHouses);
                                        }
                                        break;
                                    case "illinois avenue":
                                        propertyPositionCase1 = 22;
                                        propertyPositionCase2 = 24;
                                        propertyPositionCase3 = 25;
                                        caseNumber = 3;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase3]) {
                                                playerMoney[j] -= 150;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                            propertyHouses = housesCreator(propertyPositionCase3, propertyHouses);
                                        }
                                        break;
                                    default:
                                        System.out.print("Incorrect name entered!");
                                }
                            } else if (atlanticAveOwnership[j] != 0 && ventnorAveOwnership[j] != 0 && marvinGardensOwnership[j] != 0 &&
                                    (buildOnWhichProperty.equalsIgnoreCase(propertyNames[27]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[28]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[30]))) {
                                switch (buildOnWhichProperty) {
                                    case "atlantic avenue":
                                        byte propertyPositionCase1 = 27;
                                        byte propertyPositionCase2 = 28;
                                        byte propertyPositionCase3 = 30;
                                        byte caseNumber = 1;
                                        boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase1]) {
                                                playerMoney[j] -= 150;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                            propertyHouses = housesCreator(propertyPositionCase1, propertyHouses);
                                        }
                                        break;
                                    case "ventnor avenue":
                                        propertyPositionCase1 = 27;
                                        propertyPositionCase2 = 28;
                                        propertyPositionCase3 = 30;
                                        caseNumber = 2;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase2]) {
                                                playerMoney[j] -= 150;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                            propertyHouses = housesCreator(propertyPositionCase2, propertyHouses);
                                        }
                                        break;
                                    case "marvin gardens":
                                        propertyPositionCase1 = 22;
                                        propertyPositionCase2 = 24;
                                        propertyPositionCase3 = 25;
                                        caseNumber = 3;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase3]) {
                                                playerMoney[j] -= 150;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                            propertyHouses = housesCreator(propertyPositionCase3, propertyHouses);
                                        }
                                        break;
                                    default:
                                        System.out.print("Incorrect name entered!");
                                }
                            } else if (pacificAveOwnership[j] != 0 && northCarolinaAveOwnership[j] != 0 && pennsylvaniaAveOwnership[j] != 0 &&
                                    (buildOnWhichProperty.equalsIgnoreCase(propertyNames[32]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[33]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[35]))) {
                                switch (buildOnWhichProperty) {
                                    case "pacific avenue":
                                        byte propertyPositionCase1 = 32;
                                        byte propertyPositionCase2 = 33;
                                        byte propertyPositionCase3 = 35;
                                        byte caseNumber = 1;
                                        boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase1]) {
                                                playerMoney[j] -= 200;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                            propertyHouses = housesCreator(propertyPositionCase1, propertyHouses);
                                        }
                                        break;
                                    case "north carolina avenue":
                                        propertyPositionCase1 = 32;
                                        propertyPositionCase2 = 33;
                                        propertyPositionCase3 = 35;
                                        caseNumber = 2;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase2]) {
                                                playerMoney[j] -= 200;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                            propertyHouses = housesCreator(propertyPositionCase2, propertyHouses);
                                        }
                                        break;
                                    case "pennsylvania avenue":
                                        propertyPositionCase1 = 32;
                                        propertyPositionCase2 = 33;
                                        propertyPositionCase3 = 35;
                                        caseNumber = 3;
                                        ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);

                                        if (ifEligible) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase3]) {
                                                playerMoney[j] -= 200;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                            propertyHouses = housesCreator(propertyPositionCase3, propertyHouses);
                                        }
                                        break;
                                    default:
                                        System.out.print("Incorrect name entered!");
                                }
                            } else if (parkPlaceOwnership[j] != 0 && boardWalkOwnership[j] != 0 &&
                                    (buildOnWhichProperty.equalsIgnoreCase(propertyNames[38]) ||
                                            buildOnWhichProperty.equalsIgnoreCase(propertyNames[40]))) {
                                switch (buildOnWhichProperty) {
                                    case "park place":
                                        byte propertyPositionCase1 = 2;
                                        if ((propertyHouses[38][0] && !propertyHouses[39][0]) ||
                                                (propertyHouses[38][1] && !propertyHouses[39][1]) ||
                                                (propertyHouses[38][2] && !propertyHouses[39][2]) ||
                                                (propertyHouses[38][3] && !propertyHouses[39][3])) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase1]) {
                                                playerMoney[j] -= 200;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                            propertyHouses = housesCreator(propertyPositionCase1, propertyHouses);
                                        }
                                        break;
                                    case "boardwalk":
                                        byte propertyPositionCase2 = 4;
                                        if ((propertyHouses[38][0] && !propertyHouses[39][0]) ||
                                                (propertyHouses[38][1] && !propertyHouses[39][1]) ||
                                                (propertyHouses[38][2] && !propertyHouses[39][2]) ||
                                                (propertyHouses[38][3] && !propertyHouses[39][3])) {
                                            System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                        } else {
                                            if (!hotelOwnership[propertyPositionCase2]) {
                                                playerMoney[j] -= 200;
                                            }
                                            hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                            propertyHouses = housesCreator(propertyPositionCase2, propertyHouses);
                                        }
                                        break;
                                    default:
                                        System.out.print("Incorrect name entered!");
                                }
                            } else {
                                System.out.println("You need to own all properties of the same colour first to be able to build on them.\n");
                            }
                        }
                        if ((playerTurnInput.equals("") || playerTurnInput.equalsIgnoreCase("money") ||
                                playerTurnInput.equalsIgnoreCase("sell") || playerTurnInput.equalsIgnoreCase("build")) &&
                                !inJailStatus[j]) {        // allows the player to roll the dice after typing a command
                            playerPosition[j] += dicesRoll;

                            if (playerPosition[j] > 40) {
                                playerPosition[j] -= 40;
                                playerMoney[j] += 200;
                            }
                            System.out.println(playerNames[j] + " has rolled " + dicesRoll + " and is now on position " + playerPosition[j]);

                        }
                        if (playerTurnInput.equalsIgnoreCase("card")) {
                            if (jailCardOwned[j]) {
                                inJailStatus[j] = false;
                                System.out.println("You are out of jail!");
                            } else {
                                System.out.println("You don't own such card!");
                            }
                        }

                        switch (playerPosition[j]) {
                            case 2:
                                int propertyPrice = 60;
                                byte propertyPosition = 2;
                                int rentPrice = 2;
                                int house1Rent = 10;
                                int house2Rent = 30;
                                int house3Rent = 90;
                                int house4Rent = 160;
                                int hotelRent = 250;
                                mediterraneanAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, mediterraneanAveOwnership, playerPosition, playerCount, playerNames)[j];
                                int ownerPosition = positionChecker(mediterraneanAveOwnership, playerCount);
                                //retrieves the position to properly deduct money after an auction

                                if (!ifAlreadyPaid[2]) {          //prevents the player from paying again when on the same position again
                                    playerMoney[ownerPosition] -= mediterraneanAveOwnership[ownerPosition];  //property price is stored in the ownership array
                                    ifAlreadyPaid[2] = true;
                                }

                                if ((mediterraneanAveOwnership[ownerPosition] != 0 && balticAveOwnership[ownerPosition] != 0 && orientalAveOwnership[ownerPosition] != 0) && !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;     // if all properties of the same colour are owned the rent is doubled
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (mediterraneanAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 3:
                                switch (communityChest()) {
                                    case 1:
                                        System.out.println("Advance to go.");
                                        playerPosition[j] = 0;
                                        playerMoney[j] += 200;
                                        break;
                                    case 2:
                                        System.out.println("Advance to Illinois Avenue.");
                                        playerPosition[j] = 25;
                                        break;
                                    case 3:
                                        System.out.println("Advance to St Charles Place.");
                                        playerPosition[j] = 12;
                                        break;
                                    case 4:
                                        System.out.println("This is your get of jail card. Type \"card\" whenever you want to use this.");
                                        jailCardOwned[j] = true;
                                        break;
                                    case 5:
                                        System.out.println("Go back 3 spaces.");
                                        playerPosition[j] -= 3;
                                        break;
                                    case 6:
                                        System.out.println("Pay poor tax of $15.");
                                        playerMoney[j] -= 15;
                                        break;
                                    case 7:
                                        System.out.println("Go to jail!");
                                        playerPosition[j] = 11;
                                        inJailStatus[j] = true;
                                        break;
                                    case 8:
                                        System.out.println("You've been elected as Chairman of the board! - Pay each player $50");
                                        playerMoney[j] -= (playerCount * 50) + 50;
                                        for (int k = 0; k < playerCount; k++) {
                                            playerMoney[k] += 50;
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                propertyPrice = 60;
                                propertyPosition = 4;
                                rentPrice = 4;
                                house1Rent = 20;
                                house2Rent = 60;
                                house3Rent = 180;
                                house4Rent = 320;
                                hotelRent = 450;
                                balticAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, balticAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(balticAveOwnership, playerCount);

                                if (!ifAlreadyPaid[4]) {
                                    playerMoney[ownerPosition] -= balticAveOwnership[ownerPosition];
                                    ifAlreadyPaid[4] = true;
                                }

                                if ((mediterraneanAveOwnership[ownerPosition] != 0 && balticAveOwnership[ownerPosition] != 0) && !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (balticAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 5:
                                int tax = incomeTax(j, playerMoney);
                                playerMoney[j] -= tax;
                                break;
                            case 6:
                                propertyPrice = 200;
                                propertyPosition = 6;
                                rentPrice = 25;
                                readingRailroadOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, readingRailroadOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(readingRailroadOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= readingRailroadOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }
                                //railroad rent is multiplied by the amount of railroads owned
                                rentPrice *= railroadsOwned(ownerPosition, readingRailroadOwnership, pennsylvaniaRailroadOwnership, boRailroadOwnership, shortLineRailroadOwnership);
                                if (readingRailroadOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on a private railroad! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 7:
                                propertyPrice = 100;
                                propertyPosition = 7;
                                rentPrice = 6;
                                house1Rent = 30;
                                house2Rent = 90;
                                house3Rent = 270;
                                house4Rent = 400;
                                hotelRent = 550;
                                orientalAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, orientalAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(orientalAveOwnership, playerCount);

                                if (!ifAlreadyPaid[7]) {
                                    playerMoney[ownerPosition] -= orientalAveOwnership[ownerPosition];
                                    ifAlreadyPaid[7] = true;
                                }

                                if ((orientalAveOwnership[ownerPosition] != 0 && vermontAveOwnership[ownerPosition] != 0 && connecticutAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (orientalAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 8:
                                switch (communityChest()) {
                                    case 1:
                                        System.out.println("Advance to go.");
                                        playerPosition[j] = 0;
                                        playerMoney[j] += 200;
                                        break;
                                    case 2:
                                        System.out.println("Advance to Illinois Avenue.");
                                        playerPosition[j] = 25;
                                        break;
                                    case 3:
                                        System.out.println("Advance to St Charles Place.");
                                        playerPosition[j] = 12;
                                        break;
                                    case 4:
                                        System.out.println("This is your get of jail card. Type \"card\" whenever you want to use this.");
                                        jailCardOwned[j] = true;
                                        break;
                                    case 5:
                                        System.out.println("Go back 3 spaces.");
                                        playerPosition[j] -= 3;
                                        break;
                                    case 6:
                                        System.out.println("Pay poor tax of $15.");
                                        playerMoney[j] -= 15;
                                        break;
                                    case 7:
                                        System.out.println("Go to jail!");
                                        playerPosition[j] = 11;
                                        inJailStatus[j] = true;
                                        break;
                                    case 8:
                                        System.out.println("You've been elected as Chairman of the board! - Pay each player $50");
                                        playerMoney[j] -= (playerCount * 50) + 50;
                                        for (int k = 0; k < playerCount; k++) {
                                            playerMoney[k] += 50;
                                        }
                                        break;
                                }
                                break;
                            case 9:
                                propertyPrice = 100;
                                propertyPosition = 9;
                                rentPrice = 8;
                                house1Rent = 30;
                                house2Rent = 90;
                                house3Rent = 270;
                                house4Rent = 400;
                                hotelRent = 550;
                                vermontAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, vermontAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(vermontAveOwnership, playerCount);

                                if (!ifAlreadyPaid[9]) {
                                    playerMoney[ownerPosition] -= vermontAveOwnership[ownerPosition];
                                    ifAlreadyPaid[9] = true;
                                }

                                if ((orientalAveOwnership[ownerPosition] != 0 && vermontAveOwnership[ownerPosition] != 0 && connecticutAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (vermontAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;

                            case 10:
                                propertyPrice = 120;
                                propertyPosition = 10;
                                rentPrice = 8;
                                house1Rent = 40;
                                house2Rent = 100;
                                house3Rent = 300;
                                house4Rent = 450;
                                hotelRent = 600;
                                connecticutAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, connecticutAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(connecticutAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= connecticutAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((orientalAveOwnership[ownerPosition] != 0 && vermontAveOwnership[ownerPosition] != 0 && connecticutAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (connecticutAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 12:
                                propertyPrice = 140;
                                propertyPosition = 12;
                                rentPrice = 10;
                                house1Rent = 50;
                                house2Rent = 150;
                                house3Rent = 450;
                                house4Rent = 625;
                                hotelRent = 750;
                                stCharlesOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, stCharlesOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(stCharlesOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= stCharlesOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((stCharlesOwnership[ownerPosition] != 0 && statesAveOwnership[ownerPosition] != 0 && virginiaAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (stCharlesOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 13:
                                propertyPrice = 150;
                                propertyPosition = 13;
                                electricCompanyOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, electricCompanyOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(electricCompanyOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= waterWorksOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }
                                //rent is 4x the dice number or 10x if 2 utilities are owned
                                rentPrice = utilitiesOwned(ownerPosition, electricCompanyOwnership, waterWorksOwnership) * dicesRoll;

                                if (electricCompanyOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on a private utility! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 14:
                                propertyPrice = 140;
                                propertyPosition = 14;
                                rentPrice = 10;
                                house1Rent = 50;
                                house2Rent = 150;
                                house3Rent = 450;
                                house4Rent = 625;
                                hotelRent = 750;
                                statesAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, statesAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(statesAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= statesAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((stCharlesOwnership[ownerPosition] != 0 && statesAveOwnership[ownerPosition] != 0 && virginiaAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (statesAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 15:
                                propertyPrice = 160;
                                propertyPosition = 15;
                                rentPrice = 12;
                                house1Rent = 60;
                                house2Rent = 180;
                                house3Rent = 500;
                                house4Rent = 700;
                                hotelRent = 900;
                                virginiaAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, virginiaAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(virginiaAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= virginiaAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((stCharlesOwnership[ownerPosition] != 0 && statesAveOwnership[ownerPosition] != 0 && virginiaAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (virginiaAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 16:
                                propertyPrice = 200;
                                propertyPosition = 16;
                                rentPrice = 25;
                                pennsylvaniaRailroadOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, pennsylvaniaRailroadOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(pennsylvaniaRailroadOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= pennsylvaniaRailroadOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                rentPrice *= railroadsOwned(ownerPosition, readingRailroadOwnership, pennsylvaniaRailroadOwnership, boRailroadOwnership, shortLineRailroadOwnership);
                                if (pennsylvaniaRailroadOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on a private railroad! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 17:
                                propertyPrice = 180;
                                propertyPosition = 17;
                                rentPrice = 14;
                                house1Rent = 70;
                                house2Rent = 200;
                                house3Rent = 550;
                                house4Rent = 750;
                                hotelRent = 950;
                                stJamesAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, virginiaAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(stJamesAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= stJamesAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((stJamesAveOwnership[ownerPosition] != 0 && tennesseeAveOwnership[ownerPosition] != 0 && newYorkAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (stJamesAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 19:
                                propertyPrice = 180;
                                propertyPosition = 19;
                                rentPrice = 14;
                                house1Rent = 70;
                                house2Rent = 200;
                                house3Rent = 550;
                                house4Rent = 750;
                                hotelRent = 950;
                                tennesseeAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, tennesseeAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(tennesseeAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= tennesseeAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((stJamesAveOwnership[ownerPosition] != 0 && tennesseeAveOwnership[ownerPosition] != 0 && newYorkAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (tennesseeAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 18:
                                switch (communityChest()) {
                                    case 1:
                                        System.out.println("Advance to go.");
                                        playerPosition[j] = 0;
                                        playerMoney[j] += 200;
                                        break;
                                    case 2:
                                        System.out.println("Advance to Illinois Avenue.");
                                        playerPosition[j] = 25;
                                        break;
                                    case 3:
                                        System.out.println("Advance to St Charles Place.");
                                        playerPosition[j] = 12;
                                        break;
                                    case 4:
                                        System.out.println("This is your get of jail card. Type \"card\" whenever you want to use this.");
                                        jailCardOwned[j] = true;
                                        break;
                                    case 5:
                                        System.out.println("Go back 3 spaces.");
                                        playerPosition[j] -= 3;
                                        break;
                                    case 6:
                                        System.out.println("Pay poor tax of $15.");
                                        playerMoney[j] -= 15;
                                        break;
                                    case 7:
                                        System.out.println("Go to jail!");
                                        playerPosition[j] = 11;
                                        inJailStatus[j] = true;
                                        break;
                                    case 8:
                                        System.out.println("You've been elected as Chairman of the board! - Pay each player $50");
                                        playerMoney[j] -= (playerCount * 50) + 50;
                                        for (int k = 0; k < playerCount; k++) {
                                            playerMoney[k] += 50;
                                        }
                                        break;
                                }
                                break;
                            case 20:
                                propertyPrice = 200;
                                propertyPosition = 20;
                                rentPrice = 16;
                                house1Rent = 80;
                                house2Rent = 220;
                                house3Rent = 600;
                                house4Rent = 800;
                                hotelRent = 1000;
                                newYorkAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, newYorkAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(newYorkAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= newYorkAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((stJamesAveOwnership[ownerPosition] != 0 && tennesseeAveOwnership[ownerPosition] != 0 && newYorkAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (newYorkAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 22:
                                propertyPrice = 220;
                                propertyPosition = 22;
                                rentPrice = 18;
                                house1Rent = 90;
                                house2Rent = 250;
                                house3Rent = 700;
                                house4Rent = 875;
                                hotelRent = 1050;
                                kentuckyAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, kentuckyAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(kentuckyAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= kentuckyAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((kentuckyAveOwnership[ownerPosition] != 0 && indianaAveOwnership[ownerPosition] != 0 && illinoisAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (kentuckyAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 23:
                                switch (communityChest()) {
                                    case 1:
                                        System.out.println("Advance to go.");
                                        playerPosition[j] = 0;
                                        playerMoney[j] += 200;
                                        break;
                                    case 2:
                                        System.out.println("Advance to Illinois Avenue.");
                                        playerPosition[j] = 25;
                                        break;
                                    case 3:
                                        System.out.println("Advance to St Charles Place.");
                                        playerPosition[j] = 12;
                                        break;
                                    case 4:
                                        System.out.println("This is your get of jail card. Type \"card\" whenever you want to use this.");
                                        jailCardOwned[j] = true;
                                        break;
                                    case 5:
                                        System.out.println("Go back 3 spaces.");
                                        playerPosition[j] -= 3;
                                        break;
                                    case 6:
                                        System.out.println("Pay poor tax of $15.");
                                        playerMoney[j] -= 15;
                                        break;
                                    case 7:
                                        System.out.println("Go to jail!");
                                        playerPosition[j] = 11;
                                        inJailStatus[j] = true;
                                        break;
                                    case 8:
                                        System.out.println("You've been elected as Chairman of the board! - Pay each player $50");
                                        playerMoney[j] -= (playerCount * 50) + 50;
                                        for (int k = 0; k < playerCount; k++) {
                                            playerMoney[k] += 50;
                                        }
                                        break;
                                }
                                break;
                            case 24:
                                propertyPrice = 220;
                                propertyPosition = 24;
                                rentPrice = 18;
                                house1Rent = 90;
                                house2Rent = 250;
                                house3Rent = 700;
                                house4Rent = 875;
                                hotelRent = 1050;
                                indianaAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, indianaAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(indianaAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= indianaAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((kentuckyAveOwnership[ownerPosition] != 0 && indianaAveOwnership[ownerPosition] != 0 && illinoisAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (indianaAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 25:
                                propertyPrice = 240;
                                propertyPosition = 25;
                                rentPrice = 20;
                                house1Rent = 100;
                                house2Rent = 300;
                                house3Rent = 750;
                                house4Rent = 925;
                                hotelRent = 1100;
                                illinoisAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, illinoisAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(illinoisAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= illinoisAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((kentuckyAveOwnership[ownerPosition] != 0 && indianaAveOwnership[ownerPosition] != 0 && illinoisAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (illinoisAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 26:
                                propertyPrice = 200;
                                propertyPosition = 26;
                                rentPrice = 25;
                                boRailroadOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, boRailroadOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(boRailroadOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= boRailroadOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                rentPrice *= railroadsOwned(ownerPosition, readingRailroadOwnership, pennsylvaniaRailroadOwnership, boRailroadOwnership, shortLineRailroadOwnership);
                                if (boRailroadOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on a private railroad! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 27:
                                propertyPrice = 260;
                                propertyPosition = 27;
                                rentPrice = 22;
                                house1Rent = 110;
                                house2Rent = 330;
                                house3Rent = 800;
                                house4Rent = 975;
                                hotelRent = 1150;
                                atlanticAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, atlanticAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(atlanticAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= atlanticAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((atlanticAveOwnership[ownerPosition] != 0 && ventnorAveOwnership[ownerPosition] != 0 && marvinGardensOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (atlanticAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 28:
                                propertyPrice = 260;
                                propertyPosition = 28;
                                rentPrice = 22;
                                house1Rent = 110;
                                house2Rent = 330;
                                house3Rent = 800;
                                house4Rent = 975;
                                hotelRent = 1150;
                                ventnorAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, ventnorAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(atlanticAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= ventnorAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((atlanticAveOwnership[ownerPosition] != 0 && ventnorAveOwnership[ownerPosition] != 0 && marvinGardensOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (ventnorAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 29:
                                propertyPrice = 150;
                                propertyPosition = 29;
                                waterWorksOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, waterWorksOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(waterWorksOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= waterWorksOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                rentPrice = utilitiesOwned(ownerPosition, electricCompanyOwnership, waterWorksOwnership) * dicesRoll;

                                if (waterWorksOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on a private utility! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 30:
                                propertyPrice = 280;
                                propertyPosition = 30;
                                rentPrice = 24;
                                house1Rent = 120;
                                house2Rent = 360;
                                house3Rent = 850;
                                house4Rent = 1025;
                                hotelRent = 1200;
                                marvinGardensOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, marvinGardensOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(marvinGardensOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= marvinGardensOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((atlanticAveOwnership[ownerPosition] != 0 && ventnorAveOwnership[ownerPosition] != 0 && marvinGardensOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (marvinGardensOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 31:
                                System.out.println("You are in jail! Wait 3 turns or use a get of jail card to get free.");
                                inJailStatus[j] = true;
                                playerPosition[j] = 11;
                                break;
                            case 32:
                                propertyPrice = 300;
                                propertyPosition = 32;
                                rentPrice = 26;
                                house1Rent = 130;
                                house2Rent = 390;
                                house3Rent = 900;
                                house4Rent = 1100;
                                hotelRent = 1275;
                                pacificAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, pacificAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(pacificAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= pacificAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((pacificAveOwnership[ownerPosition] != 0 && northCarolinaAveOwnership[ownerPosition] != 0 && pennsylvaniaAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (pacificAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 33:
                                propertyPrice = 300;
                                propertyPosition = 33;
                                rentPrice = 26;
                                house1Rent = 130;
                                house2Rent = 390;
                                house3Rent = 900;
                                house4Rent = 1100;
                                hotelRent = 1275;
                                northCarolinaAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, northCarolinaAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(northCarolinaAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= northCarolinaAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((pacificAveOwnership[ownerPosition] != 0 && northCarolinaAveOwnership[ownerPosition] != 0 && pennsylvaniaAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (northCarolinaAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 34:
                                switch (communityChest()) {
                                    case 1:
                                        System.out.println("Advance to go.");
                                        playerPosition[j] = 0;
                                        playerMoney[j] += 200;
                                        break;
                                    case 2:
                                        System.out.println("Advance to Illinois Avenue.");
                                        playerPosition[j] = 25;
                                        break;
                                    case 3:
                                        System.out.println("Advance to St Charles Place.");
                                        playerPosition[j] = 12;
                                        break;
                                    case 4:
                                        System.out.println("This is your get of jail card. Type \"card\" whenever you want to use this.");
                                        jailCardOwned[j] = true;
                                        break;
                                    case 5:
                                        System.out.println("Go back 3 spaces.");
                                        playerPosition[j] -= 3;
                                        break;
                                    case 6:
                                        System.out.println("Pay poor tax of $15.");
                                        playerMoney[j] -= 15;
                                        break;
                                    case 7:
                                        System.out.println("Go to jail!");
                                        playerPosition[j] = 11;
                                        inJailStatus[j] = true;
                                        break;
                                    case 8:
                                        System.out.println("You've been elected as Chairman of the board! - Pay each player $50");
                                        playerMoney[j] -= (playerCount * 50) + 50;
                                        for (int k = 0; k < playerCount; k++) {
                                            playerMoney[k] += 50;
                                        }
                                        break;
                                }
                                break;
                            case 35:
                                propertyPrice = 320;
                                propertyPosition = 35;
                                rentPrice = 28;
                                house1Rent = 150;
                                house2Rent = 450;
                                house3Rent = 1000;
                                house4Rent = 1200;
                                hotelRent = 1400;
                                pennsylvaniaAveOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, pennsylvaniaAveOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(pennsylvaniaAveOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= pennsylvaniaAveOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((pacificAveOwnership[ownerPosition] != 0 && northCarolinaAveOwnership[ownerPosition] != 0 && pennsylvaniaAveOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (pennsylvaniaAveOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 36:
                                propertyPrice = 200;
                                propertyPosition = 36;
                                rentPrice = 25;
                                shortLineRailroadOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, shortLineRailroadOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(shortLineRailroadOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= shortLineRailroadOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                rentPrice *= railroadsOwned(ownerPosition, readingRailroadOwnership, pennsylvaniaRailroadOwnership, boRailroadOwnership, shortLineRailroadOwnership);
                                if (shortLineRailroadOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on a private railroad! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 37:
                                switch (communityChest()) {
                                    case 1:
                                        System.out.println("Advance to go.");
                                        playerPosition[j] = 0;
                                        playerMoney[j] += 200;
                                        break;
                                    case 2:
                                        System.out.println("Advance to Illinois Avenue.");
                                        playerPosition[j] = 25;
                                        break;
                                    case 3:
                                        System.out.println("Advance to St Charles Place.");
                                        playerPosition[j] = 12;
                                        break;
                                    case 4:
                                        System.out.println("This is your get of jail card. Type \"card\" whenever you want to use this.");
                                        jailCardOwned[j] = true;
                                        break;
                                    case 5:
                                        System.out.println("Go back 3 spaces.");
                                        playerPosition[j] -= 3;
                                        break;
                                    case 6:
                                        System.out.println("Pay poor tax of $15.");
                                        playerMoney[j] -= 15;
                                        break;
                                    case 7:
                                        System.out.println("Go to jail!");
                                        playerPosition[j] = 11;
                                        inJailStatus[j] = true;
                                        break;
                                    case 8:
                                        System.out.println("You've been elected as Chairman of the board! - Pay each player $50");
                                        playerMoney[j] -= (playerCount * 50) + 50;
                                        for (int k = 0; k < playerCount; k++) {
                                            playerMoney[k] += 50;
                                        }
                                        break;
                                }
                                break;
                            case 38:
                                propertyPrice = 350;
                                propertyPosition = 38;
                                rentPrice = 35;
                                house1Rent = 175;
                                house2Rent = 500;
                                house3Rent = 1100;
                                house4Rent = 1300;
                                hotelRent = 1500;
                                parkPlaceOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, parkPlaceOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(parkPlaceOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= parkPlaceOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((parkPlaceOwnership[ownerPosition] != 0 && boardWalkOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (parkPlaceOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                            case 39:
                                propertyPrice = 400;
                                propertyPosition = 39;
                                rentPrice = 50;
                                house1Rent = 200;
                                house2Rent = 600;
                                house3Rent = 1400;
                                house4Rent = 1700;
                                hotelRent = 2000;
                                boardWalkOwnership[j] = propertyOwnership(propertyPosition, propertyPrice, j, boardWalkOwnership, playerPosition, playerCount, playerNames)[j];
                                ownerPosition = positionChecker(boardWalkOwnership, playerCount);

                                if (!ifAlreadyPaid[propertyPosition]) {
                                    playerMoney[ownerPosition] -= boardWalkOwnership[ownerPosition];
                                    ifAlreadyPaid[propertyPosition] = true;
                                }

                                if ((parkPlaceOwnership[ownerPosition] != 0 && boardWalkOwnership[ownerPosition] != 0) &&
                                        !propertyHouses[propertyPosition][0]) {
                                    rentPrice *= 2;
                                }

                                rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                                if (boardWalkOwnership[j] == 0 && ifAlreadyPaid[propertyPosition]) {
                                    System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                    playerMoney[j] -= rentPrice;
                                    playerMoney[ownerPosition] += rentPrice;
                                }
                                break;
                        }
                        if (inJailStatus[j]) {    // counts the jailed player's turns
                            inJailTurns[j]++;
                            if (inJailTurns[j] == 4) {   // 3 turns are needed but it counts the turn in which the player gets in jail
                                System.out.println("You are now out of jail!");
                                inJailStatus[j] = false;
                                inJailTurns[j] = 0;
                            }
                        }

                        if (playerMoney[j] <= 0) {
                            System.out.println(playerNames[j] + " is bankrupt! Game over for them!");
                        }
                        System.out.println("--------------------------------------------------------------------------------");
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

    public static int[] propertyOwnership(byte propertyPosition, int propertyPrice, int j, int propertyOwnership[], int playerPosition[], byte playerCount, String playerNames[]) {
        Scanner input = new Scanner(System.in);
        boolean[] ifOwned = new boolean[40];
        ifOwned[propertyPosition] = ownershipChecker(ifOwned, propertyPosition, propertyOwnership, playerCount)[propertyPosition];

        if (!ifOwned[propertyPosition]) {
            System.out.print("Do you want to buy " + getPropertyNames()[propertyPosition] + " for $" + propertyPrice + "? Enter yes or no: ");
            String ifBuying = input.nextLine();
            if (ifBuying.equalsIgnoreCase("yes")) {
                ifBuyingYes(propertyPrice, j, propertyOwnership);
            } else if (ifBuying.equalsIgnoreCase("no")) {    //auction starts if player declines to buy
                ifBuyingNo(propertyPosition, j, playerNames, playerCount, propertyOwnership);
            } else {
                propertyOwnership(propertyPosition, propertyPrice, j, propertyOwnership, playerPosition, playerCount, playerNames);
            }
        }
        return propertyOwnership;
    }

    public static boolean[] ownershipChecker(boolean[] ifOwned, byte position, int propertyOwnership[], byte playerCount) {
        for (int i = 0; i < playerCount; i++) {  //cycles through the indexes to see if anyone owns the property
            if (propertyOwnership[i] != 0) {     //property price is stored in the ownership array hence the != 0 check rather than a true or false
                ifOwned[position] = true;
            }
        }
        return ifOwned;
    }

    public static int[] ifBuyingYes(int propertyPrice, int j, int propertyOwnership[]) {
        propertyOwnership[j] = propertyPrice;
        return propertyOwnership;
    }

    public static int[] ifBuyingNo(byte propertyPosition, int j, String playerNames[], byte playerCount, int propertyOwnership[]) {
        Scanner input = new Scanner(System.in);

        int maxBid = 0;
        int[] auctionBid = new int[playerCount];

        System.out.println(playerNames[j] + " has declined to buy the property. You can now enter your bid to buy it.");
        for (int i = 0; i < playerCount; i++) {
            System.out.print(playerNames[i] + " please enter your bid: ");
            auctionBid[i] = input.nextInt();
            if (auctionBid[i] > maxBid) {       //checks to see which player has the biggest bid
                maxBid = auctionBid[i];
            }
        }
        for (int i = 0; i < playerCount; i++) {
            if (auctionBid[i] == maxBid) {
                propertyOwnership[i] = maxBid;
                System.out.println(playerNames[i] + " offered the highest bid and now owns " + getPropertyNames()[propertyPosition] + ".");
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

    public static int housesOwnedChecker(boolean[] hotelOwnership, int hotelRent, int house1Rent, int house2Rent, int house3Rent, int house4Rent, boolean[][] propertyHouses, int rentPrice, byte propertyPosition) {
        if (propertyHouses[propertyPosition][0] && !propertyHouses[propertyPosition][1]) {
            rentPrice = house1Rent;
        } else if (propertyHouses[propertyPosition][1] && !propertyHouses[propertyPosition][2]) {
            rentPrice = house2Rent;
        } else if (propertyHouses[propertyPosition][2] && !propertyHouses[propertyPosition][3]) {
            rentPrice = house3Rent;
        } else if (propertyHouses[propertyPosition][3] && !hotelOwnership[propertyPosition]) {
            rentPrice = house4Rent;
        } else if (hotelOwnership[propertyPosition]) {
            rentPrice = hotelRent;
        }
        return rentPrice;
    }

    public static boolean[][] housesCreator(byte propertyPosition, boolean[][] propertyHouses) {
        byte numberOfHouses = 0;
        for (int k = 0; k < 4; k++) {
            if (propertyHouses[propertyPosition][numberOfHouses] && numberOfHouses < 4) {
                numberOfHouses++;
            }
        }
        if (numberOfHouses < 4) {
            propertyHouses[propertyPosition][numberOfHouses] = true;
            System.out.println("You have build a house! Number of houses on " + getPropertyNames()[propertyPosition] + ": " + (numberOfHouses + 1));
        }
        return propertyHouses;
    }

    public static boolean[] hotelCreator(boolean[][] propertyHouses, boolean[] hotelOwnership, byte propertyPosition) {
        if (hotelOwnership[propertyPosition]) {
            System.out.println("The lot is full! You cannot build anymore.");
        } else if (propertyHouses[propertyPosition][3] && !hotelOwnership[7]) {
            System.out.println("You have build a hotel!");
            hotelOwnership[propertyPosition] = true;
        }
        return hotelOwnership;
    }

    public static boolean ifEligibleToBuild(byte propertyPositionCase1, byte propertyPositionCase2, byte propertyPositionCase3, boolean[][] propertyHouses, byte caseNumber) {
        boolean ifEligible = false;         //method checks to see if the houses are spread evenly across a monopoly
        switch (caseNumber) {               //if one lot has 1 house more than the others and is chosen again to be build on ifEligible remains false
            case 1:                         //the property the player has chosen to build on is the caseNumber from the main and is always the true one in the ifs
                if ((propertyHouses[propertyPositionCase1][0] && (!propertyHouses[propertyPositionCase2][0] || !propertyHouses[propertyPositionCase3][0])) ||
                        (propertyHouses[propertyPositionCase1][1] && (!propertyHouses[propertyPositionCase2][1] || !propertyHouses[propertyPositionCase3][1])) ||
                        (propertyHouses[propertyPositionCase1][2] && (!propertyHouses[propertyPositionCase2][2] || !propertyHouses[propertyPositionCase3][2])) ||
                        propertyHouses[propertyPositionCase1][3] && (!propertyHouses[propertyPositionCase2][3] || !propertyHouses[propertyPositionCase3][3])) {
                    ifEligible = true;
                }
                break;
            case 2:
                if (((!propertyHouses[propertyPositionCase1][0] || !propertyHouses[propertyPositionCase3][0]) && propertyHouses[propertyPositionCase2][0]) ||
                        ((!propertyHouses[propertyPositionCase1][1] || !propertyHouses[propertyPositionCase3][1]) && propertyHouses[propertyPositionCase2][1]) ||
                        ((!propertyHouses[propertyPositionCase1][2] || !propertyHouses[propertyPositionCase3][2]) && propertyHouses[propertyPositionCase2][2]) ||
                        ((!propertyHouses[propertyPositionCase1][3] || !propertyHouses[propertyPositionCase3][3]) && propertyHouses[propertyPositionCase2][3])) {
                    ifEligible = true;
                }
                break;
            case 3:
                if (((!propertyHouses[propertyPositionCase1][0] || !propertyHouses[propertyPositionCase2][0]) && propertyHouses[propertyPositionCase3][0]) ||
                        ((!propertyHouses[propertyPositionCase1][1] || !propertyHouses[propertyPositionCase2][1]) && propertyHouses[propertyPositionCase3][1]) ||
                        ((!propertyHouses[propertyPositionCase1][2] || !propertyHouses[propertyPositionCase2][2]) && propertyHouses[propertyPositionCase3][2]) ||
                        ((!propertyHouses[propertyPositionCase1][3] || !propertyHouses[propertyPositionCase2][3]) && propertyHouses[propertyPositionCase3][3])) {
                    ifEligible = true;
                }
                break;
        }
        return ifEligible;
    }

    public static String[] getPropertyNames() {
        String[] propertyNames = new String[40];
        for (int i = 0; i < 40; i++) {
            switch (i) {
                case 0:
                    propertyNames[0] = " ";
                    break;
                case 1:
                    propertyNames[1] = " ";
                    break;
                case 2:
                    propertyNames[2] = "Mediterranean Avenue";
                    break;
                case 3:
                    propertyNames[3] = " ";
                    break;
                case 4:
                    propertyNames[4] = "Baltic Avenue";
                    break;
                case 5:
                    propertyNames[5] = " ";
                    break;
                case 6:
                    propertyNames[6] = "Reading Railroad";
                    break;
                case 7:
                    propertyNames[7] = "Oriental Avenue";
                    break;
                case 8:
                    propertyNames[8] = " ";
                    break;
                case 9:
                    propertyNames[9] = "Vermont Avenue";
                    break;
                case 10:
                    propertyNames[10] = "Connecticut Avenue";
                    break;
                case 11:
                    propertyNames[11] = " ";
                    break;
                case 12:
                    propertyNames[12] = "St Charles Place";
                    break;
                case 13:
                    propertyNames[13] = "Electric Company";
                    break;
                case 14:
                    propertyNames[14] = "States Avenue";
                    break;
                case 15:
                    propertyNames[15] = "Virginia Avenue";
                    break;
                case 16:
                    propertyNames[16] = "Pennsylvania Railroad";
                    break;
                case 17:
                    propertyNames[17] = "St James Place";
                    break;
                case 18:
                    propertyNames[18] = " ";
                    break;
                case 19:
                    propertyNames[19] = "Tennessee Avenue";
                    break;
                case 20:
                    propertyNames[20] = "New York Avenue";
                    break;
                case 21:
                    propertyNames[21] = " ";
                    break;
                case 22:
                    propertyNames[22] = "Kentucky Avenue";
                    break;
                case 23:
                    propertyNames[23] = " ";
                    break;
                case 24:
                    propertyNames[24] = "Indiana Avenue";
                    break;
                case 25:
                    propertyNames[25] = "Illinois Avenue";
                    break;
                case 26:
                    propertyNames[26] = "B & O Railroad";
                    break;
                case 27:
                    propertyNames[27] = "Atlantic Avenue";
                    break;
                case 28:
                    propertyNames[28] = "Ventnor Avenue";
                    break;
                case 29:
                    propertyNames[29] = "Water Works";
                    break;
                case 30:
                    propertyNames[30] = "Marvin Gardens";
                    break;
                case 31:
                    propertyNames[31] = " ";
                    break;
                case 32:
                    propertyNames[32] = "Pacific Avenue";
                    break;
                case 33:
                    propertyNames[33] = "North Carolina Avenue";
                    break;
                case 34:
                    propertyNames[34] = " ";
                    break;
                case 35:
                    propertyNames[35] = "Pennsylvania Avenue";
                    break;
                case 36:
                    propertyNames[36] = "Short Line Railroad";
                    break;
                case 37:
                    propertyNames[37] = " ";
                    break;
                case 38:
                    propertyNames[38] = "Park Place";
                    break;
                case 39:
                    propertyNames[39] = "Boardwalk";
                    break;
            }
        }
        return propertyNames;
    }

    public static int railroadsOwned(int ownerPosition, int[] readingRailroadOwnership, int[] pennsylvaniaRailroadOwnership, int[] boRailroadOwnership, int[] shortLineRailroadOwnership) {
        int railroadsOwned = 0;
        if (readingRailroadOwnership[ownerPosition] != 0 || pennsylvaniaRailroadOwnership[ownerPosition] != 0 ||
                boRailroadOwnership[ownerPosition] != 0 || shortLineRailroadOwnership[ownerPosition] != 0) {
            railroadsOwned = 1;
        }
        if (((readingRailroadOwnership[ownerPosition] != 0 && pennsylvaniaRailroadOwnership[ownerPosition] != 0) ||
                (readingRailroadOwnership[ownerPosition] != 0 && boRailroadOwnership[ownerPosition] != 0) ||
                (readingRailroadOwnership[ownerPosition] != 0 && shortLineRailroadOwnership[ownerPosition] != 0)) ||
                (pennsylvaniaRailroadOwnership[ownerPosition] != 0 && boRailroadOwnership[ownerPosition] != 0) ||
                (pennsylvaniaRailroadOwnership[ownerPosition] != 0 && shortLineRailroadOwnership[ownerPosition] != 0) ||
                (boRailroadOwnership[ownerPosition] != 0 && shortLineRailroadOwnership[ownerPosition] != 0)) {
            railroadsOwned = 2;
        }
        if ((readingRailroadOwnership[ownerPosition] != 0 && pennsylvaniaRailroadOwnership[ownerPosition] != 0 && boRailroadOwnership[ownerPosition] != 0) ||
                (readingRailroadOwnership[ownerPosition] != 0 && pennsylvaniaRailroadOwnership[ownerPosition] != 0 && shortLineRailroadOwnership[ownerPosition] != 0) ||
                (pennsylvaniaRailroadOwnership[ownerPosition] != 0 && boRailroadOwnership[ownerPosition] != 0 && shortLineRailroadOwnership[ownerPosition] != 0) ||
                (boRailroadOwnership[ownerPosition] != 0 && readingRailroadOwnership[ownerPosition] != 0 && shortLineRailroadOwnership[ownerPosition] != 0)) {
            railroadsOwned = 3;
        }
        if (readingRailroadOwnership[ownerPosition] != 0 && pennsylvaniaRailroadOwnership[ownerPosition] != 0 &&
                boRailroadOwnership[ownerPosition] != 0 && shortLineRailroadOwnership[ownerPosition] != 0) {
            railroadsOwned = 4;
        }
        return railroadsOwned;
    }

    public static int utilitiesOwned(int ownerPosition, int[] electricCompanyOwnership, int[] waterWorksOwnership) {
        int utilitiesOwned = 4;
        if (electricCompanyOwnership[ownerPosition] != 0 && waterWorksOwnership[ownerPosition] != 0) {
            utilitiesOwned = 10;
        }
        return utilitiesOwned;
    }

    public static int incomeTax(int j, int[] playerMoney) {
        Scanner input = new Scanner(System.in);
        int taxAmount = 0;
        System.out.print("You have to pay income tax! \nEnter \"200\" to pay 200$ or enter \"10\" to pay 10% of your total assets: ");
        String userInput = input.nextLine();

        if (userInput.equals("200")) {
            System.out.println("You have paid 200$ to the bank.");
            taxAmount = 200;
        } else if (userInput.equals("10")) {
            double taxAmountDouble = 0.1 * playerMoney[j];
            taxAmount = (int) taxAmountDouble;     //converts to int
            System.out.println("You have paid " + taxAmount + " to the bank.");
        } else {
            incomeTax(j, playerMoney);
        }
        return taxAmount;
    }

    public static int communityChest() {
        Random cardNumberGenerator = new Random();
        int cardNumber = cardNumberGenerator.nextInt(8) + 1;
        System.out.println("You've landed on a community chest and received a random card!");
        System.out.print("The cards says... ");
        return cardNumber;
    }

    public static int[] propertySeller(byte propertyPosition, int j, int propertyOwnership[], boolean propertyHouses[][]) {
        if (propertyOwnership[j] != 0 && !propertyHouses[propertyPosition][0]) {
            propertyOwnership[j] = 0;
            System.out.println("You have sold your property!");
        } else if (propertyOwnership[j] != 0) {
            System.out.println("You can only sell unimproved lots.");
        } else {
            System.out.println("You need to own the property first to sell it!");
        }
        return propertyOwnership;
    }

    public static void quitCommand(byte playerCount, int playerMoney[], String playerNames[]) {
        int mostMoney = 0;
        String winnerName = "";
        for (int k = 0; k < playerCount; k++) {
            if (playerMoney[k] > mostMoney) {
                mostMoney = playerMoney[k];
                winnerName = playerNames[k];
            }
        }
        System.out.println(winnerName + " has the most money ($" + mostMoney + ") and wins the game!");
    }

    public static int[] getPlayerMoney(byte playerCount) {
        int[] playerMoney = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            playerMoney[i] = 1500;
        }
        return playerMoney;
    }
}
