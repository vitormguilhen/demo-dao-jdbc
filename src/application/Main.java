package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department obj = new Department(1, "Book");
        Seller seller = new Seller(21, "bob", "bob@gmail.com", new Date(), 3000.0, obj);
        System.out.println(seller );
    }
}