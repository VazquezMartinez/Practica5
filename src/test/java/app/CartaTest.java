package app;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Carta;
import org.example.Figura;
import org.junit.jupiter.api.Test;

public class CartaTest {

    @Test
    public void probarCartaAs() {
        Carta carta = new Carta(1, Figura.CORAZONES);

        assertEquals("A de CORAZONES", carta.toString());
    }

    @Test
    public void probarCartaJ() {
        Carta carta = new Carta(11, Figura.ESPADAS);

        assertEquals("J de PICAS", carta.toString());
    }
}