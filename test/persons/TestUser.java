package persons;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import AML.AML;
import AML.Anime;
import AML.Genres;
import AML.LightNovel;
import AML.Manga;
import control.Control;

public class TestUser {
	
	@Test
	public void testSaveAML() {
		User user = new User("name", "password");
	
		Anime anime = new Anime("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		Manga manga = new Manga("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		LightNovel lightNovel = new LightNovel("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		AML aml = new AML(anime, manga, lightNovel);
		List<AML> list = Control.getLists();
		list.add(aml);
		
		assertFalse(user.saveAML(null, AML.ANIME, 2, "this is good"));
		assertFalse(user.saveAML(aml, "s", 2, "this is good"));
		
		assertTrue(user.saveAML(aml, AML.ANIME, 8, "this is good"));
		AML aml2 = list.get(0);
		assertTrue(aml2.getAnime().isEnd());
		assertEquals("this is good", aml2.getAnime().getDescription());
		assertEquals(8, aml2.getAnime().getMyScore());
	}
	
	@Test
	public void testdeleteAML() {
		User user = new User("name", "password");
	
		Anime anime = new Anime("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		Manga manga = new Manga("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		LightNovel lightNovel = new LightNovel("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		AML aml = new AML(anime, manga, lightNovel);
		List<AML> list = Control.getLists();
		list.add(aml);
		
		assertFalse(user.deleteAML(null, "this is bad"));
		
		assertTrue(user.deleteAML(aml, "this is bad"));
		assertTrue(list.isEmpty());
		assertEquals(Control.getDeletedAMLs().get(0), aml);
	}

}
