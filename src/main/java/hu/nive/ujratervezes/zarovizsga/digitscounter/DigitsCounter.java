package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.ArrayList;
import java.util.List;

public class DigitsCounter {

    public int getCountOfDigits(String text) {
        if (text == null) {
            return 0;
        }
        char[] characters = text.toCharArray();
        List<Character> listOfCountedDigits = new ArrayList<>();
        for (char actual : characters) {
            if (Character.isDigit(actual) && !listOfCountedDigits.contains(actual)) {
                listOfCountedDigits.add(actual);
            }
        }
        return listOfCountedDigits.size();
    }
}
