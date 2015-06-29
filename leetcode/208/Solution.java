class TrieNode {
    // Initialize your data structure here.
    private char ch;
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode(char ch) {
        this.ch = ch;
        this.isWord = false;
        children = new TrieNode[26];
    }

    public TrieNode getChild(char child) {
        return children[child - 'a'];
    }

    public TrieNode addChild(char child) {
        if (children[child - 'a'] == null) {
            children[child - 'a'] = new TrieNode(child);
        }
        return children[child - 'a'];
    }

    public void setWord() {
        this.isWord = true;
    }

    public boolean isWord() {
        return this.isWord;
    }

}

//private final static  int NUM = 26;
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('R');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int length = word.length();
        TrieNode node = this.root;
        char ch;
        for (int i = 0; i < length; i++) {
            ch = word.charAt(i);
            if (node.getChild(ch) != null) {
                node = node.getChild(ch);
            } else {
                node = node.addChild(ch);
            }
        }
        node.setWord();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int length = word.length();
        TrieNode node = this.root;
        char ch;
        for (int i = 0; i < length; i++) {
            ch = word.charAt(i);
            if (node.getChild(ch) == null)
                return false;
            node = node.getChild(ch);
        }
        return node.isWord();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int length = prefix.length();
        TrieNode node = this.root;
        char ch;
        for (int i = 0; i < length; i++) {
            ch = prefix.charAt(i);
            if (node.getChild(ch) == null)
                return false;
            node = node.getChild(ch);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");