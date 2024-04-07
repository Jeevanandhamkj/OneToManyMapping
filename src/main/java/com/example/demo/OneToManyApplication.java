package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Product;
import com.example.demo.Repo.CustomerRepo;
import com.example.demo.Repo.ProductRepo;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {
@Autowired
CustomerRepo customerRepo;
@Autowired
ProductRepo productRepo;
	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1=new Customer();
		c1.setId(1);
		c1.setName("jeeva");
		
		Product p1=new Product();
		p1.setId(1);
		p1.setProductname("mobile");
		p1.setPrice(15000);
		p1.setQuantity(1);
		
		Product p2=new Product();
		p2.setId(2);
		p2.setProductname("Tv");
		p2.setPrice(25000);
		p2.setQuantity(2);
		
		c1.getProducts().add(p1);
		c1.getProducts().add(p2);
		
		customerRepo.save(c1);
		
		Customer c2=new Customer();
		c2.setId(2);
		c2.setName("sachin");
		
		
		
		Product p3=new Product();
		p3.setId(3);
		p3.setProductname("Watch");
		p3.setPrice(5000);
		p3.setQuantity(4);
		
	
		c2.getProducts().add(p3);
		productRepo.save(p3);
		
		Customer c3=new Customer();
		c3.setName("Ajith");
		customerRepo.save(c3);// Save the Customer before associating Products
		
		
		Product p4=new Product();
		p4.setId(4);
		p4.setProductname("AirPods");
		p4.setPrice(5000);
		p4.setQuantity(40);
		p4.setCustomer(c3);// Associate with the persisted Customer
		productRepo.save(p4);
		
		Product p5=new Product();
		p5.setId(5);
		p5.setProductname("PowerBank");
		p5.setPrice(2000);
		p5.setQuantity(4);
		p5.setCustomer(c3);// Associate with the same persisted Customer
		productRepo.save(p5);
	
//		c3.getProducts().add(p4);
//		c3.getProducts().add(p5);
		
		
		
		
		
		
	}

}
