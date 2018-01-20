package br.dcc.ufla.poo.sistemaAlugueisImvoves;

/**
 * 
 * Classe responsável definir atributos e métodos de Imóvel. 
 * É composta por um objeto endereço, que é instanciado ao criar um ojeto imóvel
 *
 */
public class Imovel {
	
	private int idImovel;
	private String nomeProprietario;
	private int categoria;
	private int tipo;
	private boolean status;
	private Endereco endereco;
	
	/**
	 * 
	 * Enum criado para definir a categoria do imóvel (Residencial/Comercial ou Misto).
	 * Constantes que deixam o código mais legível e contriburm para a corretude do código.
	 * Para capturar código(int) ou descricao (String) de uma constante.
	 * 
	 *
	 */
	public enum Categoria {

		RESIDENCIAL(1, "Residencial"),
		COMERCIAL(2, "Comercial"),
		MISTO(3, "Misto");
		
		private int codigo;
		
		private String descricao;
		
		private Categoria(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public Integer getCodigo() {
			return codigo;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
		public static String getDescricao(Integer codigo) {
			
			for(Categoria status : Categoria.values()) {
				if(status.getCodigo().equals(codigo)) {
					return status.getDescricao();
				}
			}
			
			return "";
		}
	}
	
	/**
	 * 
	 * Enum criado para definir a tipo do imóvel (Apartamento/Casa).
	 * Constantes que deixam o código mais legível e contribuem para a corretude do código.
	 * Para capturar código(int) ou descricao (String) de uma constante.
	 * 
	 *
	 */
	public enum Tipo {

		APRTAMENTO(1, "Apartamento"),
		CASA(2, "Casa");
		
		private int codigo;
		
		private String descricao;
		
		private Tipo(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public Integer getCodigo() {
			return codigo;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
		public static String getDescricao(Integer codigo) {
			
			for(Tipo status : Tipo.values()) {
				if(status.getCodigo().equals(codigo)) {
					return status.getDescricao();
				}
			}
			
			return "";
		}
	}
	
	
	public Imovel(int idImovel, String nomeProprietario, int categoria, int tipo,boolean status, String cidade, String rua, String bairro, String complemento) {
		this.idImovel=idImovel;
		this.nomeProprietario = nomeProprietario;
		this.categoria=categoria;
		this.tipo=tipo;
		this.status = status;
		this.endereco=  new Endereco(cidade,rua,bairro,complemento);
		
	}
	
	/**
	 * 
	 * @return idImovel
	 * Retorna o id do imóvel. Um inteiro
	 */
	public int getIdImovel() {
		return idImovel;
	}

	/**
	 * 
	 * @param idImovel
	 * O inteiro id do imóvel é recebido como parâmentro para alterar a id do imóvel do objeto
	 */
	public void setIdImovel(int idImovel) {
		this.idImovel = idImovel;
	}

	/**
	 * 
	 * @return nomePropretario
	 * Retorna o id do proprietário. Uma String
	 */
	public String getNomeProprietario() {
		return nomeProprietario;
	}

	/**
	 * 
	 * @param nomeProprietario
	 * A String nome do proprietário é recebida como parâmentro para alterar o nome do proprietário 
	 * do imóvel do objeto
	 */
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	/**
	 * 
	 * @return categoria
	 * Retorna a categoria. um inteiro
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * 
	 * @param categoria
	 * O inteiro categoria é recebido como parâmentro para alterar a categoria do imóvel do objeto
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	/**
	 * 
	 * @return tipo
	 * Retorna o tipo. um inteiro
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 * O inteiro tipo é recebido como parâmentro para alterar o tipo do imóvel do objeto
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * 
	 * @return String Alugado ou Disponível
	 * se o status(boolean) for true então o imóvel estará alugado, senão disponível
	 */
	public String getStatus()  {
		if(status == true){
			return "Alugado";
		}
		return "Disponível";

	}

	/**
	 * 
	 * @param status
	 * O booleano status é recebido como parâmentro para alterar o status do objeto
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @return endereco
	 * Retorna objeto endereco composto no imóvel
	 */
	public Endereco getEndereco(){
		return endereco;
	}

	

	/**
	 * Sobresecreve o método toString
	 */
	@Override
	public String toString() {
		return "\n Nome do Proprietario: " + getNomeProprietario() +"\n"
				+ "categoria: "+ getCategoria() +"\n"
				+"tipo: " + getTipo()+"\n" 
				+"Status: " + getStatus()+"\n"
				//Acessa o objeto endereco e retorna o atributo cidade
				+"Cidade: "+getEndereco().getCidade()+"\n"
				//Acessa o objeto endereco e retorna o atributo rua
				+"Rua: "+getEndereco().getRua()+"\n"
				//Acessa o objeto endereco e retorna o atributo bairro
				+"Bairro: "+getEndereco().getBairro()+"\n"
				//Acessa o objeto endereco e retorna o atributo complemento
				+"Complemento: "+getEndereco().getComplemento()+"\n";
	}
		
}
