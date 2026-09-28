import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;

        int n = sc.nextInt();
        String dictStr = sc.next();
        String pattern = sc.next();

        dictStr = dictStr.replaceAll("[{}]", "");
        String[] words = dictStr.split(",");
        
        List<WordInfo> matches = new ArrayList<>();

        for (String word : words) {
            word = word.trim();
            StringBuilder abbr = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    abbr.append(ch);
                }
            }
            if (abbr.toString().startsWith(pattern)) {
                matches.add(new WordInfo(word, abbr.toString()));
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No match found");
        } else {
            matches.sort((a, b) -> {
                int cmp = a.abbr.compareTo(b.abbr);
                return cmp != 0 ? cmp : a.word.compareTo(b.word);
            });
            for (WordInfo wi : matches) {
                System.out.println(wi.word);
            }
        }
    }

    static class WordInfo {
        String word, abbr;
        WordInfo(String word, String abbr) {
            this.word = word;
            this.abbr = abbr;
        }
    }
}
