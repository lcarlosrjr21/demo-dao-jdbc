package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class ProgMain {

	public static void main(String[] args) {

		/*
		 * Department obj = new Department(1, "Livros");
		 * 
		 * Seller seller = new Seller(21, "Luiz", "luiz@email.com", new Date(), 7000.0,
		 * obj);
		 */

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- Test 1: Vendedor pelo ID ---");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);
	}

}
