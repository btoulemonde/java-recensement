package fr.diginamic.recensement.entites;

public class Departement {
	
	/**
	 * code du département de type String
	 */
	private String code;
	/**
	 * population du département de type int
	 */
	private int population;
	
	/**Constructeur de la classe Département
	 * @param code
	 * @param population
	 */
	public Departement(String code, int population) {
		super();
		this.code = code;
		this.population = population;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Departement [code=" + code + ", population=" + population + "]";
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
	
	
	

}
