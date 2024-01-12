package SDA_UAS_K10;

public class Tree {
    private static Node root;

    public Tree() {
        root = null;
    }

    public boolean lookup(int data) {
        return (lookup(root, data));
    }

    private boolean lookup(Node find, int data) {
        if (find == null) {
            return (false);
        }
        if (data == Integer.parseInt(find.id)) {
            return (true);
        } else if (data < Integer.parseInt(find.id)) {
            return (lookup(find.leftChild, data));
        } else {
            return (lookup(find.rightChild, data));
        }
    }

    public int finMin(Node tes) {
        Node min = tes;
        while (min.leftChild != null) {
            min = min.leftChild;
        }
        return Integer.parseInt(min.id);
    }

    public int finMin() {
        return (finMin(root));
    }

    public int finMax(Node tes) {
        Node max = tes;
        while (max.rightChild != null) {
            max = max.rightChild;
        }
        return Integer.parseInt(max.id);
    }

    public int finMax() {
        return (finMax(root));
    }

    public int size() {
        return (size(root));
    }

    private int size(Node node) {
        if (node == null) {
            return (0);
        } else {
            return (size(node.leftChild) + 1 + size(node.rightChild));
        }
    }

    public void insert(String id, String harga, String nama, String topping) {
        Node baru = new Node(id, harga, nama, topping);
        if (root == null) {
            root = baru;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (Integer.parseInt(id) < Integer.parseInt(current.id)) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = baru;
                        break;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = baru;
                        break;
                    }
                }
            }
        }
    }

    public void printTree() {
        printTree(root);
        System.out.println();
    }

    public void printTree(Node localroot) {
        if (localroot != null) {
            printTree(localroot.leftChild);
            localroot.displayNode();
            printTree(localroot.rightChild);
        }
    }

    public void InOrder() {
        InOrder(root);
        System.out.println();
    }

    public void InOrder(Node localroot) {
        if (localroot != null) {
            InOrder(localroot.leftChild);
            localroot.displayNode();
            InOrder(localroot.rightChild);
        }
    }

    public void PostOrder() {
        PostOrder(root);
        System.out.println();
    }

    public void PostOrder(Node localroot) {
        if (localroot != null) {
            PostOrder(localroot.leftChild);
            PostOrder(localroot.rightChild);
            localroot.displayNode();
        }
    }

    public void PreOrder() {
        PreOrder(root);
        System.out.println();
    }

    public void PreOrder(Node localroot) {
        if (localroot != null) {
            localroot.displayNode();
            PreOrder(localroot.leftChild);
            PreOrder(localroot.rightChild);
        }
    }

    public boolean delete(int id){
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;
        while(Integer.parseInt(current.id) != id){
            parent = current;
            if(id < Integer.parseInt(current.id)){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null) return false;
        }
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }else if(current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
        }else if(current.leftChild == null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
        }else{
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;

}public void printLeafNodes(){
    printLeafNodes(root);
    System.out.println();
}
    static void printLeafNodes(Node root){
        if(root == null){
            return;
        }
        if(root.leftChild==null&& root.rightChild==null){
            root.displayNode();
            return;
        }
        if(root.leftChild!= null){
            printLeafNodes(root.leftChild);
        }
        if(root.rightChild != null){
            printLeafNodes(root.rightChild);
        }
    }
    public void printRootNodes(){
        printRootNodes(root);
        System.out.println();
    }
    static void printRootNodes(Node root){
        root.displayNode();
        return;
    }
}
