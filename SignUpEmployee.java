package com.codewithkishor;


import java.io.Console;
import java.sql.*;
import java.util.Scanner;

public class SignUpEmployee{

    public static void SIGNUP_EMPLOYEE() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your Name. ");
        String Name = scan.nextLine();
        String name_pattern = "^[A-Za-z\\s]+$";

        while(Name.matches(name_pattern) != true){
            Name = scan.nextLine();
        }

        System.out.println("Enter your Email. ");
        String Email = scan.nextLine();
        String email_pattern = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

        while(Email.matches(email_pattern) != true){
            Email = scan.nextLine();
        }


        System.out.println("Enter the Phone Number. ");
        String Phone = scan.nextLine();
        String phone_pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

        while(Phone.matches(phone_pattern) != true){
            Phone = scan.nextLine();
        }

        System.out.println("Enter the password. ");
        String Password = scan.next();
        String password_pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

        while(Password.matches(password_pattern) != true){
            Password = scan.nextLine();
        }
        
            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Jeetu\\Documents\\JavaLatestProject.db");
                //conn.setAutoCommit(false);
                Statement statement = conn.createStatement();
               //statement.execute("drop table if exists SignUpEmployee");
                statement.execute("CREATE TABLE IF NOT EXISTS SignUpEmployee(Name text, Email text PRIMARY KEY, Phone text, Password text)");
                insertIntoSignUpEmployee(statement, Name, Email, Phone, Password);

                ResultSet results = statement.executeQuery("select * from SignUpEmployee");
                while (results.next()) {
                    System.out.println(results.getString("Name") + " " +
                            results.getString("Email") + " " +
                            results.getString("Phone") + " " +
                            results.getString("Password"));
                }

                results.close();
                statement.close();
                conn.close();

                LoginEmployee loginemployee = new LoginEmployee();
                loginemployee.LOGIN_EMPLOYEE();

            } catch (SQLException e) {
                System.out.println("Something went wrong. " + e.getMessage());
            }




    }

    public static void insertIntoSignUpEmployee(Statement statement, String name,String email, String phone, String password) throws SQLException{
        statement.execute("insert into SignUpEmployee(Name, Email, Phone, Password)" +
                "values('"+name+"','"+email+"', "+phone+", '"+password+"')");
    }






}
