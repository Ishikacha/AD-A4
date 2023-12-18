package trave;
import java.util.Stack;
public class TreeTraversal {
	// Rekursive Implementierung
    public static void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public static void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }

    public static void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }

    // Nicht-rekursive Implementierung
    public static void preorderNonRecursive(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + " ");

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    public static void inorderNonRecursive(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    public static void postorderNonRecursive(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            output.push(current);

            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }

        while (!output.isEmpty()) {
            System.out.print(output.pop().val + " ");
        }
    }

    public static void main(String[] args) {
        // Erstelle einen Beispielbaum
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Teste die rekursiven Traversierungsverfahren
        System.out.println("Preorder (rekursiv): ");
        preorderRecursive(root);
        System.out.println();

        System.out.println("Inorder (rekursiv): ");
        inorderRecursive(root);
        System.out.println();

        System.out.println("Postorder (rekursiv): ");
        postorderRecursive(root);
        System.out.println();

        // Teste die nicht-rekursiven Traversierungsverfahren
        System.out.println("Preorder (nicht-rekursiv): ");
        preorderNonRecursive(root);
        System.out.println();

        System.out.println("Inorder (nicht-rekursiv): ");
        inorderNonRecursive(root);
        System.out.println();

        System.out.println("Postorder (nicht-rekursiv): ");
        postorderNonRecursive(root);
        System.out.println();
    }
}
