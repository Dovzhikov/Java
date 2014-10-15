import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    JPanel contentPane;
    JPanel gamePane = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JLabel status = new JLabel();
    JButton[][] buttons = new JButton[4][4];
    int[][] matrix = new int[4][4];

    public MainFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(borderLayout1);
        this.setSize(new Dimension(206, 275));
        this.setTitle("Fifteen");
        this.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        JMenu menuHelp = new JMenu("Help");
        menuBar.add(menuGame);
        menuBar.add(menuHelp);
        this.setJMenuBar(menuBar);
        JMenuItem item1 = new JMenuItem("New game");
        JMenuItem item2 = new JMenuItem("Exit");
        JMenuItem item3 = new JMenuItem("About...");
        item1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
        item2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        item3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "2014. Game fifteen.", "About",
                        JOptionPane.QUESTION_MESSAGE);
            }
        });

        menuGame.add(item1);
        menuGame.add(item2);
        menuHelp.add(item3);
        gamePane.setLayout(null);
        int count = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton("" + count);
                buttons[i][j].addMouseListener(new mAdapter(i, j));
                buttons[i][j].setSize(50, 50);
                buttons[i][j].setLocation(50 * j, 50 * i);
                buttons[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
                gamePane.add(buttons[i][j]);
                matrix[i][j] = count;
                count++;
            }
        buttons[0][0].setText(" ");
        contentPane.add(gamePane, BorderLayout.CENTER);
        status.setBorder(BorderFactory.createEtchedBorder());
        contentPane.add(status, BorderLayout.SOUTH);
        newGame();
    }

    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    public boolean checkMatrix(int arr[]) {
        for (int i = 0; i < 15; i++) {
            
        }
    }

    public void randomizeMatrix() {
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 4);
            int b = (int) (Math.random() * 4);
            int a2 = (int) (Math.random() * 4);
            int b2 = (int) (Math.random() * 4);

            int c = matrix[a][b];
            matrix[a][b] = matrix[a2][b2];
            matrix[a2][b2] = c;
        }
    }

    public void newGame() {
        randomizeMatrix();
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                if (matrix[i][j] != 0) buttons[i][j].setText("" + matrix[i][j]);
                else buttons[i][j].setText("");
            }
        status.setText("new game started");
        gamePane.setVisible(true);
    }

    class mAdapter extends java.awt.event.MouseAdapter {
        int posi, posj;
        int startx = 0;
        int starty = 0;

        mAdapter(int posI, int posJ) {
            this.posi = posI;
            this.posj = posJ;
        }

        public void mousePressed(MouseEvent e) {
            buttons[posi][posj].setCursor(new Cursor(Cursor.MOVE_CURSOR));
            startx = e.getX();
            starty = e.getY();
        }

        public void mouseReleased(MouseEvent e) {
            buttons[posi][posj].setCursor(new Cursor(Cursor.HAND_CURSOR));
            int endx = e.getX();
            int endy = e.getY();
            int shiftx = endx - startx;
            int shifty = endy - starty;
            if (Math.abs(shiftx) > Math.abs(shifty)) {
                if (shiftx > 0) {

                    if ((posj != 3) && (matrix[posi][posj + 1] == 0)) {
                        matrix[posi][posj + 1] = matrix[posi][posj];
                        matrix[posi][posj] = 0;
                        buttons[posi][posj].setText("");
                        buttons[posi][posj + 1].setText("" + matrix[posi][posj + 1]);
                        status.setText("good turn");
                    } else status.setText("it is impossible");
                } else {

                    if ((posj != 0) && (matrix[posi][posj - 1] == 0)) {
                        matrix[posi][posj - 1] = matrix[posi][posj];
                        matrix[posi][posj] = 0;
                        buttons[posi][posj].setText("");
                        buttons[posi][posj - 1].setText("" + matrix[posi][posj - 1]);
                        status.setText("good turn");
                    } else status.setText("it is impossible");
                }
            } else {
                if (shifty > 0) {

                    if ((posi != 3) && (matrix[posi + 1][posj] == 0)) {
                        matrix[posi + 1][posj] = matrix[posi][posj];
                        matrix[posi][posj] = 0;
                        buttons[posi][posj].setText("");
                        buttons[posi + 1][posj].setText("" + matrix[posi + 1][posj]);
                        status.setText("good turn");
                    } else status.setText("it is impossible");
                } else {

                    if ((posi != 0) && (matrix[posi - 1][posj] == 0)) {
                        matrix[posi - 1][posj] = matrix[posi][posj];
                        matrix[posi][posj] = 0;
                        buttons[posi][posj].setText("");
                        buttons[posi - 1][posj].setText("" + matrix[posi - 1][posj]);
                        status.setText("good turn");
                    } else status.setText("it is impossible");
                }
            }
            int count = 1;
            int error = 0;
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++) {
                    if (matrix[i][j] != count) error++;
                    count++;
                }
            if (error == 1) {
                status.setText("You win!!!");
                int result = JOptionPane.showConfirmDialog(null,
                        "You win!!!", "You win!!! New game?", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) newGame();
                else gamePane.setVisible(false);
            }
        }
    }
}