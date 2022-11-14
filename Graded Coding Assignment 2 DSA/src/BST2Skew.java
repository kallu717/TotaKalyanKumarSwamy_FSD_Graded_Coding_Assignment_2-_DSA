import java.io.*;
class Node
{
    int val;
    Node left, right;
    Node(int item)
    {
        val = item;
        left = right = null;
    }
}
public class BST2Skew
{
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
    static void tree2skew(Node root, int order)
    {
        if(root == null)
        {
            return;
        }
        tree2skew(root.left, order);
        Node rightNode = root.right;
        Node leftNode = root.left;
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
            tree2skew(rightNode, order);
    }
    static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);
    }
    public static void main (String[] args)
    {
        BST2Skew tree = new BST2Skew();
        tree.node = new Node(50);
        tree.node.left = new Node(20);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);
        int order = 0;
        tree2skew(node, order);
        traverseRightSkewed(headNode);
    }
}
