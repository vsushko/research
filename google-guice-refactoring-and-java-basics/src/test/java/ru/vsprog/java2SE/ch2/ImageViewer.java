package ru.vsprog.java2SE.ch2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by: vsa
 * Date: 07.08.14
 */
public class ImageViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ImageViewerFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ImageViewerFrame extends JFrame {
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setTitle("ImageViewer");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // для вывода изображений используется метка
        label = new JLabel();
        add(label);

        // диалоговое окно для выбора файлов
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // создание строки меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openIem = new JMenuItem("Open");
        menu.add(openIem);

        openIem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // отображение диалогового окна для выбора файла
                int result = chooser.showOpenDialog(null);

                // если файл выбран, он задается в качестве пиктограммы для метки
                if (result == JFileChooser.APPROVE_OPTION) {
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
