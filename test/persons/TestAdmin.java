package persons;

import static org.junit.Assert.assertNotNull;
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

	@Test
	public void testUpdateAML() {
		
		Admin admin = new Admin("name", "password");
		
		// aml add to list
		Anime anime = new Anime("OOO", "productionYear", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		Manga manga = new Manga("OOO", "productionYear", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		LightNovel lightNovel = new LightNovel("OOO", "productionYear", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		AML amlOld = new AML(anime, manga, lightNovel);
		admin.addAML(amlOld);

		// aml update in list
		anime = new Anime("OOO", "pY", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		manga = new Manga("OOO", "productionYear", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		lightNovel = new LightNovel("OOO", "productionYear", "nameManufacturer", true, 5, 5, Genres.ACTION, null, "");
		AML amlNew = new AML(anime, manga, lightNovel);
		
		List<AML> list = Control.getLists();
		int size = list.size();
		admin.updateAML(amlOld, amlNew);
		
		assertEquals(size, list.size());
		
		int in = list.indexOf(amlNew);
		AML aml = list.get(in);
		assertNotNull(aml);
		assertEquals(aml.getAnime().getNameManufacturer(), amlNew.getAnime().getNameManufacturer());
		
	}
}
