<<<<<<< HEAD
package trave;
import java.util.Stack;
//Klasse für die Baumtraversierung
public class TreeTraversal {
 // Rekursive Implementierung der Preorder-Traversierung
 public static void preorderRecursive(TreeNode root) {
     // Wenn der aktuelle Knoten nicht null ist
     if (root != null) {
         System.out.print(root.val + " ");  // Gib den Wert des Knotens aus
         preorderRecursive(root.left);      // Traversiere den linken Nachfolger rekursiv
         preorderRecursive(root.right);     // Traversiere den rechten Nachfolger rekursiv
     }
 }

 // Rekursive Implementierung der Inorder-Traversierung
 public static void inorderRecursive(TreeNode root) {
     // Wenn der aktuelle Knoten nicht null ist
     if (root != null) {
         inorderRecursive(root.left);       // Traversiere den linken Nachfolger rekursiv
         System.out.print(root.val + " ");  // Gib den Wert des Knotens aus
         inorderRecursive(root.right);      // Traversiere den rechten Nachfolger rekursiv
     }
 }

 // Rekursive Implementierung der Postorder-Traversierung
 public static void postorderRecursive(TreeNode root) {
     // Wenn der aktuelle Knoten nicht null ist
     if (root != null) {
         postorderRecursive(root.left);     // Traversiere den linken Nachfolger rekursiv
         postorderRecursive(root.right);    // Traversiere den rechten Nachfolger rekursiv
         System.out.print(root.val + " ");  // Gib den Wert des Knotens aus
     }
 }

 // Nicht-rekursive Implementierung der Preorder-Traversierung
 public static void preorderNonRecursive(TreeNode root) {
     // Wenn der Wurzelknoten nicht null ist
     if (root == null) return;

     Stack<TreeNode> stack = new Stack<>();  // Verwende einen Stapel für die nicht-rekursive Traversierung
     stack.push(root);                      // Füge die Wurzel zum Stapel hinzu

     while (!stack.isEmpty()) {
         TreeNode current = stack.pop();   // Nehme den obersten Knoten vom Stapel
         System.out.print(current.val + " ");  // Gib den Wert des aktuellen Knotens aus

         if (current.right != null) stack.push(current.right);  // Füge den rechten Nachfolger hinzu
         if (current.left != null) stack.push(current.left);    // Füge den linken Nachfolger hinzu
     }
 }

 // Nicht-rekursive Implementierung der Inorder-Traversierung
 public static void inorderNonRecursive(TreeNode root) {
     // Wenn der Wurzelknoten nicht null ist
     if (root == null) return;

     Stack<TreeNode> stack = new Stack<>();  // Verwende einen Stapel für die nicht-rekursive Traversierung
     TreeNode current = root;                // Starte mit der Wurzel

     while (current != null || !stack.isEmpty()) {
         while (current != null) {
             stack.push(current);           // Füge den aktuellen Knoten zum Stapel hinzu
             current = current.left;        // Gehe so weit wie möglich nach links
         }

         current = stack.pop();             // Nehme den obersten Knoten vom Stapel
         System.out.print(current.val + " ");  // Gib den Wert des aktuellen Knotens aus
         current = current.right;          // Gehe nach rechts
     }
 }

 // Nicht-rekursive Implementierung der Postorder-Traversierung
 public static void postorderNonRecursive(TreeNode root) {
     // Wenn der Wurzelknoten nicht null ist
     if (root == null) return;

     Stack<TreeNode> stack = new Stack<>();      // Verwende einen Stapel für die nicht-rekursive Traversierung
     Stack<TreeNode> output = new Stack<>();     // Verwende einen Stapel für die Ausgabe in umgekehrter Reihenfolge
     stack.push(root);                          // Füge die Wurzel zum Stapel hinzu

     while (!stack.isEmpty()) {
         TreeNode current = stack.pop();       // Nehme den obersten Knoten vom Stapel
         output.push(current);                 // Füge den Knoten zum Ausgabestapel hinzu

         if (current.left != null) stack.push(current.left);    // Füge den linken Nachfolger hinzu
         if (current.right != null) stack.push(current.right);  // Füge den rechten Nachfolger hinzu
     }

     while (!output.isEmpty()) {
         System.out.print(output.pop().val + " ");  // Gib die Werte in umgekehrter Reihenfolge aus
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
=======
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
>>>>>>> 8342e52a7044485411729de0041d6ccb09a483bf
