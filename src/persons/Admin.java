package persons;


import java.util.List;

import AML.AML;
import control.Control;


public class Admin extends Person{

	public Admin(String name, String password) {
		super(name, password);
	}

	/**
	 * this method add AML to List in Control class.
	 * @param aml
	 * @return
	 */
	public boolean addAML(AML aml) {
		List<AML> list = Control.getLists();
		
		if(list == null)
			return false;
		list.add(aml);
		return true;
	}
	
	/**
	 * this method search aml.
	 * if serach is correct so update aml.
	 * else return false
	 * @param amlOld
	 * @param amlNew
	 * @return
	 */
	public boolean updateAML(AML amlOld, AML amlNew) {
		List<AML> list = Control.getLists();
		
		if(list == null)
			return false;
		int in = list.indexOf(amlOld);
		if(in != -1) {
			list.remove(in);
			list.add(amlNew);
			return true;
		}
		return false;
	}
}
