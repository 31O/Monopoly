import java.util.Random;
import java.util.Scanner;

public class Monopoly {
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
        boolean[] hotelOwnership = new boolean[40];
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
                    } else if (playerTurnInput.equalsIgnoreCase("b")) {
                        System.out.println("On which property do you wish to build a house/hotel on?");
                        String buildOnWhichProperty = input.nextLine();
                        if (mediterraneanAveOwnership[j] != 0 && balticAveOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "mediterranean avenue":
                                    byte propertyPositionCase1 = 2;
                                    String propertyName = "Mediterranean Avenue";
                                    if ((!propertyHouses[2][0] && propertyHouses[4][0]) ||
                                            (!propertyHouses[2][1] && propertyHouses[4][1]) ||
                                            (!propertyHouses[2][2] && propertyHouses[4][2]) ||
                                            (!propertyHouses[2][3] && propertyHouses[4][3])) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase1]) {
                                            playerMoney[j] -= 50;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase1, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "baltic avenue":
                                    byte propertyPositionCase2 = 4;
                                    propertyName = "Baltic Avenue";
                                    if ((propertyHouses[2][0] && !propertyHouses[4][0]) ||
                                            (propertyHouses[2][1] && !propertyHouses[4][1]) ||
                                            (propertyHouses[2][2] && !propertyHouses[4][2]) ||
                                            (propertyHouses[2][3] && !propertyHouses[4][3])) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase2]) {
                                            playerMoney[j] -= 50;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase2, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                default:
                                    System.out.print("Incorrect name entered!");
                            }
                        } else {
                            System.out.println("You need to own all properties of the same colour first to be able to build on them.");
                        }
                        if (orientalAveOwnership[j] != 0 && vermontAveOwnership[j] != 0 && connecticutAveOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "Oriental Avenue":
                                    byte propertyPositionCase1 = 7;
                                    byte propertyPositionCase2 = 9;
                                    byte propertyPositionCase3 = 10;
                                    byte caseNumber = 1;
                                    String propertyName = "Oriental Avenue";
                                    boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase1]) {
                                            playerMoney[j] -= 50;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase1, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "vermont avenue":
                                    propertyPositionCase1 = 7;
                                    propertyPositionCase2 = 9;
                                    propertyPositionCase3 = 10;
                                    caseNumber = 2;
                                    propertyName = "Vermont Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase2]) {
                                            playerMoney[j] -= 50;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase2, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "connecticut avenue":
                                    propertyPositionCase1 = 7;
                                    propertyPositionCase2 = 9;
                                    propertyPositionCase3 = 10;
                                    caseNumber = 3;
                                    propertyName = "Connecticut Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase3]) {
                                            playerMoney[j] -= 50;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase3, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                default:
                                    System.out.print("Incorrect name entered!");
                            }
                        } else {
                            System.out.println("You need to own all properties of the same colour first to be able to build on them.");
                        }
                        if (stCharlesOwnership[j] != 0 && statesAveOwnership[j] != 0 && virginiaAveOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "st charles place":
                                    byte propertyPositionCase1 = 12;
                                    byte propertyPositionCase2 = 14;
                                    byte propertyPositionCase3 = 15;
                                    byte caseNumber = 1;
                                    String propertyName = "St. Charles Place";
                                    boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase1]) {
                                            playerMoney[j] -= 100;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase1, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "states avenue":
                                    propertyPositionCase1 = 12;
                                    propertyPositionCase2 = 14;
                                    propertyPositionCase3 = 15;
                                    caseNumber = 2;
                                    propertyName = "States Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase2]) {
                                            playerMoney[j] -= 100;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase2, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "virginia avenue":
                                    propertyPositionCase1 = 12;
                                    propertyPositionCase2 = 14;
                                    propertyPositionCase3 = 15;
                                    caseNumber = 3;
                                    propertyName = "Virginia Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase3]) {
                                            playerMoney[j] -= 100;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase3, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                default:
                                    System.out.print("Incorrect name entered!");
                            }
                        } else {
                            System.out.println("You need to own all properties of the same colour first to be able to build on them.");
                        }
                        if (stJamesAveOwnership[j] != 0 && tennesseeAveOwnership[j] != 0 && newYorkAveOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "st james place":
                                    byte propertyPositionCase1 = 17;
                                    byte propertyPositionCase2 = 19;
                                    byte propertyPositionCase3 = 20;
                                    byte caseNumber = 1;
                                    String propertyName = "St. James Place";
                                    boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase1]) {
                                            playerMoney[j] -= 100;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase1, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "tennessee avenue":
                                    propertyPositionCase1 = 17;
                                    propertyPositionCase2 = 19;
                                    propertyPositionCase3 = 20;
                                    caseNumber = 2;
                                    propertyName = "Tennessee Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase2]) {
                                            playerMoney[j] -= 100;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase2, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "new york avenue":
                                    propertyPositionCase1 = 17;
                                    propertyPositionCase2 = 19;
                                    propertyPositionCase3 = 20;
                                    caseNumber = 3;
                                    propertyName = "New York Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase3]) {
                                            playerMoney[j] -= 100;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase3, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                default:
                                    System.out.print("Incorrect name entered!");
                            }
                        } else {
                            System.out.println("You need to own all properties of the same colour first to be able to build on them.");
                        }
                        if (kentuckyAveOwnership[j] != 0 && indianaAveOwnership[j] != 0 && illinoisAveOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "kentucky avenue":
                                    byte propertyPositionCase1 = 22;
                                    byte propertyPositionCase2 = 24;
                                    byte propertyPositionCase3 = 25;
                                    byte caseNumber = 1;
                                    String propertyName = "Kentucky Avenue";
                                    boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase1]) {
                                            playerMoney[j] -= 150;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase1, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "indiana avenue":
                                    propertyPositionCase1 = 22;
                                    propertyPositionCase2 = 24;
                                    propertyPositionCase3 = 25;
                                    caseNumber = 2;
                                    propertyName = "Indiana Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase2]) {
                                            playerMoney[j] -= 150;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase2, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "illinois avenue":
                                    propertyPositionCase1 = 22;
                                    propertyPositionCase2 = 24;
                                    propertyPositionCase3 = 25;
                                    caseNumber = 3;
                                    propertyName = "Illinois Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase3]) {
                                            playerMoney[j] -= 150;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase3, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                default:
                                    System.out.print("Incorrect name entered!");
                            }
                        } else {
                            System.out.println("You need to own all properties of the same colour first to be able to build on them.");
                        }
                        if (atlanticAveOwnership[j] != 0 && ventnorAveOwnership[j] != 0 && marvinGardensOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "atlantic avenue":
                                    byte propertyPositionCase1 = 27;
                                    byte propertyPositionCase2 = 28;
                                    byte propertyPositionCase3 = 30;
                                    byte caseNumber = 1;
                                    String propertyName = "Atlantic Avenue";
                                    boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase1]) {
                                            playerMoney[j] -= 150;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase1, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "ventnor avenue":
                                    propertyPositionCase1 = 27;
                                    propertyPositionCase2 = 28;
                                    propertyPositionCase3 = 30;
                                    caseNumber = 2;
                                    propertyName = "Ventnor Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase2]) {
                                            playerMoney[j] -= 150;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase2, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "marvin gardens":
                                    propertyPositionCase1 = 22;
                                    propertyPositionCase2 = 24;
                                    propertyPositionCase3 = 25;
                                    caseNumber = 3;
                                    propertyName = "Marvin Gardens";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase3]) {
                                            playerMoney[j] -= 150;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase3, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                default:
                                    System.out.print("Incorrect name entered!");
                            }
                        } else {
                            System.out.println("You need to own all properties of the same colour first to be able to build on them.");
                        }
                        if (pacificAveOwnership[j] != 0 && northCarolinaAveOwnership[j] != 0 && pennsylvaniaAveOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "pacific avenue":
                                    byte propertyPositionCase1 = 32;
                                    byte propertyPositionCase2 = 33;
                                    byte propertyPositionCase3 = 35;
                                    byte caseNumber = 1;
                                    String propertyName = "Pacific Avenue";
                                    boolean ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase1]) {
                                            playerMoney[j] -= 200;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase1, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "north carolina avenue":
                                    propertyPositionCase1 = 32;
                                    propertyPositionCase2 = 33;
                                    propertyPositionCase3 = 35;
                                    caseNumber = 2;
                                    propertyName = "North Carolina Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase2]) {
                                            playerMoney[j] -= 200;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase2, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "pennsylvania avenue":
                                    propertyPositionCase1 = 32;
                                    propertyPositionCase2 = 33;
                                    propertyPositionCase3 = 35;
                                    caseNumber = 3;
                                    propertyName = "Pennsylvania Avenue";
                                    ifEligible = ifEligibleToBuild(propertyPositionCase1, propertyPositionCase2, propertyPositionCase3, propertyHouses, caseNumber);
                                    if (ifEligible) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase3]) {
                                            playerMoney[j] -= 200;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase3);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase3, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                default:
                                    System.out.print("Incorrect name entered!");
                            }
                        } else {
                            System.out.println("You need to own all properties of the same colour first to be able to build on them.");
                        }
                        if (parkPlaceOwnership[j] != 0 && boardWalkOwnership[j] != 0) {
                            switch (buildOnWhichProperty) {
                                case "park place":
                                    byte propertyPositionCase1 = 2;
                                    String propertyName = "Park place";
                                    if ((!propertyHouses[38][0] && propertyHouses[40][0]) ||
                                            (!propertyHouses[38][1] && propertyHouses[40][1]) ||
                                            (!propertyHouses[38][2] && propertyHouses[40][2]) ||
                                            (!propertyHouses[38][3] && propertyHouses[40][3])) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase1]) {
                                            playerMoney[j] -= 200;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase1);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase1, hotelOwnership, propertyHouses);
                                    }
                                    break;
                                case "boardwalk":
                                    byte propertyPositionCase2 = 4;
                                    propertyName = "Boardwalk";
                                    if ((propertyHouses[38][0] && !propertyHouses[40][0]) ||
                                            (propertyHouses[38][1] && !propertyHouses[40][1]) ||
                                            (propertyHouses[38][2] && !propertyHouses[40][2]) ||
                                            (propertyHouses[38][3] && !propertyHouses[40][3])) {
                                        System.out.println("You need to spread your buildings across other properties of the same colour first!");
                                    } else {
                                        if (!hotelOwnership[propertyPositionCase2]) {
                                            playerMoney[j] -= 200;
                                        }
                                        hotelOwnership = hotelCreator(propertyHouses, hotelOwnership, propertyPositionCase2);
                                        propertyHouses = housesCreator(propertyName, propertyPositionCase2, hotelOwnership, propertyHouses);
                                    }
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
                            int ownerPosition = positionChecker(mediterraneanAveOwnership, playerCount);  //retrieves the position to properly deduct money after an auction
                            if (!ifAlreadyPaid[2]) {          //prevents the player from paying again when on the same position again
                                playerMoney[ownerPosition] -= mediterraneanAveOwnership[ownerPosition];
                                ifAlreadyPaid[2] = true;
                            }

                            if ((mediterraneanAveOwnership[ownerPosition] != 0 && balticAveOwnership[ownerPosition] != 0 && orientalAveOwnership[ownerPosition] != 0) && !propertyHouses[propertyPosition][0]) {
                                rentPrice *= 2;
                            }
                            int house1Rent = 10;
                            int house2Rent = 30;
                            int house3Rent = 90;
                            int house4Rent = 160;
                            int hotelRent = 250;

                            rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);

                            if (mediterraneanAveOwnership[j] == 0 && ifAlreadyPaid[2]) {
                                System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                playerMoney[j] -= rentPrice;
                                playerMoney[ownerPosition] += rentPrice;

                            }
                            break;
                        case 4:
                            propertyPrice = 60;
                            propertyPosition = 4;
                            rentPrice = 4;
                            propertyName = "Baltic Avenue";
                            balticAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, balticAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(balticAveOwnership, playerCount);
                            if (!ifAlreadyPaid[4]) {
                                playerMoney[ownerPosition] -= balticAveOwnership[ownerPosition];
                                ifAlreadyPaid[4] = true;
                            }
                            if ((mediterraneanAveOwnership[ownerPosition] != 0 && balticAveOwnership[ownerPosition] != 0 && orientalAveOwnership[ownerPosition] != 0) && !propertyHouses[propertyPosition][0]) {
                                rentPrice *= 2;
                            }
                            house1Rent = 20;
                            house2Rent = 60;
                            house3Rent = 180;
                            house4Rent = 320;
                            hotelRent = 450;
                            rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                            if (balticAveOwnership[j] == 0 && ifAlreadyPaid[4]) {
                                System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                playerMoney[j] -= rentPrice;
                                playerMoney[ownerPosition] += rentPrice;
                            }
                            break;
                        case 7:
                            propertyPrice = 100;
                            propertyPosition = 7;
                            rentPrice = 6;
                            propertyName = "Oriental Avenue";
                            orientalAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, orientalAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(orientalAveOwnership, playerCount);
                            if (!ifAlreadyPaid[7]) {
                                playerMoney[ownerPosition] -= orientalAveOwnership[ownerPosition];
                                ifAlreadyPaid[7] = true;
                            }
                            if ((mediterraneanAveOwnership[ownerPosition] != 0 && balticAveOwnership[ownerPosition] != 0 && orientalAveOwnership[ownerPosition] != 0) && !propertyHouses[propertyPosition][0]) {
                                rentPrice *= 2;
                            }
                            house1Rent = 30;
                            house2Rent = 90;
                            house3Rent = 270;
                            house4Rent = 400;
                            hotelRent = 550;
                            rentPrice = housesOwnedChecker(hotelOwnership, hotelRent, house1Rent, house2Rent, house3Rent, house4Rent, propertyHouses, rentPrice, propertyPosition);
                            if (orientalAveOwnership[j] == 0 && ifAlreadyPaid[7]) {
                                System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                playerMoney[j] -= rentPrice;
                                playerMoney[ownerPosition] += rentPrice;
                            }
                            break;
/*
                        case 9:
                            propertyPrice = 100;
                            propertyPosition = 9;
                            rentPrice = 2;
                            propertyName = "Vermont Avenue";
                            vermontAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, vermontAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(vermontAveOwnership, playerCount);
                            if (!ifAlreadyPaid[9]) {
                                playerMoney[ownerPosition] -= vermontAveOwnership[ownerPosition];
                                ifAlreadyPaid[9] = true;
                            }
                            if(mediterraneanAveOwnership[j] != 0 && balticAveOwnership[j] != 0 && orientalAveOwnership[j] !=0){
                                rentPrice *= 2;
                            }
                            if (mediterraneanAveOwnership[j] == 0 && ifAlreadyPaid[2] ) {
                                System.out.println("You are on another players property! You now have to pay $" + rentPrice + " rent to " + playerNames[ownerPosition]);
                                playerMoney[j] -= 2;
                            }
                            break;

                        case 10:
                            propertyPrice = 120;
                            propertyPosition = 10;
                            propertyName = "Connecticut Avenue";
                            connecticutAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, connecticutAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(connecticutAveOwnership, playerCount);
                            if (!ifAlreadyPaid[10]) {
                                playerMoney[ownerPosition] -= connecticutAveOwnership[ownerPosition];
                                ifAlreadyPaid[10] = true;
                            }
                            break;
                        case 12:
                            propertyPrice = 140;
                            propertyPosition = 12;
                            propertyName = "St. Charles Place";
                            stCharlesOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, stCharlesOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(stCharlesOwnership, playerCount);
                            if (!ifAlreadyPaid[12]) {
                                playerMoney[ownerPosition] -= stCharlesOwnership[ownerPosition];
                                ifAlreadyPaid[12] = true;
                            }
                            break;
                        case 14:
                            propertyPrice = 140;
                            propertyPosition = 14;
                            propertyName = "States avenue";
                            statesAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, statesAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(statesAveOwnership, playerCount);
                            if (!ifAlreadyPaid[14]) {
                                playerMoney[ownerPosition] -= statesAveOwnership[ownerPosition];
                                ifAlreadyPaid[14] = true;
                            }
                            break;
                        case 15:
                            propertyPrice = 160;
                            propertyPosition = 14;
                            propertyName = "Virginia Avenue";
                            virginiaAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, virginiaAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(virginiaAveOwnership, playerCount);
                            if (!ifAlreadyPaid[15]) {
                                playerMoney[ownerPosition] -= virginiaAveOwnership[ownerPosition];
                                ifAlreadyPaid[15] = true;
                            }
                            break;
                        case 17:
                            propertyPrice = 180;
                            propertyPosition = 17;
                            propertyName = "St. James Place";
                            stJamesAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, stJamesAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(stJamesAveOwnership, playerCount);
                            if (!ifAlreadyPaid[17]) {
                                playerMoney[ownerPosition] -= stJamesAveOwnership[ownerPosition];
                                ifAlreadyPaid[17] = true;
                            }
                            break;
                        case 19:
                            propertyPrice = 180;
                            propertyPosition = 19;
                            propertyName = "Tennessee Avenue";
                            tennesseeAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, tennesseeAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(tennesseeAveOwnership, playerCount);
                            if (!ifAlreadyPaid[19]) {
                                playerMoney[ownerPosition] -= tennesseeAveOwnership[ownerPosition];
                                ifAlreadyPaid[19] = true;
                            }
                            break;
                        case 20:
                            propertyPrice = 200;
                            propertyPosition = 20;
                            propertyName = "New York Avenue";
                            newYorkAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, newYorkAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(newYorkAveOwnership, playerCount);
                            if (!ifAlreadyPaid[20]) {
                                playerMoney[ownerPosition] -= newYorkAveOwnership[ownerPosition];
                                ifAlreadyPaid[20] = true;
                            }
                            break;
                        case 22:
                            propertyPrice = 220;
                            propertyPosition = 22;
                            propertyName = "Kentucky Avenue";
                            kentuckyAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, kentuckyAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(kentuckyAveOwnership, playerCount);
                            if (!ifAlreadyPaid[22]) {
                                playerMoney[ownerPosition] -= kentuckyAveOwnership[ownerPosition];
                                ifAlreadyPaid[22] = true;
                            }
                            break;
                        case 24:
                            propertyPrice = 220;
                            propertyPosition = 24;
                            propertyName = "Indiana Avenue";
                            indianaAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, indianaAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(indianaAveOwnership, playerCount);
                            if (!ifAlreadyPaid[24]) {
                                playerMoney[ownerPosition] -= indianaAveOwnership[ownerPosition];
                                ifAlreadyPaid[24] = true;
                            }
                            break;
                        case 25:
                            propertyPrice = 240;
                            propertyPosition = 25;
                            propertyName = "Illinois Avenue";
                            illinoisAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, illinoisAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(illinoisAveOwnership, playerCount);
                            if (!ifAlreadyPaid[25]) {
                                playerMoney[ownerPosition] -= illinoisAveOwnership[ownerPosition];
                                ifAlreadyPaid[25] = true;
                            }
                            break;
                        case 27:
                            propertyPrice = 260;
                            propertyPosition = 27;
                            propertyName = "Atlantic Avenue";
                            atlanticAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, atlanticAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(atlanticAveOwnership, playerCount);
                            if (!ifAlreadyPaid[27]) {
                                playerMoney[ownerPosition] -= atlanticAveOwnership[ownerPosition];
                                ifAlreadyPaid[27] = true;
                            }
                            break;
                        case 28:
                            propertyPrice = 260;
                            propertyPosition = 28;
                            propertyName = "Ventnor Avenue";
                            ventnorAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, ventnorAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(ventnorAveOwnership, playerCount);
                            if (!ifAlreadyPaid[28]) {
                                playerMoney[ownerPosition] -= ventnorAveOwnership[ownerPosition];
                                ifAlreadyPaid[28] = true;
                            }
                            break;
                        case 30:
                            propertyPrice = 280;
                            propertyPosition = 30;
                            propertyName = "Marvin Gardens";
                            marvinGardensOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, marvinGardensOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(marvinGardensOwnership, playerCount);
                            if (!ifAlreadyPaid[30]) {
                                playerMoney[ownerPosition] -= marvinGardensOwnership[ownerPosition];
                                ifAlreadyPaid[30] = true;
                            }
                            break;
                        case 32:
                            propertyPrice = 300;
                            propertyPosition = 32;
                            propertyName = "Pacific Avenue";
                            pacificAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, pacificAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(pacificAveOwnership, playerCount);
                            if (!ifAlreadyPaid[32]) {
                                playerMoney[ownerPosition] -= pacificAveOwnership[ownerPosition];
                                ifAlreadyPaid[32] = true;
                            }
                            break;
                        case 33:
                            propertyPrice = 300;
                            propertyPosition = 33;
                            propertyName = "North Carolina Avenue";
                            northCarolinaAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, northCarolinaAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(northCarolinaAveOwnership, playerCount);
                            if (!ifAlreadyPaid[33]) {
                                playerMoney[ownerPosition] -= northCarolinaAveOwnership[ownerPosition];
                                ifAlreadyPaid[33] = true;
                            }
                            break;
                        case 35:
                            propertyPrice = 320;
                            propertyPosition = 35;
                            propertyName = "Pennsylvania  Avenue";
                            pennsylvaniaAveOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, pennsylvaniaAveOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(pennsylvaniaAveOwnership, playerCount);
                            if (!ifAlreadyPaid[33]) {
                                playerMoney[ownerPosition] -= pennsylvaniaAveOwnership[ownerPosition];
                                ifAlreadyPaid[33] = true;
                            }
                            break;
                        case 38:
                            propertyPrice = 350;
                            propertyPosition = 38;
                            propertyName = "Park Place";
                            parkPlaceOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, parkPlaceOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(parkPlaceOwnership, playerCount);
                            if (!ifAlreadyPaid[38]) {
                                playerMoney[ownerPosition] -= parkPlaceOwnership[ownerPosition];
                                ifAlreadyPaid[38] = true;
                            }
                            break;
                        case 40:
                            propertyPrice = 400;
                            propertyPosition = 40;
                            propertyName = "Boardwalk";
                            boardWalkOwnership[j] = propertyOwnership(propertyPosition, propertyName, propertyPrice, j, boardWalkOwnership, playerPosition, playerCount, playerNames)[j];
                            ownerPosition = positionChecker(boardWalkOwnership, playerCount);
                            if (!ifAlreadyPaid[40]) {
                                playerMoney[ownerPosition] -= boardWalkOwnership[ownerPosition];
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

    public static boolean[][] housesCreator(String propertyName, byte propertyPosition, boolean[] hotelOwnership, boolean[][] propertyHouses) {
        byte numberOfHouses = 0;
        for (int k = 0; k < 4; k++) {
            if (propertyHouses[propertyPosition][numberOfHouses] && numberOfHouses < 4) {
                numberOfHouses++;
            }
        }
        if (numberOfHouses < 4) {
            propertyHouses[propertyPosition][numberOfHouses] = true;
            System.out.println("You have build a house! Number of houses on " + propertyName + ": " + (numberOfHouses + 1));
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
        boolean ifEligible = false;
        switch (caseNumber) {
            case 1:
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
}
