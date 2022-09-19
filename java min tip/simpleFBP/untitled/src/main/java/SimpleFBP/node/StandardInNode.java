package SimpleFBP.node;

import SimpleFBP.message.Message;

import java.util.Scanner;

public class StandardInNode extends InputNode {

    Scanner scanner;

    public StandardInNode(){
        super(getCount());
        this.scanner = new Scanner(System.in);
    }

    public StandardInNode(int count){
        super(count);
        for (int i = 0; i < count; i++){
            this.scanner = new Scanner(System.in);
        }
    }

    @Override
    public void main(){


    }

}
