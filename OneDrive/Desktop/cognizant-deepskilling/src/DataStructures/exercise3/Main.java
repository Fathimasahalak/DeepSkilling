package DataStructures.exercise3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        SortingService sos = new SortingService();
        sos.orders[0] = new Order(1, "sahala", 1000.0);
        sos.orders[1] = new Order(2, "sajna", 2022.0);
        sos.orders[2] = new Order(3, "musthafa", 100.0);
        sos.orders[3] = new Order(4, "suhara", 700.0);
        sos.orders[4] = new Order(5, "salam", 5000.0);

        //sos.bubblesort(5);

        sos.quickSort(0, 4);
        System.out.println(Arrays.toString(sos.orders));
    }
}
