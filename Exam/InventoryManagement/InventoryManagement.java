import java.sql.*;
import java.util.Scanner;

public class InventoryManagement {

    static final String URL = "jdbc:mysql://localhost:3306/inventorydb";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try ( // Connect to MySQL
                    Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Database Connected Successfully!");
                
                int choice;
                
                do {
                    System.out.println("\n===== INVENTORY MANAGEMENT =====");
                    System.out.println("1. Insert Product");
                    System.out.println("2. View Products");
                    System.out.println("3. Update Product");
                    System.out.println("4. Delete Product");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    
                    choice = sc.nextInt();
                    
                    switch (choice) {
                        
                        case 1 -> {
                            // INSERT
                            System.out.print("Enter Product ID: ");
                            int id = sc.nextInt();
                            
                            sc.nextLine();
                            System.out.print("Enter Product Name: ");
                            String name = sc.nextLine();
                            
                            System.out.print("Enter Quantity: ");
                            int quantity = sc.nextInt();
                            
                            System.out.print("Enter Price: ");
                            double price = sc.nextDouble();
                            
                            String insert = "INSERT INTO inventory VALUES (?, ?, ?, ?)";
                            PreparedStatement ps1 = con.prepareStatement(insert);
                            
                            ps1.setInt(1, id);
                            ps1.setString(2, name);
                            ps1.setInt(3, quantity);
                            ps1.setDouble(4, price);
                            
                            ps1.executeUpdate();
                            
                            System.out.println("Product inserted successfully!");
                        }
                            
                        case 2 -> {
                            // VIEW
                            String select = "SELECT * FROM inventory";
                            
                            Statement st = con.createStatement();
                            ResultSet rs = st.executeQuery(select);
                            
                            System.out.println("\nID\tName\tQuantity\tPrice");
                            System.out.println("--------------------------------------");
                            
                            while (rs.next()) {
                                System.out.println(
                                        rs.getInt("id") + "\t" +
                                                rs.getString("name") + "\t" +
                                                rs.getInt("quantity") + "\t\t" +
                                                rs.getDouble("price")
                                );
                            }
                        }
                            
                        case 3 -> {
                            // UPDATE
                            System.out.print("Enter Product ID to update: ");
                            int updateId = sc.nextInt();
                            
                            System.out.print("Enter New Quantity: ");
                            int newQuantity = sc.nextInt();
                            
                            System.out.print("Enter New Price: ");
                            double newPrice = sc.nextDouble();
                            
                            String update =
                                    "UPDATE inventory SET quantity=?, price=? WHERE id=?";
                            
                            PreparedStatement ps2 = con.prepareStatement(update);
                            
                            ps2.setInt(1, newQuantity);
                            ps2.setDouble(2, newPrice);
                            ps2.setInt(3, updateId);
                            
                            int updated = ps2.executeUpdate();
                            
                            if (updated > 0)
                                System.out.println("Product updated successfully!");
                            else
                                System.out.println("Product not found!");
                        }
                            
                        case 4 -> {
                            // DELETE
                            System.out.print("Enter Product ID to delete: ");
                            int deleteId = sc.nextInt();
                            
                            String delete = "DELETE FROM inventory WHERE id=?";
                            
                            PreparedStatement ps3 = con.prepareStatement(delete);
                            
                            ps3.setInt(1, deleteId);
                            
                            int deleted = ps3.executeUpdate();
                            
                            if (deleted > 0)
                                System.out.println("Product deleted successfully!");
                            else
                                System.out.println("Product not found!");
                        }
                            
                        case 5 -> System.out.println("Exiting...");
                            
                        default -> System.out.println("Invalid choice!");
                    }
                    
                } while (choice != 5);
            }
            sc.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}