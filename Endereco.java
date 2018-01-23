package br.dcc.ufla.poo.sistemaAlugueisImvoves;


/**
 * 
 * Classe responsável por definir o endereço do Imóvel - Irá compor a classe Imóvel
 *
 */
public class Endereco {
	
	private String cidade;
	private String rua;
	private String bairro;
	private String complemento;
	
	
	public Endereco(String cidade, String rua, String bairro, String complemento) {
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento=complemento;
	}

/**
 * 
 * @return cidade 
 * Retorna o nome da cidade. Uma String
 */
	public String getCidade() {
		return cidade;
	}

/**
 * 
 * @param cidade 
 * A String cidade é recebida como parâmentro para alterar a cidade do objeto
 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * 
	 * @return rua 
	 * Retorna o nome da rua. Uma String
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * 
	 * @param rua 
	 * A String rua é recebida como parâmentro para alterar a rua do objeto
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * 
	 * @return bairro 
	 * Retorna o nome do bairro. Uma String
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * 
	 * @param bairro 
	 * A String bairro é recebida como parâmentro para alterar o bairro do objeto
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * 
	 * @return complemento 
	 * Retorna o complemento. Uma String
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * 
	 * @param complemento
	 * A String complemento é recebida como parâmentro para alterar o complemento do objeto
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
