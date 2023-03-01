package org.orest.tsiatsiak;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextWindow extends JFrame {

    private final JLabel jLabel = new JLabel();

    public TextWindow() {
        tuneWindow();
        setUpJLabel();
        addKeyListener(getTypeListener());
    }

    private void tuneWindow() {
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setUpJLabel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jLabel);
        add(panel);
    }

    private KeyListener getTypeListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String currentText = jLabel.getText();
                if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (currentText.length() > 0) {
                        jLabel.setText(currentText.substring(0, currentText.length() - 1));
                    }
                } else {
                    jLabel.setText(currentText + e.getKeyChar());
                }
                jLabel.repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
    }

}
