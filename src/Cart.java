public class Cart {

    SaleItem[] items;
    int itemCount;

    public Cart() {
        items = new SaleItem[10];
        itemCount = 0;
    }

    public void addItem(SaleItem item) {

        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount++;
        } else {
            System.out.println("Cart is full.");
        }
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total = total + items[i].total;
        }

        return total;
    }

    public void displayCart() {

        System.out.println("\n===== RECEIPT =====");

        for (int i = 0; i < itemCount; i++) {

            System.out.println(
                    items[i].product.name +
                            " x " +
                            items[i].quantity +
                            " = GH₵" +
                            items[i].total
            );
        }

        System.out.println("-------------------");
        System.out.println("TOTAL: GH₵" + getTotal());
        System.out.println("===================");
    }

    public void processPayment(double amountPaid) {

        double total = getTotal();

        System.out.println("\n===== PAYMENT =====");
        System.out.println("Total: GH₵" + total);
        System.out.println("Amount Paid: GH₵" + amountPaid);

        if (amountPaid >= total) {

            double change = amountPaid - total;

            System.out.println("Change: GH₵" + change);

        } else {

            double remaining = total - amountPaid;

            System.out.println("Insufficient payment.");
            System.out.println("Remaining: GH₵" + remaining);
        }
    }
}