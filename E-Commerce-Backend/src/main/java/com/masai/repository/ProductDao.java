package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.models.CategoryEnum;
import com.masai.models.Product;
import com.masai.models.ProductDTO;
import com.masai.models.ProductStatus;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
	
<<<<<<< HEAD
<<<<<<< HEAD
	@Query("select new com.masai.models.ProductDTO(p.productName,p.manufacturer,p.price) "
=======
	@Query("select new com.masai.models.ProductDTO(p.productName,p.manufacturer,p.price,p.quantity) "
>>>>>>> main
=======
	@Query("select new com.masai.models.ProductDTO(p.productName,p.manufacturer,p.price,p.quantity) "
>>>>>>> main
			+ "from Product p where p.category=:catenum")
	public List<ProductDTO> getAllProductsInACategory(@Param("catenum") CategoryEnum catenum);
	
	
<<<<<<< HEAD
<<<<<<< HEAD
	@Query("select new com.masai.models.ProductDTO(p.productName,p.manufacturer,p.price) "
=======
	@Query("select new com.masai.models.ProductDTO(p.productName,p.manufacturer,p.price,p.quantity) "
>>>>>>> main
=======
	@Query("select new com.masai.models.ProductDTO(p.productName,p.manufacturer,p.price,p.quantity) "
>>>>>>> main
			+ "from Product p where p.status=:status")
	public List<ProductDTO> getProductsWithStatus(@Param("status") ProductStatus status);
	

}
