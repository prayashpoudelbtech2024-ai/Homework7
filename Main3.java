import java.util.ArrayList;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("-------------------");
    }
}

class ShoppingCart {

    ArrayList<Product> cart = new ArrayList<Product>();

    void addProduct(Product product) {
        cart.add(product);
        System.out.println(product.name + " added to cart.");
    }

    void removeProduct(String productName) {

        boolean found = false;

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).name.equals(productName)) {
                cart.remove(i);
                System.out.println(productName + " removed from cart.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found in cart.");
        }
    }

    double calculateTotalCost() {

        double total = 0;

        for (Product p : cart) {
            total = total + p.price;
        }

        return total;
    }

    void displayCart() {

        System.out.println("\nProducts in Cart:");

        for (Product p : cart) {
            p.displayProduct();
        }

        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

public class Main3 {

    public static void main(String[] args) {

        ShoppingCart sc = new ShoppingCart();

        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 500);
        Product p3 = new Product("Keyboard", 1000);

        sc.addProduct(p1);
        sc.addProduct(p2);
        sc.addProduct(p3);

        sc.displayCart();

        sc.removeProduct("Mouse");

        sc.displayCart();
    }
}
