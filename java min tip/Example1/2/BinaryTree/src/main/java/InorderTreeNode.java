import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InorderTreeNode<T, K> extends Node<T, K> {
    public InorderTreeNode(T value) {
        super(value, null, null);
    }

    public InorderTreeNode(T value, InorderTreeNode leftChildNode) {
        super(value, leftChildNode, null);
    }

    public InorderTreeNode(T value, InorderTreeNode leftChildNode, InorderTreeNode rightChildNode) {
        super(value, leftChildNode, rightChildNode);
    }

    public T search(K key) throws Exception {
        if (this.leftChild != null) {
            try {
                return (T)this.leftChild.search(key);
            }
            catch (Exception ignore) {
            }
        }

        if (this.value.equals(key))  {
            return  this.value;
        }

        if (this.rightChild != null) {
            try {
                return (T)this.rightChild.search(key);
            }
            catch (Exception ignore) {
            }
        }

        throw new Exception("Not found!");
    }

    public void add(K value) {
        if (this.value.compareTo(value) > 0) {
            if (this.leftChild != null) {
                ((InorderTreeNode)this.leftChild).add(value);
            } else {
                this.leftChild = new InorderTreeNode(value) ;
            }
        } else if (this.value.compareTo(value) <= 0) {
            if (this.rightChild != null) {
                ((InorderTreeNode)this.rightChild).add(value);
            } else {
                this.rightChild = new InorderTreeNode(value) ;
            }
        }
    }

    public void add(Node node) {
        if (this.value.compareTo(node.getValue()) > 0) {
            if (this.leftChild != null) {
                ((InorderTreeNode)this.leftChild).add(node);
            } else {
                this.leftChild = node;
            }
        } else if (this.value.compareTo(node.getValue()) <= 0) {
            if (this.rightChild != null) {
                ((InorderTreeNode)this.rightChild).add(node);
            } else {
                this.rightChild = node;
            }
        }
    }

    public void remove(K key) {
            if (this.leftChild != null) {
                try {
                    this.leftChild.search(key);
                    if (this.leftChild.getValue().equals(key)) {
                        if (this.leftChild.getLeftChildNode() != null) {
                            Node rightNode = this.leftChild.getRightChildNode();
                            this.leftChild = this.leftChild.getLeftChildNode();
                            this.leftChild.add(rightNode);
                        } else {
                            this.leftChild = this.leftChild.getRightChildNode();
                        }
                    } else {
                        this.leftChild.remove(key);
                    }
                } catch (Exception e) {
                    System.out.println(e + ": left");
                }
            }
            if (this.rightChild != null) {
                try {
                    this.rightChild.search(key);
                    if (this.rightChild.getValue().equals(key)) {
                        if (this.rightChild.getLeftChildNode() != null)  {
                            Node rightNode = this.rightChild.getRightChildNode();
                            this.rightChild = this.rightChild.getLeftChildNode();
                            this.rightChild.add(rightNode);
                        } else  {
                            this.rightChild = this.rightChild.getRightChildNode();
                        }
                    } else {
                        this.rightChild.remove(key);
                    }
                } catch (Exception e) {
                    System.out.println(e + ": right");
                }
            }
    }

    public void getList(List<T> list) {
        if (this.leftChild != null) {
            this.leftChild.getList(list);
        }

        list.add(this.value);

        if (this.rightChild != null) {
            this.rightChild.getList(list);
        }
    }

    public String toString() {
        List<String>  list = new ArrayList<>();

       if ((this.leftChild != null) || (this.rightChild != null)) {
           if (this.leftChild != null) {
               list.add(this.leftChild.toString());
           } else {
               list.add("null");
           }

           list.add(this.value.toString());

           if (this.rightChild != null) {
               list.add(this.rightChild.toString());
           } else {
               list.add("null");
           }

           return  list.toString();
       }
       else {
           return   this.value.toString();
       }

    }
}
