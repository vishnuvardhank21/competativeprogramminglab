import java.io.*;
import java.util.*;

public class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    static TrieNode root = new TrieNode();

    static void insert(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    static boolean search(String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current != null && current.isEndOfWord;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        String[] keys;

        if (sc.hasNext()) {
            String keysInput = sc.next();
            if (keysInput.contains(",")) {
                keys = keysInput.split(",");
            } else {
                keys = new String[n];
                keys[0] = keysInput;
                for (int i = 1; i < n; i++) {
                    keys[i] = sc.next();
                }
            }
        } else {
            keys = new String[0];
        }

        for (String key : keys) {
            insert(key);
        }

        if (sc.hasNext()) {
            String searchWord = sc.next();
            System.out.println(search(searchWord) ? 1 : 0);
        }
    }
}
