import java.util.*;

interface Taxable {
    double calculateTax();
}

abstract class Item {
    String itemID;
    String name;
    double basePrice;

    Item(String itemID, String name, double basePrice) {
        this.itemID = itemID;
        this.name = name;
        this.basePrice = basePrice;
    }

    abstract void display();

    double getPrice() {
        return basePrice;
    }
}

class PerishableItem extends Item implements Taxable {
    String expiryDate;

    PerishableItem(String id, String name, double price, String expiryDate) {
        super(id, name, price);
        this.expiryDate = expiryDate;
    }

    public double calculateTax() {
        return basePrice * 0.05; // 5% tax
    }

    void display() {
        System.out.println("Perishable Item -> ID: " + itemID +
                ", Name: " + name +
                ", Price: $" + basePrice +
                ", Expiry: " + expiryDate);
    }
}

class ElectronicItem extends Item implements Taxable {
    int warrantyPeriod;

    ElectronicItem(String id, String name, double price, int warrantyPeriod) {
        super(id, name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public double calculateTax() {
        return basePrice * 0.15; // 15% tax
    }

    void display() {
        System.out.println("Electronic Item -> ID: " + itemID +
                ", Name: " + name +
                ", Price: $" + basePrice +
                ", Warranty: " + warrantyPeriod + " months");
    }
}

public class Scenario1 {

    static HashMap<String, Item> inventory = new HashMap<>();

    public static void addItem(Item item) {
        inventory.put(item.itemID, item);
    }

    public static void displayItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Item item : inventory.values()) {
            item.display();
        }
    }

    public static void searchItem(String id) {
        Item item = inventory.get(id);
        if (item != null) {
            System.out.println("\nItem Found:");
            item.display();
        } else {
            System.out.println("Item not found.");
        }
    }

    public static void calculateTotalValue() {
        double total = 0;

        for (Item item : inventory.values()) {
            double tax = 0;
            if (item instanceof Taxable) {
                tax = ((Taxable) item).calculateTax();
            }
            total += item.getPrice() + tax;
        }

        System.out.printf("\nTotal Inventory Value (Incl. Tax): $%.2f\n", total);
    }

    public static void sortByPrice() {
        ArrayList<Item> list = new ArrayList<>(inventory.values());
        list.sort(Comparator.comparingDouble(Item::getPrice));

        System.out.println("\nItems sorted by price:");
        for (Item item : list) {
            item.display();
        }
    }

    public static void main(String[] args) {

        addItem(new PerishableItem("P001", "Milk", 2.50, "2026-03-10"));
        addItem(new ElectronicItem("E501", "Headphones", 120.00, 24));

        System.out.println("All Items in Warehouse:");
        displayItems();

        searchItem("P001");

        sortByPrice();

        calculateTotalValue();
    }
}