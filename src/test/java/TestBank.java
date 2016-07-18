import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mijhailvillarroel on 7/11/2016.
 */
public class TestBanks {

    private Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testEntryNumber() {
        final String entry = "    _  _     _  _  _  _  _ " +
                "  | _| _||_||_ |_   ||_||_|" +
                "  ||_  _|  | _||_|  ||_| _|";
        final String expectResult = "123456789";
        assertEquals(expectResult, bank.convertReadNumberToStringNumber(bank.readEntry(entry)));
    }

    @Test
    public void testEntryRead() {
        final String entry = "    _  _     _  _  _  _  _ " +
                "  || | _||_||_||_   ||_||_|" +
                "  ||_| _|  ||_||_|  ||_| _|";
        final String expectResult = "103486789";
        assertEquals(expectResult, bank.convertReadNumberToStringNumber(bank.readEntry(entry)));
    }

    @Test
    public void testEntryReadUnKnow() {
        final String entry =
                "    _  _     _  _  _  _  _ " +
                        "  || | _||_||_||_   ||_||_|" +
                        "  ||_| _|  ||_|| |  ||_| _|";
        final String expectedNum = "10348?789";
        assertEquals(expectedNum, bank.convertReadNumberToStringNumber(bank.readEntry(entry)));
    }

    @Test
    public void testEntryReadInvalidAccount() {
        final String entry = "345882864";
        final String expectedNum = "345882864 ERR";
        assertEquals(expectedNum, bank.formatAccountNumbers(entry));
    }

    @Test
    public void testEntryOutputFormat() {
        final String entry = "10348?789";
        final String expectedNum = "10348?789 ILL";
        assertEquals(expectedNum, bank.formatAccountNumbers(entry));

    }

    @Test
    public void testIsValidAccount() {
        final String account = "103486789";
        assertEquals(account, bank.formatAccountNumbers(account));
    }

    @Test
    public void testBank() {
        final String number5 = "    _  _     _  _  _  _  _ " +
                "  | _| _||_||_ |_   ||_||_|" +
                "  ||_  _|  | _||_|  ||_| _ ";
        Assert.assertEquals(bank.formatAccountNumbers(bank.convertReadNumberToStringNumber(bank.readEntry(number5))), "12345678?ILL");
    }
}
