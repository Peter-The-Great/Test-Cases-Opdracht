import org.junit.jupiter.api.Test;
public class TestHardloop {
    @Test
    public void testHardloop() {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
    }
}
