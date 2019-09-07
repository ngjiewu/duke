import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    //Create variable named ldt of type LocalDateTime (2019-08-08 10:00)
    LocalDateTime ldt = LocalDateTime.of(2019,8,8,10,0);

    @Test
    public void test_atString_conversion() {
        assertEquals("2019-08-08 10:00", new Event("team meeting", ldt).atString(ldt));
    }

    @Test
    public void test_string_conversion() {
        assertEquals("[E][-] team meeting (at: 2019-08-08 10:00)", new Event("team meeting", ldt).toString());
    }

    @Test
    public void test_line_conversion() {
        assertEquals("E | 0 | team meeting | 2019-08-08 10:00", new Event("team meeting", ldt).writeLine());
    }
}
