/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salespersonsApplication;

/**
 *
 * @author Jean Joel
 */
public class Salesperson {

    //declaration
    private int ID;
    private String firstName;
    private String lastName;
    private String telephone;
    private double salesAmount;

    public Salesperson(int ID, String firstName, String lastName, String telephone, double salesAmount) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.salesAmount = salesAmount;

    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    
}
