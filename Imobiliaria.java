package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;

import br.dcc.ufla.poo.sistemaAlugueisImvoves.Imovel.Categoria;
import br.dcc.ufla.poo.sistemaAlugueisImvoves.Imovel.Tipo;


/**
 * 
 * Calsse Responsável por definir, armazenar e capturar informações das entidades do sistema
 *
 */
public class Imobiliaria {	
	private ArrayList<Funcionario> listaFuncionario;
	private ArrayList<Imovel> listaImovel;
	private ArrayList<Contrato> listaContrato;

	public Imobiliaria() {
		this.listaFuncionario = new ArrayList<Funcionario>();
		this.listaImovel = new ArrayList<Imovel>();
		this.listaContrato = new ArrayList<Contrato>();

	}
	
	/**
	 * 
	 * @param funcionario
	 * Recebe um objeto funcionário como parâmetro e o armazena um uma lista de funcionário.
	 */
	public void adicionarFuncionario(Funcionario funcionario){
		listaFuncionario.add(funcionario);
	}
	
	/**
	 * 
	 * @param imovel
	 * Recebe um objeto imóvel como parâmetro e o armazena um uma lista de imóvel.
	 */
	public void adicionarImovel(Imovel imovel){
		listaImovel.add(imovel);
	}
	
	/**
	 * 
	 * @param contrato
	 * Recebe um objeto contrato como parâmetro e o armazena um uma lista de contrato.
	 */
	public void adicionarContrato(Contrato contrato){
		listaContrato.add(contrato);
	}
	
	/**
	 * 
	 * @param id, Recebe como parâmetro o id do funcionário (no caso CPF)
	 * @return funcionario 
	 * Caso ache o funcionário pelo seu cpf retorna o objeto, senão retorna null
	 */
	public Funcionario buscarFuncionario(String id){
		for(Funcionario funcionario:listaFuncionario){
			String cpf= funcionario.getCpf();
			if(cpf.equals(id))
				return funcionario;
			
		}
		return null;
	}
	
	/**
	 * 
	 * @param id, Recebe como parâmetro o id do funcionário fixo (no caso CPF)
	 * @return funcionario
	 * Caso ache o funcionário fixo pelo seu cpf retorna o objeto, senão retorna null
	 */
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
	
	/**
	 * 
	 * @param id, Recebe como parâmetro o id do funcionário autônomo (no caso CPF)
	 * @return funcionario
	 * Caso ache o funcionário autônomo pelo seu cpf retorna o objeto, senão retorna null
	 */
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
	
	/**
	 * 
	 * @param idImovel, Recebe como parâmetro o id do imóvel
	 * @return imovel
	 * caso ache o imovel pelo seu id retorna o objeto, senão retorna null
	 */
	public Imovel buscarImovel(int idImovel){
		for(Imovel imovel:listaImovel){
			if(idImovel == imovel.getIdImovel())
				return imovel;
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param categoria,
	 * @param tipo
	 * Imprime as caracteristicas de um contrato, passado como parâmetro, senão encontrar imprime que
	 * Não Existem Imóveis com esse tipo e categoria
	 */
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
					//Faz o uso do método getDesricao do enum Categoria
					System.out.println("Categoria: "+ Categoria.getDescricao(listaImovel.get(i).getCategoria()));
					//Faz o uso do método getDesricao do enum Tipo
					System.out.println("Tipo: "+Tipo.getDescricao(listaImovel.get(i).getTipo()));
					System.out.println("Status: "+listaImovel.get(i).getStatus());
				}
			}
		}
		else{
			System.out.println("Não Existem Imóveis com esse tipo e categoria");
		}

	}
	
	
	/**
	 * 
	 * @param idContrato, Recebe como parâmetro o id do Contrato
	 * @return contrato
	 * Caso ache o contrato pelo seu id retorna o objeto, senão retorna null
	 */
	public Contrato buscarContratos(int idContrato){
		for(Contrato contrato:listaContrato){
			if(contrato.getNumero() == idContrato)
				return contrato;
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param id,
	 * @return listaContrato
	 * Ao passar o id (CPF) do funcionário é feito a busca de todos os contratos que têm aquele funcionário vinculado,
	 * senão retorna null
	 */
	public ArrayList<Contrato> buscarContratosPorCpf(String id){
		
		for(Contrato contrato: listaContrato){
			if(contrato.getFuncionario().getCpf().equals(id)){
				return listaContrato;
			}
		}
		throw new RuntimeException("Nao existe nenhum funcionario com esse cpf");
	}

}
