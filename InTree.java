
public class InTree {
    public static class Node
    {
        Node left,right;
        int data;

        public Node(int data)
        {
            this.data=data;

            this.left=null;
            this.right=null;

        }

    }
    
    public Node root;

    
    public InTree(){
        root=null;
    }

public void insert(int data)
{
        Node newNode=new Node(data);

        if(root==null)
        {
            root=newNode;
            return;

        }
        else
        {
            Node current =root,parent=null;
            
            while(true)
            {

                parent=current;
                if(data<current.data)
                {
                    current=current.left;

                }
                if(current==null)
                {
                    parent.left=newNode;
                    return;
                }
            }
 
        }
}


public void inOrderTraverse(Node node)
{
    
    if(root==null)
    {
        
        System.out.println("Tree Empty");
        return;
    }
    else
    {   
        if(node.left!=null)
        {
            System.out.println("Binary search tree after insertion:");  
        
            inOrderTraverse(node.left);
            System.out.println(node.data+"");

        }
        if(node.right!=null)
        {
            inOrderTraverse(node.right);
        }
    }


}

    public static void main(String e[])
    {
        //int array[]={4,3,2,7,8,9};
       

        InTree obje=new InTree();
        obje.insert(8);
        obje.insert(3);  
        obje.insert(2);
        obje.insert(1);
            obje.insert(11);
        System.out.println("Binary search tree after insertion:");  
        
        obje.inOrderTraverse(obje.root);
       // System.out.println("Binary search tree after insertion:");  
        
    }
}
