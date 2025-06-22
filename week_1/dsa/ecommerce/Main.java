package week_1.dsa.ecommerce;

import java.util.Arrays;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }

    public int compareTo(Product other) {
        return this.productId - other.productId;
    }
}

public class Main {
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId) return mid;
            else if (products[mid].productId < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(103, "Laptop", "Electronics"),
            new Product(101, "Shoes", "Footwear"),
            new Product(105, "Smartphone", "Electronics"),
            new Product(102, "T-shirt", "Clothing"),
            new Product(104, "Backpack", "Accessories")
        };

        System.out.println("Linear Search:");
        int index = linearSearch(products, 105);
        if (index != -1) System.out.println("Found: " + products[index]);
        else System.out.println("Product not found.");

        Arrays.sort(products);

        System.out.println("\nBinary Search:");
        int sortedIndex = binarySearch(products, 105);
        if (sortedIndex != -1) System.out.println("Found: " + products[sortedIndex]);
        else System.out.println("Product not found.");
    }
}

