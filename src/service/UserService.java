package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LogDao;
import dao.UserDao;
import domain.LogDom;
import domain.UserDom;

@Service
public class UserService {
	@Autowired
	private UserDao user;
	
	@Autowired
	private LogDao log;
	
	public boolean hasMatchUser(String username,String password){
		return user.getMatchCount(username, password)>0;
	}
	
	public UserDom findUserByUserName(String username){
		return user.findUserByUsername(username);
	}
	
	public void logSuccess(UserDom user){
		user.setCredit(user.getCredit()+5);
		LogDom log=new LogDom();
		log.setDatetime(user.getDatetime());
		log.setUserId(user.getId());
		log.setIP(user.getIP());
		this.user.updateLogInfo(user);
		this.log.addLog(log);
	}
}
