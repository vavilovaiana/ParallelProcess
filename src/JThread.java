/**
 * Created by svetlanka on 26.06.17.
 */
import javax.swing.*;
import java.util.Random;


public class JThread implements Runnable
{
    private JProgressBar nameJProgressBar;
    private int value;

    JThread(JProgressBar nameJProgressBar, String name)
    {   this.nameJProgressBar = nameJProgressBar;
        Thread t = new Thread();
        t.setName(name);

    }


    @Override
    public void run()

    {
        System.out.println("start "+ Thread.currentThread().getName());
        Random random = new Random();
        {
            while (!(nameJProgressBar.getValue() == 100))
            {
                value = random.nextInt(4);//magic numbers
                nameJProgressBar.setValue(nameJProgressBar.getValue()+value);
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            Thread.interrupted();
            System.out.println("Thread kill"+Thread.currentThread().getName());
        }

    }
}
