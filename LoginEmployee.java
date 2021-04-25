package com.codewithkishor;

import java.sql.*;
import java.util.Scanner;

public class LoginEmployee{

    public static void LOGIN_EMPLOYEE() {

        Scanner scan = new Scanner(System.in);
        String email1 = "";
        String password1 = "";

        System.out.println("Enter your Email. ");
        String Email = scan.nextLine();
        String email_pattern = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

        while(Email.matches(email_pattern) != true){
            Email = scan.nextLine();
        }

        System.out.println("Enter the password. ");
        String Password = scan.next();
        String password_pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

        while(Password.matches(password_pattern) != true){
            Password = scan.nextLine();
        }

            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Jeetu\\Documents\\JavaLatestProject.db");
                Statement statement = conn.createStatement();

                ResultSet results = statement.executeQuery("select * from SignUpEMployee");

                while (results.next()) {
                    email1 = results.getString("Email");
                    if (Email.equals(email1)) {
                        password1 = results.getString("Password");
                        if (Password.equals(password1)) {
                            System.out.println("Successfully Logged In. ");
                            results.close();
                            statement.close();
                            conn.close();
                            EmployeeInterface.EMPLOYEE_INTERFACE(email1);
                        }
                    }
                }


            }
            catch (SQLException e) {
                System.out.println("Something went wrong. " + e.getMessage());
            }




    }

}
