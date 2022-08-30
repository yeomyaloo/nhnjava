package tree.binarysearch;

import java.util.List;

public class InorderTreeTraverse extends Node{
    public InorderTreeTraverse(Integer root) {
        super(root,null,null);
    }

    public InorderTreeTraverse(InorderTreeTraverse leftChildNode, InorderTreeTraverse rightChildNode) {
        super(leftChildNode, rightChildNode);
    }

    public InorderTreeTraverse(Integer root, InorderTreeTraverse leftChildNode, InorderTreeTraverse rightChildNode) {
        super(root, leftChildNode, rightChildNode);
    }


    @Override
    public Integer search(Integer key) {

        Integer value = null;
        if (this.leftChildNode != null){
            try {
                return this.leftChildNode.search(key);
            }catch (Exception e){

            }
        } else if (this.value.equals(key)) {
            try{
                return this.value;
            } catch (Exception e){

            }
        } else if (this.rightChildNode != null) {
            try {
                return this.rightChildNode.search(key);
            } catch (Exception e){

            }
        }
        return value;
    }

    @Override
    public void getList(List<Integer> list) {
        if(this.leftChildNode != null) {
            this.leftChildNode.getList(list);
        }
    }

    public void add(Integer value){
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
        else {
            node = null;
        }
    }

    public void remove(Integer key) {
        if (this.leftChildNode != null) {
            try {
                this.leftChildNode.search(key);
                if(this.leftChildNode.getLeftChildNode() != null){

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}


