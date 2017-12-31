package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;

import br.dcc.ufla.poo.sistemaAlugueisImvoves.Imovel.Categoria;
import br.dcc.ufla.poo.sistemaAlugueisImvoves.Imovel.Tipo;

public class Imobiliaria {
	
	private ArrayList<Funcionario> listaFuncionario;
	private ArrayList<Imovel> listaImovel;
	private ArrayList<Contrato> listaContrato;




	public Imobiliaria() {
		this.listaFuncionario = new ArrayList<Funcionario>();
		this.listaImovel = new ArrayList<Imovel>();
		this.listaContrato = new ArrayList<Contrato>();

	}
	
	public void adicionarFuncionario(Funcionario funcionario){
		listaFuncionario.add(funcionario);
	}
	
	public void adicionarImovel(Imovel imovel){
		listaImovel.add(imovel);
	}
	
	public void adicionarContrato(Contrato contrato){
		listaContrato.add(contrato);
	}
	
	public Funcionario buscarFuncionario(String id){
		for(Funcionario funcionario:listaFuncionario){
			String cpf= funcionario.getCpf();
			if(cpf.equals(id))
				return funcionario;
			
		}
		return null;
	}
	
	
	public Funcionario buscarFuncionarioFixo(String id){
		for(Funcionario funcionario:listaFuncionario){
			if(funcionario instanceof Fixo){
				Fixo fixo = (Fixo)funcionario;
				String cpf= fixo.getCpf();
				if(cpf.equals(id))
					return funcionario;
			}
		}
		return null;
	}
	
	public Funcionario buscarFuncionarioAutonomo(String id){
		for(Funcionario funcionario:listaFuncionario){
			if(funcionario instanceof CorretorAutonomo){
				CorretorAutonomo corretorAutonomo = (CorretorAutonomo)funcionario;
				String cpf= corretorAutonomo.getCpf();
				if(cpf.equals(id))
					return funcionario;
			}
		}
		return null;
	}
	
	public Imovel buscarImovel(int idImovel){
		for(Imovel imovel:listaImovel){
			if(idImovel == imovel.getIdImovel())
				return imovel;
		}
		return null;
	}
	
	
	
	public void imprimirImovelPorCategoriaAndTipo(int categoria, int tipo){
		if(!listaImovel.isEmpty()){
			for(int i=0;i<listaImovel.size();i++){
				if(listaImovel.get(i).getCategoria() == categoria && listaImovel.get(i).getTipo()==tipo){
					System.out.println("Id Imóvel: "+listaImovel.get(i).getIdImovel());
					System.out.println("Proprietário: "+ listaImovel.get(i).getNomeProprietario());
					System.out.println("Cidade: "+listaImovel.get(i).getEndereco().getCidade());
					System.out.println("Rua: "+listaImovel.get(i).getEndereco().getRua());
					System.out.println("Bairro: "+listaImovel.get(i).getEndereco().getBairro());
					System.out.println("Complemento: "+listaImovel.get(i).getEndereco().getComplemento());
					System.out.println("Categoria: "+ Categoria.getDescricao(listaImovel.get(i).getCategoria()));
					System.out.println("Tipo: "+Tipo.getDescricao(listaImovel.get(i).getTipo()));
					System.out.println("Status: "+listaImovel.get(i).getStatus());
				}
			}
		}
		else{
			System.out.println("Não Existem Imóveis com esse tipo e categoria");
		}

	}
	
	public Contrato imprimirContratos(int idContrato){
		for(Contrato c:listaContrato){
			if(c.getNumero() == idContrato)
				return c;
		}
		return null;
	}
	
	public ArrayList<Contrato> buscarContratosPorCpf(String id){
		
		for(Contrato c: listaContrato){
			if(c.getFuncionario().getCpf().equals(id)){
				return listaContrato;
			}
		}
		return null;
	}

}
