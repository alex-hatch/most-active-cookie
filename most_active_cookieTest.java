import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class most_active_cookieTest {
    static Map<String, Integer> cookieCount = new HashMap<>();

    @BeforeAll
    static void initAll() {
        cookieCount.put("AtY0laUfhglK3lC7",2);
        cookieCount.put("SAZuXPGUrfbcn5UA",2);
        cookieCount.put("5UAVanZf6UtGyKVS",1);
        cookieCount.put("4sMM2LxV07bPJzwf",2);
        cookieCount.put("fbcn5UAVanZf6UtG",1);
    }

    @Test
    void maxCount() {
        assertEquals(2, most_active_cookie.maxCount(cookieCount));
    }

    @Test
    void getDate() {
        String line1 = "AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00\n";
        String line2 = "SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00\n";
        String line3 = "5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00\n";
        String badLine = "this is not a valid line";
        String shortDate = "5UAVanZf6UtGyKVS,2018-08-21T07:25:00+00:00\n";

        assertEquals("2018-12-09", most_active_cookie.getDate(line1));
        assertEquals("2018-12-09", most_active_cookie.getDate(line2));
        assertEquals("2018-12-09", most_active_cookie.getDate(line3));
        assertEquals("2018-08-21", most_active_cookie.getDate(shortDate));
        assertNull(most_active_cookie.getDate(badLine));
    }

    @Test
    void getCookie() {
        String line1 = "AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00\n";
        String line2 = "SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00\n";
        String line3 = "5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00\n";
        String shortDate = "5UAVanZf6UtGyKVS,2018-08-21T07:25:00+00:00\n";
        String badLine = "this is not a valid line";

        assertEquals("AtY0laUfhglK3lC7", most_active_cookie.getCookie(line1));
        assertEquals("SAZuXPGUrfbcn5UA", most_active_cookie.getCookie(line2));
        assertEquals("5UAVanZf6UtGyKVS", most_active_cookie.getCookie(line3));
        assertEquals("5UAVanZf6UtGyKVS", most_active_cookie.getCookie(shortDate));
        assertNull(most_active_cookie.getCookie(badLine));
    }
}