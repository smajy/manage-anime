package persons;

import java.util.List;

import AML.AML;
import AML.Anime;
import AML.LightNovel;
import AML.Manga;
import control.Control;

public class User extends Person {

	public User(String name, String password) {
		super(name, password);
	}

	/**
	 *  
	 * @param aml is ANIME or MANGA or LIGHTNOVEL
	 * @param m is Strign require
	 * @param kind is NAME, MANUFACTORNAME, YEARS ,...
	 * @return
	 */
	public AML searchAML(String aml, String m, String kind) {
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

		List<Anime> animes = Control.getAnimes();

		switch (kind) {
		case AML.NAME:
			for (Anime ani : animes) {
				if (ani.getName().equalsIgnoreCase(m))
					return ani;
			}
			return null;
		case AML.NAME_MANUFACTURER:
			for (Anime ani : animes) {
				if (ani.getNameManufacturer().equalsIgnoreCase(m))
					return ani;
			}
			return null;

		case AML.PRODUCTION_YEAR:
			for (Anime ani : animes) {
				if (ani.getProductionYear().equalsIgnoreCase(m))
					return ani;
			}
			return null;

		case AML.IS_END:
			for (Anime ani : animes) {
				if (ani.isEnd()) {
					if (m.equals("true")) {
						return ani;
					}
				}
			}
			return null;

		case AML.MYSCORE:
			for (Anime ani : animes) {
				int s = Integer.parseInt(m);
				if (ani.getMyScore() == s)
					return ani;
			}
			return null;

		default:
			return null;
		}
	}

	public Manga searchManga(String m, String kind) {
		List<Manga> animes = Control.getMangas();

		switch (kind) {
		case AML.NAME:
			for (Manga ani : animes) {
				if (ani.getName().equalsIgnoreCase(m))
					return ani;
			}
			return null;
		case AML.NAME_MANUFACTURER:
			for (Manga ani : animes) {
				if (ani.getNameManufacturer().equalsIgnoreCase(m))
					return ani;
			}
			return null;

		case AML.PRODUCTION_YEAR:
			for (Manga ani : animes) {
				if (ani.getProductionYear().equalsIgnoreCase(m))
					return ani;
			}
			return null;

		case AML.IS_END:
			for (Manga ani : animes) {
				if (ani.isEnd()) {
					if (m.equals("true")) {
						return ani;
					}
				}
			}
			return null;

		case AML.MYSCORE:
			for (Manga ani : animes) {
				int s = Integer.parseInt(m);
				if (ani.getMyScore() == s)
					return ani;
			}
			return null;

		default:
			return null;
		}
	}

	public LightNovel searchLightNovel(String m, String kind) {
		List<LightNovel> lightNovels = Control.getLightNovels();
		
		switch (kind) {
		case AML.NAME:
			for(LightNovel light : lightNovels) {
				if(light.getName().equalsIgnoreCase(m))
					return light;
			}
			return null;
		case AML.NAME_MANUFACTURER:
			for(LightNovel light : lightNovels) {
				if(light.getNameManufacturer().equalsIgnoreCase(m))
					return light;
			}
			return null;

		case AML.PRODUCTION_YEAR:
			for(LightNovel light : lightNovels) {
				if(light.getProductionYear().equalsIgnoreCase(m))
					return light;
			}
			return null;

		case AML.IS_END:
			for(LightNovel light : lightNovels) {
				if(light.isEnd()) {
					if (m.equals("true")) {
						return light;
					}
				}
			}
			return null;

		case AML.MYSCORE:
			for(LightNovel light : lightNovels) {
				int s = Integer.parseInt(m);
				if(light.getMyScore() == s)
					return light;
			}
			return null;

		default:
			return null;
		}
	}
}
