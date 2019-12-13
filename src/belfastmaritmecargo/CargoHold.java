/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belfastmaritmecargo;

import java.text.DecimalFormat;

/**
 *
 * @author b-hou
 */
public class CargoHold {
    //declaring varibales for CargoHold

    private ContainerNode top;
    private int count;

    //default class constructor for CargoHold to intitalise CargoHold varibales 

    /**
     *
     */
    public CargoHold() {
        top = null;
        count = 0;
    }//Constructor

    /**
     * isEmpty method to check if the contents of the stack is empty
     *
     * @return no nodes in queue
     */
    private boolean isEmpty() {
        return (top == null);
    }//isEmpty method

    /**
     * Push method to create a new instance of ContainerNode
     *
     * @param newContainer object name
     */
    public void push(ContainerNode newContainer) {
        if (newContainer != null) {
            newContainer.setPrevious(top);
            top = newContainer;
        }//if
        count++;
    }//push method

    /**
     * Method to return the contents of a container
     *
     * @return sb.toString()
     */
    public String List() {
        if (isEmpty()) {
            return "ERROR MESSAGE: No nodes have been entered in queue";
        }//if
        StringBuilder sb = new StringBuilder();
        sb.append("Contents of Container: ").append(count);
        ContainerNode current = top;
        while (current != null) {
            sb.append("\nCargo ID").append("\t").append("Owner").append("\t\t").append("Type").append("\t\t").append("Value").append("\t\t").append("Weight").append("\t\t").append("Height\n");
            sb.append(current.getCargoID()).append("\t\t").append(current.getOwner()).append("\t\t").append(current.getCargoType()).append("\t\t").append(current.getCargoValue()).append("k").append("\t\t").append(current.getCargoWeight()).append("\t\t");

            if (current.getContainerHeight() == 3) {
                sb.append("Standard");
            }//if
            else if (current.getContainerHeight() == 4) {
                sb.append("Large");
            }//else if
            sb.append("\t\n");
            current = current.getPrevious();
        }//while
        return sb.toString();
    }//List method

    /**
     * Method to remove an node from the top of the stack
     *
     * @return remove
     */
    public ContainerNode pop() {
        if (isEmpty()) {
            return null;
        }//if
        count--;
        top = top.getPrevious();
        ContainerNode remove = top;

        return remove;
    }//pop method

    /**
     * Method to peek at the node thats at the top of the stack
     *
     * @return
     */
    public ContainerNode peek() {
        return top;
    }//peek method

    /**
     * Method that allows the user to search for a specific cargoID within the
     * stack that matches their search
     *
     * @param ID
     * @return
     */
    public String containsID(String ID) {
        if (isEmpty()) {
            return "No items found";
        }//if
        ContainerNode current = top;

        while (current != null) {
            if (current.getCargoID().compareToIgnoreCase(ID) == 0) {

                return "Searching for Container with ID: " + ID + "\n\n"
                        + "CargoID\t\t" + "Cargo Owner\t" + "Type\t\t" + "Value\t\t" + "Weight\t\t" + "Height\n"
                        + current.getCargoID() + "\t\t" + current.getOwner() + "\t\t" + current.getCargoType() + "\t\t" + current.getCargoValue() + "\t\t" + current.getCargoWeight() + "\t\t" + current.getContainerHeight();
            }//if
            current = current.getPrevious();
        }//while

        return "No matching ID's found with the ID " + ID;

    }//containsID method

    /**
     * Method that method allows the user to search for a specific Owner within
     * the stack that matches their search
     *
     * @param Owner
     * @return
     */
    public String containsOwner(String Owner) {
        if (isEmpty()) {
            return "No items found";
        }//if

        ContainerNode current = top;

        while (current != null) {
            if (current.getOwner().compareToIgnoreCase(Owner) == 0) {
                return "Searching for Container with Owner name: " + Owner + "\n\n"
                        + "CargoID\t\t" + "Cargo Owner\t" + "Type\t\t" + "Value\t\t" + "Weight\t\t" + "Height\n"
                        + current.getCargoID() + "\t\t" + current.getOwner() + "\t\t" + current.getCargoType() + "\t\t" + current.getCargoValue() + "\t\t" + current.getCargoWeight() + "\t\t" + current.getContainerHeight();
            }//if
            current = current.getPrevious();
        }//while

        return "No matching owners found with the name " + Owner;
    }//containsOwner method

    /**
     * Method that allows the user to search for a specific cargo type within
     * the stack that matches their search
     *
     * @param Type
     * @return
     */
    public String containsType(String Type) {
        if (isEmpty()) {
            return "No items found";
        }//if
        ContainerNode current = top;

        while (current != null) {
            if (current.getCargoType().compareToIgnoreCase(Type) == 0) {
                return "Searching for Container with cargo type: " + Type + "\n\n"
                        + "CargoID\t\t" + "Cargo Owner\t" + "Type\t\t" + "Value\t\t" + "Weight\t\t" + "Height\n"
                        + current.getCargoID() + "\t\t" + current.getOwner() + "\t\t" + current.getCargoType() + "\t\t" + current.getCargoValue() + "\t\t" + current.getCargoWeight() + "\t\t" + current.getContainerHeight();
            }//if
            current = current.getPrevious();

        }//while

        return "No matching items found with your search " + Type;
    }//containsType method

    /**
     * Method to calculate the total weight of the contents loaded into the
     * stack
     *
     * @return Type
     */
    public String totalWeight() {
        DecimalFormat df = new DecimalFormat("###.##");

        if (isEmpty()) {
            return "No items found";
        }//if
        ContainerNode current = top;
        double totalWeight = 0;
        while (current != null) {
            totalWeight = totalWeight + current.getCargoWeight();
            current = current.getPrevious();
        }//while
        return "Total Weight of containers in hold: " + df.format(totalWeight) + " tonne(s)";

    }//totalWeight method

    /**
     * method calculates the total Height of the contents loaded into the stack.
     *
     * @return totalHeight
     */
    public String totalHeight() {
        if (isEmpty()) {
            return "No items found";
        }//if
        ContainerNode current = top;
        int totalHeight = 0;
        while (current != null) {
            totalHeight = totalHeight + current.getContainerHeight();
            current = current.getPrevious();
        }//while
        return "Total Height of containers in hold: " + totalHeight + " meter(s)";

    }//totalWeight method

    /**
     * methods calculates the total value of the contents loaded into the stack
     *
     * @return totalValue
     */
    public String totalValue() {
        DecimalFormat df = new DecimalFormat("###.##");
        if (isEmpty()) {
            return "No items found";
        }//if
        ContainerNode current = top;
        double totalValue = 0;
        while (current != null) {
            totalValue = totalValue + current.getCargoValue();
            current = current.getPrevious();
        }//while
        return "Total value of containers in hold: " + df.format(totalValue) + "k";
    }//totalValue method

}//CargoHold class
