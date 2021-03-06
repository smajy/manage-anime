package persons;

import java.util.ArrayList;
import java.util.List;

import AML.AML;
import AML.Anime;
import AML.Grouping;
import AML.LightNovel;
import AML.Manga;
import control.Control;

public class User extends Person {

	public User(String name, String password) {
		super(name, password);
	}

	/**
	 * 
	 * @param aml  is ANIME or MANGA or LIGHTNOVEL
	 * @param m    is Strign require
	 * @param kind is NAME, MANUFACTORNAME, YEARS ,...
	 * @return
	 */
	public AML searchAML(String aml, String m, String kind) {
		if (m == null)
			return null;

		if (aml.equals(AML.ANIME))
			return searchAML(searchAnime(m, kind));

		else if (aml.equals(AML.MANGA))
			return searchAML(searchManga(m, kind));

		else if (aml.equals(AML.LIGHTNOVEL))
			return searchAML(searchLightNovel(m, kind));

		else
			return null;
	}

	public AML searchAML(Anime anime) {
		if (anime == null)
			return null;
		for (AML aml : Control.getLists()) {
			if (aml.getAnime().equals(anime))
				return aml;
		}
		return null;
	}

	public AML searchAML(Manga manga) {
		if (manga == null)
			return null;
		for (AML aml : Control.getLists()) {
			if (aml.getManga().equals(manga))
				return aml;
		}
		return null;
	}

	public AML searchAML(LightNovel lightNovel) {
		if (lightNovel == null)
			return null;
		for (AML aml : Control.getLists()) {
			if (aml.getLightNovel().equals(lightNovel))
				return aml;
		}
		return null;
	}

	public Anime searchAnime(String m, String kind) {
		if (m == null || kind == null)
			return null;
		List<Anime> animes = Control.getAnimes();

		switch (kind) {
		case AML.NAME:
			for (Anime ani : animes) {
				if (m.equalsIgnoreCase(ani.getName()))
					return ani;
			}

		case AML.NAME_MANUFACTURER:
			for (Anime ani : animes) {
				if (m.equalsIgnoreCase(ani.getNameManufacturer()))
					return ani;
			}

		case AML.PRODUCTION_YEAR:
			for (Anime ani : animes) {
				if (m.equalsIgnoreCase(ani.getProductionYear()))
					return ani;
			}

		case AML.IS_END:
			for (Anime ani : animes) {
				if (ani.isEnd()) {
					if (m.equals("true")) {
						return ani;
					}
				} else {
					if (m.equals("false"))
						return ani;
				}
			}

		case AML.MYSCORE:
			for (Anime ani : animes) {
				int s = Integer.parseInt(m);
				if (ani.getMyScore() == s)
					return ani;
			}

		default:
			return null;
		}
	}

	public Manga searchManga(String m, String kind) {
		if (m == null || kind == null)
			return null;
		List<Manga> mangas = Control.getMangas();

		switch (kind) {
		case AML.NAME:
			for (Manga man : mangas) {
				if (m.equalsIgnoreCase(man.getName()))
					return man;
			}
		case AML.NAME_MANUFACTURER:
			for (Manga man : mangas) {
				if (m.equalsIgnoreCase(man.getNameManufacturer()))
					return man;
			}

		case AML.PRODUCTION_YEAR:
			for (Manga man : mangas) {
				if (m.equalsIgnoreCase(man.getProductionYear()))
					return man;
			}

		case AML.IS_END:
			for (Manga man : mangas) {
				if (man.isEnd()) {
					if (m.equals("true")) {
						return man;
					}
				} else {
					if (m.equals("false"))
						return man;
				}
			}

		case AML.MYSCORE:
			for (Manga man : mangas) {
				int s = Integer.parseInt(m);
				if (man.getMyScore() == s)
					return man;
			}

		default:
			return null;

		}
	}

	public LightNovel searchLightNovel(String m, String kind) {
		if (m == null || kind == null)
			return null;
		List<LightNovel> lightNovels = Control.getLightNovels();

		switch (kind) {
		case AML.NAME:
			for (LightNovel light : lightNovels) {
				if (m.equalsIgnoreCase(light.getName()))
					return light;
			}
		case AML.NAME_MANUFACTURER:
			for (LightNovel light : lightNovels) {
				if (m.equalsIgnoreCase(light.getNameManufacturer()))
					return light;
			}

		case AML.PRODUCTION_YEAR:
			for (LightNovel light : lightNovels) {
				if (m.equalsIgnoreCase(light.getProductionYear()))
					return light;
			}

		case AML.IS_END:
			for (LightNovel light : lightNovels) {
				if (light.isEnd()) {
					if (m.equals("true")) {
						return light;
					}
				} else {
					if (m.equals("false"))
						return light;
				}
			}

		case AML.MYSCORE:
			for (LightNovel light : lightNovels) {
				int s = Integer.parseInt(m);
				if (light.getMyScore() == s)
					return light;
			}

		default:
			return null;
		}
	}

	/**
	 * save anime after watch it.
	 * and save score
	 * and save description
	 * @param aml
	 * @param kind
	 * @param myScore
	 * @param description
	 * @return
	 */
	public boolean saveAML(AML aml, String kind, int myScore, String description) {
		if (kind == null || aml == null)
			return false;
		if (kind.equals(AML.ANIME)) {
			Anime anime = aml.getAnime();
			anime.setEnd(true);
			anime.setMyScore(myScore);
			anime.setDescription(description);
			return true;
		} else if (kind.equals(AML.MANGA)) {
			Manga manga = aml.getManga();
			manga.setEnd(true);
			manga.setMyScore(myScore);
			manga.setDescription(description);
			return true;
		} else if (kind.equals(AML.LIGHTNOVEL)) {
			LightNovel lightNovel = aml.getLightNovel();
			lightNovel.setEnd(true);
			lightNovel.setMyScore(myScore);
			lightNovel.setDescription(description);
			return true;
		}
		return false;
	}
	
	/**
	 * delete AML after watch it.
	 * add to list deleted
	 * remove from list amls
	 * @param aml
	 * @param kind
	 * @param myScore
	 * @param description
	 * @return
	 */
	public boolean deleteAML(AML aml, String description) {
		if(aml == null)
			return false;
		Control.getLists().remove(aml);
		aml.getAnime().setDescription(description);
		aml.getManga().setDescription(description);
		aml.getLightNovel().setDescription(description);
		Control.getDeletedAMLs().add(aml);
		return true;
	}
	
	public boolean changeGroup(AML aml, Grouping g) {
		if(aml == null || g == null)
			return false;
		aml.setGroup(g);
		return true;
	}
	
	public List<AML> getAMLGroup(Grouping grouping){
		List<AML> groups = new ArrayList<>();
		List<AML> list = Control.getLists();
		for (AML aml : list) {
			if(aml.getGroup().equals(grouping))
				groups.add(aml);
		}
		return groups;
	}
	
}
