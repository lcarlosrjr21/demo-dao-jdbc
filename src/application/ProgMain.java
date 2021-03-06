package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgMain {

	public static void main(String[] args) {

		/*
		 * Department obj = new Department(1, "Livros");
		 * 
		 * Seller seller = new Seller(21, "Luiz", "luiz@email.com", new Date(), 7000.0,
		 * obj);
		 */
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("--- Test 1: Vendedor pelo ID ---");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n--- Test 2: Vendedor pelo DepartmentID ---");
		Department department = new Department(2, null); // instanciando objeto do tipo departament e informando o id

		List<Seller> list = sellerDao.findByDepartment(department); // instanciando uma lista para trazer eventuais
																	// seller de department

		for (Seller obj : list) {
			System.out.println(obj); // imprimindo a lista de seller do department
		}

		System.out.println("\n--- Test 3: Todos vendedores ---");
		list = sellerDao.findAll(); // lista com todos vendedores
		for (Seller obj : list) {
			System.out.println(obj); // imprimindo a lista de sellers (vendedores)
		}
		
		System.out.println("\n--- Test 4: teste insert ---");
		Seller novoVendedor = new Seller(null, "Carlos", "carlos@email.com", new Date(), 9999.0, department);
		sellerDao.insert(novoVendedor);
		System.out.println("Insert Novo id = " + novoVendedor.getId());
		
		System.out.println("\n--- Test 5: teste update ---");
		seller = sellerDao.findById(1);
		seller.setName("Margareth Brown");
		seller.setEmail("margareth@email.com");
		sellerDao.update(seller);
		System.out.println("Update executado!!!");	
		
		System.out.println("\n--- Test 6: teste delete ---");
		System.out.print("Entre com id do vendedor para apagar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Apagar completado!!!");
		sc.close();
	}
}