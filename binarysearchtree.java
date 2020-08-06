/*
 * Rutvika Pravin Patil
 * 2426 SY B2 COmp
 * 
 * Assignment: Binary search tree and different operations
 * 
 */

package binarysearchtree;
import java.util.*;

class node//node structure
{
	node left,right;//node links
	int data;//node data
	public node()//constructor
	{
		left = null;
		right = null;
		data = 0;
	}      
}

class BinarySearchTree
{
	node root;
	public BinarySearchTree()
	{
		root = null;
	}
	
	void create(int d)
	{
		node prev,cur,ptr;//pointers
		prev = null;
		cur = root;
		//Finding free link to insert
		while(cur != null && cur.data != d)
		{
			prev = cur;
			if(cur.data > d)
			{
				cur = cur.left;
			}
			else
			{
				cur = cur.right;
			}
		}
		
		if(cur != null && cur.data == d)
		{
			System.out.println("No Duplicate element allowed");
			//bst has unique elements
		}
		else
		{
			ptr = new node();
			ptr.data = d;
			ptr.left = null;
			ptr.right = null;
			
			if(prev != null)
			{
				if(prev.data > d)
				{
					prev.left = ptr;
				}
				else
				{
					prev.right = ptr;
				}
			}
			else
			{
				root = ptr;
				System.out.println("Root created");
			}
		}	
	}
	//traversal recursive
	void inorder(node localroot)
	{
		if(localroot != null)
		{
			inorder(localroot.left);
			System.out.print("\t"+localroot.data+"");
			inorder(localroot.right);
		}
	}
	
	//min left most node
	void findmin()
	{
		node ptr,prev;
		prev = root;
		ptr = root;
		while(ptr != null)
		{
			prev = ptr;
			ptr = ptr.left;
		}
		System.out.println("Minimum of BST: "+prev.data);
	}
	//max:rightmostnode
	void findmax()
	{
		node ptr,prev;
		prev = root;
		ptr = root;
		while(ptr != null)
		{
			prev = ptr;
			ptr = ptr.right;
		}
		System.out.println("Maximum of BST: "+prev.data);
	}
	//levelorder traversal
	void display_level()
	{
		Queue q=new LinkedList();
		int nodes=0;
		node ptr;
		if(root==null)
		{
			return;
		}
		else
		{
			q.add(root);
			
			nodes=q.size();
			while(!(q.isEmpty()))
			{
				
				ptr=(node)q.peek();
				q.remove();
				
				if(ptr.left!=null)
				{
					q.add(ptr.left);
				}
				if(ptr.right!=null)
				{
					q.add(ptr.right);
				}
				System.out.println(ptr.data+" ");
				nodes--;
			}
		}
		
	}
	//parent of node; root:-1
	void parent_node(node localroot,int val,int parent)
	{
		if(localroot==null)
		{
			return;
		}
		if(localroot.data==val)
		{
			System.out.println(parent);
		}
		else
		{
			parent_node(localroot.left,val,localroot.data);
			parent_node(localroot.right,val,localroot.data);
		}	
	}
	//count leafnodes
	int no_of_leaf_node(node localroot)
	{
		if(localroot==null)
			return 0;
		if(localroot.left==null && localroot.right==null)
			return 1;
		else
			return (no_of_leaf_node(localroot.left)+no_of_leaf_node(localroot.right));
	}
	
	void descending(node localroot)
	{
		if(localroot != null)
		{
			descending(localroot.right);
			System.out.print("\t"+localroot.data+"");
			descending(localroot.left);
		}
	}
	//height of bst
	int height(node root)
	{
		int lh,rh;
		if(root == null)
		{
			return 0;
		}
		else
		{
			if(root.left == null)
			{
				lh = 1;
			}
			else
			{
				lh=1+height(root.left);
			}
			if(root.right == null)
			{
				rh = 1;
			}
			else
			{
				rh=1+height(root.right);
			}
		}

		if(lh > rh)
		{
			return lh;
		}
		else
		{
			return rh;
		}
	}
}
public class bst1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BinarySearchTree b1 = new BinarySearchTree();
		int choice,d,ch;
		do
		{
			//menudriven
			System.out.println("\n\t>>>>>>>BINARY SEARCH TREE<<<<<<<<");
			System.out.println("1.Create BST");
			System.out.println("2.Inorder Display of BST");
			System.out.println("3.Find min and max of BST");
			System.out.println("4.Display level wise tree");
			System.out.println("5.Find height of BST");
			System.out.println("6.Display tree in descending order");
			System.out.println("7.Parent node");
			System.out.println("8.Count the leaf nodes");
			System.out.println("0.Exit");
			System.out.println("Enter your choice>>>");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				do
				{
					System.out.println("Enter data element: ");
					d = sc.nextInt();
					b1.create(d);
					System.out.println("Do you want to add more?(1/0)");
					ch = sc.nextInt();
				}while(ch != 0);
				break;
			case 2:
				b1.inorder(b1.root);
				break;
			case 3:
				b1.findmin();
				b1.findmax();
				break;
			case 4:
				b1.display_level();
				break;
			case 5:
				int z=0;
				z=b1.height(b1.root);
				System.out.println("Height:"+z);
				break;
			case 6:
				b1.descending(b1.root);
				break;
			case 7:
				{
					int v;
					System.out.println("Enter the value of node: ");
					v=sc.nextInt();
					b1.parent_node(b1.root,v, -1);
				}
				break;
			case 8:
				{
					System.out.println("No of leaf nodes are : "+b1.no_of_leaf_node(b1.root));
				}
				break;
			case 0:
				System.out.println("Exit");
				break;
			}
		}while(choice != 0);

	}

}

/*
 * 
	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
1
Enter data element: 
6
Root created
Do you want to add more?(1/0)
1
Enter data element: 
5
Do you want to add more?(1/0)
1
Enter data element: 
7
Do you want to add more?(1/0)
1
Enter data element: 
9
Do you want to add more?(1/0)
1
Enter data element: 
22
Do you want to add more?(1/0)
1
Enter data element: 
2
Do you want to add more?(1/0)
0

	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
2
	2	5	6	7	9	22
	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
3
Minimum of BST: 2
Maximum of BST: 22

	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
4
6 
5 
7 
2 
9 
22 

	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
5
Height:4

	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
6
	22	9	7	6	5	2
	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
7
Enter the value of node: 
22
9

	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
8
No of leaf nodes are : 2

	
	>>>>>>>BINARY SEARCH TREE<<<<<<<<
1.Create BST
2.Inorder Display of BST
3.Find min and max of BST
4.Display level wise tree
5.Find height of BST
6.Display tree in descending order
7.Parent node
8.Count the leaf nodes
0.Exit
Enter your choice>>>
0
Exit

*/