public class Vertice{
	private String rotulo;
	private int grau;
	
	public Vertice(String rotulo)throws Exception{
		boolean isRotuloNullOrBlank = (rotulo == null || (rotulo != null && "".equals(rotulo.trim())));
		if(isRotuloNullOrBlank)
			throw new Exception("Não é permitida a inclusão de vértices sem rótulo!");
		this.rotulo = rotulo;
	}

	public String getRotulo(){
		return this.rotulo;
	}
	
	public int getGrau(){
		return this.grau;
	}

	public void addGrau(){
		grau++;
	}
}