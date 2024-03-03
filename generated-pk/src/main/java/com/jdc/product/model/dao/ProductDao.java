package com.jdc.product.model.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.jdc.product.model.dto.Product;
import com.jdc.product.model.dto.Product.ProductDto;

@Repository
public class ProductDao {
	
	private RowMapper<ProductDto> rowMapper ;
	
	public ProductDao() {
		rowMapper = new BeanPropertyRowMapper<ProductDto>(ProductDto.class);
	}

	@Autowired
	private NamedParameterJdbcOperations jdbc;
	
	@Value("${dao.product.update}")
	private String update;
	@Value("${dao.product.delete}")
	private String delete;
	@Value("${dao.product.findById}")
	private String findById;
	@Value("${dao.product.findByCategoryId}")
	private String findByCategoryId;
	@Value("${dao.product.search}")
	private String search;
	
	@Value("${dao.product.create}")
	private String create;

	
	public int create(Product p) {
		
		var params = new MapSqlParameterSource();
		params.addValue("name", p.getName());
		params.addValue("categoryId", p.getCategory().getId());
		params.addValue("price", p.getPrice());
		
		var key= new GeneratedKeyHolder();
		jdbc.update(create, params, key);
		return key.getKey().intValue();
	}


	public Product findById(int id) {
		var params = new HashMap<String, Object>();
		params.put("id", id);
		return jdbc.queryForStream(findById, params, rowMapper).findFirst().orElseGet(()-> null);
	}


	public List<Product> findByCategoryId(int categoryId) {
		var params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		return  jdbc.queryForStream(findByCategoryId, params, rowMapper).map(ProductDto::toProduct).toList();
	}


	public int update(Product p) {
		var params = new MapSqlParameterSource();
		params.addValue("id", p.getId());
		params.addValue("name", p.getName());
		params.addValue("price", p.getPrice());
		
		return jdbc.update(update, params);
	}


	public int deleteById(int id) {
		var params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return jdbc.update(delete, params);
	}


	public List<Product> search(String keyword) {
		var params = new HashMap<String, Object>();
		params.put("keyword", keyword.toLowerCase().concat("%"));
		return jdbc.queryForStream(search, params, rowMapper).map(ProductDto::toProduct).toList();
	}
}
