package com.nt.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiniMall
{
    private static final int MAX_ORDERS = 100000;
    private static final double DISCOUNT_RATE = 0.10;
    private static final int DISCOUNT_THRESHOLD = 500;
    private final Scanner sc = new Scanner(System.in);
    private final List<OrderItem> cart = new ArrayList<>();


    static final Product[] PRODUCTS = {
        new Product("Trouser", 1999),
        new Product("T-Shirt (Nike)", 599),
        new Product("Shoes (Puma)", 4999)
    };

    void start() {
        printBanner();
        System.out.println("Welcome to Mini Mall! You can place up to " + MAX_ORDERS + " orders per session.\n");

        for (int orderNum = 1; orderNum <= MAX_ORDERS; orderNum++) {
            System.out.println("─────────────────────────────────────────");
            System.out.println("  Order #" + orderNum);
            System.out.println("─────────────────────────────────────────");

            showCatalog();

            int choice = readInt("Enter product number: ");
            if (choice < 1 || choice > PRODUCTS.length)
            {
                System.out.println("Invalid product number. Skipping this order slot.\n");
                continue;
            }

            Product selected = PRODUCTS[choice - 1];
            System.out.printf("%nYou selected: %-20s  Price: Rs.%d%n", selected.name, selected.price);

            if (!confirm("Confirm selection? (yes/no): ")) 
            {
                System.out.println("Order cancelled.\n");
                continue;
            }

            int qty = readInt("Enter quantity: ");
            if (qty <= 0) {
                System.out.println("Quantity must be at least 1. Order cancelled.\n");
                continue;
            }

            OrderItem item = new OrderItem(selected, qty);
            cart.add(item);

            System.out.printf("Added to cart → %s x%d = Rs.%d%n%n", selected.name, qty, item.subtotal);

            if (orderNum < MAX_ORDERS) {
                if (!confirm("Continue shopping? (yes/no): ")) {
                    break;
                }
            }
        }

        printReceipt();
        sc.close();
    }

    void showCatalog() 
    {
        System.out.println("\n  Available Products:");
        for (int i = 0; i < PRODUCTS.length; i++) {
            System.out.printf("  [%d] %-20s  Rs.%d%n", (i + 1), PRODUCTS[i].name, PRODUCTS[i].price);
        }
        System.out.println();
    }

    boolean confirm(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim().toLowerCase();
        return input.equals("yes") || input.equals("y");
    }

    int readInt(String prompt)
    {
        System.out.print(prompt);
        while (!sc.hasNextInt())
        {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }

    void printReceipt()
    {
        if (cart.isEmpty())
        {
            System.out.println("\nNo items were ordered. See you next time!");
            return;
        }

        int total = 0;
        for (OrderItem item : cart) 
        {
            total += item.subtotal;
        }

        int discount = total > DISCOUNT_THRESHOLD ? (int) (total * DISCOUNT_RATE) : 0;
        int payable = total - discount;

        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("              MINI MALL — RECEIPT           ");
        System.out.println("═══════════════════════════════════════════");
        System.out.printf("%-22s %6s %10s%n", "Product", "Qty", "Amount");
        System.out.println("───────────────────────────────────────────");

        for (OrderItem item : cart) 
        {
            System.out.printf("%-22s %6d %10s%n",
                item.product.name,
                item.quantity,
                "Rs." + item.subtotal);
        }

        System.out.println("───────────────────────────────────────────");
        System.out.printf("%-28s %10s%n", "Subtotal:", "Rs." + total);

        if (discount > 0) 
        {
            System.out.printf("%-28s %10s%n", "Discount (10%):", "-Rs." + discount);
        }

        System.out.println("───────────────────────────────────────────");
        System.out.printf("%-28s %10s%n", "Total Payable:", "Rs." + payable);
        System.out.println("═══════════════════════════════════════════");
        System.out.println("         Thank you for shopping with us!    ");
        System.out.println("═══════════════════════════════════════════\n");
    }

    void printBanner() 
    {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("              MINI MALL STORE               ");
        System.out.println("═══════════════════════════════════════════");
    }

    public static void main(String[] args) 
    {
        new MiniMall().start();
    }
}