<<<<<<< HEAD
package trave;

//Baumknotenklasse, repräsentiert einen Knoten in einem binären Baum
public class TreeNode {
 int val;            // Der Wert, den der Knoten enthält
 TreeNode left;      // Referenz auf den linken Nachfolger
 TreeNode right;     // Referenz auf den rechten Nachfolger

 // Konstruktor, um einen neuen Knoten mit einem gegebenen Wert zu erstellen
 public TreeNode(int val) {
     this.val = val;           // Setze den Wert des Knotens
     this.left = this.right = null;  // Initialisiere die Nachfolger als null, da der Knoten noch keine hat
 }
}

=======
package trave;

public class TreeNode {
	int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
>>>>>>> 8342e52a7044485411729de0041d6ccb09a483bf
