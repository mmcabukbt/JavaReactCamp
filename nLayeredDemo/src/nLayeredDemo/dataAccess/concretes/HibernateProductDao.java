package nLayeredDemo.dataAccess.concretes;

import java.util.List;

import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;

public class HibernateProductDao implements ProductDao {

	@Override
	public void add(Product produc) {
		System.out.println("<HibernateProductDao> Hibernate ile eklendi : " + produc.getName());		
	}

	@Override
	public void update(Product produc) {
		System.out.println("Hibernate ile güncellendi");		
	}

	@Override
	public void delete(Product produc) {
		System.out.println("Hibernate ile silindi");	
	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}