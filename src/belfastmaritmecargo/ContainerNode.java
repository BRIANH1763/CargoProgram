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
public class ContainerNode {
//Variables declared for ContainerNode

    private String cargoID;
    private String owner;
    private String cargoType;
    private double cargoValue;
    private double cargoWeight;
    private int containerHeight;
    private ContainerNode previous;
    private int nodeCount;

    /**
     * Method used to provide read access to the private variable cargoID
     *
     * @return cargoID
     */
    public String getCargoID() {
        return cargoID;
    }//getCargoID

    /**
     * Method used to provide write access to the private variable cargoID
     *
     * @param cargoID parameter String cargoID
     */
    public void setCargoID(String cargoID) {
        this.cargoID = cargoID;
    }//setCargoID

    /**
     *Method used to provide read access to the private variable owner
     *
     * @return owner
     */
    public String getOwner() {
        return owner;
    }//getOwner

    /**
     * Method used to provide write access to the private variable owner
     *
     * @param owner parameter String owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }//setOwner

    /**
     * Method used to provide read access to the private variable cargoType
     *
     * @return cargoType
     */
    public String getCargoType() {
        return cargoType;
    }//getCargoType

    /**
     * Method used to provide write access to the private variable cargoType
     *
     * @param cargoType parameter String cargoType
     */
    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }//setCargoType

    /**
     * Method used to provide read access to the private variable cargoValue
     *
     * @return cargoValue
     */
    public double getCargoValue() {
        return cargoValue;
    }//getCargoValue

    /**
     * Method used to provide write access to the private variable cargoValue
     *
     * @param cargoValue parameter double cargoValue
     */
    public void setCargoValue(double cargoValue) {
        this.cargoValue = cargoValue;
    }//setCargoValue

    /**
     * Method used to provide read access to the private variable cargoWeight
     *
     * @return cargoWeight
     */
    public double getCargoWeight() {
        return cargoWeight;
    }//getCargoWeight

    /**
     * Method used to provide write access to the private variable cargoWeight
     *
     * @param cargoWeight parameter double cargoWeight
     */
    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }//setVargoWeight

    /**
     * Method used to provide read access to the private variable containerHeight
     *
     * @return containerHeight
     */
    public int getContainerHeight() {
        return containerHeight;
    }//getContainerHeight

    /**
     * Method used to provide write access to the private variable containerHeight
     *
     * @param containerHeight parameter in containerHeight
     */
    public void setContainerHeight(int containerHeight) {
        this.containerHeight = containerHeight;
    }//setContainerHeight

    /**
     * Method used to provide read access to the private variable previous
     *
     * @return previous
     */
    public ContainerNode getPrevious() {
        return previous;
    }//getPrevious

    /**
     * Method used to provide write access to the private variable previous
     *
     * @param previous parameter ContainerNode previous
     */
    public void setPrevious(ContainerNode previous) {
        this.previous = previous;
    }//setPrevious

    /**
     * Initialises instance of ContainerNode
     *
     * @param owner parameter String owner
     * @param cargoType parameter String cargoType
     * @param cargoValue parameter double cargoValue
     * @param cargoWeight parameter double cargoWeight
     * @param containerHeight parameter int containerHeight
     */
    public ContainerNode(String owner, String cargoType, double cargoValue, double cargoWeight, int containerHeight) {

        this.cargoID = owner.charAt(0) + "" + cargoType.charAt(0) + "" + "000" + nodeCount++;
        this.owner = owner;
        this.cargoType = cargoType;
        this.cargoValue = cargoValue;
        this.cargoWeight = cargoWeight;
        this.containerHeight = containerHeight;

    }//ContainerNode method

}//ContainerNode class
