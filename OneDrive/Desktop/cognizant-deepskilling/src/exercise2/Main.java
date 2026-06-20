package exercise2;
import exercise2.Product;
import java.util.*;
import java.util.Comparator;

public class Main {
    public static  void main(String[] args){
        SearchService ss = new SearchService();
        ss.products[0] = new Product(1, "Headphones", "Electronics");
        ss.products[1] = new Product(2, "Keyboard", "Electronics");
        ss.products[2] = new Product(3, "Monitor", "Electronics");
        ss.products[3] = new Product(4, "Mouse", "Electronics");
        ss.products[4] = new Product(5, "Speaker", "Electronics");
        ss.products[5] = new Product(6, "Yam", "Vegetable");
        Arrays.sort(ss.products, 0, ss.products.length, Comparator.comparing(p -> p.productName));
// you add the rest — in alphabetical order by name
        System.out.println(ss.linearSearch("Keyboard"));
        System.out.println(ss.binarySearch("Keyboard"));
        System.out.println(ss.binarySearch("Eye"));
    }
}
