import java.util.*;

class WordSearchII_212 {
    class Trie {
        class TrieNode {
            char val;
            List<TrieNode> children;
            boolean isEndOfWord;

            TrieNode() {
                val = '0';
                children = new ArrayList<>();
                isEndOfWord = false;
            }

            TrieNode(char val, boolean isEndOfWord) {
                this.val = val;
                children = new ArrayList<>();
                this.isEndOfWord = isEndOfWord;
            }

            // Returns the TrieNode made from the child
            TrieNode addChild(char c, boolean isEndOfWord) {
                for (TrieNode child : children) {
                    if (child.val == c && child.isEndOfWord == isEndOfWord) {
                        return child;
                    }
                }
                TrieNode newChild = new TrieNode(c, isEndOfWord);
                children.add(newChild);
                return newChild;
            }

            // Return the child with the given char
            TrieNode findChild(char c) {
                for (TrieNode child : children) {
                    if (child.val == c) {
                        return child;
                    }
                }
                return null; // If child was not found among children
            }

            // Return whether an end child with the given character was found
            boolean isNextCharEnd(char c) {
                for (TrieNode child : children) {
                    if (child.val == c && child.isEndOfWord) {
                        return true;
                    }
                }
                return false; // If end child was not found among children
            }
        }

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        // Add word to trie
        void addWord(String word) {
            char[] chars = word.toCharArray();
            TrieNode currentNode = root.addChild(chars[0], word.length() == 1); // Add first char
            // Add all of the characters after the first and before the last
            for (int i = 1; i < chars.length - 1; i++) {
                currentNode = currentNode.addChild(chars[i], false);
            }
            if (word.length() > 1) {
                currentNode.addChild(chars[chars.length - 1], true); // Add last char
            }
        }

        boolean containsFirst(char firstChar) {
            return root.findChild(firstChar) != null;
        }

        // Returns whether these characters are contained in the tree (but not necessarily a full word)
        boolean subContains(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                currentNode = currentNode.findChild(word.charAt(i));
                if (currentNode == null) {
                    return false;
                }
            }
            return true;
        }

        // Returns whether the full word is contained in the tree
        boolean containsFullWord(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length() - 1; i++) {
                currentNode = currentNode.findChild(word.charAt(i));
                if (currentNode == null) {
                    return false;
                }
            }
            return currentNode.isNextCharEnd(word.charAt(word.length() - 1));
        }
    }

    class Coor {
        int i;
        int j;

        Coor(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {

            // null check
            if (o == null) {
                return false;
            }

            // this instance check
            if (this == o) {
                return true;
            }

            // instanceof Check and actual value check
            if ((o instanceof Coor) && (((Coor) o).i == this.i) && (((Coor) o).j == this.j)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int result = 0;
            result = i * 100000 + j;
            return result;
        }
    }

    Set<String> foundWordsSet = new LinkedHashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();
        Trie trie = new Trie();

        for (String word : words) {
            // Put words into trie
            trie.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If the first letter is in the trie
                if (trie.containsFirst(board[i][j])) {
                    // Search trie for word in all board directions
                    HashSet<Coor> coors = new HashSet<>();
                    String firstLetterString = String.valueOf(board[i][j]);
                    if (trie.containsFullWord(firstLetterString)) {
                        foundWordsSet.add(firstLetterString);
                    }
                    Coor startingCoor = new Coor(i, j);
                    coors.add(startingCoor);
                    dfsForWord(i, j, board, trie, firstLetterString, coors);
                }
            }
        }

        for (String foundWord : foundWordsSet) {
            foundWords.add(foundWord);
        }

        return foundWords;
    }

    // Search for whether the word is contained in the board
    // Return the word if it is in the board or null if not
    public String dfsForWord(int i, int j, char[][] board, Trie trie, String found, HashSet<Coor> coors) {
        int currI, currJ;
        Coor oneCoor = new Coor(-1, 0);
        Coor twoCoor = new Coor(0, -1);
        Coor threeCoor = new Coor(1, 0);
        Coor fourCoor = new Coor(0, 1);
        ArrayList<Coor> coorList = new ArrayList<>();

        coorList.add(oneCoor);
        coorList.add(twoCoor);
        coorList.add(threeCoor);
        coorList.add(fourCoor);

        for (Coor coor : coorList) {
            int iOffset = coor.i;
            int jOffset = coor.j;
            String newWord;
            currI = i + iOffset;
            currJ = j + jOffset;
            Coor currCoor = new Coor(currI, currJ);
            if (isValidCoor(currI, currJ, board) && !coors.contains(currCoor)) {
                newWord = found + board[currI][currJ];
            } else {
                continue;
            }
            if (trie.subContains(newWord)) {
                //dps the word
                if (trie.containsFullWord(newWord) && !foundWordsSet.contains(newWord)) {
                    foundWordsSet.add(newWord);
                }
                coors.add(currCoor);
                dfsForWord(currI, currJ, board, trie, newWord, coors);
            }
        }

        return null;
    }

    // Return whether the coordinate is on the board
    public boolean isValidCoor(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length) {
            return false;
        } else if (j < 0 || j >= board[0].length) {
            return false;
        } else {
            return true;
        }
    }
}