package vsc;

import java.sql.*;
import java.util.Scanner;

public class ServiceDAO {

    Scanner sc = new Scanner(System.in);

    public void addCustomer() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter Vehicle Number: ");
            String vehicleNo = sc.nextLine();

            System.out.print("Enter Vehicle Model: ");
            String model = sc.nextLine();

            System.out.print("Enter Service Type: ");
            String service = sc.nextLine();

            String status = "Pending";
            double bill = 0;

            String query = "insert into customers(name,phone,vehicle_no,vehicle_model,service_type,status,bill) values(?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, vehicleNo);
            ps.setString(4, model);
            ps.setString(5, service);
            ps.setString(6, status);
            ps.setDouble(7, bill);

            ps.executeUpdate();

            System.out.println("Customer Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewRecords() {
        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from customers");

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getString(3) + " | " +
                    rs.getString(4) + " | " +
                    rs.getString(5) + " | " +
                    rs.getString(6) + " | " +
                    rs.getString(7) + " | ₹" +
                    rs.getDouble(8)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStatus() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Status: ");
            String status = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                "update customers set status=? where id=?"
            );

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Status Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateBill() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Bill Amount: ");
            double amount = sc.nextDouble();

            PreparedStatement ps = con.prepareStatement(
                "update customers set bill=? where id=?"
            );

            ps.setDouble(1, amount);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Bill Generated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter ID to Delete: ");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement(
                "delete from customers where id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Record Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}