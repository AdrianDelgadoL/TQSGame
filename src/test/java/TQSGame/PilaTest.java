package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilaTest {

	@Test
	public void testAddCard() { //Test de m�todo addCard, con valores frontera
		Pila pilaOro = new Pila("Oro");
		
		assertEquals(pilaOro.peekCard(), null); //valor frontera: 0 cartas en la pila
		
		pilaOro.addCard(new Carta("Oro", 1));
		assertEquals(pilaOro.peekCard().getNum(), 1);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro");
		
		pilaOro.addCard(new Carta("Espada", 2));
		assertEquals(pilaOro.peekCard().getNum(), 1);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro");
		
		pilaOro.addCard(new Carta("Oro", 3));
		assertEquals(pilaOro.peekCard().getNum(), 1);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro");
		
		for(int i = 2; i <= 12; i++) {
			pilaOro.addCard(new Carta("Oro", i));
		}

		assertEquals(pilaOro.peekCard().getNum(), 12);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro"); //valor de frontera: pila completa
		
		pilaOro.addCard(new Carta("Oro", 13));
		assertEquals(pilaOro.peekCard().getNum(), 12);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro"); //valor fuera de l�mites: no hay m�s de 12 cartas por palo.
		
	}

}
