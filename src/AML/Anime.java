package AML;

public class Anime {
	
	private String name;
	private String productionYear;
	private String nameManufacturer;
	private boolean isEnd;
	private double score;
	private double myScore;
	private Genres generes;
	private String img;
	private String description;
	
	public Anime(String name, String productionYear, String nameManufacturer, boolean isEnd, double score,
			double myScore, Genres generes, String img, String description) {
		super();
		this.name = name;
		this.productionYear = productionYear;
		this.nameManufacturer = nameManufacturer;
		this.isEnd = isEnd;
		this.score = score;
		this.myScore = myScore;
		this.generes = generes;
		this.img = img;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	public String getNameManufacturer() {
		return nameManufacturer;
	}

	public void setNameManufacturer(String nameManufacturer) {
		this.nameManufacturer = nameManufacturer;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getMyScore() {
		return myScore;
	}

	public void setMyScore(double myScore) {
		this.myScore = myScore;
	}

	public Genres getGeneres() {
		return generes;
	}

	public void setGeneres(Genres generes) {
		this.generes = generes;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	
	
}
