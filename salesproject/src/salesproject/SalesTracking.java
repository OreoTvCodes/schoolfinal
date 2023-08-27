/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesproject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Justin Schroeder
 */
public class SalesTracking {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Create temp array
        ArrayList<Double> sales = new ArrayList<>();

        // Create array for sales staff
        ArrayList<SalesPerson> salesPeople = new ArrayList<>();

        String name;
        String title;
        int people = 0;
        int count = 0;
        Double sale;

        // Input for sales staff
        do {
            System.out.print("How many sales people do you need to enter in: ");

            // Check value for int
            if (sc.hasNextInt()) {
                people = sc.nextInt();

                if (people <= 0) {
                    System.out.println("Please enter in a positive integer!");
                    System.out.println();
                    sc.nextLine();
                    continue;
                } else if (people > 10) {
                    System.out.println("You can only enter "
                            + "in up to 10 sales at a time!");
                    System.out.println();
                    people = 0;
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();
                System.out.println();
                break;
            } else if (sc.hasNext()) {
                System.out.println("Please enter in a positive integer!");
                System.out.println();
                people = 0;
                sc.nextLine();
                continue;
            } else {
                System.out.println("Please enter in a positive integer!");
                System.out.println();
                people = 0;
                sc.nextLine();
                continue;
            }
        } while (people <= 0 || !(sc.hasNextInt()) || people > 10);

        do {
            sales.clear();
            System.out.print("Please enter sales person name: ");
            name = sc.nextLine();

            if (!(isString(name))) {
                continue;
            }

            System.out.print("Please enter your sales person title: ");
            title = sc.nextLine();

            if (!(isString(title))) {
                continue;
            }

            do {
                System.out.print("How many sales values will you "
                        + "enter for this sales person? ");

                if (sc.hasNextInt()) {
                    count = sc.nextInt();

                    if (count <= 0) {
                        System.out.println("Please enter in a positive integer!");
                        System.out.println();
                        sc.nextLine();
                        continue;
                    } else if (count > 10) {
                        System.out.println("You can only enter "
                                + "in up to 10 sales at a time!");
                        System.out.println();
                        count = 0;
                        sc.nextLine();
                        continue;
                    }
                    break;
                } else if (sc.hasNext()) {
                    System.out.println("Please enter in a positive integer!");
                    System.out.println();
                    count = 0;
                    sc.nextLine();
                    continue;
                } else {
                    System.out.println("Please enter in a positive integer!");
                    System.out.println();
                    count = 0;
                    sc.nextLine();
                    continue;
                }
            } while (count <= 0 || !(sc.hasNextInt()) || count > 10);

            sc.nextLine();
            System.out.println();

            while (count != 0) {
                sale = enterSales(name);
                sales.add(sale);
                count--;
            }
            SalesPerson sp = new SalesPerson();

            sp.setName(name);
            sp.setTitle(title);
            sp.setSales(sales);
            salesPeople.add(sp);
            System.out.println();

            people--;
        } while (people > 0);

        sc.close();
        createReport(salesPeople);
    }

    // Enter sales
    private static Double enterSales(String name) {
        Double sale = 0.0;

        do {
            System.out.print("Please enter sales figure for " + name + ": ");

            if (sc.hasNextDouble()) {
                sale = sc.nextDouble();
                if (sale <= 0.0) {
                    System.out.println("Please enter in a positive sale!");
                    System.out.println();
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();
                System.out.println();
                break;
            } else if (sc.hasNext()) {
                System.out.println("Please enter in a sale!");
                System.out.println();
                sale = 0.0;
                sc.nextLine();
                continue;
            } else {
                System.out.println("Please enter in a positive sale!");
                System.out.println();
                sale = 0.0;
                sc.nextLine();
                continue;
            }
        } while (sale <= 0.0 || !(sc.hasNextDouble()));

        return sale;
    }
    public static void createReport(ArrayList<SalesPerson> salesPeople) {
        double companyTotal = 0.0;
        DecimalFormat fmt = new DecimalFormat("$#,#00.00");
        Iterator<SalesPerson> iterPerson = salesPeople.iterator();
        while (iterPerson.hasNext()) {
            SalesPerson s = iterPerson.next();
            double total = 0.0;
            double sale = 0.0;
            double min = 9999999.9;
            double max = 0.0;
            double avg = 0.0;
            int count = 0;
            Iterator<Double> iterSales = s.iterSales();
            while (iterSales.hasNext()) {
                sale = iterSales.next();
                total += sale;
                if (sale < min) {
                    min = sale;
                }
                if (sale > max) {
                    max = sale;
                }

                count++;
            }
            companyTotal += total;
            avg = (total / count);
            System.out.println("Sales person: " + s.getName());
            System.out.println("Title: " + s.getTitle());
            System.out.println("Total Sales: " + fmt.format(total));
            System.out.println("Min Sales: " + fmt.format(min));
            System.out.println("Max Sales: " + fmt.format(max));
            System.out.println("Average Sales: " + fmt.format(avg));
            System.out.println("----------------------------------");
            System.out.println();
        }

        System.out.println("Company total sales: "
                + fmt.format(companyTotal));
    }
    public static boolean isString(String input) {
        if (input.isEmpty()) {
            System.out.println("Please enter in information!");
            System.out.println();
            return false;
        }

        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                System.out.println("Please only enter in letters!");
                System.out.println();
                return false;
            }
        }

        return true;
    }
}
