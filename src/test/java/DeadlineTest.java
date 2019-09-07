import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    //Create variable named ldt of type LocalDateTime (2019-08-10 23:59)
    LocalDateTime ldt = LocalDateTime.of(2019,8,10,23,59);

    @Test
    public void test_byString_conversion() {
        assertEquals("2019-08-10 23:59", new Deadline("geog practical", ldt).byString(ldt));
    }

    @Test
    public void test_string_conversion() {
        assertEquals("[D][-] geog practical (by: 2019-08-10 23:59)", new Deadline("geog practical", ldt).toString());
    }

    @Test
    public void test_line_conversion() {
        assertEquals("D | 0 | geog practical | 2019-08-10 23:59", new Deadline("geog practical", ldt).writeLine());
    }
}
