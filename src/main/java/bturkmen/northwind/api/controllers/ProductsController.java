package bturkmen.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bturkmen.northwind.business.abstracts.ProductService;
import bturkmen.northwind.core.utilities.results.DataResult;
import bturkmen.northwind.core.utilities.results.Result;
import bturkmen.northwind.entities.concretes.Product;
import bturkmen.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){		
		return this.productService.getAll();		
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}	
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,int categoryId){
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	
	/*
	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories){
		return this.productService.getByCategoryIdIn(categories);
	}
	
	
	
	@GetMapping("/getByProductNameStartWith")
	public DataResult<List<Product>> getByProductNameStartWith(@RequestParam String productName){
		return this.productService.getByProductNameStartWith(productName);
	}
	
	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,int categoryId){
		return this.productService.getByNameAndCategory(productName, categoryId);
	}
	*/
	
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){		
		return this.productService.getProductWithCategoryDetails();		
	}
	
}
