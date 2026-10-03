import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        if (!Login.login(input)) {
            input.close();
            return;
        }

        Product[] products = new Product[20];

        products[0] = new Product(101, "Coke", 10.00, 50);
        products[1] = new Product(102, "Bread", 15.00, 30);
        products[2] = new Product(103, "Milk", 12.00, 40);

        int productCount = 3;

        boolean running = true;

        while (running) {

            System.out.println("\n===== POS SYSTEM =====");
            System.out.println("1. Make Sale");
            System.out.println("2. View Products");
            System.out.println("3. Restock Product");
            System.out.println("4. Update Price");
            System.out.println("5. Add Product");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = input.nextInt();

            if (option == 1) {

                Cart cart = new Cart();

                int choice = 0;

                while (choice != 0) {

                    displayProducts(products, productCount);

                    System.out.println("0. Finish Sale");

                    System.out.print("\nEnter product ID: ");
                    int id = input.nextInt();

                    if (id == 0) {
                        choice = 0;
                    } else {

                        Product selectedProduct =
                                findProduct(products, productCount, id);

                        if (selectedProduct != null) {

                            System.out.print("Enter quantity: ");
                            int quantity = input.nextInt();

                            if (quantity > 0 &&
                                    quantity <= selectedProduct.stock) {

                                SaleItem item =
                                        new SaleItem(
                                                selectedProduct,
                                                quantity
                                        );

                                cart.addItem(item);

                                selectedProduct.stock =
                                        selectedProduct.stock - quantity;

                                System.out.println(
                                        selectedProduct.name +
                                                " added to cart."
                                );

                            } else {

                                System.out.println(
                                        "Invalid quantity or insufficient stock."
                                );
                            }

                        } else {

                            System.out.println(
                                    "Product ID not found."
                            );
                        }
                    }
                }

                if (cart.itemCount > 0) {

                    cart.displayCart();

                    System.out.print(
                            "\nEnter amount paid: GH₵"
                    );

                    double amountPaid = input.nextDouble();

                    cart.processPayment(amountPaid);
                }

            } else if (option == 2) {

                displayProducts(products, productCount);

            } else if (option == 3) {

                displayProducts(products, productCount);

                System.out.print(
                        "\nEnter product ID to restock: "
                );

                int id = input.nextInt();

                Product selectedProduct =
                        findProduct(products, productCount, id);

                if (selectedProduct != null) {

                    System.out.print(
                            "Enter quantity to add: "
                    );

                    int quantity = input.nextInt();

                    selectedProduct.restock(quantity);

                } else {

                    System.out.println(
                            "Product ID not found."
                    );
                }

            } else if (option == 4) {

                displayProducts(products, productCount);

                System.out.print(
                        "\nEnter product ID to update: "
                );

                int id = input.nextInt();

                Product selectedProduct =
                        findProduct(products, productCount, id);

                if (selectedProduct != null) {

                    System.out.print(
                            "Enter new price: GH₵"
                    );

                    double newPrice = input.nextDouble();

                    selectedProduct.updatePrice(newPrice);

                } else {

                    System.out.println(
                            "Product ID not found."
                    );
                }

            } else if (option == 5) {

                if (productCount < products.length) {

                    System.out.print(
                            "Enter product ID: "
                    );

                    int id = input.nextInt();

                    input.nextLine();

                    System.out.print(
                            "Enter product name: "
                    );

                    String name = input.nextLine();

                    System.out.print(
                            "Enter price: GH₵"
                    );

                    double price = input.nextDouble();

                    System.out.print(
                            "Enter stock: "
                    );

                    int stock = input.nextInt();

                    products[productCount] =
                            new Product(
                                    id,
                                    name,
                                    price,
                                    stock
                            );

                    productCount++;

                    System.out.println(
                            "Product added successfully."
                    );

                } else {

                    System.out.println(
                            "Product storage is full."
                    );
                }

            } else if (option == 6) {

                running = false;

                System.out.println(
                        "Thank you for using the POS."
                );

            } else {

                System.out.println(
                        "Invalid option."
                );
            }
        }

        input.close();
    }


    public static void displayProducts(
            Product[] products,
            int productCount) {

        System.out.println("\n===== PRODUCTS =====");

        for (int i = 0; i < productCount; i++) {

            System.out.println(
                    "ID: " + products[i].id +
                            " | " + products[i].name +
                            " | GH₵" + products[i].price +
                            " | Stock: " + products[i].stock
            );
        }
    }


    public static Product findProduct(
            Product[] products,
            int productCount,
            int id) {

        for (int i = 0; i < productCount; i++) {

            if (products[i].id == id) {
                return products[i];
            }
        }

        return null;
    }
}