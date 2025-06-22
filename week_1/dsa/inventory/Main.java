package week_1.dsa.inventory;

import java.util.HashMap;
import java.util.Scanner;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: ₹" + price;
    }
}

class Inventory {
    private HashMap<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        if (inventory.containsKey(product.productId)) {
            System.out.println("Product ID already exists.");
        } else {
            inventory.put(product.productId, product);
            System.out.println("Product added.");
        }
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product p = inventory.get(productId);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Product ID: ");
                    String id = sc.nextLine();
                    System.out.print("Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    inventory.addProduct(new Product(id, name, qty, price));
                }
                case 2 -> {
                    System.out.print("Enter Product ID to update: ");
                    String id = sc.nextLine();
                    System.out.print("New Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("New Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    inventory.updateProduct(id, qty, price);
                }
                case 3 -> {
                    System.out.print("Enter Product ID to delete: ");
                    String id = sc.nextLine();
                    inventory.deleteProduct(id);
                }
                case 4 -> inventory.displayInventory();
                case 5 -> System.out.println("Exited");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
