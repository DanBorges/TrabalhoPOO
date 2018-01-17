package br.dcc.ufla.poo.sistemaAlugueisImvoves;

/**
 * 
 * Interface criada para ser implementada algum desconto na remuneração de algum funcionário
 *
 */
public interface Tributavel {
	/**
	 * 
	 * @param remuneracao com base na remuneração do funcionario será definido a porcentagem de juros
	 */
	public double calculaPocentagemSidicato(double remuneracao);
}
