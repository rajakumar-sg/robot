package wfh;

import javax.swing.*;
import java.awt.*;

public class KeepAlive {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            try {
                Robot robot = new Robot();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                double r = screenSize.getHeight() / 4.0d;
                double a = 0;
                while (true) {
                    double x = Math.sin(a) * r + screenSize.getWidth() / 2;
                    double y = Math.cos(a) * r + screenSize.getHeight() / 2;

                    robot.mouseMove((int) x, (int) y);
                    Thread.sleep(100);
                    a += 0.1;
                }
            }catch (Exception ex) {
                System.out.println(ex);
            }
        }).start();

        new Thread(() -> {
            JOptionPane.showMessageDialog(null, "close to stop");
            System.exit(0);
        }).start();

        System.out.println("Press enter to stop");
        System.in.read();
        System.out.println("stopped");
        System.exit(0);
    }
}
