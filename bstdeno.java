import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import org.w3c.dom.Node;



class bst{
    
    bst left,right;
    int key;
    
    bst(int item)
    {
        key=item;
        left=right=null; 
    }
}


class bstdeno
{
    static bst root;
    
    public void insert(int  key)
    {
        root=insecTree(root,key);
        
    }
    public bst insecTree(bst root,int key)//node mean bst 
    {
        if(root==null)
        {
            root=new bst(key);
            return root;
        }
        
        if(root.key>key)
        {
            root.left=insecTree(root.left, key);
        }
        else if(root.key<key)
        {
            root.right=insecTree(root.right, key);
        }
        return root;
        
    }
    
    public void inOrderTraversal(bst root)
    {
        
        if(root!=null)
        {
            
            System.out.print(" ");
            
            inOrderTraversal(root.left);
            System.out.print(" "+root.key);
            inOrderTraversal(root.right); 
        }
    }
    
    public void prreOrder(bst root)
    {
        if(root!=null)
        {
            System.out.print(" ");
            
            System.out.print(" "+root.key);
            prreOrder(root.left);
            prreOrder(root.right);
            
        }
    }
    
    public void postOrder(bst root)
    {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" "+root.key);
            
        }
    }
    
    public void print()
    {
        
        System.out.println(" ");
        System.out.print("In Order    -");
        
        inOrderTraversal(root);
        System.out.println(" ");
        
        System.out.print("PreOrder     ");
        
        prreOrder(root);
        System.out.println(" ");
        
        System.out.print("Post   Order    ");
        
        postOrder(root);
        
    }
    
    
    boolean findeu(bst root,int ntargete)
    {
        if(root==null)
        {
            return false;//if not value
        }
        if(root.key==ntargete)
        {
            return true;    //is the equal to tree curent node checke
        }
        if(root.key<ntargete)
        {
            return findeu(root.right,ntargete);// m search to the right 
        }
        else{
            return findeu(root.left,ntargete);//searche to the left of it 
            
        }
        
        
        
    }
    int minValue(bst root)
    {
        bst current=root;
        if(current==null)
        { 
            return -1;
        }
        while(current.left!=null)
        {
            current=current.left;
        }
        return current.key;
        
    }
    
    int maxvalue(bst root){
        bst current=root;
        
        if(current==null){
            return -1;
        }
        while(current.right!=null)
        {
            current=current.right;
        }
        return current.key;
    }
    
    
    
    
    bst nodedelete(bst node,int ntargete)//
    {
        //base case
        if(node==null)
        {
            return null;
        }
        
        
        if(ntargete>node.key)
        {
            node.right=nodedelete(node.right, ntargete);
        }
        else if(ntargete<node.key)
        {
            node.left=nodedelete(node.left, ntargete);
        }
        else
        {
            if(node.left==null&&node.right==null)
            {
                return null;
            }
            if(node.left==null&&node.right!=null)
            {
                return node.right;
            }
            if(node.left!=null&&node.right==null)
            {
                return node.left;
            }
            else
            {
                node.key=maxvalue(node.left);   
                node.left=nodedelete(node.left, node.key);
            }
        }
        return node;
    }
    
    
    
    public static void bfs(bst root) {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        
        Queue<bst> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            bst current = queue.poll();
            System.out.print(current.key + "\t");
            
            if (current.left != null) {
                queue.add(current.left);
            }
            
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
    
    
    
    public static void main(String u[])
    {
        Scanner sc=new Scanner(System.in);
        bstdeno obje=new bstdeno();
        
        System.out.println("Enter Size of The Array Size");
        int  lenge=sc.nextInt();
        
        int m;
        System.out.println("Enter The Elements In  Array  ");
        
        
        int arr[]=new int[60];
        for(int i=0;i<=lenge;i++)
        {                
            arr[i]=sc.nextInt(); 
            obje.insert(arr[i]);    
        }
        
        System.out.println("Enter 2 For The Deletion");
        System.out.println("Enter 3 For The Search");
        
        // System.out.println("Enter What Operation Do You Want");
        // int ii=sc.nextInt();
        
        int ii;
        System.out.println("Enter What Operation Do You Want");
        ii=sc.nextInt();
        switch(ii)
        {
            
            case 2:  
            System.out.print(" Please Enter Elements Do You Want To DeletiOn");
            int y=sc.nextInt();
            System.out.print(" Deletion After Node");
            obje.root=obje.nodedelete(root,y);
            obje.inOrderTraversal(obje.root);
            break;
            
            
            
            case 3:
            System.out.println("Enter What Elements Do You Want to Searche");
            int see=sc.nextInt();
            boolean o=obje.findeu(root,see);
            
            
            System.out.println(" ");  
            if(o)
            {
                System.out.println("Finde Elemenet ");
            }
            else
            {
                System.out.println(" Elemene  Not Found");
            }
            break;
        }
        
        obje.print();
        
        
        System.out.println(" ");            
        System.out.println("Bfs");            
        
        //bfs(root);
        bfs(root);
        
        
        //        int m=sc.nextInt();
        //int arr[]={100,150,15,48,60,175,110,3};    
        //  for(int i=0;i<arr.length;i++)
        //{ 
            //  obje.insert(arr[i]);    
            // }
            
            
            //  System.out.println("Minimum Value intree "+obje.minValue(root));
            // System.out.println("Maxiimum Value in tree"+obje.maxvalue(root));
            
            
            
            
            //    obje.inOrderTraversal(root);
            //giving the tree which is the left and right            
            
            //  System.out.println("I Delete node "+obje.root.key);//working with the leaf only
            
            
        }
    }
    
    
    