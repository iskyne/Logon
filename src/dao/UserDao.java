package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import domain.LogDom;
import domain.UserDom;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTmp;
	
	public int getMatchCount(String name,String password){
		String sql="select count(*) from user where Name=? and Password=?";
		
		return jdbcTmp.queryForObject(sql, new Object[]{name,password},Integer.class);
	}
	
	public UserDom findUserByUsername(final String username){
		String sql="select * from myspring1.user where Name = ? ";
		final UserDom user=new UserDom();
		jdbcTmp.query(sql, new Object[]{username}, new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException{
				user.setName(username);
				user.setCredit(rs.getInt(4));
				user.setPassword(rs.getString(3));
			}
		});
		return user;
	}
	
	public void updateLogInfo(UserDom user){
		String sql="update user set Credit = ? and Last_Visit = ? and Last_Ip = ? where Name = ?";
		jdbcTmp.update(sql, new Object[]{user.getCredit(),user.getDatetime(),user.getIP(),user.getName()});
	}
}
