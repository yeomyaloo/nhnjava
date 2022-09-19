package SimpleFBP.node;

import SimpleFBP.message.Message;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerNode extends InputNode{


    private Timer timer;
    public TimerNode(Date time) {
        super(getCount());
        Message message = new Message;
        message.setPayload(time);
    }



    static class Helper extends TimerTask {
        @Override
        public void run() {

        }
    }
}
