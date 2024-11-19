import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // StockItem class to represent each stock item
    static class StockItem {
        private String itemId;
        private String itemName;
        private int quantity;
        private double price;

        public StockItem(String itemId, String itemName, int quantity, double price) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters and setters
        public String getItemId() { return itemId; }
        public void setItemId(String itemId) { this.itemId = itemId; }

        public String getItemName() { return itemName; }
        public void setItemName(String itemName) { this.itemName = itemName; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return "Item ID: " + itemId + ", Name: " + itemName + ", Quantity: " + quantity + ", Price: $" + price;
        }
    }

    // StockManager class to manage the stock items
    static class StockManager {
        private List<StockItem> stockItems;

        public StockManager() {
            this.stockItems = new ArrayList<>();
        }

        // Add new stock item
        public void addItem(StockItem item) {
            stockItems.add(item);
            System.out.println("Item added successfully!");
        }

        // Update stock quantity
        public void updateStock(String itemId, int quantity) {
            for (StockItem item : stockItems) {
                if (item.getItemId().equals(itemId)) {
                    item.setQuantity(item.getQuantity() + quantity);
                    System.out.println("Stock updated successfully!");
                    return;
                }
            }
            System.out.println("Item not found!");
        }

        // Delete stock item
        public void deleteItem(String itemId) {
            stockItems.removeIf(item -> item.getItemId().equals(itemId));
            System.out.println("Item deleted successfully!");
        }

        // View all stock items
        public void viewStock() {
            if (stockItems.isEmpty()) {
                System.out.println("No stock items available.");
            } else {
                for (StockItem item : stockItems) {
                    System.out.println(item);
                }
            }
        }

        // Search for a stock item by ID
        public StockItem searchItem(String itemId) {
            for (StockItem item : stockItems) {
                if (item.getItemId().equals(itemId)) {
                    return item;
                }
            }
            return null;
        }
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockManager stockManager = new StockManager();

        while (true) {
            System.out.println("\nStock Management System:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Stock");
            System.out.println("3. Delete Item");
            System.out.println("4. View Stock");
            System.out.println("5. Search Item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item ID: ");
                    String itemId = scanner.next();
                    System.out.print("Enter item name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    StockItem newItem = new StockItem(itemId, itemName, quantity, price);
                    stockManager.addItem(newItem);
                    break;
                case 2:
                    System.out.print("Enter item ID to update: ");
                    String updateId = scanner.next();
                    System.out.print("Enter quantity to add or subtract: ");
                    int qty = scanner.nextInt();
                    stockManager.updateStock(updateId, qty);
                    break;
                case 3:
                    System.out.print("Enter item ID to delete: ");
                    String deleteId = scanner.next();
                    stockManager.deleteItem(deleteId);
                    break;
                case 4:
                    stockManager.viewStock();
                    break;
                case 5:
                    System.out.print("Enter item ID to search: ");
                    String searchId = scanner.next();
                    StockItem foundItem = stockManager.searchItem(searchId);
                    if (foundItem != null) {
                        System.out.println(foundItem);
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}