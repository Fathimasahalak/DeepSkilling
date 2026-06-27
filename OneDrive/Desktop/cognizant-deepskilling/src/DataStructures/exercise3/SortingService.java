package DataStructures.exercise3;

public class SortingService {
    Order[] orders = new Order[5];
    int n = orders.length;

    public void bubblesort(int n) {

        for (int i = 0;i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    double temp = orders[j].totalPrice;
                    orders[j].totalPrice = orders[j+1].totalPrice;
                    orders[j+1].totalPrice = temp;
                }
            }
        }
    }
    int partition(int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;  // index of smaller element

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;
        // swap orders[i+1] and orders[high] (put pivot in correct position)
        // write the swap here
        return i + 1;  // return pivot index
    }
    public void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi-1);
            quickSort(pi + 1, high);

        }
    }
}


