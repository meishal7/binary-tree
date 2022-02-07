/** 
* TITLE: BinaryTree.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 
* PROJECT: Lab 17_BinaryTree
* LAST MODIFIED: 12/01/2020
* DESCRIPTION: this program defines the class BinaryTree which is Binary Search Tree
*
* ALGORITHM:
* 1. Declare public class BinaryTree<E extends Comparable<E>> class
* 2. Declare private Node<E> root
* 3. Declare default and one argument constructors
* 4. Declare setter and getter for the root
* 5. Declare public void insert() method that makes a call to the recursive method addRecursive(...) 
* in order to traverse the tree from root to leaves to find the correct place 
* to insert the new element.  It will reassign the root to the result of addRecursive(...) 
* in the case where the tree is empty. This method always returns true, since an element 
* can always be added to a binary tree.
* 6. Declare private Node<E> insert_Recursive(Node<E> root, E data)
* If root == null -> tree is empty -> create new Node. Otherwise compare inserted data to the root
* and tarverse recursevely eather left or right branch. When the leaf is found, insert the Node.
* 7. Declare public boolean contains(E data). This public method makes a call to the recursive method containsRecursive(...) 
* in order to traverse the tree from root to leaves to determine if the element exists 
* in the binary tree. This method returns the result of containsRecursive(...).
* 8. Declare private boolean containsRecursive(Node<E> root, E data). If root == null -> tree is empty -> return null
* Otherwise compare inserted data to the root and tarverse recursevely eather left or right branch. 
* 9. Declare public void remove(E data). This public method makes a call to the recursive method removeRecursive(...) 
* in order to traverse the tree from root to leaves to determine if the element exists in the binary tree.
* 10. Declare private Node<E> removeRecursive(Node<E> root, E data). Look for the Node.
* If root == null -> tree is empty -> return null
* Otherwise compare data to the root and tarverse recursevely eather left or right branch. When the needed Node 
* is found -> if no children -> delete the Node, return null.
* If no right child -> delete the Node and put left child on it's place
* If no left child -> delete the Node and put right child on it's place
* If the Node has two children -> find minimal value in right branch
* take right branch and check if it has a left child
* if no left child -> return rightLink, so we substitute deleted node with it's right child
* if it has a left child -> return this left child, so we substitute deleted node with left child of deleted node right child
* 11. Declare public void toStringInOrder() that prints out the Binary Tree making call to recursive method
* private void inOrder(Node<E> root).
* 12. Declare private void inOrder(Node<E> root). Traverse left branch -> find min data -> print it; do the same with right branch
* 13. Declare private inner generic class Node<E>
*/   
public class BinaryTree<E extends Comparable<E>>{
    private Node<E> root;
    /**
     * Default constructor
     */
    public BinaryTree()
    {
        root = null;
    }
    /**
     * One argument constructor
     * @param root root Node for setting root
     */
    public BinaryTree(Node<E> root)
    {
        setRoot(root);
    }
    /**
     * Sets the root
     * @param root root Node for setting root
     */
    public void setRoot(Node<E> root)
    {
        this.root = root;
    }
    /**
     * Gets the root
     * @return root
     */
    public Node<E> getRoot(){return root;}
    /**
     * Clears the Binary Tree
     * Sets root equal to null
     */
    public void clean()
    {
        root = null;
    }
    /**
     * Inserts Node in Binary Tree
     * This public method makes a call to the recursive method addRecursive(...) 
     * in order to traverse the tree from root to leaves to find the correct place 
     * to insert the new element.  It will reassign the root to the result of addRecursive(...) 
     * in the case where the tree is empty. This method always returns true, since an element 
     * can always be added to a binary tree.
     * @param data data to be inserted
     */
    public void insert(E data)  { 
        root = insert_Recursive(root, data); 
    } 
   //Helper method
   //Inserts Node ricursively
    private Node<E> insert_Recursive(Node<E> root, E data) {
        //If tree is empty, create new Node
        if (root == null) { 
            root = new Node<E>(data); 
            return root; 
        } 
        //If data needs to be inserted is less then root data
        //traverse left link
        if ((data.compareTo(root.data) < 0))
        {
            root.leftLink = insert_Recursive(root.leftLink, data); 
        }
        //If data needs to be inserted is more or equal to root data
        //traverse right link    
        else if ((data.compareTo(root.data) >= 0))
        {
            root.rightLink = insert_Recursive(root.rightLink, data); 
        }  
        return root; 
    } 
    /**
     * Check if Binary Tree contains certain data.
     * This public method makes a call to the recursive method containsRecursive(...) 
     * in order to traverse the tree from root to leaves to determine if the element exists 
     * in the binary tree. This method returns the result of containsRecursive(...) 
     * @param data data need to be checked
     * @return true if tree contains the needed data
     */
    public boolean contains(E data)
    {
        return containsRecursive(root, data);
    }
    //Helper method
    //Check resursively if tree contains certain data
    private boolean containsRecursive(Node<E> root, E data)
    {
        //If tree is empty
        if(root == null) return false;
        //If data less then root.data
        //Traverse left link
        else if((data.compareTo(root.data) < 0))
        {
            return containsRecursive(root.leftLink, data);
        }
        //If data more then root.data
        //Traverse right link
        else if((data.compareTo(root.data) > 0))
        {
            return containsRecursive(root.rightLink, data);
        }
        else return true;
    }
    /**
     * Removes the first occurrence of the specified element from this binary tree, 
     * if it is present. This public method makes a call to the recursive method removeRecursive(...) 
     * in order to traverse the tree from root to leaves to determine if the element 
     * exists in the binary tree
     * @param data data needs to be removed
     */
    public void remove(E data)
    {
        root = removeRecursive(root, data);
    }
    //Helper method
    //Removes the Node
    private Node<E> removeRecursive(Node<E> root, E data)
    {   //If tree is empty
        if(root == null) return null;
        //Look for data
        //If data less then root.data
        //Traverse left link
        else if((data.compareTo(root.data) < 0))
        {
            root.leftLink = removeRecursive(root.leftLink, data);
        }
        //Look for data
        //If data more then root.data
        //Traverse right link
        else if((data.compareTo(root.data) > 0))
        {
            root.rightLink = removeRecursive(root.rightLink, data);
        }
        //When the needed element is found
        else{
            //If the Node has no children, delete the Node, return null
            if(root.rightLink == null && root.leftLink == null) return null;
            //If the Node has only left child, delete the Node and put left child 
            //on it's place, return left child
            if(root.rightLink == null) return root.leftLink;
            //If the Node has only right child, delete the Node and put right child 
            //on it's place, return right child
            if(root.leftLink == null) return root.rightLink;
            //If the Node has two children, we need to find minimal value in right branch
            //take right branch and check if it has a left child
            //if it dosnt have a left child, return rightLink, so we substitute deleted node with it's right child
            //if it has a left child, return this left child, so we substitute deleted node with left child of deleted node right child
            root.data = minValue(root.rightLink);
            root.rightLink = removeRecursive(root.rightLink, root.data);
            
        }

        return root;
    }
    //Helper method
    //Looks for min value
    private E minValue(Node<E> root)
    {
        E minValue = root.data;
        while(root.leftLink != null)
        {
            minValue = root.leftLink.data;
            root = root.leftLink;
        }
        return minValue;
    }
    /**
     * Prints out the Binary Tree in-order
     */
    public void toStringInOrder()
    {
        System.out.println("In-order Traversal:");
        System.out.print("[");
        inOrder(root);
        System.out.print("]");
		
		
    }
    //Helper method
    //Prints out the Binary Tree recursevly in-order
    private void inOrder(Node<E> root)
	{
        if (root == null)
        {
          //System.out.println("Binary Tree is empty.");
          return;  
        } 
        else
        {
            //Traverse left branch to find the minimum data
            inOrder(root.leftLink);
            System.out.print(root.data + ",");
            //Traverse right branch
            inOrder(root.rightLink);
        }
        
	}


    
    private class Node<E>{
        private E data;
        private Node<E> leftLink;
        private Node<E> rightLink;
        /**
         * One argument constructor for Node generic class
         * @param data data to set in Node
         */
        public Node(E data)
        {
            this.data = data;
            leftLink = null;
            rightLink = null;
        }

    }//End of Node inner class
}
