package persons;


import java.util.List;

import AML.AML;
import control.Control;


public class Admin extends Person{

	public Admin(String name, String password) {
		super(name, password);
	}

	public boolean addAML(AML aml) {
		List<AML> list = Control.getLists();
		
		if(list == null)
			return false;
		list.add(aml);
		return true;
	}
}
