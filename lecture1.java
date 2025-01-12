public class lecture1 {
    public static void main(String[] args) {
        // Your code goes here
        System.out.println("Hello, World!");
    }
}


class Marker{
    String name;
    String color;
    int price;

    public Marker(String name,String color,int price) {
        this.name=name;
        this.color=color;
        this.price=price;
    }
     
}

//single responsilbilty honi chaiye refactored code should be
class Invoice{
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker,int q){
      this.marker=marker;
      this.quantity=q;  
    }

    public int calcTotalCost(){
        int price = (marker.price)* this.quantity;
        return price;
    }

    public void printInvoice(){
        //prints invoice;

    }

    public void saveToDb(){
        //savestoDb;
    }


}



// this same code should be refactored in such a way that each class should change for only 
// one reason to adhere to single object responsibility
 

class InvoicePrinter{

    private Invoice invoice;

    public InvoicePrinter(Invoice invoice){
        this.invoice=invoice;
    }

    void printInvoice(){
        //prints Invoice;

    }
}

// Now when we want to add more features we need to write more code
//  
