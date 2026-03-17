package com.example.springsample;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilityServiceTests {

    private final UtilityService service = new UtilityService();

    @Test
    void reverse_handlesNormalAndNull() {
        assertEquals("cba", service.reverse("abc"));
        assertEquals("", service.reverse(""));
        assertNull(service.reverse(null));
    }

    @Test
    void sumOfEvens_sumsOnlyEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(12, service.sumOfEvens(numbers)); // 2 + 4 + 6
    }

    @Test
    void sumOfEvens_handlesNullsAndEmptyList() {
        assertEquals(0, service.sumOfEvens(Collections.emptyList()));
        assertEquals(0, service.sumOfEvens(null));
        assertEquals(2, service.sumOfEvens(Arrays.asList(null, 2, null)));
    }

    @Test
    void averageLength_computesAverageIgnoringNulls() {
        List<String> words = Arrays.asList("hi", "there", null);
        // lengths: 2 and 5 -> avg = 3.5
        assertEquals(3.5, service.averageLength(words), 0.0001);
    }

    @Test
    void averageLength_handlesEmptyOrNull() {
        assertEquals(0.0, service.averageLength(Collections.emptyList()), 0.0001);
        assertEquals(0.0, service.averageLength(null), 0.0001);
    }

    @Test
    void shuffleCopy_returnsDifferentInstanceWithSameElements() {
        List<String> items = Arrays.asList("a", "b", "c", "d");
        List<String> shuffled = service.shuffleCopy(items);

        assertNotSame(items, shuffled);
        assertEquals(items.size(), shuffled.size());
        assertTrue(shuffled.containsAll(items));
    }

    @Test
    void randomGreeting_includesNameOrFallback() {
        String greetingWithName = service.randomGreeting("Saurabh");
        assertTrue(greetingWithName.contains("Saurabh"));

        String greetingAnon = service.randomGreeting("");
        assertTrue(greetingAnon.toLowerCase().contains("there"));
    }
}

