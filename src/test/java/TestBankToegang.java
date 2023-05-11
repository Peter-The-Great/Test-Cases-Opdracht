import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.pjotr.Bank;
import org.pjotr.Bank2;
import org.pjotr.Bank3;

public class TestBankToegang {

    /**
     * Test de toegang voor de bank met een condition coverage test
     * Hiermee moet in ieder geval elke conditie een keer waar en een keer onwaar zijn
     * dus twee keer.
     */
    @Test
    public void TestBankToegangCondition(){
        // Test case 1: Alle conditions staan op true
        assertTrue(Bank.getToegangVault(true, true, true));

        // Test case 2: Alle conditions staan op false
        assertFalse(Bank.getToegangVault(false, false, false));
    }

    /**
     * Test de toegang voor de bank met een decision coverage test
     */
    @Test
    public void TestBankToegangDecision() {
        // Test case 1: Baas heeft toegang tot kluis en kassa. Een keer true.
        assertTrue(Bank.getToegangVault(true, false, false));

        // Test case 2: Manager heeft toegang tot kassa, maar niet de kluis. Een keer false.
        assertFalse(Bank.getToegangVault(false, true, false));
    }

    /**
     * Test de toegang voor de bank met een condition/decision coverage test
     */
    @Test
    public void TestBankToegangCONDITIONDECISION() {
        //Testcase 1: De baas heeft toegang tot de kluis en kassa
        assertTrue(Bank.getToegangVault(true, false, false));

        //Testcase 2: De manager heeft toegang tot de kluis en kassa
        assertTrue(Bank.getToegangVault(false, true, true));

        //Testcase 3: Normale medewerkers krijgen geen toegang tot de kluis of kassa
        assertFalse(Bank.getToegangVault(false, false, false));
    }

    /**
     * Test de toegang voor de bank met een modified condition/decision coverage test
     */
    @Test
    public void TestBankToegangModified(){
        // Testcase 1:
        assertTrue(Bank.getToegangVault(true, false, false));

        // Testcase 2:
        assertFalse(Bank.getToegangVault(false, true, false));

        // Testcase 3:
        assertFalse(Bank.getToegangVault(false, false, true));

        // Testcase 4:
        assertTrue(Bank.getToegangVault(false, true, true));

        // Testcase 5:
        assertTrue(Bank.getToegangVault(true, true, true));

        // Testcase 6:
        assertFalse(Bank.getToegangVault(false, false, false));

        // Testcase 7:
        assertTrue(Bank.getToegangVault(true, true, false));

        // Testcase 8:
        assertTrue(Bank.getToegangVault(true, false, true));
    }

    /**
     * Test de toegang voor de bank met een multiple condition coverage test
     */
    @Test
    public void TestBankToegangMultible(){
        // Testcase 1:
        assertTrue(Bank.getToegangVault(true, false, false));

        // Testcase 2:
        assertFalse(Bank.getToegangVault(false, true, false));

        // Testcase 3:
        assertFalse(Bank.getToegangVault(false, false, true));

        // Testcase 4:
        assertTrue(Bank.getToegangVault(false, true, true));

        // Testcase 5:
        assertTrue(Bank.getToegangVault(true, true, true));

        // Testcase 6:
        assertFalse(Bank.getToegangVault(false, false, false));

        // Testcase 7:
        assertTrue(Bank.getToegangVault(true, true, false));

        // Testcase 8:
        assertTrue(Bank.getToegangVault(true, false, true));
    }

    /**
     * Test de toegang voor de bank met een all-uses coverage met een boundary coverage test voor leeftijd
     */
    @Test
    public void TestBankToegangEquivelentenRandwaarden(){
        // Testen van geldige input

        //Testcase 1: leeftijd < 18
        assertFalse(Bank3.getToegangVault(false, true, 0));

        //Testcase 2: leeftijd < 18
        assertFalse(Bank3.getToegangVault(false, true, 18));

        //Testcase 3: leeftijd > 18
        assertTrue(Bank3.getToegangVault(false, true, 19));

        //Testcase 4: leeftijd = 65
        assertFalse(Bank3.getToegangVault(false, true, 65));

        //Testcase 5: leeftijd > 65
        assertFalse(Bank3.getToegangVault(false, true, 66));

        // Testen van ongeldige input

        //Testcase 6: leeftijd < 0
        assertFalse(Bank3.getToegangVault(false, true, -1));

        //Testcase 7: leeftijd > 120
        assertFalse(Bank3.getToegangVault(false, true, 121));
    }

    /**
     * Test de toegang voor de bank met een pairwise coverage test
     */
    @Test
    public void TestBankToegangPairwise(){
        // Testcase 1: alle waarden zijn minimumwaarden
        assertFalse(Bank2.getToegangVault(false, false, 1, 18));

        // Testcase 2: isbaas = true en de overige waarden zijn minimumwaarden
        assertTrue(Bank2.getToegangVault(true, false, 1, 18));

        // Testcase 3: ismanager = true en jareninDienst > 8 en leeftijd > 18 en leeftijd < 65
        assertTrue(Bank2.getToegangVault(false, true, 9, 19));

        // Testcase 4: ismanager = true en jareninDienst <= 8 en leeftijd > 18 en leeftijd < 65
        assertFalse(Bank2.getToegangVault(false, true, 8, 19));

        // Testcase 5: leeftijd = 16 en de overige waarden zijn maximumwaarden
        assertFalse(Bank2.getToegangVault(false, false, 0, 18));

        // Testcase 6: isbaas = true en de overige waarden zijn maximumwaarden
        assertTrue(Bank2.getToegangVault(true, false, 30, 64));

        // Testcase 7: ismanager = true en jareninDienst > 8 en leeftijd = 65
        assertFalse(Bank2.getToegangVault(false, true, 9, 65));

        // Testcase 8: ismanager = false en leeftijd = 19
        assertFalse(Bank2.getToegangVault(false, false, 1, 19));

        // Testcase 9: ismanager = true en jareninDienst = 8 en leeftijd = 18
        assertFalse(Bank2.getToegangVault(false, true, 8, 18));

        // Testcase 10: alle waarden zijn maximumwaarden
        assertFalse(Bank2.getToegangVault(false, false, 30, 65));
    }
}
