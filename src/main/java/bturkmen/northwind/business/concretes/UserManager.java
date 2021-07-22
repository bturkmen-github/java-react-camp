package bturkmen.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bturkmen.northwind.business.abstracts.UserService;
import bturkmen.northwind.core.dataAccess.UserDao;
import bturkmen.northwind.core.entities.User;
import bturkmen.northwind.core.utilities.results.DataResult;
import bturkmen.northwind.core.utilities.results.Result;
import bturkmen.northwind.core.utilities.results.SuccessDataResult;
import bturkmen.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	UserDao userDao;
		
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı Bulundu");
	}

}
