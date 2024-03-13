import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class AddNodeAtDepth {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;

        while (currentDepth < depth - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            currentDepth++;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode leftChild = new TreeNode(val);
            leftChild.left = node.left;
            node.left = leftChild;

            TreeNode rightChild = new TreeNode(val);
            rightChild.right = node.right;
            node.right = rightChild;
        }

        return root;
    }
}
