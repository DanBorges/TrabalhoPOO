package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;
 
/**
 *
 * Classe representa a entidade Funcionário, possui atributos e métodos genéricos dos funcionários do sistema 
 *
 */

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
	
	
	/**
	 * 
	 * @return cpf
	 * Retorna o Cpf do Funcionário. Uma String
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * 
	 * @param cpf
	 * A String Cpf é recebida como parâmentro para alterar o cpf do objeto
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * 
	 * @return nome
	 * Retorna o nome do Funcionário. Uma String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 * A String nome é recebida como parâmentro para alterar o nome do objeto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return telefone
	 * Retorna o telefone do Funcionário. Uma String
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * 
	 * @param telefone 
	 * A String telefone é recebida como parâmentro para alterar o telefone do objeto
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * 
	 * @return email
	 * Retorna o email do Funcionário. Uma String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 * A String email é recebida como parâmentro para alterar o e-mail do objeto
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return numeroContratosFechados
	 * Retorna a numero de contratos fechados do Funcionário. Um inteiro
	 */
	public int getNumeroContratosFechados() {
		return numeroContratosFechados;
	}

	/**
	 * 
	 * @param numeroContratosFechados
	 * O inteiro numero de contratos fechados é recebido como parâmentro para alterar o e-mail do objeto
	 */
	public void setNumeroContratosFechados(int numeroContratosFechados) {
		this.numeroContratosFechados = numeroContratosFechados;
	}
	
	/**
	 * 
	 * @return remunercaoFinal
	 *  Retorna a remuneração final do Funcionário. Um Double
	 */
	public double getRemuneracaoFinal() {
		return remuneracaoFinal;
	}
	
	/**
	 * 
	 * @param remuneracaoFinal 
	 * O dpuble remuneração é recebido como parâmentro para alterar a remuneração final do objeto
	 * O Cálculo para definir a remuneração de cada objeto será implmentado em suas classes específicas
	 */
	public void setRemuneracaoFinal(double remuneracaoFinal) {
		this.remuneracaoFinal = remuneracaoFinal;
	}

		
	/**
	 * 
	 * @param contrato Recebe um objeto do tipo
	 * @param funcionario Recebe um objeto do tipo Funcionário, que está vinculado no contrato pelo seu CPF 
	 * responsável por fazer o contrato para que esse tenha sua quantidade de contratos incrementado
	 * @param imovel um objeto do tipo imóvel 
	 * @return objeto do tipo imóvel que está vinculado no contrato pelo IdImovel
	 */
	public Contrato gerarContrato(Contrato contrato, Funcionario funcionario, Imovel imovel){
		contrato = new Contrato(contrato, funcionario,imovel);
		//A cada contrato fechado é incrementado o atributo numero de contratos fechados
		funcionario.setNumeroContratosFechados(funcionario.getNumeroContratosFechados()+1);
		return contrato;
	}	
	
	/**
	 * 
	 * Método será sobresecrito pelas subclasses Fixo e Corretor Autônomo
	 * @param listaContrato 
	 * Recebe uma lista de contratos, que será filtrada pelo CPF do funcionário
	 */
	public abstract void calcularRemuneracao(ArrayList<Contrato> listaContrato);

	
	
}
