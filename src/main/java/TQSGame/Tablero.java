package TQSGame;

import java.util.ArrayList;
import java.util.List;

import Mocks.RandomBaraja;

//public interface Tablero { //De momento es una interficie para poder implementar el mock
public class Tablero { 
	Baraja baraja = new Baraja();
	Pila[] pilas = {new Pila("Oro"), new Pila("Copa"), new Pila("Espada"), new Pila("Basto")};
	Carta cartaFuera = null;
	Columna[] columnas = { new Columna(), new Columna(), new Columna(), new Columna(), new Columna(), new Columna(), new Columna() };
	
	public void addAPila(Carta carta, String paloPila) {
		switch(paloPila) {
		case "Oro": pilas[0].addCard(carta);
		case "Copa": pilas[1].addCard(carta);
		case "Espada": pilas[2].addCard(carta);
		case "Basto": pilas[3].addCard(carta);
		}
	}

	public void sacaCarta() { 
		if(cartaFuera == null) 
			cartaFuera = baraja.pullCard();
		else {
			baraja.addCard(cartaFuera);
			cartaFuera = baraja.pullCard();
		}
			
	}
	//public void setColumnas(int idCol, Columna col) { columnas[idCol] = col; }
	
	public void moverAColumna(int columnaOrigen, int columnaDestino, int cartasAMover) { //Si cartasAMover == 1, se mueve 1 carta sola de un sitio a otro.
		if((columnaOrigen >= 0 && columnaOrigen <= 7) && (columnaDestino >= 0 && columnaOrigen <= 7))
		if(cartasAMover == 1) {
			columnas[columnaDestino].addCard(columnas[columnaOrigen].pullCard());
		}
		else if( cartasAMover > 1 && cartasAMover <= columnas[columnaOrigen].getNumCartasReveladas() ) 
			columnas[columnaDestino].addColumna(columnas[columnaOrigen].pullColumna(cartasAMover));
	} 
	
	public Carta sacaCartaColumna(int columna) { return columnas[columna].pullCard(); }
	
	public Pila[] getPilas() { return pilas;}
	
	public Columna[] getColumnas() { return columnas; }
	
	public void addCartaColumna(int columna, Carta carta) { columnas[columna].addCard(carta); }

	public boolean getBaraja() { return baraja.getNumCartas() > 0; }	
	
	public void repartirCartas() {
		for(int i = 1; i <= 3; i++) {
			for(int j = 0; j < i; j++) {
				sacaCarta();
				if(j == (i - 1))
					columnas[i-1].addCard(cartaFuera);
				else
					columnas[i-1].addCartaOculta(cartaFuera);
			}
		}
		sacaCarta();
	}	

	public Carta getCartaFuera() { return cartaFuera; }
	
	public void setCartaNull() { cartaFuera = null; }

	public void setCartaFuera(Carta cartaMovida) { cartaFuera = cartaMovida;}
	
	public boolean pilasLlenas() { return (pilas[0].pilaLlena() && pilas[1].pilaLlena() && pilas[2].pilaLlena() && pilas[3].pilaLlena()); }
}
