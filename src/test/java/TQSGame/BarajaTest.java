package TQSGame;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BarajaTest {
	


	@Test
	public void test() { //Testea los m�todos de Baraja por test de caja negra.
		Baraja baraja = new Baraja();
		
		Carta carta = baraja.pullCard();
		
		assertEquals(47, baraja.getNumCartas()); //comprueba que se ha extraido exitosamente
		assertEquals("Oro", carta.getPalo()); // comprobar la carta que se saca
		assertEquals(1, carta.getNum());
		baraja.addCard(carta);				 //comprueba el a�adir carta
		assertEquals(48, baraja.getNumCartas()); //caja negra, mira que se ha a�adido la carta correctamente
		carta = baraja.pullCard();
		assertEquals("Oro", carta.getPalo());
		assertEquals(2, carta.getNum());
		
		for(int i = 0; i < 45; i++)
			carta = baraja.pullCard();
		
		assertEquals(2, baraja.getNumCartas());
		
		baraja.pullCard();
		carta = baraja.pullCard(); //�ltima carta de la baraja, valor l�mite
		
		assertEquals(0, baraja.getNumCartas());
		assertEquals(null, baraja.pullCard()); //Una baraja sin cartas
		
		
	}

}
