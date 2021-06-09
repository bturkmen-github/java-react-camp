package bturkmen.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bturkmen.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName);
	Product getByProductNameAndCategoryId(String productName,int categoryId);
	List<Product> getByProductNameOrCategoryId(String productName,int categoryId);
	List<Product> getByCategoryIdIn(List<Integer> categories);
	List<Product> getByProductNameContains(String productName);
	List<Product> getByProductNameStartWith(String productName);

	@Query("From Product where productName=:productName and categoryId=:cotegoryId")
	List<Product> getByNameAndCategory(String productName,int categoryId);
	
}