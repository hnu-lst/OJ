import java.util.Arrays;

public class Codec {
    private void pre(TreeNode root, StringBuilder sb) {
        if (null == root) return;
        sb.append("," + String.valueOf(root.val) + root.toString().substring(8));
        pre(root.left, sb);
        pre(root.right, sb);
    }

    private void in(TreeNode root, StringBuilder sb) {
        if (null == root) return;
        in(root.left, sb);
        sb.append("," + String.valueOf(root.val) + root.toString().substring(8));
        in(root.right, sb);
    }

    private TreeNode generate(String[] preOrder, String[] inOrder) {
        int len = preOrder.length;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(Integer.parseInt(preOrder[0].split("@")[0]));
        TreeNode root = new TreeNode(Integer.parseInt(preOrder[0].split("@")[0]));
        int idx = 0;
        String addr = preOrder[0].split("@")[1];
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i].split("@")[1].equals(addr)) {
                idx = i;
                break;
            }
        }
        root.left = generate(Arrays.copyOfRange(preOrder, 1, 1 + idx),
                             Arrays.copyOfRange(inOrder, 0, idx));
        root.right = generate(Arrays.copyOfRange(preOrder, 1 + idx, preOrder.length),
                              Arrays.copyOfRange(inOrder, idx + 1, inOrder.length));
        return root;
    }

    public String serialize(TreeNode root) {
        if (root == null) return "";//为空树则返回""
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        pre(root, pre);
        in(root, in);
        return pre.toString().substring(1) + " " + in.toString().substring(1);
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] strs = data.split(" ");
        String[] preOrder = strs[0].split(",");
        String[] inOrder = strs[1].split(",");
        return generate(preOrder, inOrder);
    }
}