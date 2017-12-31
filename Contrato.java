package br.dcc.ufla.poo.sistemaAlugueisImvoves;



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
	



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public double getValorMensalAluguel() {
		return valorMensalAluguel;
	}

	public void setValorMensalAluguel(double valorMensalAluguel) {
		this.valorMensalAluguel = valorMensalAluguel;
	}

	public double getPercentualImobiliaria() {
		return percentualImobiliaria;
	}

	public void setPercentualImobiliaria(double percentualImobiliaria) {
		this.percentualImobiliaria = percentualImobiliaria;
	}

	public String getNomeFiador() {
		return nomeFiador;
	}

	public void setNomeFiador(String nomeFiador) {
		this.nomeFiador = nomeFiador;
	}

	public String getNomeLocatario() {
		return nomeLocatario;
	}

	public void setNomeLocatario(String nomeLocatario) {
		this.nomeLocatario = nomeLocatario;
	}
	
	public void cadastrarFuncionario(Funcionario funcionario){
		this.funcionario=funcionario;
		
	}
	
	public void cadastrarImovel(Imovel imovel){
		this.imovel=imovel;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}


	public Imovel getImovel() {
		return imovel;
	}
	
	@Override
	public String toString() {
		return " Numero: " + getNumero() + "\n"
				+ "duracao=" + getDuracao()+"\n"
				+ "Valor Mensal do Aluguel: " + getValorMensalAluguel()+"\n"
				+ "Percentual da Imobiliaria: " + getPercentualImobiliaria()+"\n"
				+ "Fiador: " + getNomeFiador() +"\n" 
				+ "Nome do Locatario: "+ getNomeLocatario()+"\n"
				+"Funcionário Responsável: "+ getFuncionario().getNome()+"\n"
				+"Id do Imóvel: "+getImovel().getIdImovel();
	}
}
