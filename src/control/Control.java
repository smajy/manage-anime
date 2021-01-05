package control;

import java.util.ArrayList;
import java.util.List;

import AML.AML;
import AML.Anime;
import AML.LightNovel;
import AML.Manga;

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
	
	public static List<Anime> getAnimes(){
		List<Anime> list = new ArrayList<>();
		for(AML aml : lists) {
			list.add(aml.getAnime());
		}
		return list;
	}

	public static List<Manga> getMangas(){
		List<Manga> list = new ArrayList<>();
		for(AML aml : lists) {
			list.add(aml.getManga());
		}
		return list;
	}
	
	public static List<LightNovel> getLightNovels(){
		List<LightNovel> list = new ArrayList<>();
		for(AML aml : lists) {
			list.add(aml.getLightNovel());
		}
		return list;
	}
}
