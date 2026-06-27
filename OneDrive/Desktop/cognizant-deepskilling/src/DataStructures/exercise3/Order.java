package DataStructures.exercise3;

public class Order {
    int orderId; String customerName; double totalPrice;

    public Order(int orderId, String customerName, double totalPrice){ this.orderId = orderId; this.customerName = customerName; this.totalPrice = totalPrice; }
    @Override public String toString(){ return "[ orderId:" + orderId + " name:" + customerName + " Total price:" + totalPrice + "]";}
}
