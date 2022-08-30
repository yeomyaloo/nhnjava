package tree.binarysearch;

import java.util.List;

public class PreorderTreeTraverse extends Node{

    public PreorderTreeTraverse(Integer root) {
        super(root,null,null);
    }

    public PreorderTreeTraverse(PreorderTreeTraverse leftChildNode, PreorderTreeTraverse rightChildNode) {
        super(leftChildNode, rightChildNode);
    }

    public PreorderTreeTraverse(Integer root, PreorderTreeTraverse leftChildNode, PreorderTreeTraverse rightChildNode) {
        super(root, leftChildNode, rightChildNode);
    }

    @Override
    public Integer search(Integer key) {
        Integer value = null;

        if (this.value.equals(key)){
            try {
                return this.value;
            }catch (Exception e){

            }
        } else if (this.leftChildNode != null) {
            try{
                return this.leftChildNode.search(key);
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

    }



    private void preorder(Node node){
        if (node == null){
            return;
        }
        preorder(node.leftChildNode);
        preorder(node.rightChildNode);
    }

}
