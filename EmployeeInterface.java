package com.codewithkishor;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmployeeInterface {

    public static void EMPLOYEE_INTERFACE(String Email){



        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        Date date = new Date();
        System.out.println(df.format(date));
        String purchase_date = df.format(date);
        System.out.println(purchase_date);


        System.out.println("These are the items available with us. ");

        System.out.println("1.PUFF. ");
        System.out.println("2.Bun. ");
        System.out.println("3.BREAD. ");
        System.out.println("4.TOAST. ");
        System.out.println("5.DOUGH-NUT. ");
        System.out.println("6.CREAMROLLS. ");

        int rate = 84;
        int sum = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("The Quantities are in dozens only. ");

        System.out.println("Enter the quantity of Puff. ");
        int puff_quantity = scan.nextInt();
        int puff_amount = 100 * puff_quantity;
        sum += puff_amount;

        System.out.println("Enter the quantity of Bun. ");
        int bun_quantity = scan.nextInt();
        int bun_amount = 100 * bun_quantity;
        sum += bun_amount;

        System.out.println("Enter the quantity of Bread. ");
        int bread_quantity = scan.nextInt();
        int bread_amount = 100 * bread_quantity;
        sum += bread_amount;

        System.out.println("Enter the quantity of Toast. ");
        int toast_quantity = scan.nextInt();
        int toast_amount = 100 * toast_quantity;
        sum += toast_amount;

        System.out.println("Enter the quantity of Dough-Nut. ");
        int doughnut_quantity = scan.nextInt();
        int doughnut_amount = 100 * doughnut_quantity;
        sum += doughnut_amount;

        System.out.println("Enter the quantity of CreamRolls. ");
        int rolls_quantity = scan.nextInt();
        int rolls_amount = 100 * rolls_quantity;
        sum += rolls_amount;


        System.out.println("Your bill is.  "+sum);

        try {

            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Jeetu\\Documents\\JavaLatestProject.db");
            // conn.setAutoCommit(false);
            Statement statement = conn.createStatement();

            //statement.execute("drop table if exists EmployeeInterface");
            statement.execute("CREATE TABLE IF NOT EXISTS EmployeeInterface( Email text, purchase_date DATE, puff_quantity integer, bun_quantity integer, bread_quantity integer, toast_quantity integer, doughnut_quantity integer, rolls_quantity integer, Rate integer, Sum integer)");

            insertIntoUser(statement, Email, purchase_date, puff_quantity, bun_quantity, bread_quantity, toast_quantity, doughnut_quantity, rolls_quantity, rate, sum);

            /*ResultSet results = statement.executeQuery("select * from SignUpUser");
            while (results.next()) {
                System.out.println(results.getString("Name") + " " +
                        results.getString("Email") + " " +
                        results.getString("Phone") + " " +
                        results.getString("Password"));
            }

            results.close();*/

            statement.close();
            conn.close();
        } catch (
                SQLException e) {
            System.out.println("Something went wrong. " + e.getMessage());
        }

    }

    public static void insertIntoUser(Statement statement,String Email, String pd, int pq, int bq, int brq, int tq, int dnq, int rq, int rate, int sum ) throws SQLException{
        statement.execute("insert into EmployeeInterface(Email, purchase_date, puff_quantity, bun_quantity, bread_quantity, toast_quantity, doughnut_quantity, rolls_quantity, Rate, Sum)" +
                "values('"+Email+"', '"+pd+"', "+pq+", "+bq+", "+brq+", "+tq+", "+dnq+", "+rq+", "+rate+", "+sum+")");
    }


}
