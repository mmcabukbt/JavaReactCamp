package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products") /// localhost//api/products için adres
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall") // HTTP "GET" isteğinde /getAll adresi için bunu çağır
	public List<Product> getAll() {
		return this.productService.getAll();
	}

	@GetMapping("/getbycategoryid")
	@ResponseBody
	public List<Product> getByCategoryId(@RequestParam(defaultValue = "1") String id) {
		return this.productService.getByCategoryId(Integer.parseInt(id));
	}
}