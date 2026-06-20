package exercise1;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // test addProduct
        manager.addProduct(1, "USB Cable", 10, 299.0);
        manager.addProduct(2, "Keyboard", 5, 1499.0);
        manager.updateProduct(1, "USB CABLE", 10, 299.0);
        manager.viewProducts();
    }
}