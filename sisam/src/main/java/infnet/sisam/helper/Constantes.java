package infnet.sisam.helper;

public interface Constantes {
	public String EMAIL_FROM = "avaliacaoinfnettc@gmail.com";
	
	//REST INFNET
	public String URI_REST_INFNET_LOCAL = "http://localhost:8080/servicosrest";
	public String URI_REST_INFNET = "https://services-infnet.herokuapp.com/";
	public String PATH_TURMAS = "/turmas";

	
	public String URI_SERVER_DEV = "http://localhost:8080/sisam/";
	public String URI_SERVER_PROD = "https://sisam-infnet.herokuapp.com/";
	public String PATH_PESQUISA = "pesquisa/";
	
	//PROFILES
	public static final String PRODUCTION_NAME = "prod";
	public static final String DEVELOPMENT_NAME = "dev";
}
