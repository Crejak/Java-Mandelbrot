
public class Imaginary {
	private double re;
	private double im;

	public Imaginary(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public Imaginary add(Imaginary other) {
		return new Imaginary(this.re + other.getRe(), this.im + other.getIm());
	}
	
	public Imaginary mul(Imaginary other) {
		return new Imaginary(this.re*other.getRe()-this.im*other.getIm(),
				this.re*other.getIm()+this.im*other.getRe());
	}
	
	public double squaredMod() {
		return this.re*this.re + this.im*this.im;
	}
	
	public double mod() {
		return Math.sqrt(this.re*this.re + this.im*this.im);
	}
	
	public double getRe() {
		return this.re;
	}
	
	public void setRe(double re) {
		this.re = re;
	}
	
	public double getIm() {
		return this.im;
	}
	
	public void setIm(double im) {
		this.im = im;
	}

	public String toString() {
		if (this.im >= 0) {
			return this.re + " + i" + this.im;
		} else {
			return this.re + " - i" + (-this.im);
		}
	}
}
