/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belfastmaritmecargo;

/**
 *
 * @author b-hou
 */
public class BelfastMaritImeCargo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Test case 1");
        //Creating new container called pn1
        ContainerNode pn1 = new ContainerNode("Brian", "Car", 7.0, 4.9, 3);
        //Creating new container called pn2
        ContainerNode pn2 = new ContainerNode("Morgen", "Books", 7.3, 2.4, 4);
        //Creating new cargo hold stack called stack
        CargoHold stack = new CargoHold();
        //pushing pn1 into the stack
        stack.push(pn1);
        //pushing pn2 into the stack 
        stack.push(pn2);
        //Displaying the list with the contents of the two containers
        System.out.println(stack.List());

        System.out.println("******************Removing from the stack****************************\n");

        System.out.println("Removing Container (Uncomment code) ");
        //Removing the node from the top of the stack
        stack.pop();
        //displaying the list to show that the container has been removed
        System.out.println(stack.List());
        System.out.println("");
        System.out.println("\n******************Valid Searches********************");
        //Searching for a container that has an ID of BC0000
        System.out.println(stack.containsID("BC0000"));
        //Searching for a container that has an owner name of Morgen
        System.out.println(stack.containsOwner("Morgen"));
        //Searching for a container that has a cargo type of Books
        System.out.println(stack.containsType("Books"));
        System.out.println("\n****************Totals **********************\n");
        
        //displaying the total weight of the containers in the stack 
        System.out.println(stack.totalWeight());
        System.out.println("");
        //displaying the total height of the containers in the stack
        System.out.println(stack.totalHeight());
        System.out.println("");
        //dsiplaying the total value of the container in the stack
        System.out.println(stack.totalValue());

        System.out.println("\n**************Invalid searches*************\n");
        //Searching for an invalid ID
        System.out.println(stack.containsID("ABFSDO"));
        System.out.println("");
        //Searching for an invalid Owner name
        System.out.println(stack.containsOwner("Aurthur"));
        System.out.println("");
        //Searching for an invalid cargo Type
        System.out.println(stack.containsType("Toliets"));

    }//Main

}//Class
