/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg15_game;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Админ
 */
/**
 *
 * @author SEREGS
 */
public class MainFrame extends JFrame {

    public static int count = 0;
    private String title;
    private Dimension d;
    JPanel panelButton = new JPanel();
    JPanel panelVictory = new JPanel(new GridLayout(6, 1));
    JPanel panelBut = new JPanel();
    JLabel textVictory;
    JLabel countStep;
    JLabel timeGame;
    JLabel addGame;
    JButton yes;
    JButton no;
    Date startTime;
    Date endTime;
    long tGame;

    GridLayout grid = new GridLayout(4, 4, 0, 0);
    JButton[][] v;
    JButton[][] v1;
    ArrayList<JButton> but;
    String[][] vv;
    String[][] vv1;
    ArrayList<String> vvv = new ArrayList<>();
    ArrayList<String> vvv1 = new ArrayList<>();

    Font font = new Font("SansSerif", Font.BOLD, 40);
    Font font1 = new Font("SansSerif", Font.BOLD, 26);

    public MainFrame(String title, Dimension d) {
        this.v = new JButton[4][4];
        this.title = title;
        this.d = d;
    }

    void arrPrint() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(vv[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println("N хода: " + count);
    }

    void addVictoryPanel() {

        remove(panelButton);
        tGame = endTime.getTime() - startTime.getTime();

        int seconds = (int) tGame / 1000;
        int seconds1 = (int) seconds % 60;
        int minutes = seconds / 60;
        textVictory = new JLabel("ВЫ ВЫИГРАЛИ!");
        countStep = new JLabel("Количество ходов: " + count);
        if (minutes == 0) {
            timeGame = new JLabel("Время игры: " + seconds1 + " сек.");
        } else {
            timeGame = new JLabel("Время игры: " + minutes + " мин. " + seconds1 + " сек.");
        }
        addGame = new JLabel("Ещё сыграть?" + '\n');
        yes = new JButton("ДА");
        no = new JButton("НЕТ");
        textVictory.setFont(font);
        textVictory.setHorizontalAlignment(SwingConstants.CENTER);
        countStep.setFont(font1);
        countStep.setHorizontalAlignment(SwingConstants.CENTER);
        timeGame.setFont(font1);
        timeGame.setHorizontalAlignment(SwingConstants.CENTER);
        addGame.setFont(font1);
        addGame.setHorizontalAlignment(SwingConstants.CENTER);
        panelBut.add(yes);
        panelBut.add(no);
        panelVictory.add(textVictory);
        panelVictory.add(countStep);
        panelVictory.add(timeGame);
        panelVictory.add(addGame);
        panelVictory.add(panelBut);

        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainFrame f = new MainFrame("15", new Dimension(400, 400));
                f.init();
            }
        });

        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        add(panelVictory);
    }

    public void init() {

        startTime = new Date();
        setTitle(title);
        setSize(d);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panelButton.setLayout(grid);
        // addButtons(); - добавляем кнопки в хаотичном порядке :))))))
        but = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            but.add(new JButton(String.valueOf(i + 1)));
        }
        but.add(new JButton(""));
        System.out.println(but.size());
        Collections.shuffle(but);

        v = new JButton[4][4];
        vv = new String[4][4];
        vv1 = new String[4][4];

        v[0][0] = but.get(0);
        v[0][1] = but.get(1);
        v[0][2] = but.get(2);
        v[0][3] = but.get(3);
        v[1][0] = but.get(4);
        v[1][1] = but.get(5);
        v[1][2] = but.get(6);
        v[1][3] = but.get(7);
        v[2][0] = but.get(8);
        v[2][1] = but.get(9);
        v[2][2] = but.get(10);
        v[2][3] = but.get(11);
        v[3][0] = but.get(12);
        v[3][1] = but.get(13);
        v[3][2] = but.get(14);
        v[3][3] = but.get(15);

        //Рабочий массив данных - рабочий шаблон
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                vv[i][j] = v[i][j].getText();
            }
        }

        //Победный массив данных - победный шаблон
        int y = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                vv1[i][j] = String.valueOf(y);
                y++;
            }
        }
        vv1[3][3] = "";

//Установливаем шрифт текста кнопок
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                v[i][j].setFont(font);
                panelButton.add(v[i][j]);
            }
        }

        for (int i = 0; i < 4; i++) {
            int k = i;
            for (int j = 0; j < 4; j++) {
                int h = j;
                v[k][h].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count1 = count;
                        try {
                            if (v[k][h + 1].getText().equals("")) {
                                String ex = v[k][h].getText();
                                v[k][h].setText(v[k][h + 1].getText());
                                v[k][h + 1].setText(ex);
                                vv[k][h] = vv[k][h + 1];
                                vv[k][h + 1] = ex;
                                count++;
                                System.out.println("count " + count);
                                if (Arrays.deepEquals(vv, vv1)) {
                                    System.out.println("УРА! ПОБЕДА!");
                                    endTime = new Date();
                                    addVictoryPanel();
                                }
                                arrPrint();
                                repaint();
                            }
                        } catch (ArrayIndexOutOfBoundsException eq) {
                        }
                        try {
                            if (v[k][h - 1].getText().equals("")) {
                                String ex = v[k][h].getText();
                                v[k][h].setText(v[k][h - 1].getText());
                                v[k][h - 1].setText(ex);
                                vv[k][h] = vv[k][h - 1];
                                vv[k][h - 1] = ex;
                                count++;
                                System.out.println("count " + count);
                                if (Arrays.deepEquals(vv, vv1)) {
                                    System.out.println("УРА! ПОБЕДА!");
                                    endTime = new Date();
                                    addVictoryPanel();
                                }
                                arrPrint();
                                repaint();
                            }
                        } catch (ArrayIndexOutOfBoundsException eq) {
                        }
                        try {
                            if (v[k
                                    + 1][h].getText().equals("")) {
                                String ex = v[k][h].getText();
                                v[k][h].setText(v[k + 1][h].getText());
                                v[k + 1][h].setText(ex);
                                vv[k][h] = vv[k + 1][h];
                                vv[k + 1][h] = ex;
                                count++;
                                System.out.println("count " + count);
                                if (Arrays.deepEquals(vv, vv1)) {
                                    System.out.println("УРА! ПОБЕДА!");
                                    endTime = new Date();
                                    addVictoryPanel();
                                }
                                arrPrint();
                                repaint();
                            }

                        } catch (ArrayIndexOutOfBoundsException eq) {
                        }
                        try {
                            if (v[k - 1][h].getText().equals("")) {
                                String ex = v[k][h].getText();
                                v[k][h].setText(v[k - 1][h].getText());
                                v[k - 1][h].setText(ex);
                                vv[k][h] = vv[k - 1][h];
                                vv[k - 1][h] = ex;
                                count++;
                                System.out.println("count " + count);
                                if (Arrays.deepEquals(vv, vv1)) {
                                    endTime = new Date();
                                    addVictoryPanel();
                                }
                                arrPrint();
                                repaint();
                            }

                        } catch (ArrayIndexOutOfBoundsException eq) {
                        }
                        System.out.println("Нажатие...");
                    }
                }
                );
            }
        }
        System.out.println();
        add(panelButton);

//pack();
//panelButton.setVisible(true);
        setResizable(false);
        setVisible(true);
    }
}
//Изменение 1