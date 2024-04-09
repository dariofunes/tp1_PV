package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
	private Integer n;
	
	public CalculadoraEspecial() {
		// TODO Auto-generated constructor stub
	}
	
	public double calcularSumatoria() {
		double sum = 0;
		for(int i=1;i<=this.getN();i++) {
			sum += Math.pow(i*(i+1)/2, 2);
		}
		return sum;
	}
	
	public double calcularProductoria() {
		double prod = 1;
		for(int i=1;i<=this.getN();i++) {
			prod *= i*(i+4);
		}
		return prod;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}
	
	
}
