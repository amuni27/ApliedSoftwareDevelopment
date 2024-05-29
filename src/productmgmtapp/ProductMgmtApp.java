package productmgmtapp;

import productmgmtapp.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ProductMgmtApp {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("3128874119", "Banana", "2023-01-24", 124, 0.55));
        products.add(new Product("2927458265", "Apple", "2022-12-09", 18, 1.09));
        products.add(new Product("3128874119", "Carrot", "2023-01-24", 89, 2.99));
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printProducts(products);
    }

    public static void printProducts(List<Product> products) {
        System.out.println("Printed in Json Format");
        System.out.println("[");
        for (Product product : products) {
            System.out.println("    {   productId: " + product.getProductId() + ", name: " + product.getName() + ", dateSupplied: " + product.getDateSupplied() + " quantityInStock: " + product.getQuantityInStock() + " unitPrice: " + product.getUnitPrice() + "    }");
        }
        System.out.println("]");
        System.out.println("------------------------------");
        System.out.println("Printed in XML Format");
        System.out.println("<?xml version=\"1.0\" ?>");
        System.out.println("<products>");
        for (Product product : products) {
            System.out.println("    <product   productId: \"" + product.getProductId() + "\", name: \"" + product.getName() + "\", dateSupplied: \"" + product.getDateSupplied() + "\" quantityInStock: \"" + product.getQuantityInStock() + "\" unitPrice: \"" + product.getUnitPrice() + "\">");
        }
        System.out.println("</products>");
        System.out.println("------------------------------");
        System.out.println("Printed in Coma Separated Value(CSV) Format");
        for (Product product : products) {
            System.out.println(product.getProductId() + " , " + product.getName() + " , " + product.getDateSupplied() + " , " + product.getQuantityInStock() + " , " + product.getUnitPrice());
        }
    }
}