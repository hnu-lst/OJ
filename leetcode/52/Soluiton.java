public class Solution {
    private static List<List<String>> solutions;
    private int boardSize;
    private int[] board; // board[x] = y; 代表点[x,y]放了一个皇后
    private int INITIAL = -1000;

    public int totalNQueens(int n) {
        solutions = new LinkedList<List<String>>();
        boardSize = n;
//        System.out.println("boardSize = " + boardSize);
        board = new int[boardSize];
        Arrays.fill(board, INITIAL);
//        for (int i = 0; i < boardSize; i++)
//            System.out.println("board[" + i + "] = " + board[i]);
        queen();
        return solutions.size();
    }


    void queen()      //N皇后程序
    {
        int n = 0;
        int i = 0, j = 0;
        while (i < boardSize) {
//            System.out.println(" x = " + i);
            while (j < boardSize)        //对i行的每一列进行探测，看是否可以放置皇后
            {
//                System.out.println(" y = " + j);
                if (isValid(i, j))     //该位置可以放置皇后
                {
                    board[i] = j;        //第i行放置皇后
                    j = 0;           //第i行放置皇后以后，需要继续探测下一行的皇后位置，所以此处将j清零，从下一行的第0列开始逐列探测
                    break;
                } else {
                    ++j;             //继续探测下一列
                }
            }
            if (board[i] == INITIAL)        //第i行没有找到可以放置皇后的位置
            {
                if (i == 0)             //回溯到第一行，仍然无法找到可以放置皇后的位置，则说明已经找到所有的解，程序终止
                    break;
                else                    //没有找到可以放置皇后的列，此时就应该回溯
                {
                    --i;
                    j = board[i] + 1;        //把上一行皇后的位置往后移一列
                    board[i] = INITIAL;      //把上一行皇后的位置清除，重新探测
                    continue;
                }
            }
            if (i == boardSize - 1)          //最后一行找到了一个皇后位置，说明找到一个结果，打印出来
            {
                addToSol();
                j = board[i] + 1;             //从最后一行放置皇后列数的下一列继续探测
                board[i] = INITIAL;           //清除最后一行的皇后位置
                continue;
            }
            ++i;              //继续探测下一行的皇后位置
        }
    }

    private void addToSol() {
        List<String> sol = new ArrayList<String>();
        for (int i = 0; i < boardSize; i++) {
            char[] line = new char[boardSize];
            Arrays.fill(line, '.');
            line[board[i]] = 'Q';
            sol.add(String.valueOf(line));
        }
        solutions.add(sol);
    }

    private boolean isValid(int x, int y) {
        for (int i = 0; i < boardSize; i++) {
            if (board[i] == y)//该列已经放了
                return false;
            if (Math.abs(i - x) == Math.abs(board[i] - y))
                return false;
        }
        return true;
    }
}