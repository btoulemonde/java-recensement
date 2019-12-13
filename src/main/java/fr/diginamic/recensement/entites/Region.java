package fr.diginamic.recensement.entites;

public class Region {
	/**
	 * code de la région de type String
	 */
	private String code;
	/**
	 * population de la région de type int
	 */
	private int population;
	/**
	 * nom de la région de type String
	 */
	private String nomRegion;
	
	/**constructeur de la classe Region
	 * @param population de type int
	 * @param nomRegion de type String
	 */
	public Region(int population, String nomRegion) {
		super();
		this.population = population;
		this.nomRegion= nomRegion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nomRegion+" : " + population+" habitants.";
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/** Getter
	 * @return the nomRegion
	 */
	public String getNomRegion() {
		return nomRegion;
	}

	/** Setter
	 * @param nomRegion the nomRegion to set
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	
	

}
