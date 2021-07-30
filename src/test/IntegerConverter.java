package test;

import java.util.*;

public class IntegerConverter {
	
/*
 * Этот класс нашел в Википедии
 */

    public static String arabicToRoman(int number) {
        if (number > 100 || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    public static int romanToArabic(String number) {
    	//^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$
        int result = 0;
        for(Integer key : units.descendingKeySet()) {
        	while (number.startsWith(units.get(key))) {
                number = number.replaceFirst(units.get(key), "");
                result += key;
            }
        }
        return result;
    }    
    
    private static final NavigableMap<Integer, String> units;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }
}