package fr.diginamic.recensement.entites;



public class Ville  {

	/**
	 * Code de la région de type String
	 */
	private String codeRegion;
	/**
	 * nom de la région de type String
	 */
	private String nomRegion;
	/**
	 * code du département de type String
	 */
	private String codeDepartement;
	/**
	 * nom de la commune de type String
	 */
	private String nomCommune;
	/**
	 * population totale de la ville de type int
	 */
	private int population;

	/**Constructeur
	 * @param nomCommune
	 * @param population
	 */
	public Ville(String nomCommune, int population) {
		super();
		this.nomCommune = nomCommune;
		this.population = population;
	}

	/**Constructeur
	 * @param codeRegion
	 * @param nomRegion
	 * @param codeDepartement
	 * @param nomCommune
	 * @param population
	 */
	public Ville(String codeRegion, String nomRegion, String codeDepartement, String nomCommune,int population) {
		super();
		this.codeRegion=codeRegion;
		this.nomRegion = nomRegion;
		this.codeDepartement=codeDepartement;
		this.nomCommune = nomCommune;
		this.population = population;
		}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nomCommune + " : " + population + " habitants.";
	}

	
	/**
	 * @return the codeRegion
	 */
	public String getCodeRegion() {
		return codeRegion;
	}

	/**
	 * @param codeRegion
	 *            the codeRegion to set
	 */
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

	/**
	 * @return the nomRegion
	 */
	public String getNomRegion() {
		return nomRegion;
	}

	/**
	 * @param nomRegion
	 *            the nomRegion to set
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	/**
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * @param codeDepartement
	 *            the codeDepartement to set
	 */
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/**
	 * @return the nomCommune
	 */
	public String getNomCommune() {
		return nomCommune;
	}

	/**
	 * @param nomCommune
	 *            the nomCommune to set
	 */
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @param population
	 *            the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

}
