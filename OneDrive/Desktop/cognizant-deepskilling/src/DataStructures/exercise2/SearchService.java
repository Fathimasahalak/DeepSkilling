package DataStructures.exercise2;

public class SearchService {
    Product[] products = new Product[6];

    public Object linearSearch(String productName){
        for(int i = 0;i<products.length;i++){
            if(products[i].productName.equals(productName)){
                return products[i];
            }
        }
        return "no element found";
    }
    public Object binarySearch(String productName){
        int low = 0;
        int high = products.length-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(products[mid].productName.equals(productName)){
                return products[mid];
            }
            else if(products[mid].productName.compareTo(productName) > 0){

                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return "element not found";

    }



}
