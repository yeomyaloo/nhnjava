package org.example.thread;

import java.applet.Applet;
import java.awt.*;
import java.util.Calendar;

public class RunnableTest extends Applet implements Runnable{


    Thread clock;
    Font myFont;

    public void init() {
        myFont = new Font("Serif", Font.BOLD, 40);
        setBackground(Color.BLACK);
    }

    public void start() {
        //실행 중인 쓰레드가 없는 경우 생성해준다.
        if(clock == null){
            clock = new Thread(this);
            clock.start();
        }
    }

    public void paint(Graphics g) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int date = now.get(Calendar.DATE);
        int hour = now.get(Calendar.HOUR);
        int min = now.get(Calendar.MINUTE);
        int sec = now.get(Calendar.SECOND);

        g.setFont(myFont);
        g.drawString(year + "-" + month +"-" + date + " " + hour + ":" + min + ":" + sec,10,40);
    }


    public void stop() {
        /**
         * 해당 쓰레드가 존재하고 지금 활동을 한다면
         * 멈추기 위해서 thread를 삭제해준다. (정지 = 삭제)
         * */
        if((clock!=null) && (clock.isAlive())){
            clock=null;
        }
    }


    /**
     * 단순히 1초에 한 번씩 repaint()명령을 실행하는 코드이다.
     * repaint()sms paint() 메서드를 실행라는 것이기 때문에,
     * 1초에 한 번씩 paint() 메서드가 실행되고 paint() 메서드에서는 현재 시간을 얻어
     * 화면에 출력한다. (이는 결국 디지털 시계가 되는 것이다.)
     * */
    @Override
    public void run() {
        while (true){
            try{
                clock.sleep(1000);

            } catch (InterruptedException e) {}
            repaint(); //repaint() 메서드를 실행시켜주는 역할을 함.
        }
    }
}
