package problem01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem01 {

    /**
     * Write a console program which is used to process a string and return the
     * longest word in that string. Keep in mind that if there are two or more
     * words with the same length, return the first word from the string with
     * that length. Words can contain numbers, for example “Java is great123”.
     */
    //run Problem1.
    public void run() {
        boolean invalid = true;
        String words = "";
        do {
            words = getString();
            invalid = checkInput(words);
        } while (invalid == false);
        //if there is no space then it is longest word. show it and return.
        if (!words.contains(" ")) {
            System.out.println("Longest word is: " + words);
            return;
        }
        //find the longest word if the String has more word.
        String longestWord = getLongestWord(getListWord(words));
        System.out.println("Longest word is: " + longestWord);
    }

    //get words from the keyboard.
    public String getString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please put something!");
        return sc.nextLine().trim();
    }

    //get list word from entered string
    public List<String> getListWord(String string) {
        List<String> listWord = new ArrayList<>();
        int star = 0;
        for (int i = 0; i < string.length(); i++) {
            //get word in the string.
            if (string.charAt(i) == ' ') {
                String word = string.substring(star, i);
                if (!word.isEmpty()) {
                    listWord.add(word);
                }
                star = i + 1;
            }
            //get the last word in the string.
            if (string.lastIndexOf(" ") == i && i < string.length() - 1) {
                String word = string.substring(star, string.length());
                listWord.add(word);
            }
        }
        return listWord;
    }

    //get the longest word from list word.
    public String getLongestWord(List<String> listWord) {
        String longestWord = "";
        for (String s : listWord) {
            if (s.length() > longestWord.length()) {
                longestWord = s;
            }
        }
        return longestWord;
    }

    //validate data from the keyboard.
    private boolean checkInput(String string) {
        String regex = "^[a-zA-Z0-9\\s]*$";
        if (string.isEmpty()) {
            return false;
        }
        if (!string.matches(regex)) {
            System.out.println("Words accepts only numbers (0-9) and word characters");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem01 p = new Problem01();
        p.run();
    }
}