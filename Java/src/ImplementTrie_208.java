public class ImplementTrie_208 {
    class TrieNode {
        TrieNode[] children;
        char character;
        boolean isEnd;

        TrieNode(){
            character = '#';
            children = new TrieNode[26];
            isEnd = false;
        }

        TrieNode(char c){
            character = c;
            children = new TrieNode[26];
            isEnd = false;
        }

        public boolean containsChild(char c) {
            return (children[c-'a'] != null);
        }

        public TrieNode addChild(char c) {
            TrieNode child = new TrieNode(c);
            children[c-'a'] = child;
            return child;
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie_208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() < 1) return;
        char firstChar = word.charAt(0);
        TrieNode node = root.getChild(firstChar);
        if (node == null) {
            node = root.addChild(firstChar);
        }
        TrieNode parent = node;
        for (int i = 1; i < word.length(); ++i) {
            char curr = word.charAt(i);
            node = parent.getChild(curr);
            if (node == null) {
                node = parent.addChild(curr);
            }
            parent = node;
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char firstChar = word.charAt(0);
        TrieNode node = root.getChild(firstChar);
        if (node == null) return false;
        TrieNode parent = node;
        for (int i = 1; i < word.length(); ++i) {
            char curr = word.charAt(i);
            node = parent.getChild(curr);
            if (node == null) return false;
            parent = node;
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char firstChar = prefix.charAt(0);
        TrieNode node = root.getChild(firstChar);
        if (node == null) return false;
        TrieNode parent = node;
        for (int i = 1; i < prefix.length(); ++i) {
            char curr = prefix.charAt(i);
            node = parent.getChild(curr);
            if (node == null) return false;
            parent = node;
        }
        return true;
    }
}
