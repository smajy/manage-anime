package persons;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPerson {

	@Test
	public void controlPerson() {
		Person person = new Person("Person", "passperson");
		Admin admin = new Admin("admin", "passwordAdmin");
		User user = new User("user", "passwordUser");
		
		assertNotNull(person);
		assertNotNull(admin);
		assertNotNull(user);
		
	}

	@Test
	public void TestLoging() {
		Admin admin = new Admin("admin", "admin");
		assertTrue(admin.login(admin));
		
		Admin adminFake = new Admin("fake", "fake");
		assertFalse(adminFake.login(adminFake));
		
		User user = new User("user", "user");
		assertTrue(user.login(user));
		
		User userFake = new User("fake", "fake");
		assertFalse(userFake.login(userFake));
		
		
	}


	@Test
	public void TestRegisterd() {
		Admin admin = new Admin("admin", "admin");
		admin.register(admin);
		
		User user = new User("user", "user");
		user.register(user);
	
	}
}
