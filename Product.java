import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private String description;
    private String manufacturer;
    private int warrantyPeriod;

    public Product(String productId, String productName, String description, String manufacturer, int warrantyPeriod) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}

class ProductRegistrationSystem {
    private ArrayList<Product> products = new ArrayList<>();

    public void registerProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product Details:");
        System.out.print("Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Warranty Period (in months): ");
        int warrantyPeriod = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Product product = new Product(productId, productName, description, manufacturer, warrantyPeriod);
        products.add(product);
        System.out.println("Product registered successfully!");
    }

    public void displayAllProducts() {
        System.out.println("Registered Products:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Manufacturer: " + product.getManufacturer());
            System.out.println("Warranty Period: " + product.getWarrantyPeriod() + " months");
            System.out.println();
        }
    }

    public void searchProductById(String productId) {
        boolean found = false;
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                System.out.println("Product Details:");
                System.out.println("Product ID: " + product.getProductId());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Description: " + product.getDescription());
                System.out.println("Manufacturer: " + product.getManufacturer());
                System.out.println("Warranty Period: " + product.getWarrantyPeriod() + " months");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    public void generateReport() {
        int totalProducts = products.size();
        int expiredWarrantyProducts = 0;
        for (Product product : products) {
            if (product.getWarrantyPeriod() <= 0) {
                expiredWarrantyProducts++;
            }
        }
        int activeWarrantyProducts = totalProducts - expiredWarrantyProducts;

        System.out.println("Product Registration Report:");
        System.out.println("Total Products Registered: " + totalProducts);
        System.out.println("Active Warranty Products: " + activeWarrantyProducts);
        System.out.println("Expired Warranty Products: " + expiredWarrantyProducts);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRegistrationSystem prs = new ProductRegistrationSystem();

        while (true) {
            System.out.println("\nProduct Registration System Menu:");
            System.out.println("1. Register a Product");
            System.out.println("2. Display All Registered Products");
            System.out.println("3. Search for a Product by ID");
            System.out.println("4. Generate Product Registration Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    prs.registerProduct();
                    break;
                case 2:
                    prs.displayAllProducts();
                    break;
                case 3:
                    System.out.print("Enter Product ID to search: ");
                    String productId = scanner.nextLine();
                    prs.searchProductById(productId);
                    break;
                case 4:
                    prs.generateReport();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
