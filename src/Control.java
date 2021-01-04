import java.util.ArrayList;
import java.util.List;

import AML.AML;

public class Control {

	// save list AMLs
	private static List<AML> lists;
	
	// TODO Load list AML in ???
	static {
		lists = new ArrayList<>();
	}
	
	public static List<AML> getLists() {
		return lists;
	}
}
