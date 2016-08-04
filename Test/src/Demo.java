import java.util.ArrayList;
import java.util.List;


public final class Demo {

	class bitreeNode{
		public int Data;
		public bitreeNode leftSubTree;
		public bitreeNode rightSubTree;

	}
//	class BinaryTree{
//		public BinaryTree(int[] value){
//			
//		}
//	}
//	private int i =0;
//	public bitreeNode createBitreeNode(int[] value){
//		bitreeNode p =null;
//		if(i<value.length){
//			int tempData=value[i];
//			i++;
//			if(tempData!=0){
//				p=new bitreeNode();
//				p.Data=tempData;
//				System.out.print(tempData+" ");
//				p.leftSubTree=createBitreeNode(value);
//				p.rightSubTree=createBitreeNode(value);
//			}
//		}
//		System.out.println();
//		return p;
//	}
	
	
	public int[] bitree(int D){
		if(D<=0) return null;
//		int length = 2*D-1;
//		int value[]=new int[length];
//		for(int j=0;j<length;j++){
//			value[j]=j+1;
//		}
//		
//		createBitreeNode(value);
		bitreeNode rootNode = new bitreeNode();
		rootNode.Data=1;
		//previous create bitree
		preCreateBTree(rootNode,1,D);
		List<Integer> list = new ArrayList<Integer>();
		trsBTreeInOrder(rootNode,list);
		int nodeVal[] = new int[list.size()];
		for(int i =0;i<list.size();i++){
			nodeVal[i]=list.get(i);
			System.out.print(nodeVal[i]+" ");
		}
		return nodeVal;
	
		//middle sort output
		
	}
	private int preCreateBTree(bitreeNode node , int nodeValue,int nodeDepth){
		node.Data=nodeValue;
		int nodeNextValue=++nodeValue;
		if(--nodeDepth>0){
			node.leftSubTree=new bitreeNode();
			node.rightSubTree=new bitreeNode();
			nodeNextValue=preCreateBTree(node.leftSubTree,nodeNextValue,nodeDepth);
			nodeNextValue=preCreateBTree(node.rightSubTree,nodeNextValue,nodeDepth);
			
		}
		
		return nodeNextValue;
	}
	private void trsBTreeInOrder(bitreeNode node, List<Integer> list){
		if(node==null){
			return;
			
		}
		trsBTreeInOrder(node.leftSubTree,list);
		list.add(node.Data);
		trsBTreeInOrder(node.rightSubTree,list);
		
	}
	public static void main(String[] args) {
//		new Demo().bitree(3);
//		new Demo().bitree(5);
		int a =0;
		System.out.println(5/a);
	}
}
