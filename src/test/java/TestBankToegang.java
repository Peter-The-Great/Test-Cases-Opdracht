import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.pjotr.Bank;
public class TestBankToegang {

    /**
     * Test de toegang voor de bank met een condition coverage test
     */
    @Test
    public void TestBankToegangCondition(){
        assertEquals("De baas heeft toegang tot de kluis en kassa", Bank.getToegangVault(true, true, true, 15));
        assertEquals("De manager heeft toegang tot de kluis en kassa", Bank.getToegangVault(true, false, true, 9));
        assertEquals("De manager heeft toegang tot de kassa", Bank.getToegangVault(true, false, true, 7));
        assertEquals("De Werknemer heeft toegang tot de kluis", Bank.getToegangVault(true, false, false, 1));
    }
}
