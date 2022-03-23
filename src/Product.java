public class Product {
    String bcode;
    String title;
    int quantity;
    double price;

    public Product() {
    }

    public Product(String bcode, String title, int quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return this.bcode+"  |  "+this.title+"      |   "+this.quantity+"    | "+this.price;
    }
}
