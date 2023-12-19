package trave;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TreeTraversalTest {

    // Testet einen normalen Baum
    @Test
    public void testNormalTree() {
        // Erstelle einen Beispielbaum
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Erwartete Ausgabe für Preorder: 1 2 4 5 3
        assertConsoleOutput("1 2 4 5 3", () -> TreeTraversal.preorderNonRecursive(root));
        assertConsoleOutput("1 2 4 5 3", () -> TreeTraversal.preorderRecursive(root));
        

        // Erwartete Ausgabe für Inorder: 4 2 5 1 3
        assertConsoleOutput("4 2 5 1 3", () -> TreeTraversal.inorderNonRecursive(root));
        assertConsoleOutput("4 2 5 1 3", () -> TreeTraversal.inorderRecursive(root));

        // Erwartete Ausgabe für Postorder: 4 5 2 3 1
        assertConsoleOutput("4 5 2 3 1", () -> TreeTraversal.postorderNonRecursive(root));
        assertConsoleOutput("4 5 2 3 1", () -> TreeTraversal.postorderRecursive(root));
    }

    // Testet einen rechts-lastigen Baum
    @Test
    public void testRightSkewedTree() {
        // Rechts-lastiger Baum
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Erwartete Ausgabe: 1 2 3 4
        assertConsoleOutput("1 2 3 4", () -> TreeTraversal.preorderNonRecursive(root));
        assertConsoleOutput("1 2 3 4", () -> TreeTraversal.inorderNonRecursive(root));
        assertConsoleOutput("4 3 2 1", () -> TreeTraversal.postorderNonRecursive(root));
    }

    // Testet einen links-lastigen Baum
    @Test
    public void testLeftSkewedTree() {
        // Links-lastiger Baum
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        // Erwartete Ausgabe: 1 2 3 4
        assertConsoleOutput("1 2 3 4", () -> TreeTraversal.preorderNonRecursive(root));
        assertConsoleOutput("4 3 2 1", () -> TreeTraversal.inorderNonRecursive(root));
        assertConsoleOutput("4 3 2 1", () -> TreeTraversal.postorderNonRecursive(root));
    }

    // Testet einen ausgeglichenen Baum
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

        // Erwartete Ausgabe für Preorder: 1 2 4 5 3 6 7
        assertConsoleOutput("1 2 4 5 3 6 7", () -> TreeTraversal.preorderNonRecursive(root));
        assertConsoleOutput("4 2 5 1 6 3 7", () -> TreeTraversal.inorderNonRecursive(root));
        assertConsoleOutput("4 5 2 6 7 3 1", () -> TreeTraversal.postorderNonRecursive(root));
    }

    // Testet einen leeren Baum
    @Test
    public void testEmptyTree() {
        // Teste leeren Baum
        TreeNode root = null;
        assertConsoleOutput("", () -> TreeTraversal.preorderNonRecursive(root));
        assertConsoleOutput("", () -> TreeTraversal.inorderNonRecursive(root));
        assertConsoleOutput("", () -> TreeTraversal.postorderNonRecursive(root));
    }

    // Testet einen Baum mit nur einem Knoten
    @Test
    public void testSingleNodeTree() {
        // Teste Baum mit nur einem Knoten
        TreeNode root = new TreeNode(42);
        assertConsoleOutput("42", () -> TreeTraversal.preorderNonRecursive(root));
        assertConsoleOutput("42", () -> TreeTraversal.inorderNonRecursive(root));
        assertConsoleOutput("42", () -> TreeTraversal.postorderNonRecursive(root));
    }
    private void assertConsoleOutput(String expectedOutput, Runnable action) {
        // Speichere die aktuelle System.out
        PrintStream originalOut = System.out;

        // Erstelle einen neuen PrintStream für den ByteArray
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outContent);

        // Leite System.out auf den neuen PrintStream um
        System.setOut(newOut);

        try {
            // Führe die Aktion aus, die die Konsole verwenden wird
            action.run();

            // Überprüfe, ob die Ausgabe der Konsole der erwarteten Ausgabe entspricht
            assertEquals(expectedOutput, outContent.toString().trim());
        } finally {
            // Setze System.out auf die ursprüngliche System.out zurück
            System.setOut(originalOut);
        }
    }
}



