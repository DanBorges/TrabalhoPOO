package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;
import java.util.Scanner;

import br.dcc.ufla.poo.sistemaAlugueisImvoves.Imovel.Categoria;
import br.dcc.ufla.poo.sistemaAlugueisImvoves.Imovel.Tipo;



public class Main {

	public static int carregarMenuPrincipal(Scanner in){
		System.out.println("----------------------------------------------Imobiliaria----------------------------------------------");
		

		boolean entradaValida=false;
		int op=4;
		
		while(!entradaValida){
			System.out.println("+++++++++++++++++++++++++++++++++++++++++MENU+++++++++++++++++++++++++++++++++++");
			System.out.println("1. Módulo Funcionário");
			System.out.println("2. Módulo Imóvel");
			System.out.println("3. Módulo Contrato");
			System.out.println("4. Sair");

			try{
				String input = in.nextLine();
				op = Integer.parseInt(input);
				System.out.println("Chegou aqui");

				if(op == 1 ||op == 2 || op == 3 || op == 4){
					entradaValida = true;
				}
				else{
					throw new Exception("A Entrada é Invalida");
				}
			}
			catch(Exception e){
				System.out.println("Entrada Inváilida digite novamente \n");
			}
		}
		return op;

	}


	public static void carregarModuloFuncionário(Imobiliaria imobiliaria, ArrayList<Funcionario>listaFuncionario){
		boolean entradaValida=false;
		int op=2;
		Scanner in = new Scanner(System.in);
		while(!entradaValida){
			System.out.println("MÓDULO FUNCIONÁRIO");
			System.out.println("1. Cadastrar Funcionario Fixo");
			System.out.println("2. Cadastrar Funcionário Comissionado");
			System.out.println("3. Exibir relatório de funcionario fixo");
			System.out.println("4. Exibir relatório de funcionario Autônomo");
			System.out.println("5. Voltar");
			
			try{
				String input = in.nextLine();
				op = Integer.parseInt(input);

				if(op == 1 ||op == 2 || op == 3 || op == 4 || op == 5){
					entradaValida = true;
					String cpf,nome,telefone,email;
					if(op==1){
						double salario;
						System.out.println("Informe o cpf do Funcionário:");
						cpf = in.next();
						if(imobiliaria.buscarFuncionario(cpf)==null){
							System.out.println("Informe o Nome do Funcionário");
							nome = in.next();
							System.out.println("Informe o telefone do Funcionário");
							telefone = in.next();
							System.out.println("Informe o E-mail do funcionario");
							email = in.next();
							System.out.println("Informe o salário base do Funcionário");
							salario=in.nextInt();
						
							Funcionario funcionario = new Fixo(cpf,nome, telefone, email, salario);
							
							funcionario.calcularRemuneracao(imobiliaria.buscarContratosPorCpf(cpf));
							
							imobiliaria.adicionarFuncionario(funcionario);
							listaFuncionario.add(funcionario);

							System.out.println("Funcionário Fixo Cadastrado com sucesso!!!");
						}
						else{
							System.out.println("Já exixte um funcionário Fixo com esse CPF");
						}
					}
					if(op==2){
						double taxaComissao;

						System.out.println("Informe o cpf do Funcionário:");
						cpf = in.next();
						if(imobiliaria.buscarFuncionario(cpf)==null){
							System.out.println("Informe o Nome do Funcionário");
							nome = in.next();
							System.out.println("Informe o telefone do Funcionário");
							telefone = in.next();
							System.out.println("Informe o E-mail do funcionario");
							email = in.next();
							System.out.println("Informe a taxa de comissão em porcentagem(%) do Funcionário");
							taxaComissao=in.nextDouble();
							Funcionario funcionario = new CorretorAutonomo(cpf,nome, telefone, email, taxaComissao);
							imobiliaria.adicionarFuncionario(funcionario);
							listaFuncionario.add(funcionario);

							System.out.println("Funcionário Comissionado Cadastrado com sucesso!!!");
						}
						else{
							System.out.println("Já Existe um funcionário Comissionado com esse cpf");
						}



					}
					if(op==3){
						String cpfPesquisa;
						System.err.println("Informe o CPF do funcionário");
						cpfPesquisa = in.next();
						if(imobiliaria.buscarFuncionarioFixo(cpfPesquisa) != null)
							System.out.println(imobiliaria.buscarFuncionarioFixo(cpfPesquisa));
						else{
							System.out.println("Não existe um funcionário Fixo com esse CPF");
						}
					}


					if(op==4){
						String cpfPesquisa;
						System.err.println("Informe o CPF do funcionário");
						cpfPesquisa = in.next();
						if(imobiliaria.buscarFuncionarioAutonomo(cpfPesquisa)!= null ){
							System.out.println(imobiliaria.buscarFuncionarioAutonomo(cpfPesquisa));
						}
						else{
							System.out.println("Não existe nenhum funcionário Autonômo com esse cpf");
						}
					}
					

				}
				else{
					throw new Exception("A Entrada á Invalida");
				}
			}
			catch(Exception e){
				System.out.println("Entrada Inváilida digite novamente \n");
			}
		}
	}

	public static void carregarModuloImovel(Imobiliaria imobiliaria){
		boolean entradaValida=false;
		int op=3;
		Scanner in = new Scanner(System.in);
		while(!entradaValida){
			System.out.println("MÓDULO IMÓVEL");
			System.out.println("1. Cadastrar Imóvel");
			System.out.println("2. Imprimir Imóveis Por Categoria e Tipo");
			System.out.println("3. Voltar");
			try{
				String input = in.nextLine();
				op = Integer.parseInt(input);

				if(op == 1 ||op == 2 || op == 3){
					entradaValida = true;
					if(op==1){
						String cidade,rua, bairro,complemento;
						
						System.out.println("Informe a Cidade do Imóvel");
						cidade = in.next();
						
						System.out.println("Informe a Rua do Imóvel");
						rua = in.next();
						
						System.out.println("Informe o Bairro do Imóvel");
						bairro = in.next();
						
						System.out.println("Informe o Complemento do Imóvel");
						complemento = in.next();
						
						
						
						Imovel imovel = new Imovel(0,"", 0, 0,false, cidade,rua,bairro,complemento);
						int idImovel;
						String nomeProprietario;
						Integer categoria,tipo;
						
						System.out.println("Informe o Id do Imóvel: ");
						idImovel = in.nextInt();
						imovel.setIdImovel(idImovel);
						
						System.out.println("Informe o Nome do proprietário: ");
						nomeProprietario = in.next();
						imovel.setNomeProprietario(nomeProprietario);
						
						System.out.println("Informe a categoria do Imóvel: 1-Residencial/2-Comercial/3-Misto ");
						categoria = in.nextInt();
						
						if(categoria.equals(Categoria.RESIDENCIAL.getCodigo())){
							imovel.setCategoria(Categoria.RESIDENCIAL.getCodigo());
						}
						if(categoria.equals(Categoria.COMERCIAL.getCodigo())){
							imovel.setCategoria(Categoria.COMERCIAL.getCodigo());
						}
						if(categoria.equals(Categoria.MISTO.getCodigo())){
							imovel.setCategoria(Categoria.MISTO.getCodigo());
						}
						

						System.out.println("Informe tipo do Imóvel: 1-Apartamento/2-Casa ");
						tipo = in.nextInt();
						if(tipo.equals(Tipo.CASA.getCodigo())){
							imovel.setTipo(Tipo.CASA.getCodigo());
						}
						if(tipo.equals(Tipo.APRTAMENTO.getCodigo())){
							imovel.setTipo(Tipo.APRTAMENTO.getCodigo());
						}
						
						
						imobiliaria.adicionarImovel(imovel);

					}

					if(op==2){
						int categoria,tipo;

						System.out.println("Informea categoria do Imóvel1-Residencial/2-Comercial/3-Misto: ");
						categoria = in.nextInt();

						System.out.println("Informea o tipo do Imóvel:1-Apartamento/2-Casa  ");
						tipo = in.nextInt();

						imobiliaria.imprimirImovelPorCategoriaAndTipo(categoria,tipo);
						
					}
				}
			}

			catch(Exception e){
				System.out.println("Entrada Inváilida digite novamente \n");
			}
		}
	}


	public static void carregarModuloContrato(Imobiliaria imobiliaria){
		boolean entradaValida=false;
		int op=1;
		Scanner in = new Scanner(System.in);
		while(!entradaValida){
			
			System.out.println("1. Gerar Contrato");
			System.out.println("2. Imprimir Contratos");
			System.out.println("3. Voltar");
			try{
				String input = in.nextLine();
				op = Integer.parseInt(input);

				if(op == 1 ||op == 2 || op == 3){
					entradaValida = true;

					if(op==1){
						int numero,duracao,idImovel;
						double valorMensalAluguel,percentualImobiliaria;
						String nomeFiador, nomeLocatario, cpfFuncionario;

						Contrato contrato= new Contrato(null, null, null);


						System.out.println("Informe o CPF do funcionário");
						cpfFuncionario = in.next();
						Funcionario funcionario = imobiliaria.buscarFuncionario(cpfFuncionario);

						if(funcionario == null ){
							System.out.println("Não Existe nenhum funcionário com esse CPF");
							return;
						}

						System.out.println("Informe o Id do Imóvel para a locação");
						idImovel = in.nextInt();
						Imovel imovel = imobiliaria.buscarImovel(idImovel);


						if(imovel == null){
							System.out.println("Não existe Nenhim Imóvel com esse ID");
							return;
						}
						else{
							System.out.println("Informe o numero do contrato");
							numero = in.nextInt();
							contrato.setNumero(numero);

							System.out.println("Informe a duração do contrato(meses)");
							duracao = in.nextInt();
							contrato.setDuracao(duracao);

							System.out.println("Informe valor mensal do aluguel");
							valorMensalAluguel = in.nextDouble();
							contrato.setValorMensalAluguel(valorMensalAluguel);

							System.out.println("Informe o percentual da imobiliaria(%)");
							percentualImobiliaria = in.nextDouble();
							contrato.setPercentualImobiliaria(percentualImobiliaria);

							System.out.println("Informe o nome do Fiador");
							nomeFiador = in.next();
							contrato.setNomeFiador(nomeFiador);

							System.out.println("Informe o nome do Locatário");
							nomeLocatario = in.next();
							contrato.setNomeLocatario(nomeLocatario);

							contrato.cadastrarFuncionario(funcionario);
							contrato.cadastrarImovel(imovel);


							contrato = funcionario.gerarContrato(contrato,funcionario,imovel);
							
							imobiliaria.adicionarContrato(contrato);
							
							//lista de contrato
							ArrayList<Contrato> listaContrato = imobiliaria.buscarContratosPorCpf(cpfFuncionario);
							
							
							funcionario.calcularRemuneracao(listaContrato);
							imovel.setStatus(true);

							System.out.println("Contrato Firmado com sucesso");
						}

					}

					if(op==2){
						int numero;
						System.out.println("Informe o numero do contrato");
						numero = in.nextInt();
						if(imobiliaria.imprimirContratos(numero) == null){
							System.out.println("Não existe nenhum contrato com esse número");
						}
						else{
							System.out.println(imobiliaria.imprimirContratos(numero));
						}
					}
				}
			}

			catch(Exception e){
				System.out.println("Entrada Inváilida digite novamente \n");
			}
		}

	}

	public static void main(String[] args) {
		Imobiliaria imobiliaria = new Imobiliaria();
		ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		Scanner in = new Scanner(System.in);
		int opPrincipal;
		do{
			opPrincipal = carregarMenuPrincipal(in);
			if(opPrincipal == 1){
				carregarModuloFuncionário(imobiliaria,listaFuncionario);
			}
			if(opPrincipal == 2){
				carregarModuloImovel(imobiliaria);
			}
			if(opPrincipal == 3){
				carregarModuloContrato(imobiliaria);
			}
		
		}while(opPrincipal != 4);
		

	}
}
