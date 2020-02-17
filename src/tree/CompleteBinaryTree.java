package tree;

import java.util.ArrayList;

// 完全二叉树
public class CompleteBinaryTree {
	// 创建完全二叉树
	public Node createTree(int[] arr){
		if(arr == null || arr.length<0) return null;    // 返回空树
		ArrayList<Node> list = new ArrayList<>();
		for (int i=0; i<arr.length; i++) {
			list.add(new Node(arr[i]));
		}
		// 假设有n个结点：3， 7， 8， 20， 11， 5， 81
		// 需要迭代所有的非叶子结点，给这些非叶子结点添加叶子，共有 n/2=3 个叶子结点,即 3， 7， 8，
		for(int i=0; i< arr.length/2; i++){
			if(2*i+1 < arr.length){   // 给非叶子结点添加左节点
				list.get(i).left = list.get(2*i+1);
			}
			if(2*i+2 < arr.length){   // 给非叶子结点添加右节点
				list.get(i).right = list.get(2*i+2);
			}
		}
		return list.get(0);
	}
	
	// 先根遍历
	public void firstRootPrint(Node root){
		if (root == null) return;
		System.out.print(root.val+"->");
		firstRootPrint(root.left);
		firstRootPrint(root.right);
	}
}
