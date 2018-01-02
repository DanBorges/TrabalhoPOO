package br.dcc.ufla.poo.sistemaAlugueisImvoves;

import java.util.ArrayList;
import java.util.Scanner;

import br.dcc.ufla.poo.sistemaAlugueisImvoves.Imovel.Categoria;
import br.dcc.ufla.poo.sistemaAlugueisImvoves.Imovel.Tipo;


/**
 * 
 * Classe responsável em definir interface com usuário
 *
 */
public class Main {

	/**
	 * 
	 * @param in,
	 * @return
	 * Método que carrega o menu principal, onde o usuário escolhe qual módulo vai acionar
	 */
	public static int carregarMenuPrincipal(Scanner in){
		System.out.println("----------------------------------------------Imobiliaria----------------------------------------------");
		/*Variável criada para definir estado da ação*/
		boolean entradaValida=false;
		//inicializa variável op
		int op=0;
		/*Sai do loop somente quando a variável entradaValida for igual a true, fazendo com que o usuário tenha uma nova
		chance em escolher uma opção válida*/
		while(!entradaValida){
			/*Menu Principal*/
			System.out.println("+++++++++++++++++++++++++++++++++++++++++MENU+++++++++++++++++++++++++++++++++++");
			System.out.println("1. Módulo Funcionário");
			System.out.println("2. Módulo Imóvel");
			System.out.println("3. Módulo Contrato");
			System.out.println("4. Sair");

			/*Tenta Executar o bloco de comandos dentro de try*/
			try{
				String input = in.nextLine();
				op = Integer.parseInt(input);
				/*Altera o valor de entradaValida, para que saia do loop se a opção digitada estiver no menu*/
				if(op == 1 ||op == 2 || op == 3 || op == 4){
					entradaValida = true;
				}
				/*Lança excessão*/
				else{
					throw new Exception("A Entrada é Invalida");
				}
			}
			/*Caso haja algum erro é mostrado essa mensagem ao usuário*/
			catch(Exception e){
				System.out.println("Entrada Inváilida \n");
			}
		}
		return op;

	}

	/**
	 * 
	 * @param imobiliaria. 
	 * Recebe Objeto imobiliária
	 */
	public static void carregarModuloFuncionário(Imobiliaria imobiliaria){
		/*Variável criada para definir estado da ação*/
		boolean entradaValida=false;
		int op;
		Scanner in = new Scanner(System.in);
		/*sai do loop somente quando a variável entradaValida for igual a true, fazendo com que o usuário tenha 
		uma nova chance em escolher uma opção válida*/
		while(!entradaValida){
			System.out.println("MÓDULO FUNCIONÁRIO");
			/*Menu módulo funcionário*/
			System.out.println("1. Cadastrar Funcionario Fixo");
			System.out.println("2. Cadastrar Funcionário Comissionado");
			System.out.println("3. Exibir relatório de funcionario fixo");
			System.out.println("4. Exibir relatório de funcionario Autônomo");
			System.out.println("5. Voltar");

			/*Tenta Executar o bloco de comandos dentro de try*/
			try{	
				String input = in.nextLine();
				op = Integer.parseInt(input);
				/*Altera o valor de entradaValida, para que saia do loop se a opção digitada estiver no menu*/
				if(op == 1 ||op == 2 || op == 3 || op == 4 || op == 5) {
					entradaValida = true;
					String cpf,nome,telefone,email;
					if(op==1){
						/*Atributo específico de funcionário fixo*/
						double salario;
						System.out.println("Informe o cpf do Funcionário:");
						cpf = in.next();
						/*Verifica se não existe um funcionário com o mesmo CPF. Se Existir não executa bloco*/
						if(imobiliaria.buscarFuncionario(cpf)==null){
							System.out.println("Informe o Nome do Funcionário");
							nome = in.next();
							System.out.println("Informe o telefone do Funcionário");
							telefone = in.next();
							System.out.println("Informe o E-mail do funcionario");
							email = in.next();
							System.out.println("Informe o salário base do Funcionário");
							salario=in.nextInt();

							/*Instancia funcionário como variável polimórfica para funcionário fixo*/
							Funcionario funcionario = new Fixo(cpf,nome, telefone, email, salario);							
							/*Adiciona o funcionário na lista de funcionários*/
							imobiliaria.adicionarFuncionario(funcionario);
							System.out.println("Funcionário Fixo Cadastrado com sucesso!!!");
						}
						/*Caso o cpf já esteja cadastrado no sistema é disparado mensagem 
						 Já exixte um funcionário Fixo com esse CPF*/
						else{
							System.out.println("Já exixte um funcionário Fixo com esse CPF");
						}
					}
					if(op==2){
						/*Atrubuto específico de funcionário autônomo*/
						double taxaComissao;
						System.out.println("Informe o cpf do Funcionário:");
						cpf = in.next();
						/*Verifica se não existe um funcionário com o mesmo CPF. Se Existir não executa bloco*/
						if(imobiliaria.buscarFuncionario(cpf)==null){
							System.out.println("Informe o Nome do Funcionário");
							nome = in.next();
							System.out.println("Informe o telefone do Funcionário");
							telefone = in.next();
							System.out.println("Informe o E-mail do funcionario");
							email = in.next();
							System.out.println("Informe a taxa de comissão em porcentagem(%) do Funcionário");
							taxaComissao=in.nextDouble();

							/*Instancia funcionário como variável polimórfica para funcionário autônomo*/
							Funcionario funcionario = new CorretorAutonomo(cpf,nome, telefone, email, taxaComissao);
							/*Instancia funcionário como variável polimórfica para funcionário fixo*/
							imobiliaria.adicionarFuncionario(funcionario);
							System.out.println("Funcionário Comissionado Cadastrado com sucesso!!!");
						}
						/*Caso o cpf já esteja cadastrado no sistema é disparado mensagem 
						 Já exixte um funcionário Comissionado com esse CPF*/
						else{
							System.out.println("Já Existe um funcionário Comissionado com esse cpf");
						}
					}

					if(op==3){
						String cpfPesquisa;
						System.err.println("Informe o CPF do funcionário");
						cpfPesquisa = in.next();
						/*Faz a busca do funcionário pelo seu CPF, caso encontro imprime a lista de funcionários fixos*/
						if(imobiliaria.buscarFuncionarioFixo(cpfPesquisa) != null)
							System.out.println(imobiliaria.buscarFuncionarioFixo(cpfPesquisa));
						/*senão encontrar o funcionário na lista exibe a mensagem Não existe um 
						funcionário Fixo com esse CPF  */
						else{
							System.out.println("Não existe um funcionário Fixo com esse CPF");
						}
					}


					if(op==4){
						String cpfPesquisa;
						System.err.println("Informe o CPF do funcionário");
						cpfPesquisa = in.next();
						/*Faz a busca do funcionário pelo seu CPF, caso encontro imprime a lista de funcionários autônomos*/
						if(imobiliaria.buscarFuncionarioAutonomo(cpfPesquisa)!= null ){
							System.out.println(imobiliaria.buscarFuncionarioAutonomo(cpfPesquisa));
						}
						/*senão encontrar o funcionário na lista exibe a mensagem Não existe um
						 funcionário Fixo com esse CPF  */
						else{
							System.out.println("Não existe nenhum funcionário Autonômo com esse cpf");
						}
					}
				}
				/*Lança excessão*/
				else{
					throw new Exception("A Entrada á Invalida");
				}
			}
			/*Caso haja algum erro é mostrado essa mensagem ao usuário*/
			catch(Exception e){
				System.out.println("Entrada Inváilida \n");
			}

		}
	}

	/**
	 * 
	 * @param imobiliaria
	 * Recebe Objeto imobiliária
	 */
	public static void carregarModuloImovel(Imobiliaria imobiliaria){
		/*Variável criada para definir estado da ação*/
		boolean entradaValida=false;
		int op;
		Scanner in = new Scanner(System.in);
		/*sai do loop somente quando a variável entradaValida for igual a true, fazendo com que o usuário tenha 
		uma nova chance em escolher uma opção válida*/
		while(!entradaValida){
			/*Menu Módulo Imóvel*/
			System.out.println("MÓDULO IMÓVEL");
			System.out.println("1. Cadastrar Imóvel");
			System.out.println("2. Imprimir Imóveis Por Categoria e Tipo");
			System.out.println("3. Voltar");
			/*Tenta Executar o bloco de comandos dentro de try*/
			try{
				String input = in.nextLine();
				op = Integer.parseInt(input);
				/*Altera o valor de entradaValida, para que saia do loop se a opção digitada estiver no menu*/
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


						/*Intancia objeto imóvel passando os atributos de  endereço para ser instânciado
						 * dentro da classe Imovel*/
						Imovel imovel = new Imovel(0,"", 0, 0,false, cidade,rua,bairro,complemento);
						int idImovel;
						String nomeProprietario;
						Integer categoria,tipo;

						/*Para cada atributo lido de imóvel é setado o valor do imóvel*/
						System.out.println("Informe o Id do Imóvel: ");
						idImovel = in.nextInt();
						imovel.setIdImovel(idImovel);

						System.out.println("Informe o Nome do proprietário: ");
						nomeProprietario = in.next();
						imovel.setNomeProprietario(nomeProprietario);

						System.out.println("Informe a categoria do Imóvel: 1-Residencial/2-Comercial/3-Misto ");
						categoria = in.nextInt();

						/*Altera a categoria do imóvel se a categoria for residencial
						 conforme o valor do enum definido na classe Imovel*/
						if(categoria.equals(Categoria.RESIDENCIAL.getCodigo())){
							imovel.setCategoria(Categoria.RESIDENCIAL.getCodigo());
						}
						/*Altera a categoria do imóvel se a categoria for comercial
						 conforme o valor do enum definido na classe Imovel*/
						if(categoria.equals(Categoria.COMERCIAL.getCodigo())){
							imovel.setCategoria(Categoria.COMERCIAL.getCodigo());
						}
						/*Altera a categoria do imóvel se a categoria for mista
						 conforme o valor do enum definido na classe Imovel*/
						if(categoria.equals(Categoria.MISTO.getCodigo())){
							imovel.setCategoria(Categoria.MISTO.getCodigo());
						}

						System.out.println("Informe tipo do Imóvel: 1-Apartamento/2-Casa ");
						tipo = in.nextInt();

						/*Altera  tipo do imóvel se o tipo for casa
						 conforme o valor do enum definido na classe Imovel*/
						if(tipo.equals(Tipo.CASA.getCodigo())){
							imovel.setTipo(Tipo.CASA.getCodigo());
						}

						/*Altera  tipo do imóvel se o tipo for apartamento
						 conforme o valor do enum definido na classe Imovel*/
						if(tipo.equals(Tipo.APRTAMENTO.getCodigo())){
							imovel.setTipo(Tipo.APRTAMENTO.getCodigo());
						}

						/*Adiciona imóvel na lista de imóvel*/
						imobiliaria.adicionarImovel(imovel);

					}

					if(op==2){
						int categoria,tipo;
						System.out.println("Informea categoria do Imóvel1-Residencial/2-Comercial/3-Misto: ");
						categoria = in.nextInt();

						System.out.println("Informea o tipo do Imóvel:1-Apartamento/2-Casa  ");
						tipo = in.nextInt();

						/*Imprime os imóveis que são da mesma categoria e tipo, informados pelo usuário*/
						imobiliaria.imprimirImovelPorCategoriaAndTipo(categoria,tipo);

					}
				}
				else{
					/*Lança a excessão*/
					throw new Exception("A Entrada é Invalida");
				}
			}

			/*Caso haja algum erro é mostrado essa mensagem ao usuário*/
			catch(Exception e){
				System.out.println("Entrada Inváilida \n");
			}
		}
	}

	/**
	 * 
	 * @param imobiliaria
	 * Recebe Objeto imobiliária
	 */
	public static void carregarModuloContrato(Imobiliaria imobiliaria){
		/*Variável criada para definir estado da ação*/
		boolean entradaValida=false;
		int op;
		Scanner in = new Scanner(System.in);
		/*sai do loop somente quando a variável entradaValida for igual a true, fazendo com que o usuário tenha 
		uma nova chance em escolher uma opção válida*/
		while(!entradaValida){
			/*Menu do Módulo Contrato*/
			System.out.println("1. Gerar Contrato");
			System.out.println("2. Imprimir Contratos");
			System.out.println("3. Voltar");
			/*Tenta Executar o bloco de comandos dentro de try*/
			try{
				String input = in.nextLine();
				op = Integer.parseInt(input);
				/*Altera o valor de entradaValida, para que saia do loop se a opção digitada estiver no menu*/
				if(op == 1 ||op == 2 || op == 3){
					entradaValida = true;
					if(op==1){
						int numero,duracao,idImovel;
						double valorMensalAluguel,percentualImobiliaria;
						String nomeFiador, nomeLocatario, cpfFuncionario;

						/*nstancia objeto do tipo contrato*/
						Contrato contrato= new Contrato(null, null, null);
						System.out.println("Informe o CPF do funcionário");
						cpfFuncionario = in.next();
						/*Faz a busca do funcionário pelo seu CPF*/
						Funcionario funcionario = imobiliaria.buscarFuncionario(cpfFuncionario);
						/*Caso não encontre o funcionário exibe a mensagem Não Existe nenhum funcionário com esse CPF */
						if(funcionario == null ){
							System.out.println("Não Existe nenhum funcionário com esse CPF");
							return;
						}

						System.out.println("Informe o Id do Imóvel para a locação");
						idImovel = in.nextInt();
						/*Faz a busca do imovel pelo seu Id*/
						Imovel imovel = imobiliaria.buscarImovel(idImovel);
						/*Caso não encontre o imóvel exibe a mensagem Não Existe nenhum Imóvel com esse Id */
						if(imovel == null){
							System.out.println("Não existe Nenhim Imóvel com esse ID");
							return;
						}

						else{
							/*Para cada atributo lido de imóvel é setado o valor do imóvel*/
							System.out.println("Informe o numero do contrato");
							numero = in.nextInt();
							contrato.setNumero(numero);
							
							/*Caso encontre um contrato com o mesmo número lido 
							 exibe a mensagem Não Existe nenhum Imóvel com esse Id */
							if(imobiliaria.buscarContratos(numero) != null){
								System.out.println("Há existe um contrato com esse número");
								return;
							}

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

							/*Chama a funcão para gerar o contrato na classe funcionário*/
							contrato = funcionario.gerarContrato(contrato,funcionario,imovel);
							/*Adiciona o contrato na lista de contratos*/
							imobiliaria.adicionarContrato(contrato);

							/*lista de contratos do cpf lido, recebida como retorno do método buscarContratosPorCpf*/
							ArrayList<Contrato> listaContrato = imobiliaria.buscarContratosPorCpf(cpfFuncionario);

							/*Passa como parâmentro a lista de contratos do funcionário específico para calcuar
							  sua remuneração*/
							funcionario.calcularRemuneracao(listaContrato);
							/*Altera o status do imóvel para alugado*/
							imovel.setStatus(true);

							System.out.println("Contrato Firmado com sucesso");
						}
					}
					if(op==2){
						int numero;
						System.out.println("Informe o numero do contrato");
						numero = in.nextInt();
						/*Caso não encontre nenum contrato com o idContrato lido exibe a
						 mensagem Não existe nenhum contrato com esse número*/
						if(imobiliaria.buscarContratos(numero) == null){
							System.out.println("Não existe nenhum contrato com esse número");
						}
						/*Faz a busca do da lista de contratos pelo idContrato lido,
						 caso encontro imprime a lista de funcionários autônomos*/
						else{
							System.out.println(imobiliaria.buscarContratos(numero));
						}
					}
				}
				/*Lança excessão*/
				else{
					throw new Exception("A Entrada é Invalida");
				}
			}
			/*Caso haja algum erro é mostrado essa mensagem ao usuário*/
			catch(Exception e){
				System.out.println("Entrada Inváilida\n");
			}
		}

	}

	/**
	 * 
	 *@param args
	 *Função pricipal.
	 *Carrega o menu principal e aguarda a ação do usuário
	 */
	public static void main(String[] args) {
		/*Instancia objeto do tipo Imobiliaria*/
		Imobiliaria imobiliaria = new Imobiliaria();
		Scanner in = new Scanner(System.in);
		int opPrincipal;
		/*Executa instrução até o usuário digitar a opção 4*/
		do{
			/*A variável opPrincipal recebe o retorno da função carregarMenuPrincipal()*/
			opPrincipal = carregarMenuPrincipal(in);
			if(opPrincipal == 1){
				carregarModuloFuncionário(imobiliaria);
			}
			if(opPrincipal == 2){
				carregarModuloImovel(imobiliaria);
			}
			if(opPrincipal == 3){
				carregarModuloContrato(imobiliaria);
			}

		}while(opPrincipal != 4);
		System.out.println("O sistema foi encerrado");


	}
}
