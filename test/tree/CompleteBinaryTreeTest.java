package tree;

public class CompleteBinaryTreeTest {
	public static void main(String[] args){
	    int[] arr = new int[]{3, 7, 8, 20, 11, 5, 81, 23, 32};
		CompleteBinaryTree tree = new CompleteBinaryTree();
		Node root = tree.createTree(arr);
		tree.firstRootPrint(root);
	}
}
