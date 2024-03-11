import java.util.ArrayList;
import java.util.List;

class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Cart {
    private List<Product> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addToCart(Product product) {
        cartItems.add(product);
    }

    public void removeFromCart(Product product) {
        cartItems.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        for (Product p : cartItems) {
            if (p.getProductId().equals(product.getProductId())) {
                p.setQuantity(quantity);
                break;
            }
        }
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Products in your cart:");
            for (Product product : cartItems) {
                System.out.println("Product ID: " + product.getProductId());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Price: $" + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println();
            }
        }
    }

    public void checkout() {
        double total = 0;
        System.out.println("Items in your cart:");
        for (Product product : cartItems) {
            total += product.getPrice() * product.getQuantity();
            System.out.println(product.getProductName() + " - Quantity: " + product.getQuantity() + ", Price: $" + product.getPrice());
        }
        System.out.println("Total amount: $" + total);
        System.out.println("Thank you for shopping with us! Your order has been placed.");
        cartItems.clear();
    }
}

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("P001", "Laptop", 999.99, 2);
        Product product2 = new Product("P002", "Smartphone", 499.99, 1);
        Product product3 = new Product("P003", "Headphones", 49.99, 3);

        Cart cart = new Cart();

        cart.addToCart(product1);
        cart.addToCart(product2);
        cart.addToCart(product3);

        System.out.println("Initial Cart:");
        cart.viewCart();
        System.out.println();

        cart.updateQuantity(product1, 3);

        System.out.println("Updated Cart:");
        cart.viewCart();
        System.out.println();

        cart.removeFromCart(product2);

        System.out.println("Cart after removing product:");
        cart.viewCart();
        System.out.println();

        cart.checkout();
    }
}
