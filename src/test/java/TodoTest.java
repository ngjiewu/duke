import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void test_string_conversion() {
        assertEquals("[T][-] read geog textbook", new Todo("read geog textbook").toString());
    }

    @Test
    public void test_line_conversion() {
        assertEquals("T | 0 | read geog textbook", new Todo("read geog textbook").writeLine());
    }
}
