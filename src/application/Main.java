package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println(" ==== TEST 1 : seller findById ==== ");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller );

        System.out.println("\n ==== TEST 2 : seller findByDepartment ==== ");
        Department dep = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(dep);
        for (Seller s : sellers) {
            System.out.println(s);
        }

        System.out.println("\n ==== TEST 3 : seller findAll ==== ");
        sellers = sellerDao.findAll();
        for (Seller obj: sellers) {
            System.out.println(obj);
        }

        System.out.println("\n ==== TEST 4 : seller insert ==== ");
        Seller newSeller = new Seller(null,"greg", "greg@gmail.com", new Date(), 4000.0, dep );
        sellerDao.insert(newSeller);
        System.out.println("Inserted Seller: " + newSeller.getId());

        System.out.println("\n ==== TEST 5 : seller update ==== ");
        seller = sellerDao.findById(1);
        seller.setName("Bob brown");
        sellerDao.update(seller);
        System.out.println("Update complete");

        System.out.println("\n ==== TEST 6 : seller delete ==== ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete complete");
    }
}