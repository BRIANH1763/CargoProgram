/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belfastmaritmecargo;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author b-hou
 */
public class CargoShip {

    public void Display() {
        Scanner input = new Scanner(System.in);
        int maxHeight;
        double maxWeight;
        ContainerNode newContainer = null;
        boolean newContainerLoaded = true;
        double OverallWeight = 0;
        double OverallHeight = 0;
        double portsideWeight = 0;
        double starboardsideWeight = 0;
        double cargoWeight = 0;
        int containerHeight = 0;
        CargoHold port = new CargoHold();
        CargoHold starboard = new CargoHold();
        ContainerNode cargoID = null;

        System.out.println("1)  Create a new container with description");
        System.out.println("2)	Load a container to the cargo hold");
        System.out.println("3)	Remove a container from the cargo hold");
        System.out.println("4)	Search for a container by ID");
        System.out.println("5)	Search for a container by owner");
        System.out.println("6)	Search for a container by cargo type");
        System.out.println("7)	Display details of a container");
        System.out.println("8)	Display total weight of containers in the hold");
        System.out.println("9)	Display total height of containers in the hold");
        System.out.println("10)	Display total value of containers in the hold");
        System.out.println("11)	Display ship restrictions: maximum height and maximum weight\n\n");

        //Scanner input = new Scanner(System.in);
        System.out.println("Enter maximum height: ");
        maxHeight = input.nextInt();
        System.out.println("The maximum height of the ship has been set to " + maxHeight + " meters");
        System.out.println("\nEnter maximum weight: ");
        maxWeight = input.nextInt();
        System.out.println("The maximum weight of the ship has been set to " + maxWeight + " tonnes");
        System.out.println("\n");

        boolean quit = false;
        int menuItem;
        do {
            double PercentOfLoad;
            DecimalFormat df = new DecimalFormat("###.##");
            System.out.println("Select an option: ");
            menuItem = input.nextInt();
            switch (menuItem) {
                case 1:

                    System.out.println("Owner");
                    String owner = input.next();
                    System.out.println("Cargo Type");
                    String cargoType = input.next();
                    System.out.println("Cargo Value");
                    double cargoValue = input.nextDouble();
                    System.out.println("Cargo Weight");
                    cargoWeight = input.nextDouble();
                    System.out.println("Container Height");
                    containerHeight = input.nextInt();
                    ContainerNode Container = new ContainerNode(owner, cargoType, cargoValue, cargoWeight, containerHeight);
                    newContainer = Container;
                    break;
                case 2:
                    Scanner input2 = new Scanner(System.in);
                    if (newContainer == null) {
                        System.out.print("Please create a container entry before attempting to load\n");
                        break;
                    }

                    System.out.print("Load onto Port side select 1 and to load onto Starboard select 2: ");
                    int option = input2.nextInt();
                    if (option == 1) {
                        if (containerHeight > maxHeight || cargoWeight > maxWeight) {
                            System.out.println("WARNING: CONTAINER EXCEEDS RESTRICTIONS");
                        } else if (OverallHeight <= maxHeight || OverallWeight <= maxWeight) {
                            port.push(newContainer);
                            System.out.println("The container has been successfuly loaded to port side");
                            OverallHeight = OverallHeight + containerHeight;
                            OverallWeight = OverallWeight + cargoWeight;
                            portsideWeight = portsideWeight + cargoWeight;

                            newContainerLoaded = true;
                            PercentOfLoad = portsideWeight / OverallWeight * 100;
                            if (PercentOfLoad >= 55) {
                                System.out.println("WARNING: LOAD IN THE HOLD IS NOT EVEN");
                            } else {
                                System.out.println("Total port weight: " + portsideWeight + "tonne(s)");
                                System.out.println("Total starboard weight: " + starboardsideWeight + "tonne(s)");
                                System.out.println("Total weight of containers: " + OverallWeight + "tonne(s)");
                                System.out.println("Percentage of the load: " + df.format(PercentOfLoad) + "%");
                            }
                        }
                        break;
                    } else if (option == 2) {
                        if (OverallHeight > maxHeight || OverallWeight > maxWeight) {
                            System.out.println("WARNING: CONTAINER EXCEEDS RESTRICTIONS");
                        } else if (containerHeight <= maxHeight || cargoWeight <= maxWeight) {
                            starboard.push(newContainer);
                            System.out.println("The container has been successfully loaded to starboard");
                            OverallWeight = OverallWeight + cargoWeight;
                            OverallHeight = OverallHeight + containerHeight;
                            starboardsideWeight = starboardsideWeight + cargoWeight;
                            newContainerLoaded = true;
                            PercentOfLoad = starboardsideWeight / OverallWeight * 100;
                            if (PercentOfLoad >= 55) {
                                System.out.println("WARNING: LOAD IN THE HOLD IS NOT EVEN");
                            } else {
                                System.out.println("Total port weight: " + portsideWeight + "tonne(s)");
                                System.out.println("Total starboard weight: " + starboardsideWeight + "tonne(s)");
                                System.out.println("Total Weight of containers: " + OverallWeight + "tonne(s)");
                                System.out.println("Percentage of the load: " + df.format(PercentOfLoad) + "%");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Please enter valid option");
                        break;
                    }

                case 3:
                    System.out.println("Remove a container from the cargo hold");
                    System.out.print("To remove container in port side select 1:\n "
                            + "To remove container in starboard side select 2:\n ");
                    Scanner input3 = new Scanner(System.in);
                    int optionForPop = input3.nextInt();

                    if (optionForPop == 1) {
                        port.pop();
                        System.out.println("Container removed from port side");
                        break;
                    } else if (optionForPop == 2) {
                        starboard.pop();
                        System.out.println("Container removed from starboard side");

                        break;
                    } else {
                        System.out.println("Please enter valid option");
                        break;
                    }

                case 4:
                    System.out.println("Search for container by ID");
                    System.out.print("To search for a container matching the search in the port side select 1\n"
                            + "To search for a container matching the search in the starboard side select 2:\n ");
                    Scanner input4 = new Scanner(System.in);
                    int optionForSID = input4.nextInt();

                    if (optionForSID == 1) {
                        String ID = input4.next();
                        System.out.println(port.containsID(ID));
                    } else if (optionForSID == 2) {
                        String ID = input4.next();
                        System.out.println(starboard.containsID(ID));
                    }
                    break;
                case 5:
                    System.out.println("Search for a container by owner");
                    System.out.print("To search for a container matching the search in the port side select 1\n"
                            + "To search for a container matching the search in the starboard side select 2:\n ");
                    Scanner input5 = new Scanner(System.in);
                    int optionForSO = input5.nextInt();

                    if (optionForSO == 1) {
                        String Owner = input5.next();
                        System.out.println("\n" + port.containsOwner(Owner));
                    } else if (optionForSO == 2) {
                        String Owner = input5.next();
                        System.out.println("\n" + starboard.containsOwner(Owner));
                    }
                    break;
                case 6:
                    System.out.println("Search for a container by cargo type");
                    System.out.print("To search for a container matching the search in the port side select 1\n"
                            + "To search for a container matching the search in the starboard side select 2:\n ");
                    Scanner input6 = new Scanner(System.in);
                    int optionForST = input6.nextInt();

                    if (optionForST == 1) {
                        String Type = input6.next();
                        System.out.println("\n" + port.containsType(Type));
                    } else if (optionForST == 2) {
                        String Type = input6.next();
                        System.out.println("\n" + starboard.containsType(Type));
                    }

                    break;
                case 7:
                    System.out.println("Display details of a container");
                    System.out.print("To display the details of containers in port side select 1:\nTo display "
                            + "the details of containers in starboard side select 2:\n ");
                    Scanner input9 = new Scanner(System.in);
                    int optionForDetails = input9.nextInt();

                    if (optionForDetails == 1) {
                        System.out.println("\n" + port.List());
                    } else if (optionForDetails == 2) {
                        System.out.println("\n" + starboard.List());
                    }

                    break;
                case 8:
                    System.out.println("Display total weight of containers in the hold");
                    System.out.print("To display the total weight of containers in port side select 1:\nTo display "
                            + "the total weight of containers in starboard side select 2:\n ");
                    Scanner input10 = new Scanner(System.in);
                    int optionForCargoWeight = input10.nextInt();

                    if (optionForCargoWeight == 1) {
                        System.out.println("\n" + port.totalWeight());
                    } else if (optionForCargoWeight == 2) {
                        System.out.println("\n" + starboard.totalWeight());
                    }

                    break;
                case 9:
                    System.out.println("Display total height of containers in the hold");
                    System.out.print("To display the total height of containers in port side select 1:\nTo display "
                            + "the total height of containers in starboard side select 2:\n ");
                    Scanner input11 = new Scanner(System.in);
                    int optionForHeight = input11.nextInt();
                    if (optionForHeight == 1) {
                        System.out.println("\n" + port.totalHeight());

                    } else if (optionForHeight == 2) {
                        System.out.println("\n" + starboard.totalHeight());

                    }

                    break;
                case 10:
                    System.out.println("Display total value of containers in the hold\n");
                    System.out.print("To display the total value of containers in port side select 1:\n To display "
                            + "the total value of containers in starboard side select 2:\n ");
                    Scanner input12 = new Scanner(System.in);
                    int optionForValue = input12.nextInt();

                    if (optionForValue == 1) {
                        System.out.println("\n" + port.totalValue());
                    } else if (optionForValue == 2) {
                        System.out.println("\n" + starboard.totalValue());
                    }

                    break;
                case 11:
                    System.out.println("Display ship restrictions: maximum height and maximum weight  ");

                    System.out.println("\nThe maximum height of the ship has been set to " + maxHeight + " meters.");
                    System.out.println("The maximum weight of the ship has been set to " + maxWeight + " tonnes.");

                    break;
                case 0:
                    quit = true;
                    System.out.println("You have selected to exit the menu");
                    break;
                default:
                    System.out.println("Invalid choice selected.");
            }

        } while (!quit);

    }

}
