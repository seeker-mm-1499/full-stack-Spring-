package com.jdc.jdbc.facotry;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jdc.jdbc.dto.Member;

@Component
public class MapRow implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		var m = new Member(
				rs.getString(1),
				rs.getString(2), 
				rs.getString(3), 
				rs.getString(4), 
				rs.getString(5));
		return m;
	}

}
