import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;
public class Student
 {
    public static void main(String[] args)
    {

        int choice,rno,admo;
        String name,clg;

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
                    System.out.println("Enter the name");
                    name= sc.next();
                    System.out.println("Enter the roll number");
                    rno= sc.nextInt();
                    System.out.println("Enter the admission  number");
                    admo=sc.nextInt();
                    System.out.println("Enter the college name");
                    clg=sc.next();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
                        String sql=" INSERT INTO `students` (`NAME`, `Rno`, `ADMno`, `COLLEGE`) VALUES (?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setInt(2,rno);
                        stmt.setInt(3,admo);
                        stmt.setString(4,clg);
                        stmt.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("view all student selected");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
                        String sql="SELECT `NAME`, `Rno`, `ADMno`, `COLLEGE` FROM `students` ";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while (rs.next()){
                            String getName=rs.getString("NAME");
                            String getRoll=rs.getString("Rno");
                            String getAdm=rs.getString("ADMno");
                            String getClg=rs.getString("COLLEGE");
                            System.out.println("Name :"+getName);
                            System.out.println("Roll No :"+getRoll);
                            System.out.println("Ad No :"+getAdm);
                            System.out.println("College:"+getClg+"\n");



                        }
                    }
                    catch (Exception e){
                        System.out.println(e);}
                    break;
                case 3:
                    System.out.println("search a student selected");
                    System.out.println("Enter the admission number for search a student");
                    admo=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
                        String sql="SELECT `NAME`, `Rno`, `ADMno`, `COLLEGE` FROM `students` WHERE `ADMno`="+String.valueOf(admo);
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while (rs.next()){
                            String getName=rs.getString("NAME");
                            String getRoll=rs.getString("Rno");
                            String getAdm=rs.getString("ADMno");
                            String getClg=rs.getString("COLLEGE");
                            System.out.println("Name :"+getName);
                            System.out.println("Roll No :"+getRoll);
                            System.out.println("Ad No :"+getAdm);
                            System.out.println("College:"+getClg+"\n");

                     }
                    }
                    catch (Exception e){
                        System.out.println(e);}
                    break;
                case 4:
                    System.out.println("update student selected");
                    System.out.println("Enter the admission number");
                    String adm=sc.next();
                    System.out.println("Enter the name to be updated");
                    name= sc.next();
                    System.out.println("Enter the roll number to be updated");
                    rno= sc.nextInt();
                    System.out.println("Enter the college name to be updated");
                    clg=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
                        String sql="UPDATE `students` SET `NAME`='"+name+"',`Rno`='"+rno+"',`COLLEGE`='"+clg+"' WHERE `ADMno`="+adm;
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("updated successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);}
                    break;
                case 5:
                    System.out.println("Delete a student selected");
                    System.out.println("Enter the admission number that you want to delete");
                    String ad=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
                        String sql="DELETE FROM `students` WHERE `ADMno`="+ad;
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);}
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }

        }
    }
 }
