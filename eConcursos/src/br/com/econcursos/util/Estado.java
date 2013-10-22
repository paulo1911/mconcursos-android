/**
 * 
 */
package br.com.econcursos.util;

/**
 * @author Paulo
 * 
 */
public enum Estado {

			Todos("Todos","all"),
			Acre("Acre","ac"), Alagoas("Alagoas","al"), Amapa("Amapa", "ap"), Amazonas("Amazonas","am"), Bahia(
			"Bahia","ba"), Ceara("Ceará","ce"), Distrito_Federal("Distrito Federal","df"), Espirito_Santo(
			"Espirito Santo", "es"), Goias("Goiás", "go"), Maranhao("Maranhão","ma"), Mato_Grosso(
			"Mato Grosso", "mt"), Mato_Grosso_do_Sul("Mato Grosso do Sul","ms"), Minas_Gerais(
			"Minas Gerais","mg"), Para("Pará","pa"), Paraiba("Paraíba", "pb"), Parana("Paraná","pr"), Pernambuco(
			"Pernambuco","pe"), Piaui("Piauí","pi"), Rio_de_Janeiro("Rio de Janeiro","rj"), Rio_Grande_do_Norte(
			"Rio Grande do Norte","rn"), Rio_Grande_do_Sul("Rio Grande do Sul","rs"), Rondonia(
			"Rondonia","ro"), Roraima("Roraima","rr"), Santa_Catarina("Santa Catarina","sc"), Sao_Paulo(
			"São Paulo","sp"), Sergipe("Sergipe","se"), Tocantins("Tocantins","to");

	Estado(String nome, String sigla) {
		this.nomeEstado = nome;
		this.sigla = sigla;
	}

	public static Estado getEstado(String estado) {
		if (estado != null) {
			for (Estado e : values()) {
				if (estado.equalsIgnoreCase(e.name()))
					return e;
			}
		}
		return null;
	}
	
	private String nomeEstado = null;
	private String sigla = null;
	
	public String nomeEstado() {
		return this.nomeEstado;
	}
	
	public String getSigla() {
		return this.sigla;
	}

}
