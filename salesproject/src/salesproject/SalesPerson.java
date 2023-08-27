/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesproject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Justin Schroeder
 */
public class SalesPerson {

    private String name;
    private String title;
    private ArrayList<Double> sales;
    
    public SalesPerson() {
        this.name = "unkonwn";
        this.title = "unknown";
        this.sales = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
        public String getName(){
        return this.name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setSales(ArrayList<Double> sales) {
        for (int i = 0; i < sales.size(); i++) {
            this.sales.add(sales.get(i));
        }
    }

    public ArrayList<Double> getSales() {
        return this.sales;
    }

    Iterator<Double> iterSales() {
        return sales.iterator();
    }
}
