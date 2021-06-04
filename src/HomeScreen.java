import org.opencv.core.Core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class HomeScreen extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton camera = new JButton("Take Image");
        JButton convert = new JButton("Convert to Text");
        JTextField input_file_name = new JTextField();
        JLabel message = new JLabel("Enter File Name: ");
        message.setBounds(250, 70, 200, 10);
        input_file_name.setBounds(115, 120, 200, 30);
        camera.setBounds(250, 400, 120, 40);
        convert.setBounds(320, 120, 140, 30);

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                EventQueue.invokeLater(new Runnable() {
                    // Overriding existing run() method
                    @Override public void run()
                    {
                        final Scan scan = new Scan();

                        // Start camera in thread
                        new Thread(new Runnable() {
                            @Override public void run()
                            {
                                String file_name = input_file_name.getText();
                                scan.scanFile(file_name);
                            }
                        }).start();
                    }
                });
            }
        });

        camera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
                EventQueue.invokeLater(new Runnable() {
                    // Overriding existing run() method
                    @Override public void run()
                    {
                        final Camera camera = new Camera();

                        // Start camera in thread
                        new Thread(new Runnable() {
                            @Override public void run()
                            {
                                camera.startCamera();
                            }
                        }).start();
                    }
                });
            }
        });

        frame.add(message);
        frame.add(input_file_name);
        frame.add(convert);
        frame.add(camera);
        frame.setSize(new Dimension(600, 500));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}