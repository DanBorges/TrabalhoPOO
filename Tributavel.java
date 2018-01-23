package br.dcc.ufla.poo.sistemaAlugueisImvoves;

/**
 * 
 * Interface criada para ser implementada algum desconto na remuneração de algum funcionário
 *
 */
interface Tributavel {
	/**
	 * 
	 * @param remuneracao com base na remuneração do funcionario será definido a porcentagem de juros
	 * 
	 */
	double calculaPocentagemSidicato(double remuneracao);
}
