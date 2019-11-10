package dz.acs.si.demo1.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("typeFactureRowMapper")
public class TypeFactureRowMapper implements RowMapper<TypeFacture>{

	@Override
	public TypeFacture mapRow(ResultSet rs, int rowNum) throws SQLException {
		TypeFacture res = TypeFacture.NULL;
		res  = new TypeFacture(rs.getInt(1),rs.getString(2),
				rs.getString(3),rs.getInt(4));
		return res;
	}
}
