package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private int x, y;
    private int rows, cols;
    private int boardWidth, boardHeight;
    private int cellWidth, cellHeight;
    private int padX, padY;
    private final int canvasWidth = 800, canvasHeight = 600;
    private BufferedImage image;
    private Graphics2D offscreen;
    private int incercari = 8;
    private int lungime;

//    private List<Square> squares;
//    private Map<Stone, Player> positions;
//    private Board board;
//    private Stone previousStone;
//    private boolean endOfGame;
//    Player player;
//    private Game game;
//    int turn;
//    List<Player> players = new ArrayList<>();
//    private MouseAdapter mouse;


    public Boolean verificareCategorie(String categorie) {
        List<String> list = new ArrayList<>();
        list.add("Animale");
        list.add("Geografie");
        list.add("Istorie");
        list.add("Literatura");
        list.add("Medicina");
        list.add("Plante");

        for (String s : list) {
            if (s.toLowerCase(Locale.ROOT).equals(categorie.toLowerCase(Locale.ROOT)))
                return true;
        }
        return false;
    }


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    private void init() {
        this.padX = 30;
        this.padY = 30;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
        });
    }


    public void selectGridSize() {
        frame.configPanel.modifyHelpMessage("Select size of the board: ");
        frame.canvas.setLayout(null);
        JSpinner width = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        JSpinner height = new JSpinner(new SpinnerNumberModel(3, 3, 10, 1));
        JButton nextButton = new JButton("Next");
        JLabel numberOfRows = new JLabel("Number of rows:");
        JLabel numberOfCols = new JLabel("Number of cols:");
        width.setBounds(400, 150, 150, 40);
        height.setBounds(400, 250, 150, 40);
        nextButton.setBounds(250, 350, 300, 40);
        numberOfRows.setBounds(250, 250, 100, 40);
        numberOfCols.setBounds(250, 150, 100, 40);
        nextButton.addActionListener(e -> {
            rows = (int) height.getValue() + 1;
            cols = (int) width.getValue() + 1;
            frame.canvas.remove(width);
            frame.canvas.remove(height);
            frame.canvas.remove(nextButton);
            frame.canvas.remove(numberOfCols);
            frame.canvas.remove(numberOfRows);
            repaint();
            selectColorAndIcon();
        });
        frame.canvas.add(numberOfRows);
        frame.canvas.add(numberOfCols);
        frame.canvas.add(height);
        frame.canvas.add(width);
        frame.canvas.add(nextButton);
    }

    public void selectColorAndIcon() {
        frame.configPanel.modifyHelpMessage("Select color: ");
        frame.canvas.setLayout(null);

        JButton nextButton = new JButton("Next");
        JButton changeColorButton = new JButton("Change color");
        JLabel labelChosenColor = new JLabel("Current color: ");
        JButton chosenColor = new JButton("");
        labelChosenColor.setBounds(250, 150, 150, 40);
        chosenColor.setBounds(400, 150, 150, 40);
        chosenColor.setBackground(Color.red);
        changeColorButton.setBounds(250, 250, 300, 40);
        nextButton.setBounds(250, 350, 300, 40);
        nextButton.addActionListener(e -> {
            frame.canvas.remove(labelChosenColor);
            frame.canvas.remove(changeColorButton);
            frame.canvas.remove(nextButton);
            frame.canvas.remove(chosenColor);
            repaint();
            reinitializeCanvas();
        });
        changeColorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(frame.canvas, "Select a Color", Color.white);
            chosenColor.setBackground(color);

        });
        frame.canvas.add(labelChosenColor);
        frame.canvas.add(changeColorButton);
        frame.canvas.add(nextButton);
        frame.canvas.add(chosenColor);
    }

    public void startGame() throws IOException {

        frame.configPanel.modifyHelpMessage("Alege categoria din care o sa primeste un cuvant");
        JLabel label = new JLabel("<html><h3>   Categoriile disponibile sunt: Animale, Plante, Geografie, Istorie, Literatura si Medicina</h3></html>");
        JButton nextButton = new JButton("Start joc");
        JLabel labelCategorie = new JLabel("Categorie: ");
        JTextField categorie = new JTextField();
//        BufferedImage myPicture = ImageIO.read(new File("Img/background.png"));
//        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        frame.canvas.setLayout(null);

//        frame.canvas.add(picLabel);
        frame.canvas.add(label);
        frame.canvas.add(labelCategorie);
        frame.canvas.add(categorie);
        frame.canvas.add(nextButton);

//        picLabel.setBounds(10,10,600,600);
        label.setBounds(200, 50, 500, 150);
        labelCategorie.setBounds(250, 200, 150, 40);
        categorie.setBounds(350, 200, 200, 40);
        nextButton.setBounds(250, 300, 300, 40);
        nextButton.addActionListener(e -> {
            if (verificareCategorie(categorie.getText())) {
                frame.canvas.remove(label);
                frame.canvas.remove(nextButton);
                frame.canvas.remove(labelCategorie);
                frame.canvas.remove(categorie);
                repaint();
                try {
                    playGame(categorie.getText());
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            } else {
                frame.configPanel.modifyHelpMessage("Categoria introdusa nu exista. Incearca din nou!");

            }
        });

    }

    public void playGame(String table) throws SQLException, IOException {
        Game game = new Game();
        String word = game.generareCuvant(table);
        frame.configPanel.modifyHelpMessage("Succes!");
        BufferedImage myPicture = ImageIO.read(new File("Img/1.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        Icon iconA = new ImageIcon("Img/A.png");
        JButton A = new JButton(iconA);
        Icon iconB = new ImageIcon("Img/B.png");
        JButton B = new JButton(iconB);
        Icon iconC = new ImageIcon("Img/C.png");
        JButton C = new JButton(iconC);
        Icon iconD = new ImageIcon("Img/D.png");
        JButton D = new JButton(iconD);
        Icon iconE = new ImageIcon("Img/E.png");
        JButton E = new JButton(iconE);
        Icon iconF = new ImageIcon("Img/F.png");
        JButton F = new JButton(iconF);
        Icon iconG = new ImageIcon("Img/G.png");
        JButton G = new JButton(iconG);
        Icon iconH = new ImageIcon("Img/H.png");
        JButton H = new JButton(iconH);
        Icon iconI = new ImageIcon("Img/I.png");
        JButton I = new JButton(iconI);
        Icon iconJ = new ImageIcon("Img/J.png");
        JButton J = new JButton(iconJ);
        Icon iconK = new ImageIcon("Img/K.png");
        JButton K = new JButton(iconK);
        Icon iconL = new ImageIcon("Img/L.png");
        JButton L = new JButton(iconL);
        Icon iconM = new ImageIcon("Img/M.png");
        JButton M = new JButton(iconM);
        Icon iconN = new ImageIcon("Img/N.png");
        JButton N = new JButton(iconN);
        Icon iconO = new ImageIcon("Img/O.png");
        JButton O = new JButton(iconO);
        Icon iconP = new ImageIcon("Img/P.png");
        JButton P = new JButton(iconP);
        Icon iconR = new ImageIcon("Img/R.png");
        JButton R = new JButton(iconR);
        Icon iconS = new ImageIcon("Img/S.png");
        JButton S = new JButton(iconS);
        Icon iconT = new ImageIcon("Img/T.png");
        JButton T = new JButton(iconT);
        Icon iconU = new ImageIcon("Img/U.png");
        JButton U = new JButton(iconU);
        Icon iconV = new ImageIcon("Img/V.png");
        JButton V = new JButton(iconV);
        Icon iconW = new ImageIcon("Img/W.png");
        JButton W = new JButton(iconW);
        Icon iconX = new ImageIcon("Img/X.png");
        JButton X = new JButton(iconX);
        Icon iconY = new ImageIcon("Img/Y.png");
        JButton Y = new JButton(iconY);
        Icon iconZ = new ImageIcon("Img/Z.png");
        JButton Z = new JButton(iconZ);
        JLabel labelIncercari = new JLabel("Numarul de incercari ramase: " + incercari);

        frame.canvas.setLayout(null);
        frame.canvas.add(picLabel);
        frame.canvas.add(labelIncercari);
        frame.canvas.add(A);
        frame.canvas.add(B);
        frame.canvas.add(C);
        frame.canvas.add(D);
        frame.canvas.add(E);
        frame.canvas.add(F);
        frame.canvas.add(G);
        frame.canvas.add(H);
        frame.canvas.add(I);
        frame.canvas.add(J);
        frame.canvas.add(K);
        frame.canvas.add(L);
        frame.canvas.add(M);
        frame.canvas.add(N);
        frame.canvas.add(O);
        frame.canvas.add(P);
        frame.canvas.add(R);
        frame.canvas.add(S);
        frame.canvas.add(T);
        frame.canvas.add(U);
        frame.canvas.add(V);
        frame.canvas.add(W);
        frame.canvas.add(X);
        frame.canvas.add(Y);
        frame.canvas.add(Z);

        picLabel.setBounds(3, 5, 200, 500);
        labelIncercari.setBounds(60, 10, 500, 150);
        A.setBounds(50, 450, 45, 45);
        B.setBounds(110, 450, 45, 45);
        C.setBounds(170, 450, 45, 45);
        D.setBounds(230, 450, 45, 45);
        E.setBounds(290, 450, 45, 45);
        F.setBounds(350, 450, 45, 45);
        G.setBounds(410, 450, 45, 45);
        H.setBounds(470, 450, 45, 45);
        I.setBounds(530, 450, 45, 45);
        J.setBounds(590, 450, 45, 45);
        K.setBounds(650, 450, 45, 45);
        L.setBounds(710, 450, 45, 45);

        M.setBounds(20, 510, 45, 45);
        N.setBounds(80, 510, 45, 45);
        O.setBounds(140, 510, 45, 45);
        P.setBounds(200, 510, 45, 45);
        R.setBounds(260, 510, 45, 45);
        S.setBounds(320, 510, 45, 45);
        T.setBounds(380, 510, 45, 45);
        U.setBounds(440, 510, 45, 45);
        V.setBounds(500, 510, 45, 45);
        W.setBounds(560, 510, 45, 45);
        X.setBounds(620, 510, 45, 45);
        Y.setBounds(680, 510, 45, 45);
        Z.setBounds(740, 510, 45, 45);

        lungime = word.length();
        System.out.println(word);
        int x = 200;
        ArrayList<JLabel> listaLabel = new ArrayList<>();
        while (lungime != 0) {
            JLabel label = new JLabel("<html>____</html>");
            frame.canvas.add(label);
            x = x + 50;
            label.setBounds(x, 300, 500, 150);
            lungime--;
            listaLabel.add(label);
        }

        A.addActionListener(e -> {

            frame.canvas.remove(A);
            repaint();
            Icon icon = new ImageIcon("Img/A_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(50, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("a", word);
            if (lista.size() == 0) {
                frame.canvas.remove(labelIncercari);
                repaint();
                incercari--;
                JLabel labelIncercariNou = new JLabel("Numarul de incercari ramase: " + incercari);
                frame.canvas.add(labelIncercariNou);
                labelIncercariNou.setBounds(60, 10, 500, 150);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>A</h1></html>");
                    }
                    repaint();
                }
            }
            System.out.println(lista);
        });
        B.addActionListener(e -> {
            frame.canvas.remove(B);
            repaint();
            Icon icon = new ImageIcon("Img/B_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(110, 450, 45, 45);
        });
        C.addActionListener(e -> {
            frame.canvas.remove(C);
            repaint();
            Icon icon = new ImageIcon("Img/C_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(170, 450, 45, 45);
        });
        D.addActionListener(e -> {
            frame.canvas.remove(D);
            repaint();
            Icon icon = new ImageIcon("Img/D_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(230, 450, 45, 45);
        });
        E.addActionListener(e -> {
            frame.canvas.remove(E);
            repaint();
            Icon icon = new ImageIcon("Img/E_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(290, 450, 45, 45);
        });
        F.addActionListener(e -> {
            frame.canvas.remove(F);
            repaint();
            Icon icon = new ImageIcon("Img/F_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(350, 450, 45, 45);
        });
        G.addActionListener(e -> {
            frame.canvas.remove(G);
            repaint();
            Icon icon = new ImageIcon("Img/G_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(410, 450, 45, 45);
        });
        H.addActionListener(e -> {
            frame.canvas.remove(H);
            repaint();
            Icon icon = new ImageIcon("Img/H_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(470, 450, 45, 45);
        });
        I.addActionListener(e -> {
            frame.canvas.remove(I);
            repaint();
            Icon icon = new ImageIcon("Img/I_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(530, 450, 45, 45);
        });
        J.addActionListener(e -> {
            frame.canvas.remove(J);
            repaint();
            Icon icon = new ImageIcon("Img/J_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(590, 450, 45, 45);
        });
        K.addActionListener(e -> {
            frame.canvas.remove(K);
            repaint();
            Icon icon = new ImageIcon("Img/K_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(650, 450, 45, 45);
        });
        L.addActionListener(e -> {
            frame.canvas.remove(L);
            repaint();
            Icon icon = new ImageIcon("Img/L_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(710, 450, 45, 45);
        });
        M.addActionListener(e -> {
            frame.canvas.remove(M);
            repaint();
            Icon icon = new ImageIcon("Img/M_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(20, 510, 45, 45);
        });
        N.addActionListener(e -> {
            frame.canvas.remove(N);
            repaint();
            Icon icon = new ImageIcon("Img/N_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(80, 510, 45, 45);
        });
        O.addActionListener(e -> {
            frame.canvas.remove(O);
            repaint();
            Icon icon = new ImageIcon("Img/O_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(140, 510, 45, 45);
        });
        P.addActionListener(e -> {
            frame.canvas.remove(P);
            repaint();
            Icon icon = new ImageIcon("Img/P_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(200, 510, 45, 45);
        });
        R.addActionListener(e -> {
            frame.canvas.remove(R);
            repaint();
            Icon icon = new ImageIcon("Img/R_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(260, 510, 45, 45);
        });
        S.addActionListener(e -> {
            frame.canvas.remove(S);
            repaint();
            Icon icon = new ImageIcon("Img/S_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(320, 510, 45, 45);
        });
        T.addActionListener(e -> {
            frame.canvas.remove(T);
            repaint();
            Icon icon = new ImageIcon("Img/T_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(380, 510, 45, 45);
        });
        U.addActionListener(e -> {
            frame.canvas.remove(U);
            repaint();
            Icon icon = new ImageIcon("Img/U_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(440, 510, 45, 45);
        });
        V.addActionListener(e -> {
            frame.canvas.remove(V);
            repaint();
            Icon icon = new ImageIcon("Img/V_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(500, 510, 45, 45);
        });
        W.addActionListener(e -> {
            frame.canvas.remove(W);
            repaint();
            Icon icon = new ImageIcon("Img/W_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(560, 510, 45, 45);
        });
        X.addActionListener(e -> {
            frame.canvas.remove(X);
            repaint();
            Icon icon = new ImageIcon("Img/X_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(620, 510, 45, 45);
        });
        Y.addActionListener(e -> {
            frame.canvas.remove(Y);
            repaint();
            Icon icon = new ImageIcon("Img/Y_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(680, 510, 45, 45);
        });
        Z.addActionListener(e -> {
            frame.canvas.remove(Z);
            repaint();
            Icon icon = new ImageIcon("Img/Z_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(740, 510, 45, 45);
        });
    }

    public void start() {
        frame.configPanel.modifyHelpMessage("You are playing with the other users. Login first: ");
        JButton loginButton = new JButton("Login");
        JLabel labelName = new JLabel("Username: ");
        JTextField username = new JTextField();
        JLabel labelPassword = new JLabel("Password: ");
        JTextField password = new JTextField();
        frame.canvas.setLayout(null);

        labelName.setBounds(250, 150, 150, 40);
        username.setBounds(350, 150, 200, 40);
        labelPassword.setBounds(250, 250, 150, 40);
        password.setBounds(350, 250, 200, 40);
        loginButton.setBounds(250, 350, 300, 40);

        loginButton.addActionListener(e -> {
            if (checkCredentials(username.getText(), password.getText())) {
                frame.canvas.remove(loginButton);
                frame.canvas.remove(labelName);
                frame.canvas.remove(username);
                frame.canvas.remove(labelPassword);
                frame.canvas.remove(password);
                repaint();
                selectGridSize();
            }
        });
        frame.canvas.add(labelName);
        frame.canvas.add(username);
        frame.canvas.add(labelPassword);
        frame.canvas.add(password);
        frame.canvas.add(loginButton);
    }

    public boolean checkCredentials(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return true;
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    public void reinitializeCanvas() {
        init();
        createOffscreenImage();
        repaint();
        paintGrid();
//        getStonesCoordinates();
        // frame.canvas.removeMouseListener(mouse);
    }

    private void paintGrid() {
        offscreen.setColor(Color.BLACK);
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            offscreen.drawLine(x1, y1, x2, y1);
        }

        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int y2 = padY + boardHeight;
            offscreen.drawLine(x1, y1, x1, y2);
        }
    }
}
