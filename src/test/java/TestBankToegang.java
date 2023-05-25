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
        assertFalse(Bank.getToegangVault(false, false, false));
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

        //Testcase 1:
        assertFalse(Bank3.getToegangVault(false, true, 0));

        //Testcase 2:
        assertFalse(Bank3.getToegangVault(false, true, 17));

        //Testcase 3:
        assertFalse(Bank3.getToegangVault(false, true, 18));

        //Testcase 4:
        assertTrue(Bank3.getToegangVault(false, true, 19));

        //Testcase 5:
        assertTrue(Bank3.getToegangVault(false, true, 64));

        //Testcase 6:
        assertFalse(Bank3.getToegangVault(false, true, 65));

        //Testcase 7:
        assertFalse(Bank3.getToegangVault(false, true, 66));
    }

    /**
     * Test de toegang voor de bank met een pairwise coverage test
     */
    @Test
    public void TestBankToegangPairwise() {

        // Test case 1: (isbaas = true, ismanager = true, jareninDienst = 9, leeftijd = 17)
        assertTrue(Bank2.getToegangVault(true, true, 9, 17));

        // Test case 2: (isbaas = false, ismanager = false, jareninDienst = 8, leeftijd = 17)
        assertFalse(Bank2.getToegangVault(false, false, 8, 17));

        // Test case 3: (isbaas = true, ismanager = true, jareninDienst = 8, leeftijd = 30)
        assertTrue(Bank2.getToegangVault(true, true, 8, 30));

        // Test case 4: (isbaas = false, ismanager = false, jareninDienst = 9, leeftijd = 30)
        assertFalse(Bank2.getToegangVault(false, false, 9, 30));

        // Test case 5: (isbaas = false, ismanager = true, jareninDienst = 8, leeftijd = 15)
        assertFalse(Bank2.getToegangVault(false, true, 8, 15));

        // Test case 6: (isbaas = true, ismanager = false, jareninDienst = 9, leeftijd = 15)
        assertFalse(Bank2.getToegangVault(true, false, 9, 15));

    }
}
