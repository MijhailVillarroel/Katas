import org.fundacionjala.katas.EANValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEvan {

    @Test
    public void test_01() {
        assertTrue(EANValidator.validate("9783815820865"));
    }

    @Test
    public void test_02() {
        assertFalse(EANValidator.validate("9783815820864"));
    }

    @Test
    public void test_03() {
        assertTrue(EANValidator.validate("9783827317100"));
    }
}