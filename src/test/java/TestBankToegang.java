import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.pjotr.Bank;
public class TestBankToegang {

    /**
     * Test de toegang voor de bank met een condition coverage test
     * Hiermee moet in ieder geval elke conditie een keer waar en een keer onwaar zijn
     */
    @Test
    public void TestBankToegangCondition(){
        // Test case 1: baas heeft toegang
        assertTrue(Bank.getToegangVault(true, false, 0));

        // Test case 2: manager heeft toegang tot kluis en kassa
        assertTrue(Bank.getToegangVault(false, true, 9));

        // Test case 3: manager heeft alleen toegang tot kassa
        assertFalse(Bank.getToegangVault(false, true, 5));

        // Test case 4: klant heeft geen toegang
        assertFalse(Bank.getToegangVault(false, false, 0));
    }

    /**
     * Test de toegang voor de bank met een decision coverage test
     */
    @Test
    public void TestBankToegangDecision() {
        // Test case 1: Baas heeft toegang tot kluis en kassa
        assertTrue(Bank.getToegangVault(true, false, 0));

        // Test case 2: Manager heeft toegang tot kluis en kassa
        assertTrue(Bank.getToegangVault(false, true, 10));

        // Test case 3: Manager heeft toegang tot kassa, maar niet de kluis
        assertFalse(Bank.getToegangVault(false, true, 5));

        // Test case 4: Klant heeft geen toegang tot kluis of kassa
        assertFalse(Bank.getToegangVault(false, false, 0));
    }

    /**
     * Test de toegang voor de bank met een condition/decision coverage test
     */
    @Test
    public void TestBankToegangCONDITIONDECISION() {
        // Decision 1: isbaas
        assertTrue(Bank.getToegangVault(true, false, 0)); // expected output: true
        assertFalse(Bank.getToegangVault(false, false, 0)); // expected output: false

        // Decision 2: ismanager
        assertTrue(Bank.getToegangVault(false, true, 10)); // expected output: true
        assertFalse(Bank.getToegangVault(false, false, 10)); // expected output: false

        // Decision 3: jareninDienst > 8
        assertTrue(Bank.getToegangVault(false, true, 10)); // expected output: true
        assertFalse(Bank.getToegangVault(false, true, 5)); // expected output: false
    }

    /**
     * Test de toegang voor de bank met een modified condition/decision coverage test
     */
    @Test
    public void TestBankToegangModified(){

        // Testcase 1: De baas heeft toegang tot de kluis en kassa
        assertTrue(Bank.getToegangVault(true, false, 0));
        assertFalse(Bank.getToegangVault(false, false, 0));

        // Testcase 2: De manager heeft meer dan 8 jaar in dienst en heeft toegang tot de kluis en kassa
        assertTrue(Bank.getToegangVault(false, true, 9));
        assertFalse(Bank.getToegangVault(false, true, 8));

        // Testcase 3: De manager heeft minder dan 8 jaar in dienst en heeft alleen toegang tot de kassa
        assertFalse(Bank.getToegangVault(false, true, 7));

        // Testcase 4: Er is geen
        assertFalse(Bank.getToegangVault(false, false, 0));
    }

    /**
     * Test de toegang voor de bank met een multiple condition coverage test
     */
    @Test
    public void TestBankToegangMultible(){
        // Test case 1: alle drie de voorwaarden zijn waar
        assertTrue(Bank.getToegangVault(true, true, 9));

        // Test case 2: isbaas is waar, ismanager en jareninDienst zijn niet van belang
        assertTrue(Bank.getToegangVault(true, false, 4));

        // Test case 3: ismanager is waar en jareninDienst is minder dan 8
        assertFalse(Bank.getToegangVault(false, true, 5));

        // Test case 4: ismanager is waar en jareninDienst is gelijk aan 8
        assertFalse(Bank.getToegangVault(false, true, 8));

        // Test case 5: ismanager is waar en jareninDienst is meer dan 8
        assertTrue(Bank.getToegangVault(false, true, 10));

        // Test case 6: isbaas en ismanager zijn onwaar, jareninDienst is minder dan 8
        assertFalse(Bank.getToegangVault(false, false, 5));

        // Test case 7: isbaas en ismanager zijn onwaar, jareninDienst is gelijk aan 8
        assertFalse(Bank.getToegangVault(false, false, 8));

        // Test case 8: isbaas en ismanager zijn onwaar, jareninDienst is meer dan 8
        assertFalse(Bank.getToegangVault(false, false, 10));
    }

    /**
     * Test de toegang voor de bank met een all-uses coverage test
     */
    @Test
    public void TestBankToegangEquivelent(){
        // Testen van geldige input
        // Testen van isBaas
        assertTrue(Bank.getToegangVault(true, false, 0)); // Equivalentieklasse: isbaas = true
        assertFalse(Bank.getToegangVault(false, false, 0)); // Equivalentieklasse: isbaas = false, ismanager = false
        assertFalse(Bank.getToegangVault(false, true, 7)); // Equivalentieklasse: isbaas = false, ismanager = true, jareninDienst < 8
        assertFalse(Bank.getToegangVault(false, true, 8)); // Equivalentieklasse: isbaas = false, ismanager = true, jareninDienst = 8
        assertTrue(Bank.getToegangVault(false, true, 9)); // Equivalentieklasse: isbaas = false, ismanager = true, jareninDienst > 8

        // Testen van ongeldige input
        assertFalse(Bank.getToegangVault(false, true, -1)); // Equivalentieklasse: jareninDienst < 0
    }
    /**
     * Test de toegang voor de bank met een boundary coverage test
     */
    @Test
    public void TestBankToegangRandwaarden(){
        //Testcase 1: baas
        assertTrue(Bank.getToegangVault(true, false, 0));

        //Testcase 2: manager, jareninDienst > 8
        assertTrue(Bank.getToegangVault(false, true, 9));

        //Testcase 3: manager, jareninDienst == 8
        assertFalse(Bank.getToegangVault(false, true, 8));

        //Testcase 4: manager, jareninDienst < 8
        assertFalse(Bank.getToegangVault(false, true, 7));

        //Testcase 5: klant
        assertFalse(Bank.getToegangVault(false, false, 0));
    }

    /**
     * Test de toegang voor de bank met een pairwise coverage test
     */
    @Test
    public void TestBankToegangPairwise(){
        // Test case 1: isbaas = false, ismanager = false, jareninDienst = 0
        assertFalse(Bank.getToegangVault(false, false, 0));

        // Test case 2: isbaas = false, ismanager = true, jareninDienst = 1
        assertFalse(Bank.getToegangVault(false, true, 1));

        // Test case 3: isbaas = false, ismanager = true, jareninDienst = 8
        assertFalse(Bank.getToegangVault(false, true, 8));

        // Test case 4: isbaas = false, ismanager = true, jareninDienst = 9
        assertTrue(Bank.getToegangVault(false, true, 9));

        // Test case 5: isbaas = true, ismanager = false, jareninDienst = 0
        assertTrue(Bank.getToegangVault(true, false, 0));

        // Test case 6: isbaas = true, ismanager = true, jareninDienst = 1
        assertTrue(Bank.getToegangVault(true, true, 1));

        // Test case 7: isbaas = true, ismanager = true, jareninDienst = 8
        assertTrue(Bank.getToegangVault(true, true, 8));

        // Test case 8: isbaas = true, ismanager = true, jareninDienst = 9
        assertTrue(Bank.getToegangVault(true, true, 9));
    }
}
