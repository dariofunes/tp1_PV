package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
	private final Integer INGREDIENTES_ESPECIALES_20 = 500;
	private final Integer INGREDIENTES_ESPECIALES_30 = 750;
	private final Integer INGREDIENTES_ESPECIALES_40 = 1000;
	
	private Integer diametro;
	private Float precio;
	private Float area;
	private boolean ingredientesEspeciales;
	
	public Pizza() {
		// TODO Auto-generated constructor stub
	}
	
	public String mostrarDatos() {
		return "\nDiametro= " + diametro + "\nIngredientes Especiales= " + ingredientesEspeciales
				+ "\nPrecio de la Pizza= $" + precio + "\nArea de la Pizza= " + area + "\n";
	}
	
	public void calcularPrecio() {
		switch (this.getDiametro()) {
		case 20: {
			if(this.isIngredientesEspeciales())
				this.setPrecio((float) 4500+INGREDIENTES_ESPECIALES_20);
			else
				this.setPrecio(4500f);
			break;
		}
		case 30: {
			if(this.isIngredientesEspeciales())
				this.setPrecio((float) 4800+INGREDIENTES_ESPECIALES_30);
			else
				this.setPrecio(4800f);
			break;
		}
		case 40: {
			if(this.isIngredientesEspeciales())
				this.setPrecio((float) 5500+INGREDIENTES_ESPECIALES_40);
			else
				this.setPrecio(5500f);
			break;
		}
		default:
			System.out.println("Los valores esperados son: 20, 30, 40.");
		}
	}
	
	public void calcularArea() {
		this.setArea( (float) Math.PI * (float) Math.pow(this.getDiametro()/2, 2) );
	}
	
	public Integer getDiametro() {
		return diametro;
	}

	public void setDiametro(Integer diametro) {
		this.diametro = diametro;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public boolean isIngredientesEspeciales() {
		return ingredientesEspeciales;
	}

	public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
		this.ingredientesEspeciales = ingredientesEspeciales;
	}
}
