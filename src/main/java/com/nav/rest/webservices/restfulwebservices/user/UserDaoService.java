package com.nav.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class UserDaoService {
	
	private static List<User> users=new ArrayList<>();
	private static int userCount=0;
	
	static {
		users.add(new User(++userCount,"Navaraj",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Nitant",LocalDate.now().minusYears(15)));
		users.add(new User(++userCount,"Nivan",LocalDate.now().minusYears(5)));
	}

	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate=user->(user.getId().equals(id));
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	public void deleteById(int id) {
		Predicate<? super User> predicate=user->(user.getId().equals(id));
		users.removeIf(predicate);
	}
}
