package br.dcc.ufla.poo.sistemaAlugueisImvoves;


/**
 * 
 * Classe responsável por firmar um contrato de locação de um imóvel. É agregada por um objeto do tipo funcionário
 * que é passado como parâmetro e um objeto do tipo imóvel que é passado como parâmetro
 *
 */
public class Contrato {
	
	private int numero;
	private int duracao;
	private double valorMensalAluguel;
	private double percentualImobiliaria;
	private String nomeFiador;
	private String nomeLocatario;
	private Funcionario funcionario;
	private Imovel imovel;
	
	public Contrato(Contrato contrato, Funcionario funcionario,Imovel imovel) {
		if(contrato!=null && funcionario != null){
			this.numero = contrato.getNumero();
			this.duracao = contrato.getDuracao();
			this.valorMensalAluguel = contrato.getValorMensalAluguel();
			this.percentualImobiliaria = contrato.percentualImobiliaria;
			this.nomeFiador = contrato.nomeFiador;
			this.nomeLocatario = contrato.getNomeLocatario();
			this.funcionario = contrato.getFuncionario();
			this.imovel = contrato.getImovel();

		}
	}
	


	/**
	 * 
	 * @return numero
	 * Retorna o número do contrato. Um inteiro
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * 
	 * @param numero
	 * O inteiro numero é recebido como parâmentro para alterar a número do objeto
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * 
	 * @return duracao.
	 *  Retorna a duração do contrato. Um inteiro
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * 
	 * @param duracao
	 * O inteiro numero é recebido como parâmentro para alterar a número do objeto
	 */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	/**
	 * 
	 * @return valorMensalAluguel
	 *  Retorna a valor mensal do aluguel em R$. Um double
	 */
	public double getValorMensalAluguel() {
		return valorMensalAluguel;
	}

	/**
	 * 
	 * @param valorMensalAluguel
	 *  O double valor mensal do aluguel como é recebido parâmentro para alterar a valor
	 *  mensal em R$ do objeto.
	 */
	public void setValorMensalAluguel(double valorMensalAluguel) {
		this.valorMensalAluguel = valorMensalAluguel;
	}

	/**
	 * 
	 * @return percentualImobiliaria
	 * Retorna a porcentagem da imobiliária do aluguel em %. Um double
	 */
	public double getPercentualImobiliaria() {
		return percentualImobiliaria;
	}

	/**
	 * 
	 * @param percentualImobiliaria 
	 * O double. percentualImobiliaria como parâmentro para alterar a porcentagem
	 * da imobiliária em % do objeto
	 */
	public void setPercentualImobiliaria(double percentualImobiliaria) {
		this.percentualImobiliaria = percentualImobiliaria;
	}

	/**
	 * 
	 * @return nomeFiador
	 *  Retorna o nome do fiador. Uma String
	 */
	public String getNomeFiador() {
		return nomeFiador;
	}

	/**
	 * 
	 * @param nomeFiador
	 * A String nome do fiador é recebida como parâmentro para alterar o nome do fiador
	 * do objeto.
	 */
	public void setNomeFiador(String nomeFiador) {
		this.nomeFiador = nomeFiador;
	}
	
	/**
	 * 
	 * @return nomeLocatario
	 * Retorna o nome do locatário. Uma String
	 */
	public String getNomeLocatario() {
		return nomeLocatario;
	}

	/**
	 * 
	 * @param nomeLocatario
	 * A String nome do locatário é recebida como parâmentro para alterar o nome do locatário
	 * do objeto.
	 */
	public void setNomeLocatario(String nomeLocatario) {
		this.nomeLocatario = nomeLocatario;
	}
	
	/**
	 * 
	 * @param funcionario
	 * O objeto funcionário recebido como parâmentro que o contrato receba o objeto do tipo funcionário
	 * do objeto.
	 */
	public void setFuncionario(Funcionario funcionario){
		this.funcionario=funcionario;
		
	}
	
	/**
	 * 
	 * @param imovel
	 * O objeto imovel recebido como parâmentro que o contrato receba o objeto do tipo imovel
	 * do objeto.
	 */
	public void setImovel(Imovel imovel){
		this.imovel=imovel;
	}
	
	/**
	 * 
	 * @return funcionario
	 * Retorna o funcionario. Um Objeto
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * 
	 * @return imovel
	 * Retorna o imovel. Um Objeto
	 */
	public Imovel getImovel() {
		return imovel;
	}
	
	/**
	 * Sobresecreve o método toString
	 */
	@Override
	public String toString() {
		return " Numero: " + getNumero() + "\n"
				+ "duracao=" + getDuracao()+"\n"
				+ "Valor Mensal do Aluguel: " + getValorMensalAluguel()+"\n"
				+ "Percentual da Imobiliaria: " + getPercentualImobiliaria()+"\n"
				+ "Fiador: " + getNomeFiador() +"\n" 
				+ "Nome do Locatario: "+ getNomeLocatario()+"\n"
				//Acessa o objeto funcionário e retorna o atributo nome
				+"Funcionário Responsável: "+ getFuncionario().getNome()+"\n"
				//Acessa o objeto imovel e retorna o atributo idImovel
				+"Id do Imóvel: "+getImovel().getIdImovel() + "\n";
	}
}