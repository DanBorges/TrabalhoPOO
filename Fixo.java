package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;

/**
 * 
 * Classe responsável por definir atributos e métodos de funcionários fixos
 *
 */
public class Fixo extends Funcionario {
	private double salarioBase;
	
	public Fixo(String cpf, String nome, String telefone, String email,double salarioBase) {
		super(cpf,nome, telefone, email);
		this.salarioBase = salarioBase;
	}

	/**
	 * 
	 * @return slarioBase 
	 * valor double específico da classe Fixo
	 */
	public double getSalarioBase() {
		return salarioBase;
	}

	/**
	 * param listaContrato uma lista já filtrada somente pelo cpf do funcionário passado como parâmetro na classe imobiliária
	 * Para o funcionário fixo é feito a fórmula so seu salário base (entrada)+ quantidade do valor contratos fechados
	 * pelo funcionário * 1%
	 * Altera o valor do atributo genérico remuneracaoFinal
	 */
	@Override
	public void calcularRemuneracao(ArrayList<Contrato> listaContrato) {
		double valorTotal = 0;
		for(Contrato c:listaContrato){
			valorTotal = valorTotal + getSalarioBase()+
			(c.getValorMensalAluguel()*(0.01));
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
				+"\n"+ "Número de Contratos: "+getNumeroContratosFechados()
				+"\n"+ "CPF: "+getCpf()
				+"\n"+ "Salário: "+getRemuneracaoFinal();
	}

}
