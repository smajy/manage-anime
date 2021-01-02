package AML;
/**
 * 
 * @author smajy
 * this is AML. means Aniem and Manga and Light Novel.
 * this is all of them. 
 * anime create from manga.
 * manga create from lightnovel.
 * if save anime, I shoud save manga and light novel.
 */
public class AML {
	private Anime anime;
	private Manga manga;
	private LightNovel lightNovel;
	
	public AML(Anime anime, Manga manga, LightNovel lightNovel) {
		super();
		this.anime = anime;
		this.manga = manga;
		this.lightNovel = lightNovel;
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
	
}
