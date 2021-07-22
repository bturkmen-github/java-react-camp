package bturkmen.northwind.business.abstracts;

import bturkmen.northwind.core.entities.User;
import bturkmen.northwind.core.utilities.results.DataResult;
import bturkmen.northwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
