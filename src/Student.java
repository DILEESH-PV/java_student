import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
public class Student
 {
    public static void main(String[] args)
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
        }
        catch (Exception e){
            System.out.println(e);
        }
        int choice;
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("Select an option");
            System.out.println("1. Add student");
            System.out.println("2. view all student");
            System.out.println("3. search a student");
            System.out.println("4. update student");
            System.out.println("5. Delete a student");
            System.out.println("6.Exit");

            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Add student selected");
                    break;
                case 2:
                    System.out.println("view all student selected");
                    break;
                case 3:
                    System.out.println("search a student selected");
                    break;
                case 4:
                    System.out.println("update student selected");
                    break;
                case 5:
                    System.out.println("Delete a student selected");
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }

        }
    }
 }
