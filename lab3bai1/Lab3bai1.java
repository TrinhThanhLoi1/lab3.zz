package lab3bai1;

import java.time.LocalDate;
import java.util.Scanner;

public class Lab3bai1 {

    public class Product {

        String description;
        String productID;
        double price;

        @Override
        public String toString() {
            return "Product{" + "description=" + description + ", productID=" + productID + ", price=" + price + '}';
        }

        public Product() {
        }

        public Product(String description, String productID, double price) {
            this.description = description;
            this.productID = productID;
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getProductID() {
            return productID;
        }

        public void setProductID(String productID) {
            this.productID = productID;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }

    public class OrderDetail extends Product {

        int quatity;
        Product product;

        public double calcTotalPrice() {
            return quatity * price;
        }

        @Override
        public String toString() {
            return "OrderDetail{" + "quatity=" + quatity + ", product=" + product + '}';
        }

        public int getQuatity() {
            return quatity;
        }

        public void setQuatity(int quatity) {
            this.quatity = quatity;
        }

        public OrderDetail(Product product, int quatity) {
            this.quatity = quatity;
            this.product = product;
        }

    }

    public class Order {

        int orderID;
        LocalDate orderDate;
        OrderDetail[] lineItems = new OrderDetail[20];
        int count;

        public void addLineItem(Product p, int x) {
            lineItems[count] = new OrderDetail(p, x);
            count++;
        }

        public double calcTotalCharge() {
            count = lineItems.length;
            return 0;

        }

        @Override
        public String toString() {
            return "Order{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", lineItems=" + lineItems + ", count=" + count + '}';
        }

        public Order(int orderID, LocalDate orderDate) {

            this.orderID = orderID;
            this.orderDate = orderDate;
        }

        public int getOrderID() {
            return orderID;
        }

        public LocalDate getOrderDate() {
            return orderDate;
        }

        public OrderDetail[] getLineItems() {
            return lineItems;
        }

        public void setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
        }
    }

    public class Main {

        public static void main(String[] args) {
            Order order = new Order(1, LocalDate.of(2023, 5, 9));
            order.addLineItem(new Product("sp4", "Nuoc tuong", 8000), 10);
            order.addLineItem(new Product("sp1", "Gao", 18000), 5);
            order.addLineItem(new Product("sp4", "Duong", 10000), 1);
            order.addLineItem(new Product("sp1", "Gao", 18000), 1);
            System.out.println(order.toString());
        }
    }
}
