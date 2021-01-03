package persons;

import static org.junit.Assert.assertNotNull;

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
	
}
