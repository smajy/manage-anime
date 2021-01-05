package persons.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import AML.AML;
import AML.Anime;
import AML.Genres;
import AML.LightNovel;
import AML.Manga;
import control.Control;
import persons.User;

public class Search {

	@BeforeClass
	public static void InitilazeListAMLS() {
		List<AML> list = Control.getLists();

		// 1
		Anime anime = new Anime("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		Manga manga = new Manga("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		LightNovel lightNovel = new LightNovel("1", "12", "AS", true, 50, 50, Genres.ACTION, null, "");
		AML aml1 = new AML(anime, manga, lightNovel);
		// 2
		Anime anime2 = new Anime("2", "24", "ASD", false, 51, 51, Genres.ACTION, null, "");
		Manga manga2 = new Manga("2", "24", "ASD", false, 51, 51, Genres.ACTION, null, "");
		LightNovel lightNovel2 = new LightNovel("2", "24", "ASD", false, 51, 51, Genres.ACTION, null, "");
		AML aml2 = new AML(anime2, manga2, lightNovel2);
		// 3
		Anime anime3 = new Anime("3", null, "zx", true, 5, 5, Genres.ACTION, null, "");
		Manga manga3 = new Manga("3", null, "zx", true, 5, 5, Genres.ACTION, null, "");
		LightNovel lightNovel3 = new LightNovel("3", null, "zx", true, 5, 5, Genres.ACTION, null, "");
		AML aml3 = new AML(anime3, manga3, lightNovel3);
		// 4
		Anime anime4 = new Anime("4", "3", "c", true, 53, 53, Genres.ACTION, null, "");
		Manga manga4 = null;
		LightNovel lightNovel4 = new LightNovel("4", "3", "c", true, 53, 53, Genres.ACTION, null, "");
		AML aml4 = new AML(anime4, manga4, lightNovel4);

		// 5
		Anime anime5 = new Anime("5", "213", "e", true, 55, 55, Genres.ACTION, null, "");
		Manga manga5 = new Manga("5", "213", "e", true, 55, 55, Genres.ACTION, null, "");
		LightNovel lightNovel5 = new LightNovel("5", "213", "e", true, 55, 55, Genres.ACTION, null, "");
		AML aml5 = new AML(anime5, manga5, lightNovel5);

		list.add(aml1);
		list.add(aml2);
		list.add(aml3);
		list.add(aml4);
		list.add(aml5);
		assertEquals(5, Control.getLists().size());

	}

	@Test
	public void TestSearchAnime() {
		// name
		User user = new User("name", "password");
		assertNull(user.searchAnime(null, AML.NAME));
		assertNull(user.searchAnime("sa", null));
		assertNull(user.searchAnime("sa", "as"));		
		
		Anime anime = user.searchAnime("3", AML.NAME);
		assertNotNull(anime);
		assertEquals(anime.getProductionYear(), null);

		Anime animeFake = user.searchAnime("10", AML.NAME);
		assertNull(animeFake);

		// productio year
		anime = user.searchAnime("213", AML.PRODUCTION_YEAR);
		assertNotNull(anime);
		assertEquals(anime.getNameManufacturer(), "e");

		animeFake = user.searchAnime("10", AML.PRODUCTION_YEAR);
		assertNull(animeFake);

		// facture name
		anime = user.searchAnime("ASD", AML.NAME_MANUFACTURER);
		assertNotNull(anime);
		assertEquals(anime.getName(), "2");

		animeFake = user.searchAnime("10", AML.NAME_MANUFACTURER);
		assertNull(animeFake);

		// is end
		anime = user.searchAnime("true", AML.IS_END);
		assertNotNull(anime);
		assertEquals(anime.getName(), "1");

		animeFake = user.searchAnime("10", AML.IS_END);
		assertNull(animeFake);
		// is end ture
		anime = user.searchAnime("true", AML.IS_END);
		assertNotNull(anime);
		assertEquals(anime.getName(), "1");

		animeFake = user.searchAnime("10", AML.IS_END);
		assertNull(animeFake);
		// is end false
		anime = user.searchAnime("false", AML.IS_END);
		assertNotNull(anime);
		assertEquals(anime.getName(), "2");

		animeFake = user.searchAnime("10", AML.IS_END);
		assertNull(animeFake);

		// score
		anime = user.searchAnime("5", AML.MYSCORE);
		assertNotNull(anime);
		assertEquals(anime.getName(), "3");

		animeFake = user.searchAnime("10", AML.IS_END);
		assertNull(animeFake);
	}

	@Test
	public void TestSearchManga() {
		// name
		User user = new User("name", "password");
		Manga manga = user.searchManga("3", AML.NAME);
		assertNotNull(manga);
		assertEquals(manga.getProductionYear(), null);

		Manga mangaFake = user.searchManga("10", AML.NAME);
		assertNull(mangaFake);

		// productio year
		manga = user.searchManga("213", AML.PRODUCTION_YEAR);
		assertNotNull(manga);
		assertEquals(manga.getNameManufacturer(), "e");

		mangaFake = user.searchManga("10", AML.PRODUCTION_YEAR);
		assertNull(mangaFake);

		// facture name
		manga = user.searchManga("ASD", AML.NAME_MANUFACTURER);
		assertNotNull(manga);
		assertEquals(manga.getName(), "2");

		mangaFake = user.searchManga("10", AML.NAME_MANUFACTURER);
		assertNull(mangaFake);

		// is end
		manga = user.searchManga("true", AML.IS_END);
		assertNotNull(manga);
		assertEquals(manga.getName(), "1");

		mangaFake = user.searchManga("10", AML.IS_END);
		assertNull(mangaFake);
		// is end ture
		manga = user.searchManga("true", AML.IS_END);
		assertNotNull(manga);
		assertEquals(manga.getName(), "1");

		mangaFake = user.searchManga("10", AML.IS_END);
		assertNull(mangaFake);
		// is end false
		manga = user.searchManga("false", AML.IS_END);
		assertNotNull(manga);
		assertEquals(manga.getName(), "2");

		mangaFake = user.searchManga("10", AML.IS_END);
		assertNull(mangaFake);

		// score
		manga = user.searchManga("5", AML.MYSCORE);
		assertNotNull(manga);
		assertEquals(manga.getName(), "3");

		mangaFake = user.searchManga("10", AML.IS_END);
		assertNull(mangaFake);
	}

	@Test
	public void TestSearchLightNovel() {
		// name
		User user = new User("name", "password");
		LightNovel lightNovel = user.searchLightNovel("3", AML.NAME);
		assertNotNull(lightNovel);
		assertEquals(lightNovel.getProductionYear(), null);

		LightNovel lightNovelFake = user.searchLightNovel("10", AML.NAME);
		assertNull(lightNovelFake);

		// productio year
		lightNovel = user.searchLightNovel("213", AML.PRODUCTION_YEAR);
		assertNotNull(lightNovel);
		assertEquals(lightNovel.getNameManufacturer(), "e");

		lightNovelFake = user.searchLightNovel("10", AML.PRODUCTION_YEAR);
		assertNull(lightNovelFake);

		// facture name
		lightNovel = user.searchLightNovel("ASD", AML.NAME_MANUFACTURER);
		assertNotNull(lightNovel);
		assertEquals(lightNovel.getName(), "2");

		lightNovelFake = user.searchLightNovel("10", AML.NAME_MANUFACTURER);
		assertNull(lightNovelFake);

		// is end
		lightNovel = user.searchLightNovel("true", AML.IS_END);
		assertNotNull(lightNovel);
		assertEquals(lightNovel.getName(), "1");

		lightNovelFake = user.searchLightNovel("10", AML.IS_END);
		assertNull(lightNovelFake);
		// is end ture
		lightNovel = user.searchLightNovel("true", AML.IS_END);
		assertNotNull(lightNovel);
		assertEquals(lightNovel.getName(), "1");

		lightNovelFake = user.searchLightNovel("10", AML.IS_END);
		assertNull(lightNovelFake);
		// is end false
		lightNovel = user.searchLightNovel("false", AML.IS_END);
		assertNotNull(lightNovel);
		assertEquals(lightNovel.getName(), "2");

		lightNovelFake = user.searchLightNovel("10", AML.IS_END);
		assertNull(lightNovelFake);

		// score
		lightNovel = user.searchLightNovel("5", AML.MYSCORE);
		assertNotNull(lightNovel);
		assertEquals(lightNovel.getName(), "3");

		lightNovelFake = user.searchLightNovel("10", AML.IS_END);
		assertNull(lightNovelFake);
	}
}
