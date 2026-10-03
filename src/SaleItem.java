public class SaleItem {

    Product product;
    int quantity;
    double total;

    public SaleItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.total = product.price * quantity;
    }
}