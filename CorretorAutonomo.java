package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;


/**
 * 
 * Classe responsável por definir atributos e métodos de funcionários Corretor Autônomo
 *
 */
public class CorretorAutonomo extends Funcionario {
	public double taxaComissao;
	
	public CorretorAutonomo(String cpf, String nome, String telefone, String email, double taxaComissao) {
		super(cpf, nome, telefone, email);
		this.taxaComissao = taxaComissao;
	}


	/**
	 * 
	 * @return taxaComissao
	 * Retorna a taxa de comissão. Um double
	 * valor double específico de corretor autônomo 
	 */
	public double getTaxaComissao() {
		return taxaComissao;
	}


	/**
	 * param listaContrato uma lista já filtrada somente pelo cpf do funcionário passado como parâmetro 
	 * na classe imobiliária Para o funcionário Corretor Autônomo é feito a fórmula da quantidade do valor
	 * contratos fechadospelo funcionário * taxa de comissao em %.
	 * Altera o valor do atributo genérico remuneracaoFinal
	 */
	@Override
	public void calcularRemuneracao(ArrayList<Contrato> listaContrato){
		double valorTotal = 0;
		for(Contrato c:listaContrato){
			valorTotal = valorTotal + c.getValorMensalAluguel()*(getTaxaComissao()/100) ;
		}
		setRemuneracaoFinal(valorTotal);
	}
	
	
	/**
	 * Sobresecreve o método toString
	 */
	@Override
	public String toString() {
		return "Nome: "+getNome()
				+"\n"+"Telefone: "+getTelefone()
				+"\n"+"E-mail: "+getEmail()
				+"\n"+"Número de Contratos: "+getNumeroContratosFechados()
				+"\n"+ "CPF: "+getCpf()
				+"\n"+ "Salário: "+ getRemuneracaoFinal();
	}
	
	
}
