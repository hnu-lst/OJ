public class Solution {
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static Trie trie;
    private static List<String> result;
    private void dfs(char[][] board, int x, int y, String pre) {//遍历的路径如果在字典树中不存在该词则直接结束
        int xm = board.length;
        int ym = board[0].length;
        if (x < 0 || x >= xm || y < 0 || y >= ym) return;
        if (board[x][y] == '$') return;
        char old = board[x][y];
        board[x][y] = '$';
        pre += old;
        if (!trie.startsWith(pre)) {
            board[x][y] = old;
            return;
        }
        if (trie.search(pre)) {
            if (!result.contains(pre))
                result.add(pre);
        }
        for (int i = 0; i < 4; i++) {
            dfs(board, x + dir[i][0], y + dir[i][1], pre);
        }
        board[x][y] = old;
    }

    public List<String> findWords(char[][] board, String[] words) {
        result = new LinkedList<String>();
        int num = words.length;
        if (num == 0) return result;
        trie = new Trie();
        for (int i = 0; i < num; i++) {//将所有待查询的词加入字典树
            trie.insert(words[i]);
        }
        int xm = board.length;
        int ym = board[0].length;
        for (int x = 0; x < xm; x++) {
            for (int y = 0; y < ym; y++) {
                dfs(board, x, y, "");
            }
        }
        Collections.sort(result);
        return result;
    }

    static class TrieNode {
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
    static class Trie {
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
}