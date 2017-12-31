package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;


public abstract class Funcionario {
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private int numeroContratosFechados;
	private double remuneracaoFinal;

	



	public Funcionario(String cpf, String nome, String telefone, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumeroContratosFechados() {
		return numeroContratosFechados;
	}

	public void setNumeroContratosFechados(int numeroContratosFechados) {
		this.numeroContratosFechados = numeroContratosFechados;
	}
	
	public double getRemuneracaoFinal() {
		return remuneracaoFinal;
	}

	public void setRemuneracaoFinal(double remuneracaoFinal) {
		this.remuneracaoFinal = remuneracaoFinal;
	}

		
	public void cadastrarImovelLocacao(ArrayList<Imovel> listaImoveis, Imovel imovel){
		listaImoveis.add(imovel);
	}


	public Contrato gerarContrato(Contrato contrato, Funcionario funcionario, Imovel imovel){
		Imobiliaria imobiliaria = new Imobiliaria();
		contrato = new Contrato(contrato, funcionario,imovel);
		funcionario.setNumeroContratosFechados(funcionario.getNumeroContratosFechados()+1);
		return contrato;
	}	
	
	public abstract void calcularRemuneracao(ArrayList<Contrato> listaContrato);

	
	
}
