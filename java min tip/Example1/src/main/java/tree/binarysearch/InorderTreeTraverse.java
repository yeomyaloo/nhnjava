package tree.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class InorderTreeTraverse<T,K> extends Node<T,K>{
    public InorderTreeTraverse(T root) {
        super(root,null,null);
    }

    public InorderTreeTraverse(InorderTreeTraverse leftChildNode, InorderTreeTraverse rightChildNode) {
        super(leftChildNode, rightChildNode);
    }

    public InorderTreeTraverse(T root, InorderTreeTraverse leftChildNode, InorderTreeTraverse rightChildNode) {
        super(root, leftChildNode, rightChildNode);
    }


    @Override
    public T search(K key) throws Exception{
        if (this.leftChildNode != null){
            try {
                return (T) this.leftChildNode.search(key);
            }catch (Exception e){

            }
        } else if (this.value.equals(key)) {
            try{
                return this.value;
            } catch (Exception e){

            }
        } else if (this.rightChildNode != null) {
            try {
                return (T) this.rightChildNode.search(key);
            } catch (Exception e){

            }
        }
        return new Exception("not found!");
    }

    
    public void getList(List<T> list) {
        if(this.leftChildNode != null) {
            this.leftChildNode.getList(list);
        }
        list.add(this.value);
        
        if(this.rightChildNode != null) {
            this.rightChildNode.getList(list);
        }
    }

    public void add(K value){
        if(this.value.compareTo(value) > 0) {
            if(this.leftChildNode != null) {
                ((InorderTreeTraverse)this.leftChildNode).add(value);
            }
            else {
                this.leftChildNode = new InorderTreeTraverse(value);
            }
        } else if (this.value.compareTo(value) <= 0) {
            if (this.rightChildNode != null) {
                ((InorderTreeTraverse)this.rightChildNode).add(value);
            }
            else{
                this.rightChildNode = new InorderTreeTraverse(value);
            }
        }
    }

    public void remove(Node node){
        if (node == null){
            return;
        }
        if (node.leftChildNode != null){
            Node cur = node;
            node = node.leftChildNode;
            cur = null;
        } else if (node.rightChildNode != null) {
            Node cur = node;
            node = node.rightChildNode;
            cur = null;
            }
    }

    public void remove(K key) {
        if (this.leftChildNode != null) {
            {
            this.leftChildNode.search(key);
            if (this.leftChildNode.getValue().equals(key)) {
                if (this.leftChildNode.getLeftChildNode() != null) {
                    Node rightNode = this.leftChildNode.getRightChildNode();

                }
                }
            }
        }


    }
    public String toString() {
        List<String>  list = new ArrayList<>();

        if ((this.leftChildNode != null) || (this.rightChildNode != null)) {
            if (this.leftChildNode != null) {
                list.add(this.leftChildNode.toString());
            } else {
                list.add("null");
            }

            list.add(this.value.toString());

            if (this.rightChildNode != null) {
                list.add(this.rightChildNode.toString());
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


