import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class StreamOfCharacters_1032 {

    class Trie {
        class TrieNode {
            Map<Character, TrieNode> children;
            char character;
            boolean isEnd;

            TrieNode(char c) {
                character = c;
                children = new HashMap<>();
                isEnd = false;
            }

            public char getChar() {
                return character;
            }

            public void setEnd(boolean isEnd) {
                this.isEnd = isEnd;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public boolean containsChild(char c) {
                return children.containsKey(c);
            }

            public TrieNode getChild(char c) {
                if (children.containsKey(c)) return children.get(c);
                else return null;
            }

            public void addChild(char c) {
                if (children.containsKey(c)) return; // Do not add because already in children map
                TrieNode node = new TrieNode(c);
                children.put(c, node);
            }
        }


        Trie() {
            firstLetterMap = new HashMap<>();
        }

        Map<Character, TrieNode> firstLetterMap;

        public void addWord(String s) {
            int len = s.length();
            if (len == 0) return;

            char firstChar = s.charAt(len - 1);
            TrieNode firstNode = firstLetterMap.getOrDefault(firstChar, new TrieNode(firstChar));
            firstLetterMap.put(firstChar, firstNode);
            TrieNode prevNode = firstNode;
            for (int i = len - 2; i >= 0; --i) {
                char curr = s.charAt(i);
                prevNode.addChild(curr);
                TrieNode child = prevNode.getChild(curr);
                prevNode = child;
            }
            prevNode.setEnd(true);
        }

        // Check if the buffer contains a trie word
        public boolean contains(LinkedList<Character> buffer) {
            if (buffer.size() < 1) return false;
            Iterator<Character> iter = buffer.descendingIterator();
            char first = iter.next();
            TrieNode node = firstLetterMap.getOrDefault(first, null);
            while (iter.hasNext()) {
                char curr = iter.next();
                if (node != null && node.isEnd()) return true;
                if (node != null && node.containsChild(curr)) {
                    node = node.getChild(curr);
                } else {
                    return false;
                }
            }
            return (node != null) ? node.isEnd() : false;
        }
    }

    int longestWord; // Store the length of the longest word from the inital list
    // This is used as a buffer length to compare the stream against

    LinkedList<Character> buffer;
    Trie trie;

    public StreamOfCharacters_1032(String[] words) {
        trie = new Trie();
        longestWord = 0;
        for (String word : words) {
            trie.addWord(word);
            if (word.length() > longestWord) longestWord = word.length();
        }
        buffer = new LinkedList<>();
    }

    public boolean query(char letter) {
        //System.out.println(letter);
        if (buffer.size() >= longestWord) {
            buffer.poll();
        }
        buffer.add(letter);
        return trie.contains(buffer);
    }
}
