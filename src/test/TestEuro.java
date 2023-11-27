package test;
import static org.junit.Assert.*;
import org.junit.Test;
import code.Business_logic.Euro;

public class TestEuro {

   

    @Test
    public void testCostruttoreEuroConValorePositivo() {
        Euro euro = new Euro(20, 50);
        assertEquals(1050, euro.getValore());
    }

    @Test
    public void testCostruttoreEuroConValoreNegativo() {
        Euro euro = new Euro(-5, 30);
        assertEquals(-530, euro.getValore()); 
    }

    @Test
    public void testCostruttoreEuroConDouble() {
        Euro euro = new Euro(12.75);
        assertEquals(1275, euro.getValore());
    }

    @Test
    public void testSomma() {
        Euro euro1 = new Euro(10, 50);
        Euro euro2 = new Euro(5, 25);
        Euro risultato = euro1.somma(euro2);
        assertEquals(1575, risultato.getValore());
    }

    @Test
    public void testSottrai() {
        Euro euro1 = new Euro(10, 50);
        Euro euro2 = new Euro(5, 25);
        Euro risultato = euro1.sottrai(euro2);
        assertEquals(525, risultato.getValore());
    }

    @Test
    public void testUgualeA() {
        Euro euro1 = new Euro(10, 50);
        Euro euro2 = new Euro(10, 50);
        assertTrue(euro1.ugualeA(euro2));
    }

    @Test
    public void testNonUgualeA() {
        Euro euro1 = new Euro(10, 50);
        Euro euro2 = new Euro(5, 25);
        assertFalse(euro1.ugualeA(euro2));
    }

    @Test
    public void testMinoreDi() {
        Euro euro1 = new Euro(5, 25);
        Euro euro2 = new Euro(10, 50);
        assertTrue(euro1.minoreDi(euro2));
    }

    @Test
    public void testNonMinoreDi() {
        Euro euro1 = new Euro(10, 50);
        Euro euro2 = new Euro(5, 25);
        assertFalse(euro1.minoreDi(euro2));
    }

    @Test
    public void testStampa() {
        Euro euro = new Euro(12.75);
        assertEquals("12.75 euro", euro.stampa());
    }
}

