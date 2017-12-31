package br.dcc.ufla.poo.sistemaAlugueisImvoves;

public class Imovel {
	
	private int idImovel;
	private String nomeProprietario;
	private int categoria;
	private int tipo;
	private boolean status;
	private Endereco endereco;
	
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
	
	public int getIdImovel() {
		return idImovel;
	}


	public void setIdImovel(int idImovel) {
		this.idImovel = idImovel;
	}


	public String getNomeProprietario() {
		return nomeProprietario;
	}


	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public String getStatus()  {
		if(status == true){
			return "Alugado";
		}
		return "Disponível";

	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Endereco getEndereco(){
		return endereco;
	}
	public void setEndereco(Endereco endereco){
		this.endereco=endereco;
	}
	


	@Override
	public String toString() {
		return "Nome do Proprietario: " + getNomeProprietario() +"\n"
				+ "categoria: "+ getCategoria() +"\n"
				+"tipo: " + getTipo()+"\n" 
				+"Status: " + getStatus()+"\n"
				+"Cidade: "+getEndereco().getCidade()+"\n"
				+"Rua: "+getEndereco().getRua()+"\n"
				+"Bairro: "+getEndereco().getBairro()+"\n"
				+"Complemento: "+getEndereco().getComplemento()+"\n";
	}
		
}
