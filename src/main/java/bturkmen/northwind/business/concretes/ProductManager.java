package bturkmen.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bturkmen.northwind.business.abstracts.ProductService;
import bturkmen.northwind.core.utilities.results.DataResult;
import bturkmen.northwind.core.utilities.results.Result;
import bturkmen.northwind.core.utilities.results.SuccessDataResult;
import bturkmen.northwind.core.utilities.results.SuccessResult;
import bturkmen.northwind.dataAccess.abstracts.ProductDao;
import bturkmen.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"Data Listelendi");
		
		//return this.productDao.findAll();
	}

	@Override
	public Result add(Product product) {
		
		this.productDao.save(product);		
		return new SuccessResult("Ürün Eklendi");
	}

	
}
