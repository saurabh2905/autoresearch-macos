package com.example.springsample;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class UtilityService {

    private final Random random = new Random();

    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public int sumOfEvens(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }
        return numbers.stream()
                .filter(n -> n != null && n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double averageLength(List<String> words) {
        if (words == null || words.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        int count = 0;
        for (String w : words) {
            if (w != null) {
                total += w.length();
                count++;
            }
        }
        return count == 0 ? 0.0 : (double) total / count;
    }

    public List<String> shuffleCopy(List<String> items) {
        if (items == null) {
            return Collections.emptyList();
        }
        List<String> copy = new ArrayList<>(items);
        Collections.shuffle(copy, random);
        return copy;
    }

    public String randomGreeting(String name) {
        String base = (name == null || name.isBlank()) ? "there" : name;
        String[] templates = new String[]{
                "Hello, %s!",
                "Hi %s, nice to see you.",
                "Greetings, %s.",
                "Yo %s!",
                "Good day, %s."
        };
        String template = templates[random.nextInt(templates.length)];
        return String.format(template, base);
    }
}

