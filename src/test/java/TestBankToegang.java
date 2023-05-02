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
        // Test case 1: baas heeft toegang
        assertTrue(Bank.getToegangVault(true, false, 8));
        // Test case 2: manager met meer dan 8 jaar in dienst heeft toegang
        assertTrue(Bank.getToegangVault(false, true, 9));

        // Test case 3: manager met minder dan 8 jaar in dienst heeft geen toegang tot kluis
        assertFalse(Bank.getToegangVault(false, true, 7));

        // Test case 4: werknemer heeft geen toegang tot kluis
        assertFalse(Bank.getToegangVault(false, false, 2));

        // Test case 5: klant heeft geen toegang tot kluis
        assertFalse(Bank.getToegangVault(false, false, 0));
    }

    /**
     * Test de toegang voor de bank met een multiple condition coverage test
     */
    @Test
    public void TestBankToegangMultible(){
        // Test case 1: baas heeft toegang tot de kluis en kassa
        assertTrue(Bank.getToegangVault(true, false, 0));

        // Test case 2: manager heeft toegang tot de kluis en kassa
        assertTrue(Bank.getToegangVault(false, true, 9));

        // Test case 3: manager heeft toegang tot de kassa, maar niet de kluis
        assertFalse(Bank.getToegangVault(false, true, 7));

        // Test case 4: werknemer heeft geen toegang tot de kluis of kassa
        assertFalse(Bank.getToegangVault(false, false, 0));
    }
}
