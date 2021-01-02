package AML;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestAML {

	@Test
	public void testAllAML() {
		Anime anime = new Anime("One Piece", "1999", "", false, 7.5, 8.75, Genres.ACTION, null, null);
		Manga manga = new Manga("One Piece", "1999", "", false, 7.5, 8.75, Genres.ACTION, null, null);
		LightNovel lightNovel = null;
		
		assertNotNull(anime);
		assertNotNull(manga);
		assertNull(lightNovel);
		
		assertEquals(Genres.ACTION, anime.getGeneres());
		
		AML aml = new AML(anime, manga, lightNovel);
		assertNotNull(aml);
	}
}
