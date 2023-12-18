package Trav;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTraversalTest {
    @Test
    public void testPreorderTraversal() {
        // Erstelle einen Beispielbaum
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Erwartete Ausgabe: 1 2 4 5 3
        assertEquals("1 2 4 5 3 ", getOutput(TreeTraversal::preorderNonRecursive, root));
        assertEquals("1 2 4 5 3 ", getOutput(TreeTraversal::preorderRecursive, root));
    }

    @Test
    public void testInorderTraversal() {
        // Erstelle einen Beispielbaum
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Erwartete Ausgabe: 4 2 5 1 3
        assertEquals("4 2 5 1 3 ", getOutput(TreeTraversal::inorderNonRecursive, root));
        assertEquals("4 2 5 1 3 ", getOutput(TreeTraversal::inorderRecursive, root));
    }

    @Test
    public void testPostorderTraversal() {
        // Erstelle einen Beispielbaum
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Erwartete Ausgabe: 4 5 2 3 1
        assertEquals("4 5 2 3 1 ", getOutput(TreeTraversal::postorderNonRecursive, root));
        assertEquals("4 5 2 3 1 ", getOutput(TreeTraversal::postorderRecursive, root));
    }

    @Test
    public void testEmptyTree() {
        // Teste leeren Baum
        TreeNode root = null;
        assertEquals("", getOutput(TreeTraversal::preorderNonRecursive, root));
        assertEquals("", getOutput(TreeTraversal::inorderNonRecursive, root));
        assertEquals("", getOutput(TreeTraversal::postorderNonRecursive, root));
    }

    @Test
    public void testSingleNodeTree() {
        // Teste Baum mit nur einem Knoten
        TreeNode root = new TreeNode(42);
        assertEquals("42 ", getOutput(TreeTraversal::preorderNonRecursive, root));
        assertEquals("42 ", getOutput(TreeTraversal::inorderNonRecursive, root));
        assertEquals("42 ", getOutput(TreeTraversal::postorderNonRecursive, root));
    }

    private String getOutput(TreeTraversalFunction traversalFunction, TreeNode root) {
        // Hilfsmethode zum Erfassen der Ausgabe der Traversierungsfunktion
        // Hier wird System.out an einen String umgeleitet und zurückgegeben.
        // Dadurch können wir die Ausgabe überprüfen.
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Aufruf der Traversierungsfunktion
        traversalFunction.traverse(root);

        // Zurücksetzen der Standardausgabe
        System.setOut(System.out);

        return outContent.toString();
    }

    // Funktionales Interface für die Traversierungsfunktion
    @FunctionalInterface
    interface TreeTraversalFunction {
        void traverse(TreeNode root);
    }
    @Test
    public void testRightSkewedTree() {
        // Rechts-lastiger Baum
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Erwartete Ausgabe: 1 2 3 4
        assertEquals("1 2 3 4 ", getOutput(TreeTraversal::preorderNonRecursive, root));
        assertEquals("1 2 3 4 ", getOutput(TreeTraversal::inorderNonRecursive, root));
        assertEquals("4 3 2 1 ", getOutput(TreeTraversal::postorderNonRecursive, root));
    }

    @Test
    public void testLeftSkewedTree() {
        // Links-lastiger Baum
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // Erwartete Ausgabe: 1 2 3 4
        assertEquals("1 2 3 4 ", getOutput(TreeTraversal::preorderNonRecursive, root));
        assertEquals("4 3 2 1 ", getOutput(TreeTraversal::inorderNonRecursive, root));
        assertEquals("4 3 2 1 ", getOutput(TreeTraversal::postorderNonRecursive, root));
    }

    @Test
    public void testBalancedTree() {
        // Ausgeglichener Baum
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Erwartete Ausgabe: 1 2 4 5 3 6 7
        assertEquals("1 2 4 5 3 6 7 ", getOutput(TreeTraversal::preorderNonRecursive, root));
        assertEquals("4 2 5 1 6 3 7 ", getOutput(TreeTraversal::inorderNonRecursive, root));
        assertEquals("4 5 2 6 7 3 1 ", getOutput(TreeTraversal::postorderNonRecursive, root));
    }

}
