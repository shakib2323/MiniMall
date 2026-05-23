package com.nt.p1;

public class OrderItem {
    Product product;
    int quantity;
    int subtotal;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = product.price * quantity;
    }
}
