/*
 * 
 * By: Rutvika Pravin Patil
 * 2426 B2
 * SY Comp
 * */



package Binarytree;
import java.util.*;

class node
{
	node left,right; //links
	int data;//node data

	public node()//constructor
	{
		left = null;
		right = null;
		data = 0;
	}
	public node(int d)//Parameterized constructor
	{
		left = null;
		right = null;
		data = d;
	}
}

class BT
{
	node root;//root of tree

	public BT()
	{
		root = null;
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void create()
	{
		node ptr;
		node t = new node();
		int flag =0;
		char direction;
		
		System.out.println("Enter data to insert: ");//input
		t.data = sc.nextInt();

		if(root == null)//first node
		{
			root = t;
			flag = 1;
		}
		else
		{
			ptr = root;
			while(flag==0)
			{
				System.out.println(ptr.data);
				System.out.println("Enter direction (L/R): ");//left or right child
				direction = sc.next().charAt(0);
				if(direction == 'l' || direction == 'L')
				{
					if(ptr.left != null)
					{
						ptr = ptr.left;
					}
					else
					{
						ptr.left = t;
						flag = 1;
					}
				}
				else
				{
					if(ptr.right != null)
					{
						ptr = ptr.right;
					}
					else
					{
						ptr.right = t;
						flag = 1;
					}
				}

			}
		}
	}
	
	
	//recursive traversal
	void inorder(node localroot)
	{
		if(localroot != null)
		{
			inorder(localroot.left);
			System.out.println(localroot.data+" ");
			inorder(localroot.right);
		}
	}
    //recursive preorder
	void preorder(node localroot)
	{
		if(localroot != null)
		{
			System.out.println(localroot.data+" ");
			preorder(localroot.left);
			preorder(localroot.right);
		}
	}
    //recursive postorder
	void postorder(node localroot)
	{
		if(localroot != null)
		{
			postorder(localroot.left);
			postorder(localroot.right);
			System.out.println(localroot.data+" ");
		}
	}


public void in_nonrecur()//inorder nonrecursive
{
	Stack<node> s=new Stack<node>();
	node ptr;
	ptr=root;
	
	while((!s.empty())||(ptr!=null)) {
	while(ptr!=null)
	{
		s.push(ptr);
		ptr=ptr.left;
	}
	
	
		ptr=s.pop();
		System.out.println(ptr.data);
		ptr=ptr.right;
	
	}
	
	
}
//preorder non recursive
public void pre_nonrecur()
{
   Stack<node> sp= new Stack<node> ();
   node ptr=root;
   
   while(!sp.empty()|| ptr!=null) {
	   while(ptr!=null)
	   {
		   System.out.println(ptr.data);
		   sp.push(ptr);
		   ptr=ptr.left;
	   }
	   
		   ptr=sp.pop();
		   ptr=ptr.right;
	   
   }
  
 }
//post nonrecursive
public void post_nonrecur1()
{
	Stack<node> s1=new Stack<node> ();
	Stack<Character> s2=new Stack<Character> ();
	node ptr=root;
	//s1.push(root);
	while(!s1.empty()||ptr!=null) {
	while(ptr!=null)
	{
		s1.push(ptr);
		s2.push('L');
		ptr=ptr.left;
	}
	
		ptr=s1.pop();
		if(s2.pop()=='L')
			{
			  s1.push(ptr);
			  s2.push('R');
			  ptr=ptr.right;
			}
		else
		{
			System.out.println(ptr.data+" ");
			ptr=null;
		}
	
	}
	
	
}
}


public class tree {

public static void main(String[] args) 
{
// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	BT b = new BT();
	int choice,c = 0;

	do
	{
		//Menu driven
		System.out.println("Menu");
		System.out.println("1.Create");
		System.out.println("2.Inorder");
		System.out.println("3.Preorder");
		System.out.println("4.Postorder");
		System.out.println("5.Inorder Non Recursive");
		System.out.println("6.Preorder Non Recursive");
		System.out.println("7.Postorder Non Recursive");
		System.out.println("0.Exit");
		System.out.println("Enter your choice: ");
		choice = sc.nextInt();

		switch(choice)
		{
		case 1:
			do
			{
				b.create();
				System.out.println("Do you want to add more(1/0): ");
				c = sc.nextInt();
			}while(c != 0);
			break;
		case 2:
			b.inorder(b.root);
			break;
		case 3:
			b.preorder(b.root);
			break;
		case 4:
			b.postorder(b.root);
			break;
		case 5:
			b.in_nonrecur();
			break;
		case 6:
			b.pre_nonrecur();
			break;
		case 7:
			b.post_nonrecur1();
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
 * OUTPUT:
 * 
 * 
 * 
 * Menu
1.Create
2.Inorder
3.Preorder
4.Postorder
5.Inorder Non Recursive
6.Preorder Non Recursive
7.Postorder Non Recursive
0.Exit
Enter your choice: 
1
Enter data to insert: 
23
Do you want to add more(1/0): 
1
Enter data to insert: 
99
23
Enter direction (L/R): 
R
Do you want to add more(1/0): 
1
Enter data to insert: 
45
23
Enter direction (L/R): 
L
Do you want to add more(1/0): 
1
Enter data to insert: 
12
23
Enter direction (L/R): 
R
99
Enter direction (L/R): 
L
Do you want to add more(1/0): 
0
Menu
1.Create
2.Inorder
3.Preorder
4.Postorder
5.Inorder Non Recursive
6.Preorder Non Recursive
7.Postorder Non Recursive
0.Exit
Enter your choice: 
2
45 
23 
12 
99 
Menu
1.Create
2.Inorder
3.Preorder
4.Postorder
5.Inorder Non Recursive
6.Preorder Non Recursive
7.Postorder Non Recursive
0.Exit
Enter your choice: 
5
45
23
12
99
Menu
1.Create
2.Inorder
3.Preorder
4.Postorder
5.Inorder Non Recursive
6.Preorder Non Recursive
7.Postorder Non Recursive
0.Exit
Enter your choice: 
3
23 
45 
99 
12 
Menu
1.Create
2.Inorder
3.Preorder
4.Postorder
5.Inorder Non Recursive
6.Preorder Non Recursive
7.Postorder Non Recursive
0.Exit
Enter your choice: 
6
23
45
99
12
Menu
1.Create
2.Inorder
3.Preorder
4.Postorder
5.Inorder Non Recursive
6.Preorder Non Recursive
7.Postorder Non Recursive
0.Exit
Enter your choice: 
4
45 
12 
99 
23 
Menu
1.Create
2.Inorder
3.Preorder
4.Postorder
5.Inorder Non Recursive
6.Preorder Non Recursive
7.Postorder Non Recursive
0.Exit
Enter your choice: 
7
45 
12 
99 
23 
Menu
1.Create
2.Inorder
3.Preorder
4.Postorder
5.Inorder Non Recursive
6.Preorder Non Recursive
7.Postorder Non Recursive
0.Exit
Enter your choice: 
0
Exit

 * */
