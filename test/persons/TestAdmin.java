package persons;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import AML.AML;
import AML.Anime;
import AML.Genres;
import AML.LightNovel;
import AML.Manga;
import control.Control;

public class TestAdmin {
	
	@Test
	public void testAddAML() {
		
		Admin admin = new Admin("name", "password");
		
		Anime anime = new Anime("OOO", "productionYear", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		Manga manga = new Manga("OOO", "productionYear", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		LightNovel lightNovel = new LightNovel("OOO", "productionYear", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		
		AML amlAdd = new AML(anime, manga, lightNovel);
		
		List<AML> list = Control.getLists();
		int size = list.size();
		
		admin.addAML(amlAdd);
		
		// test for size
		assertEquals(size + 1, list.size());
		
		// test for exist
		int in = list.indexOf(amlAdd);
		assertEquals(amlAdd, list.get(in));
	}

}
