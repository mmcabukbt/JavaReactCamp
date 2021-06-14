package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@CrossOrigin
@RequestMapping("/api/products/") /// localhost//api/products için adres
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {

		this.productService = productService;
	}

	@PostMapping("add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}

	@GetMapping("getById") 
	public DataResult<Product> getById(@RequestParam() int productId) {
		return this.productService.getById(productId);
	}

	@GetMapping("getall") 
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}

	@GetMapping("getallSorted")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}

	@GetMapping("getallBypage") // HTTP "GET" isteğinde /getAll adresi için bunu çağır
	public DataResult<List<Product>> getAllPaged(@RequestParam() int pageNo, @RequestParam() int pageSize) {
		return this.productService.getAllPaged(pageNo - 1, pageSize);
	}

	@GetMapping("getbycategoryId")
	public DataResult<List<Product>> getByCategoryId(@RequestParam() int categoryId) {
		return this.productService.getByCategoryId(categoryId);
	}

	@GetMapping("getByProductName")
	public DataResult<Product> getByProductName(@RequestParam() String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam() String productName,
			@RequestParam() int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam() String productName,
			@RequestParam() int categoryId) {
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}

//*
	@GetMapping("getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam() List<Integer> categories) {
		return this.productService.getByCategoryIdIn(categories);
	}// *///

	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam() String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam() String productName) {
		return this.productService.getByProductNameStartsWith(productName);
	}

	@GetMapping("getByNameAndCategoryId")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam() String productName,
			@RequestParam() int categoryId) {
		return this.productService.getByNameAndCategoryId(productName, categoryId);
	}// */////

	@GetMapping("getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}// */////
}