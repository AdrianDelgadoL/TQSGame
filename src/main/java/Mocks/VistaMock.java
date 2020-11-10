package Mocks;

import TQSGame.*;

/**
 * 
 * @author Adrian Delgado Lopez
 * 
 * Este mock simula una vista para el controlador del juego Game. Envia se�ales para modificar el estado del Tablero a trav�s de Game i
 * "imprime" (devuelve el estado de) los elementos del tablero para poder hacer tests sobre Game.
 * 
 */

public class VistaMock {
	Game game = null;
	
	public VistaMock(Game game) {
		this.game = game;
	}
	
	public void mostraTablero() {
		this.printBaraja();
		this.printCartaFuera();
		this.printColumnas();
		this.printPilas();
	}
	
	public boolean printBaraja() { return game.getBarajaStatus(); } //En este mock usare los print para devolver el estado del Game para los tests
	public Carta printCartaFuera() { return game.getCartaFuera(); }
	public Columna[] printColumnas() { return game.getColumnas(); }
	public Pila[] printPilas() { return game.getPilas(); }
	
	public void sacaCarta() { game.getCartaFuera(); }
	public void mueveCarta(int idOrigen, int idDestino) { game.setCartaMovida(idOrigen); game.addCartaDestino(idDestino); } //el ID identificar� de donde se coge la carta y a donde se mueve: 0 es de la carta de la baraja, 1-7 seran las columnas, 8-11 seran las pilas.
	public void mueveColumna(int colOrigen, int colDestino, int nCartas) { game.mueveColumna(colOrigen, colDestino, nCartas); }
	
	
}
