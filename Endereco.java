package br.dcc.ufla.poo.sistemaAlugueisImvoves;

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


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	

	
	
	
	

}
