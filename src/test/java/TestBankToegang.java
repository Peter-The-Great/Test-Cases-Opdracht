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
        assertTrue(Bank.getToegangVault(false, true, false, 0));

        // Test case 2: manager met meer dan 8 jaar dienst heeft toegang
        assertTrue(Bank.getToegangVault(true, false, true, 9));

        // Test case 3: manager met minder dan 8 jaar dienst heeft geen toegang tot kluis
        assertFalse(Bank.getToegangVault(true, false, true, 5));

        // Test case 4: werknemer zonder managersrechten heeft geen toegang tot kluis
        assertFalse(Bank.getToegangVault(true, false, false, 0));

        // Test case 5: klanten hebben geen toegang
        assertFalse(Bank.getToegangVault(false, false, false, 0));
    }

    /**
     * Test de toegang voor de bank met een decision coverage test
     */
    @Test
    public void TestBankToegangDecision() {
        // Testcase 1: baas heeft toegang tot de kluis en kassa
        boolean resultaat = Bank.getToegangVault(false, true, false, 0);
        assertTrue(resultaat);

        // Testcase 2: werknemer is manager met meer dan 8 jaar in dienst, heeft toegang tot kluis en kassa
        resultaat = Bank.getToegangVault(true, false, true, 9);
        assertTrue(resultaat);

        // Testcase 3: werknemer is manager met minder dan 8 jaar in dienst, heeft toegang tot kassa, maar niet kluis
        resultaat = Bank.getToegangVault(true, false, true, 7);
        assertFalse(resultaat);

        // Testcase 4: werknemer is geen manager, heeft toegang tot kassa, maar niet kluis
        resultaat = Bank.getToegangVault(true, false, false, 0);
        assertFalse(resultaat);

        // Testcase 5: klanten hebben geen toegang tot de kluis of kassa
        resultaat = Bank.getToegangVault(false, false, false, 0);
        assertFalse(resultaat);
    }

    /**
     * Test de toegang voor de bank met een condition/decision coverage test
     */
    @Test
    public void TestBankToegangCONDITIONDECISION() {
        // Decision 1: isbaas
        assertTrue(Bank.getToegangVault(false, true, false, 0));
        assertFalse(Bank.getToegangVault(false, false, false, 0));

        // Decision 2a: !isbaas && iswerknemer && !ismanager
        assertFalse(Bank.getToegangVault(true, false, false, 0));
        assertFalse(Bank.getToegangVault(true, false, false, 8));
        assertFalse(Bank.getToegangVault(true, false, false, 9));

        // Decision 2b: !isbaas && iswerknemer && ismanager
        assertFalse(Bank.getToegangVault(true, false, true, 0));
        assertFalse(Bank.getToegangVault(true, false, true, 8));
        assertTrue(Bank.getToegangVault(true, false, true, 9));

        // Decision 2c: !isbaas && !iswerknemer
        assertFalse(Bank.getToegangVault(false, false, false, 0));
    }
    @Test
    public void TestBankToegangModified(){
        // Test case 1: isbaas is true
        assertTrue(Bank.getToegangVault(true, true, false, 0));

        // Test case 2: iswerknemer is false
        assertFalse(Bank.getToegangVault(false, false, false, 0));

        // Test case 3: iswerknemer is true, ismanager is true, jareninDienst > 8
        assertTrue(Bank.getToegangVault(true, false, true, 10));

        // Test case 4: iswerknemer is true, ismanager is true, jareninDienst < 8
        assertFalse(Bank.getToegangVault(true, false, true, 5));

        // Test case 5: iswerknemer is true, ismanager is false
        assertFalse(Bank.getToegangVault(true, false, false, 0));
    }
    @Test
    public void TestBankToegangMultible(){
        // Test case 1: isbaas is true
        boolean result1 = Bank.getToegangVault(false, false, false, 0);
        assertFalse(result1);

        // Test case 2: iswerknemer is false
        boolean result2 = Bank.getToegangVault(true, false, false, 0);
        assertFalse(result2);

        // Test case 3: iswerknemer is true, ismanager is true, jareninDienst > 8
        boolean result3 = Bank.getToegangVault(true, false, true, 4);
        assertFalse(result3);

        // Test case 4: iswerknemer is true, ismanager is true, jareninDienst < 8
        boolean result4 = Bank.getToegangVault(true, false, true, 9);
        assertTrue(result4);

        // Test case 5: iswerknemer is true, ismanager is false
        boolean result5 = Bank.getToegangVault(true, true, false, 0);
        assertTrue(result5);

        // Test case 6: iswerknemer is true, ismanager is false
        boolean result6 = Bank.getToegangVault(true, true, false, 4);
        assertTrue(result6);

        // Test case 7: iswerknemer is true, ismanager is false
        boolean result7 = Bank.getToegangVault(true, true, false, 9);
        assertTrue(result7);

        // Test case 8: iswerknemer is true, ismanager is false
        boolean result8 = Bank.getToegangVault(true, true, true, 0);
        assertTrue(result8);

        // Test case 9: iswerknemer is true, ismanager is false
        boolean result9 = Bank.getToegangVault(true, true, true, 4);
        assertTrue(result9);

        // Test case 10: iswerknemer is true, ismanager is false
        boolean result10 = Bank.getToegangVault(true, true, true, 9);
        assertTrue(result10);
    }
}
