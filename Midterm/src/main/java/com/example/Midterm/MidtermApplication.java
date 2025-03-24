package com.example.Midterm;

import com.example.Midterm.Models.Brand;
import com.example.Midterm.Models.Category;
import com.example.Midterm.Models.Product;
import com.example.Midterm.Services.Originals.BrandService;
import com.example.Midterm.Services.Originals.CategoryService;
import com.example.Midterm.Services.Originals.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MidtermApplication implements CommandLineRunner {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(MidtermApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		* Category
		*/
		System.out.println("================================");
		System.out.println("============Category============");
		Category c1 = new Category(1L, "Category 1");
		Category c2 = new Category(2L, "Category 2");
		Category c3 = Category.builder().name("Category 3").build();
		categoryService.addOne(c1);
		categoryService.addOne(c2);
		categoryService.addOne(c3);
		System.out.println(categoryService.findAll());
		System.out.println(categoryService.findOne(1L));
		c3.setName("Category 100");
		System.out.println(categoryService.updateOne(c3));
		categoryService.deleteOne(2L);
		System.out.println(categoryService.findAll());

		/*
		* Brand
		*/
		System.out.println("=============================");
		System.out.println("============Brand============");
		Brand b1 = new Brand(1L, "Brand 1");
		Brand b2 = new Brand(2L, "Brand 2");
		Brand b3 = Brand.builder().name("Brand 3").build();
		brandService.addOne(b1);
		brandService.addOne(b2);
		brandService.addOne(b3);
		System.out.println(brandService.findAll());
		System.out.println(brandService.findOne(2L));
		b2.setName("Brand 0");
		System.out.println(brandService.updateOne(b2));
		brandService.deleteOne(2L);
		System.out.println(brandService.findAll());

		/*
		 * Product
		 */
		System.out.println("===============================");
		System.out.println("============Product============");
		Product p1 = Product.builder().category(c1).name("Product 1").price(31222.0).brand(b1).color("red").build();
		Product p2 = new Product(c3, 2L, "Product 2", 125000.422, b1, "green");
		Product p3 = new Product(c3, 3L, "Product 3", 16.0, b3, "blue");
		System.out.println(productService.addOne(p1));
		productService.addOne(p2);
		productService.addOne(p3);
		System.out.println(productService.findAll());
		System.out.println(productService.findOne(1L));
		p3.setCategory(c1);
		productService.updateOne(p3);
		productService.deleteOne(1L);
		System.out.println(productService.findAll());
	}
}
