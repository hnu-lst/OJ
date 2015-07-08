/**
 * Created by HNULST on 2015/7/8.
 */
public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        System.out.println("---");
        wd.addWord("abc");
        System.out.println(wd.search("..."));
    }

    private Trie trie;

    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, this.trie.getRoot());
    }

    private boolean dfs(String word, TrieNode root) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) == '.') {
                for (char child = 'a'; child <= 'z'; child++) {
                    if (root.getChild(child) != null) {
                        if (dfs(word.substring(i + 1), root.getChild(child)))
                            return true;
                    }
                }
                return false;
            } else {
                if (root.getChild(word.charAt(i)) != null) {
                    root = root.getChild(word.charAt(i));
                } else {
                    return false;
                }
            }
        }
        return root.isWord();
    }

    private class TrieNode {
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

    private class Trie {

        private TrieNode root;

        public TrieNode getRoot() {
            return this.root;
        }

        public Trie() {
            root = new TrieNode('R');
        }

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
}

