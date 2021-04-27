package com.calc.example;

public class Calculator 
{
	ICalculator icalc;
	
	public Calculator(){
	}
	public Calculator(ICalculator icalc){
		this.icalc = icalc;
	}
	public double add(double d1, double d2) {
		return icalc.add(d1, d2);
	}
	public double subtract(double d1, double d2) {
		return icalc.subtract(d1, d2);
	}
	public double multiply(double d1, double d2) {
		return icalc.multiply(d1, d2);
	}
	public double divide(double d1, double d2) {
		return icalc.divide(d1, d2);
	}

	public double double15() {
		return 15.0;
	}
}
