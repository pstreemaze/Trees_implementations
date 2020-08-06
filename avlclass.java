package avl;

import java.util.*;


class node 
{
	node left, right;
	String name;
	long phone_no;
	int height;
	int h;

	public node()
	{
		left = right = null;
		height = 1;
	}

	public node(String n, long ph)
	{
		left = right = null;
		name = n;
		phone_no = ph;
	}
}

class avl  
{
	node root;

	avl()  
	{
		root = null;
	}

	
	int height(node localroot)
	{
		if(localroot==null)
			return 0;
		else
		{
			int l_height=height(localroot.left);
			int r_height=height(localroot.right);
			if(l_height>r_height)
				return(l_height+1);
			else
				return (r_height+1);
		}
	}

	node ptr, temp;

	node rr(node root) 
	{
		ptr = root;
		temp = ptr.right;
		ptr.right = temp.left;
		temp.left = ptr;
		temp.h = height(temp);
		ptr.h = height(temp);
		System.out.println(" >>RR");
		return (temp);
	}

	node ll(node root) 
	{
		ptr = root;
		temp = ptr.left;
		ptr.left = temp.right;
		temp.right = ptr;
		temp.h = height(temp);
		ptr.h = height(temp);
		System.out.println(" >>LL");
		return (temp);
	}

	node lr(node root)
	{
		ptr = root;
		ptr.left = rr(ptr.left);  
		root = ll(root);      
		//System.out.println( ll(root));
		System.out.println(" >>LR");
		return (root);
	}

	node rl(node root)
	{
		ptr = root;
		ptr.right = ll(ptr.right);   
		root = rr(root);  
		//System.out.println( rr(root));
		System.out.println(" >>RL");
		return (root);
	}

	int getBalance(node root)
	{
		if (root == null)
			return 0;
		else
			return height(root.left) - height(root.right);
	}

	Scanner sc = new Scanner(System.in);

	void create() 
	{
		int ch = 1;
		String name;
		long ph_no;
		do {
			System.out.println("NAME :");
			name = sc.next();
			System.out.println("CONTACT :  ");
			ph_no = sc.nextLong();
			root = insert(root, name, ph_no);

			System.out.println("ADD MORE?(1/0)");
			ch = sc.nextInt();

		} while (ch==1);
	}

	node insert(node localroot, String n, long ph)
	{
		
		if (localroot == null)
		{
			return new node(n, ph);
		}
		else
		{

			if (localroot.name.compareToIgnoreCase(n) < 0)
			{
				localroot.right = insert(localroot.right, n, ph);
			}
			else if (localroot.name.compareToIgnoreCase(n) > 0)
			{
				localroot.left = insert(localroot.left, n, ph);
			}

		}

		int bf = getBalance(localroot);
		if (bf > 1)
		{
			if (n.compareToIgnoreCase(localroot.left.name) < 0)
			{
				return ll(localroot);
			}
			else
			{
			
				return lr(localroot);
			}
		}
		else if (bf < -1)
		{

			if (n.compareToIgnoreCase(localroot.right.name) > 0)
			{
				return rr(localroot);
			} else {
				
				return rl(localroot);
			}
		}

		return localroot;


	}

	void displayAVL(node localroot)
	{

		if (localroot != null)
		{
			displayAVL(localroot.left);
			System.out.println(localroot.name + " - " + localroot.phone_no);
			displayAVL(localroot.right);
		}
	}
	void levelOrder(node tree)
	{
		Queue<node> q = new LinkedList<node>();

		q.add(root);


		while(true)
		{

	
			int Count = q.size();
			if(Count == 0)
				break;

			
			while(Count > 0)
			{
				node node = q.peek();
				System.out.print("\t"+node.name + "- "+node.phone_no);
				q.remove();
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
				Count--;
			}
			System.out.println(" ");
		}

	}

	void search(node localroot) 
	{
		String n;
		int flag = 0;
		System.out.println("Name : ");
		n = sc.next();

		ptr = localroot;
		while (ptr != null)
		{
			if ((n).compareToIgnoreCase(ptr.name) == 0) 
			{
				flag = 1;
				break;
			}
			else if ((n).compareToIgnoreCase(ptr.name) < 0)
			{
				ptr = ptr.left;
			}
			else
			{
				ptr = ptr.right;
			}
		}
		if (flag == 0)
		{
			System.out.println("No data ");
		} else

		{
			System.out.println(ptr.name + " : " + ptr.phone_no);
		}

	}


	void update() 
	{
		int flag = 0;
		long update;
		String n;
		System.out.println("Enter name ");
		n = sc.next();
		node ptr = root;
		while (ptr != null)
		{
			if ((n).compareToIgnoreCase(ptr.name) == 0)
			{
				System.out.println("Customer is present");
				flag = 1;
				break;
			}
			else if ((n).compareToIgnoreCase(ptr.name) < 0)
			{
				ptr = ptr.left;
			}
			else
			{
				ptr = ptr.right;
			}
		}
		if (flag == 0)
		{
			System.out.println("No data found !!!");
		} else
		{
			System.out.println("Enter the updated phone number : ");
			update = sc.nextLong();
			ptr.phone_no = update;
			System.out.println("Updated");
			System.out.println(ptr.name + " : " + ptr.phone_no);

		}

	}

	void delete() 
	{
		int flag = 0;
		String n;
		node prev = null;
		System.out.println("Name to delete : ");
		n = sc.next();
		ptr = root;
		while (ptr != null) {
			if ((n).compareToIgnoreCase(ptr.name) == 0) {
				flag = 1;
				break;
			} else if ((n).compareToIgnoreCase(ptr.name) < 0) {
				prev = ptr;
				ptr = ptr.left;
			} else {
				prev = ptr;
				ptr = ptr.right;
			}
		}
		if (flag == 0) {
			System.out.println("No data found !!!");
		} else {
			while (ptr != null) {
				
				if (ptr.left == null && ptr.right == null) {
					if (((prev.left).name).compareTo(n) == 0) {
						prev.left = null;
					} else {
						prev.right = null;
					}
					break;
				}
			

				if (ptr.left != null && ptr.right == null) {
					if (((prev.left).name).compareTo(n) == 0) {
						prev.left = ptr.left;
					} else {
						prev.right = ptr.left;
					}
					break;
				}
			

				if (ptr.left == null && ptr.right != null) {
					if (((prev.left).name).compareTo(n) == 0) {
						prev.left = ptr.right;
					} else {
						prev.right = ptr.right;
					}
					break;
				}
				

				if (ptr.left != null && ptr.right != null) {
					node temp = ptr.left;
					prev = null;
					while (temp.right != null) {
						prev = temp;
						temp = temp.right;
					}
					ptr.name = temp.name;
					ptr.phone_no = temp.phone_no;
					if (prev != null) {
						prev.right = temp.left;
					}
					break;
				}

			}
		}
	}

}

public class avlclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		avl a = new avl();
		int ch = 0, n, k = 0;
		int data;
		avl t = null;
		do {
			System.out.println("-----------------TELEPHONE DIRECTORY-------------------- ");
			System.out.println("\n1.Enter Contact Details ");
			System.out.println("2.Display Contact ");
			System.out.println("3.Search Contact");
			System.out.println("4.Update Contact");
            System.out.println("5.Delete Contact ");
            System.out.println("6.Avl Check");
			System.out.println("0.Exit ");
			System.out.println("\n");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				a.create();

				break;

			case 2:
				a.displayAVL(a.root);
				break;
			case 3:
				a.search(a.root);
				break;
			case 4:
				a.update();
				break;
			case 5:
				a.delete();
				break;
			case 6:
				a.levelOrder(a.root);
				break;
			case 0:
				System.out.println("ThankYou");
				break;

			}
		} while (ch!=0);

	}

}




/*
 * OUTPUT:
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


1
NAME :
aarya
CONTACT :  
6857744
ADD MORE?(1/0)
1
NAME :
sakshi
CONTACT :  
78654
ADD MORE?(1/0)
1
NAME :
siddhi
CONTACT :  
6799064
 >>RR
ADD MORE?(1/0)
1
NAME :
didi
CONTACT :  
5453684
ADD MORE?(1/0)
1
NAME :
utopia
CONTACT :  
7865
ADD MORE?(1/0)
1
NAME :
richa
CONTACT :  
7855
 >>RR
ADD MORE?(1/0)
0
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


2
aarya - 6857744
didi - 5453684
richa - 7855
sakshi - 78654
siddhi - 6799064
utopia - 7865
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


3
Name : 
sakshi
sakshi : 78654
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


4
Enter name 
sakshi
Customer is present
Enter the updated phone number : 
79544433
Updated
sakshi : 79544433
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


2
aarya - 6857744
didi - 5453684
richa - 7855
sakshi - 79544433
siddhi - 6799064
utopia - 7865
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


5
Name to delete : 
richa
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


2
aarya - 6857744
didi - 5453684
sakshi - 79544433
siddhi - 6799064
utopia - 7865
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


6
	sakshi- 79544433 
	didi- 5453684	siddhi- 6799064 
	aarya- 6857744	utopia- 7865 
-----------------TELEPHONE DIRECTORY-------------------- 

1.Enter Contact Details 
2.Display Contact 
3.Search Contact
4.Update Contact
5.Delete Contact 
6.Avl Check
0.Exit 


0
ThankYou
*/
