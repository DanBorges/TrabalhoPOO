package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;

public class Fixo extends Funcionario {
	private double salarioBase;
	
	public Fixo(String cpf, String nome, String telefone, String email,double salarioBase) {
		super(cpf,nome, telefone, email);
		this.salarioBase = salarioBase;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	@Override
	public void calcularRemuneracao(ArrayList<Contrato> listaContrato) {
		double valorTotal = 0;
		for(Contrato c:listaContrato){
			valorTotal = valorTotal + getSalarioBase()+
			(c.getValorMensalAluguel()*(0.01));
		}
		setRemuneracaoFinal(valorTotal);
	}
	
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
