package it.overnet.web;

public class A {
	
	public Telefono telefono;

	public void metodo1() {
		System.out.println("metodo 1");
		B b = new B();
		b.metodo2();
		
		GestoreStudenti gs = new GestoreStudenti();
		gs.salvaUnoStudente();
		
		telefono.chiama();
	}
}
