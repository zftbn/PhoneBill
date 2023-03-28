import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBillTest {
    private PhoneBill phoneBill;

    @BeforeEach
    public void setUp() {
        phoneBill = new PhoneBill();
    }

    // 测试等价类1：0分钟<=通话时长<1分钟
    @Test
    public void testCalculateBillLessThanOneMinute() {
        int min = 1/6;
        double expectedBill = 0.05;
        double delta = 0.001;
        assertEquals(expectedBill, phoneBill.Money(min), delta);
    }

    // 测试等价类2：1分钟<=通话时长<=20分钟
    @Test
    public void testCalculateBillMoreThanOneMinute() {
        int min = 10;
        double expectedBill = 0.5;
        double delta = 0.001;
        assertEquals(expectedBill, phoneBill.Money(min), delta);
    }

    // 测试等价类3：通话时长>=20分钟
    @Test
    public void testCalculateBillMoreThanTwentyMinute() {
        int min = 60;
        double expectedBill = 5;
        double delta = 0.001;
        assertEquals(expectedBill, phoneBill.Money(min), delta);
    }

    @DisplayName(value = "等价类测试用例")
    @CsvFileSource(resources = "/等价类测试用例.csv", numLinesToSkip = 1, encoding = "UTF-8")
    void fileTest(int min, double expected) throws ParseException {
        double delta = 0.001;
        assertEquals(expected, phoneBill.Money(min), delta);
    }
}
