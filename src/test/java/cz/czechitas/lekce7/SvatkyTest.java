package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void vratKdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        // Přidání několika jmen do seznamu
        String jmenoJeVSeznamu = "Filip";
        String jmenoneniVSeznamu = "Dáša";

        boolean resultJeVSeznamu = svatky.jeVSeznamu(jmenoJeVSeznamu);
        boolean resultNeniVSeznamu = svatky.jeVSeznamu(jmenoneniVSeznamu);

        assertTrue(resultJeVSeznamu, "Očekávala jsem, že " + jmenoJeVSeznamu + " je v seznamu jmen.");
        assertFalse(resultNeniVSeznamu, "Očekávala jsem, že " + jmenoneniVSeznamu + " není v seznamu jmen.");
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //TODO Otestovat, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());

    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());

    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        // Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        String expectedName = "Filip";
        MonthDay expectedDate = MonthDay.of(5, 26);

        svatky.pridejSvatek("Filip", 26, 5);
        boolean isAdded = svatky.jeVSeznamu(expectedName);

        assertTrue(isAdded);
        assertEquals(expectedDate, svatky.vratKdyMaSvatek(expectedName));

    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        // Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();

        assertFalse(svatky.jeVSeznamu("Adam"));

        svatky.pridejSvatek("Adam", 2,Month.DECEMBER);

        assertTrue(svatky.jeVSeznamu("Adam"));

        assertEquals(2, svatky.vratKdyMaSvatek("Adam").getDayOfMonth());

        assertEquals(Month.DECEMBER, svatky.vratKdyMaSvatek("Adam").getMonth());

    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        assertFalse(svatky.jeVSeznamu("Dáša"));

        // ověření, že svátek má správný den
        svatky.pridejSvatek("Dáša", MonthDay.of(Month.DECEMBER, 20));
        assertEquals(20, svatky.vratKdyMaSvatek("Dáša").getDayOfMonth());

        assertEquals("DECEMBER", svatky.vratKdyMaSvatek("Dáša").getMonth().name());
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        // Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky();
        svatky.smazSvatek("Ferdinand");


        assertEquals(37 - 1, svatky.getPocetJmen());
        assertFalse(svatky.jeVSeznamu("Ferdinand"));
    }
}
