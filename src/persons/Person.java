package persons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Person {

	private String name;
	private String password;

	public Person(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * this method is read file and save admin and user data.
	 * 
	 * @param person
	 * @return boolean. true, mean this person is registered.
	 */
	public boolean register(Person person) {

		try {
			File file = new File("../requireData/admin-user");

			Scanner scanner = new Scanner(file);
			FileWriter writer = new FileWriter(file);

			String adminData = scanner.nextLine();
			String userData = scanner.nextLine();

			if (person instanceof Admin) {
				adminData = "admin = " + person.getName() + "#" + person.getPassword();

			} else if (person instanceof User) {
				userData = "User = " + person.getName() + "#" + person.getPassword();
			}

			writer.write(adminData);
			writer.write("/n");
			writer.write(userData);

			scanner.close();
			writer.close();
			return true;
		} catch (IOException e1) {
			System.out.println("file data admin and user does not open");
		}
		return false;

	}

	/**
	 * this method is read file and control for equal admin and user data.
	 * 
	 * @param person
	 * @return boolean. true, mean this person is logined.
	 */
	public boolean login(Person person) {

		try {
			boolean login = false;
			File file = new File("../requireData/admin-user");
			Scanner scanner = new Scanner(file);

			String adminData = scanner.nextLine();
			String[] admin = adminData.substring(adminData.indexOf("=")).trim().split("#");

			String userData = scanner.nextLine();
			String[] user = userData.substring(userData.indexOf("=")).trim().split("#");

			if (person instanceof Admin) {
				if (person.getName().equalsIgnoreCase(admin[0]) && person.getPassword().equalsIgnoreCase(admin[1]))
					login = true;
			} else if (person instanceof User) {
				if (person.getName().equalsIgnoreCase(user[0]) && person.getPassword().equalsIgnoreCase(user[1]))
					login = true;
			}

			scanner.close();
			return login;

		} catch (FileNotFoundException e) {
			System.out.println("file data admin and user does not open");
		}

		return false;

	}

}
