package tree.binarysearch;

import java.util.List;

public class PostorderTreeTraverse extends Node{
    public PostorderTreeTraverse(Integer root) {
        super(root,null,null);
    }

    public PostorderTreeTraverse(PostorderTreeTraverse leftChildNode, PostorderTreeTraverse rightChildNode) {
        super(leftChildNode, rightChildNode);
    }

    public PostorderTreeTraverse(Integer root, PostorderTreeTraverse leftChildNode, PostorderTreeTraverse rightChildNode) {
        super(root, leftChildNode, rightChildNode);
    }
    @Override
    public Integer search(Integer value) {
        return null;
    }

    @Override
    public void getList(List<Integer> list) {

    }


}
