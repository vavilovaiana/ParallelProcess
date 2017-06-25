import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


class GUI extends JFrame {
    private JProgressBar jProgressBar1 = new JProgressBar();
    private JProgressBar jProgressBar2 = new JProgressBar();
    private JProgressBar jProgressBar3 = new JProgressBar();
    private static final int MY_MINIMUM = 0;
    private static final int MY_MAXIMUM = 100;
    private JThread thread1 = new JThread(jProgressBar1, "one");
    private JThread thread2 = new JThread(jProgressBar2, "two");
    private JThread thread3 = new JThread(jProgressBar3, "three");

    GUI() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridheight = 1;
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(20, 20, 20, 20);


        gridBagLayout.setConstraints(jProgressBar1, constraints);
        setSettingJProgressBar(jProgressBar1);
        add(jProgressBar1);

        gridBagLayout.setConstraints(jProgressBar2, constraints);
        setSettingJProgressBar(jProgressBar2);
        add(jProgressBar2);

        gridBagLayout.setConstraints(jProgressBar3, constraints);
        setSettingJProgressBar(jProgressBar3);
        add(jProgressBar3);


        JButton jButton = new JButton("Start!");
        gridBagLayout.setConstraints(jButton, constraints);
        add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t1 = new Thread(thread1);
                Thread t2 = new Thread(thread2);
                Thread t3 = new Thread(thread3);

                ArrayList<Thread> threadsList = new ArrayList<>();
                threadsList.add(t1);
                threadsList.add(t2);
                threadsList.add(t3);


                for (Thread t : threadsList)
                {
                    t.start();
                }


            }
        });

        setSize(500, 250);
        setVisible(true);
    }

    private JProgressBar setSettingJProgressBar(JProgressBar nameJProgressBar) {
        nameJProgressBar.setVisible(true);
        nameJProgressBar.setStringPainted(true);
        nameJProgressBar.setMaximum(MY_MAXIMUM);
        nameJProgressBar.setMinimum(MY_MINIMUM);
        return nameJProgressBar;
    }



}
