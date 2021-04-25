package com.codewithkishor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your choice. ");
        System.out.println("1 for Sign Up if new user. ");
        System.out.println("2 for Login if already a user. ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("SignUp as Employee press 1 or as a user press 2. ");
                int choice1 = scan.nextInt();

                 switch (choice1) {
                    case 1:
                        SignUpEmployee signupemployee = new SignUpEmployee();
                        signupemployee.SIGNUP_EMPLOYEE();
                        break;

                    case 2:
                        SignUpUser signupuser = new SignUpUser();
                        signupuser.SIGNUP_USER();
                        break;

                    default:
                }
                break;


            }
            case 2: {
                System.out.println("Login as Employee press 1 or as a user press 2. ");
                int choice2 = scan.nextInt();
                switch (choice2) {
                    case 1:
                        LoginEmployee loginemployeee = new LoginEmployee();
                        loginemployeee.LOGIN_EMPLOYEE();
                        break;

                    case 2:
                        LoginUser loginuser = new LoginUser();
                        loginuser.LOGIN_USER();
                        break;

                    default:
                }

            }
            break;

            default:

        }
    }
}
