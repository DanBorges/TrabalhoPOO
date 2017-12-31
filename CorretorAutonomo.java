package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;

public class CorretorAutonomo extends Funcionario {
	public double taxaComissao;
	
	public CorretorAutonomo(String cpf, String nome, String telefone, String email, double taxaComissao) {
		super(cpf, nome, telefone, email);
		this.taxaComissao = taxaComissao;
	}


	public double getTaxaComissao() {
		return taxaComissao;
	}


	public void setTaxaComissao(double taxaComissao) {
		this.taxaComissao = taxaComissao;
	}


	
	@Override
	public void calcularRemuneracao(ArrayList<Contrato> listaContrato){
		
		double valorTotal = 0;
		for(Contrato c:listaContrato){
			valorTotal = valorTotal + 
						(c.getValorMensalAluguel()*(getTaxaComissao()/100));
		}
		setRemuneracaoFinal(valorTotal);
	}

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
