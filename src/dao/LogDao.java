package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.LogDom;

@Repository
public class LogDao {
	@Autowired
	JdbcTemplate jdbcTmp;
	
	public void addLog(LogDom log){
		String sql="insert into Log(Datetime,User_id,IP) value(?,?,?)";
		jdbcTmp.update(sql,new Object[]{log.getDatetime(),log.getUserid(),log.getIP()});
	}
}
