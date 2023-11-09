/* Binary Search Tree Class
 *  Made for CS165 at CSU
 *  A basic binary search tree of integers, without a remove method.
 */


public class BST implements Tree<Integer> {

    private TreeNode<Integer> root;
    private int size;

    public class TreeNode<Integer> {
        public Integer element;
        public TreeNode<Integer> rightChild;
        public TreeNode<Integer> leftChild;

        /* TODO: finish this constructor
         *  Think: what needs to be initialized, there are three member variables */
        public TreeNode(Integer element) {
            this.element=element;
            this.rightChild=null;
            this.leftChild=null;
        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(Integer item) {
        super();
        insert(item);
    }

    public BST(Integer[] items) {
        super();
        for(Integer item:items){
            insert(item);
        }
        /* TODO: Insert all of items into this tree */

    }

    /* Does a binary search.
     *  TODO: complete this method */
    @Override
    public boolean search(Integer item) {
        TreeNode<Integer>temp=root;
        while (temp!=null){
            if(item== temp.element){
                return true;
            } else if (item<temp.element) {
                temp=temp.leftChild;
            } else{
                temp=temp.rightChild;
            }
        }
        return false;
    }

    /* Inserts item into tree, return false if item is already in tree.
     *  Order of the tree is: root.element > left.element &&
     *                        root.element < right.element
     *  TODO: complete this method
     */
    @Override
    public boolean insert(Integer item) {
        if(root==null){
            root=new TreeNode<Integer>(item);
            ++size;
            return true;
        }
        TreeNode<Integer>temp=root;
        TreeNode<Integer>tempInsert=null;
        while(temp!=null){
            tempInsert=temp;
            if(item==temp.element){
                return false;
            }else if(item<temp.element){
                temp=temp.leftChild;
            }else{
                temp=temp.rightChild;
            }
        }
        if(item<tempInsert.element){
            tempInsert.leftChild=new TreeNode<>(item);
        }else{
            tempInsert.rightChild=new TreeNode<>(item);
        }
        ++size;
        return true;
    }


    // for the next lab
//    @Override
//    public boolean remove(Integer item) {
//        return false;
//    }

    /* Getter method for the size of the tree
     *  TODO: complete this method
     */
    @Override
    public int size() {
        return size;
    }

    /* Does an inorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void inorder() {
        inOrderRecursive(root);
    }
    public void inOrderRecursive(TreeNode<Integer> temp){
        if (temp == null) {
            return;
        }
        inOrderRecursive(temp.leftChild);
        System.out.print(temp.element+" ");
        inOrderRecursive(temp.rightChild);
    }


    /* Does a postorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void postorder() {
        postOrderRecursive(root);
    }
    public void postOrderRecursive(TreeNode<Integer> temp){
        if(temp==null){
            return;
        }
        postOrderRecursive(temp.leftChild);
        postOrderRecursive(temp.rightChild);
        System.out.print(temp.element+" ");
    }

    /* Does a preorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void preorder() {
        preOrderRecursive(root);
    }
    public void preOrderRecursive(TreeNode<Integer>temp){
        if(temp==null){
            return;
        }
        System.out.print(temp.element+" ");
        preOrderRecursive(temp.leftChild);
        preOrderRecursive(temp.rightChild);
    }
    /* Prints true on empty tree, false otherwise
     *  TODO: Complete this method
     */
    @Override
    public boolean isEmpty() {
        boolean temp=(root==null);
        return temp;
    }

    /* Returns the root node of the tree */
    public TreeNode<Integer> getRoot() {
        return root;
    }
}
