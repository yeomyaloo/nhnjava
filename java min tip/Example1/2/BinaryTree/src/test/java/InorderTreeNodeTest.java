import java.util.Random;

public class InorderTreeNodeTest {
    public static void main(String[] args) {
        InorderTreeNode node1 = new InorderTreeNode(1);
        InorderTreeNode node2 = new InorderTreeNode(2);
        InorderTreeNode node3 = new InorderTreeNode(3, node1, node2);
        InorderTreeNode node4 = new InorderTreeNode(4, node3);
        InorderTreeNode node5 = new InorderTreeNode(5);
        InorderTreeNode node6 = new InorderTreeNode(6, node5);
        InorderTreeNode node7 = new InorderTreeNode(7, node6);
        InorderTreeNode node8 = new InorderTreeNode(8, node4, node7);

        System.out.println(node8);
        InorderTreeNode node10 = new InorderTreeNode(50);
        Random random = new Random();
        for(int i = 0 ; i < 10 ; i++) {
            node10.add(random.nextInt(100)-50);
        }

        System.out.println(node8);
        node8.remove(2);
        System.out.println(node8);
    }
}
