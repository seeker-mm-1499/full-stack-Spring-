package com.jdc.product.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
/*import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;*/
import org.springframework.stereotype.Service;

import com.jdc.product.model.dto.Category;

@Service
public class CategoryDao {
	
	@Autowired
	private SimpleJdbcInsert insert;
	
	private BeanPropertyRowMapper<Category> rowMapper;
	
	public CategoryDao() {
		rowMapper = new BeanPropertyRowMapper<Category>(Category.class);
	}
	
	@Value("${dao.category.update}")
	private String update;
	
	@Value("${dao.category.findById}")
	private String findById;
	
	@Value("${dao.category.findByNameLike}")
	private String findByNameLike;
	
	@Value("${dao.category.findCountByNameLike}")
	private String findCountByNameLike;
	
	@Value("${dao.category.deleteById}")
	private String deleteById;
	
	
	
	public int create(Category c) {
		
		Map<String, Object> params  = new HashMap<>();
		
		params.put("name", c.getName());
		
		return insert.executeAndReturnKey(params).intValue();
	}

	public int update(Category c) {
		return insert.getJdbcTemplate().update(update, c.getName(),c.getId());
	}

	public Category findById(int id) {
		return insert.getJdbcTemplate().queryForObject(findById, rowMapper, id);
	}

	public List<Category> findByNameLike(String name) {
		return insert.getJdbcTemplate().query(findByNameLike, rowMapper, 
				name.toLowerCase().concat("%"));
	}

	public int deleteById(int id) {
		return insert.getJdbcTemplate().update(deleteById, id);
	}

	public int findCountByNameLike(String name) {
		return insert.getJdbcTemplate().queryForObject(findCountByNameLike, 
				Integer.class, name.toLowerCase().concat("%"));
	}

	

	/*
	 * @Autowired private JdbcOperations jdbc;
	 * 
	 * @Autowired private PreparedStatementCreatorFactory factory;
	 * 
	 * public int create(Category c) { var creator =
	 * factory.newPreparedStatementCreator(List.of(c.getName()));
	 * factory.setReturnGeneratedKeys(true);
	 * 
	 * GeneratedKeyHolder keyholder = new GeneratedKeyHolder();
	 * 
	 * jdbc.update(creator, keyholder); return keyholder.getKey().intValue(); }
	 */
}
