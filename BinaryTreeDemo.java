/** 
* TITLE: BinaryTreeDemo.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 6
* PROJECT: Lab 12_CycleInventory
* LAST MODIFIED: 12/02/2020
* DESCRIPTION: this program creates Binary Tree of numbers, clears tree, checks if the tree contains
* certain data, removes data from the tree, prints out the tree
*
* ALGORITHM:
* 1. Create an instance of BinaryTree generic class
* 2. Calll insert()
* 3. Call remove()
* 4. Call contains()
* 5. Call toStringInOrder() after every method called above
* 
* 
*/   
public class BinaryTreeDemo{
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.toStringInOrder();

        System.out.println("\n\nAdding nodes:");
        bt.insert(5);
        bt.insert(1);
        bt.insert(6);
        
        bt.insert(7);
        bt.insert(3);
        bt.insert(9);
     
        bt.insert(8);
        bt.insert(14);
        bt.insert(2);
     
        bt.toStringInOrder();
        
        System.out.println("\n\nIf Binary Tree contains number 14:");
        System.out.println(bt.contains(14));

        System.out.println("\nRemoving number 6:");
        bt.remove(6);
        bt.toStringInOrder();

        System.out.println("\n\nCleaning.");
        bt.clean();
        bt.toStringInOrder();

        


    }
}