package pattern.structure.Composite.one;

/**
 * 組合模式有时又叫部分-整体模式在处理类似树形结构的问题时比较方便
 * @author Peng.lv
 *
 */
public class TreeMain {
	 TreeNode root = null;  
	  
	    public TreeMain(String name) {  
	        root = new TreeNode(name);  
	    }  
	  
	    public static void main(String[] args) {  
	        TreeMain tree = new TreeMain("A");  
	        TreeNode nodeB = new TreeNode("B");  
	        TreeNode nodeC = new TreeNode("C");  
	          
	        nodeB.add(nodeC);  
	        tree.root.add(nodeB);  
	        System.out.println("build the tree finished!");  
	    }  
}
