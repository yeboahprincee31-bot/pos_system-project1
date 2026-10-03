public class Product {

    int id;
    String name;
    double price;
    int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void restock(int quantity) {

        if (quantity > 0) {
            stock = stock + quantity;

            System.out.println(name + " restocked successfully.");
            System.out.println("New stock: " + stock);

        } else {
            System.out.println("Invalid restock quantity.");
        }
    }

    public void updatePrice(double newPrice) {

        if (newPrice > 0) {
            price = newPrice;

            System.out.println(name + " price updated successfully.");
            System.out.println("New price: GH₵" + price);

        } else {
            System.out.println("Invalid price.");
        }
    }
}