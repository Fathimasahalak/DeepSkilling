
package exercise1;
import java.util.*;

public class InventoryManager{
    Map <Integer, Product> products = new HashMap<>();
    public void addProduct(int productId, String productName, int quantity, double price){
        if (products.containsKey(productId)){
            Product p = products.get(productId);
            p.quantity +=1;
        }
        else{
           Product p = new Product(productId, productName, quantity, price);
           products.put(productId, p);
        }
    }
    public void updateProduct(int productId, String productName, int quantity, double price){
        if (products.containsKey(productId)){
            Product p = products.get(productId);
            p.productName = productName;  // update fields directly
            p.quantity = quantity;
            p.price = price;
        }
        else{
            System.out.println("There is no such product");
        }
    }
    public void deleteProduct(int productId){
        if (products.containsKey(productId)){
            products.remove(productId);
            System.out.println("product" + productId + "deleted");
        }
        else{
            System.out.println("There is no such product");
        }
    }
    public void viewProducts(){
        System.out.println(products);
    }
}
