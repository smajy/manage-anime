package AML;

/**
 * 
 * @author smajy this is AML. means Aniem and Manga and Light Novel. this is all
 *         of them. anime create from manga. manga create from lightnovel. if
 *         save anime, I shoud save manga and light novel.
 */
public class AML {
	
	public static final String ANIME = "anime";
	public static final String MANGA = "manga";
	public static final String LIGHTNOVEL = "lightNovel";
	
	public static final String NAME = "name";
	public static final String PRODUCTION_YEAR = "productionYear";
	public static final String NAME_MANUFACTURER = "nameManufacturer";
	public static final String IS_END = "isEnd";
	public static final String MYSCORE = "myScore";
	public static final String GENERS = "genres";
	
	
	private Anime anime;
	private Manga manga;
	private LightNovel lightNovel;
	private Grouping group;

	public AML(Anime anime, Manga manga, LightNovel lightNovel) {
		super();
		this.anime = anime;
		this.manga = manga;
		this.lightNovel = lightNovel;
		this.group = Grouping.NEXT;
	}

	public AML(Anime anime, Manga manga, LightNovel lightNovel , Grouping grouping) {
		super();
		this.anime = anime;
		this.manga = manga;
		this.lightNovel = lightNovel;
		this.group = grouping;
	}

	public Anime getAnime() {
		return anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	public LightNovel getLightNovel() {
		return lightNovel;
	}

	public void setLightNovel(LightNovel lightNovel) {
		this.lightNovel = lightNovel;
	}
	
	public Grouping getGroup() {
		return group;
	}
	public void setGroup(Grouping group) {
		this.group = group;
	}

	/**
	 * equal AML: (this)anime == (other)anime && (this)manga == (other)manga &&
	 * (this)light == (other)light
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != AML.class)
			return false;
		AML other = (AML) obj;
		if (this.getAnime().equals(other.getAnime()) && this.getManga().equals(other.getManga())
				&& this.getLightNovel().equals(other.getLightNovel()))
			return true;
		return false;
	}
}
