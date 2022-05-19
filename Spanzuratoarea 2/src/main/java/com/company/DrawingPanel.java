package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private final int canvasWidth = 800, canvasHeight = 600;
    private BufferedImage image;
    private Graphics2D offscreen;
    private int incercari = 7;
    private int lungime;
    private int gresite = 0;
    private int ghicite = 0;

    public String comunicare(String tabel) {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String request = tabel;
            out.println(request);
            String response = in.readLine();
            System.out.println(response);
            return response;
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Tabelul nu exista";
    }

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
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint();
            }
        });
    }


    public void startGame() throws IOException {

        frame.configPanel.modifyHelpMessage("Alege categoria din care o sa primeste un cuvant");
        JLabel label = new JLabel("<html><h3>   Categoriile disponibile sunt: Animale, Plante, Geografie, Istorie, Literatura si Medicina</h3></html>");
        JButton nextButton = new JButton("Start joc");
        JLabel labelCategorie = new JLabel("Categorie: ");
        JTextField categorie = new JTextField();
        frame.canvas.setLayout(null);

        frame.canvas.add(label);
        frame.canvas.add(labelCategorie);
        frame.canvas.add(categorie);
        frame.canvas.add(nextButton);


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
        String word = comunicare(table);
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
        lungime = word.length();


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
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);//
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>A</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });


        B.addActionListener(e -> {
            frame.canvas.remove(B);
            repaint();
            Icon icon = new ImageIcon("Img/B_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(110, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("b", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>B</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        C.addActionListener(e -> {
            frame.canvas.remove(C);
            repaint();
            Icon icon = new ImageIcon("Img/C_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(170, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("c", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>C</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        D.addActionListener(e -> {
            frame.canvas.remove(D);
            repaint();
            Icon icon = new ImageIcon("Img/D_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(230, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("d", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>D</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        E.addActionListener(e -> {
            frame.canvas.remove(E);
            repaint();
            Icon icon = new ImageIcon("Img/E_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(290, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("e", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>E</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        F.addActionListener(e -> {
            frame.canvas.remove(F);
            repaint();
            Icon icon = new ImageIcon("Img/F_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(350, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("f", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>F</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        G.addActionListener(e -> {
            frame.canvas.remove(G);
            repaint();
            Icon icon = new ImageIcon("Img/G_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(410, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("g", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>G</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        H.addActionListener(e -> {
            frame.canvas.remove(H);
            repaint();
            Icon icon = new ImageIcon("Img/H_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(470, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("h", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();

                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>H</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        I.addActionListener(e -> {
            frame.canvas.remove(I);
            repaint();
            Icon icon = new ImageIcon("Img/I_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(530, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("i", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>I</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        J.addActionListener(e -> {
            frame.canvas.remove(J);
            repaint();
            Icon icon = new ImageIcon("Img/J_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(590, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("j", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>J</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        K.addActionListener(e -> {
            frame.canvas.remove(K);
            repaint();
            Icon icon = new ImageIcon("Img/K_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(650, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("k", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>K</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        L.addActionListener(e -> {
            frame.canvas.remove(L);
            repaint();
            Icon icon = new ImageIcon("Img/L_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(710, 450, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("l", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>L</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        M.addActionListener(e -> {
            frame.canvas.remove(M);
            repaint();
            Icon icon = new ImageIcon("Img/M_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(20, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("m", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>M</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        N.addActionListener(e -> {
            frame.canvas.remove(N);
            repaint();
            Icon icon = new ImageIcon("Img/N_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(80, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("n", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>N</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        O.addActionListener(e -> {
            frame.canvas.remove(O);
            repaint();
            Icon icon = new ImageIcon("Img/O_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(140, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("o", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>O</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        P.addActionListener(e -> {
            frame.canvas.remove(P);
            repaint();
            Icon icon = new ImageIcon("Img/P_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(200, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("p", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>P</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        R.addActionListener(e -> {
            frame.canvas.remove(R);
            repaint();
            Icon icon = new ImageIcon("Img/R_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(260, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("r", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>R</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        S.addActionListener(e -> {
            frame.canvas.remove(S);
            repaint();
            Icon icon = new ImageIcon("Img/S_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(320, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("s", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>S</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        T.addActionListener(e -> {
            frame.canvas.remove(T);
            repaint();
            Icon icon = new ImageIcon("Img/T_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(380, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("t", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>T</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        U.addActionListener(e -> {
            frame.canvas.remove(U);
            repaint();
            Icon icon = new ImageIcon("Img/U_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(440, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("u", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>U</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        V.addActionListener(e -> {
            frame.canvas.remove(V);
            repaint();
            Icon icon = new ImageIcon("Img/V_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(500, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("v", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>V</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        W.addActionListener(e -> {
            frame.canvas.remove(W);
            repaint();
            Icon icon = new ImageIcon("Img/W_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(560, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("w", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>W</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        X.addActionListener(e -> {
            frame.canvas.remove(X);
            repaint();
            Icon icon = new ImageIcon("Img/X_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(620, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("x", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>X</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        Y.addActionListener(e -> {
            frame.canvas.remove(Y);
            repaint();
            Icon icon = new ImageIcon("Img/Y_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(680, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("y", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>Y</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
        Z.addActionListener(e -> {
            frame.canvas.remove(Z);
            repaint();
            Icon icon = new ImageIcon("Img/Z_press.png");
            JButton pressed = new JButton(icon);
            frame.canvas.add(pressed);
            pressed.setBounds(740, 510, 45, 45);
            Game g = new Game();
            List<Integer> lista = g.cautareLitera("z", word);
            if (lista.size() == 0) {
                gresite++;
                switch (gresite) {
                    case 1:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/2.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/3.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/4.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/5.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 5:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/6.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 6:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/7.png"))));
                            repaint();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    case 7:
                        try {
                            picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/final.png"))));
                            repaint();
                            frame.canvas.removeAll();
                            aiPierdut(word);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    default:
                        // code block
                }
                incercari--;
                labelIncercari.setText("Numarul de incercari ramase: " + incercari);
            } else {
                for (int i = 0; i < lungime; i++) {
                    if (lista.contains(i)) {
                        listaLabel.get(i).setText("<html><h1>Z</h1></html>");
                        ghicite++;
                    }
                }

            }
            System.out.println(lista);
            if (ghicite == lungime) {
                try {
                    picLabel.setIcon(new ImageIcon(ImageIO.read(new File("Img/win.png"))));
                    frame.canvas.removeAll();
                    aiCastigat(word);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                repaint();
            }
        });
    }

    public void aiCastigat(String cuvant) throws IOException {
        frame.configPanel.modifyHelpMessage("Felicitari!");
        BufferedImage myPicture = ImageIO.read(new File("Img/win2.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JLabel label2 = new JLabel("<html><h1>Ai ghicit!</h1></html>");
        JLabel label = new JLabel("<html><h1>Cuvantul introdus: ");
        JButton newGame = new JButton("Joaca din nou!");
        JButton exit = new JButton("Exit");
        label.setText(label.getText() + cuvant);
        frame.canvas.setLayout(null);

        frame.canvas.add(picLabel);
        frame.canvas.add(label);
        frame.canvas.add(label2);
        frame.canvas.add(newGame);
        frame.canvas.add(exit);
        picLabel.setBounds(70, 5, 200, 500);
        label2.setBounds(450, 100, 500, 100);
        label.setBounds(350, 150, 500, 100);
        newGame.setBounds(350, 300, 300, 40);
        exit.setBounds(350, 350, 300, 40);

        newGame.addActionListener(e -> {
            try {
                frame.canvas.removeAll();
                repaint();
                incercari = 7;
                gresite = 0;
                ghicite = 0;
                startGame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        exit.addActionListener(e -> frame.dispose());

    }

    public void aiPierdut(String cuvant) throws IOException {
        frame.configPanel.modifyHelpMessage("Ai pierdut!");
        BufferedImage myPicture = ImageIO.read(new File("Img/final.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JLabel label2 = new JLabel("<html><h1>Ai pierdut!</h1></html>");
        JLabel label = new JLabel("<html><h1>Cuvantul introdus: ");
        JButton newGame = new JButton("Incearca din nou!");
        JButton exit = new JButton("Exit");
        label.setText(label.getText() + cuvant);
        frame.canvas.setLayout(null);

        frame.canvas.add(picLabel);
        frame.canvas.add(label);
        frame.canvas.add(label2);
        frame.canvas.add(newGame);
        frame.canvas.add(exit);
        picLabel.setBounds(3, 5, 200, 500);
        label2.setBounds(450, 100, 500, 100);
        label.setBounds(350, 150, 500, 100);
        newGame.setBounds(350, 300, 300, 40);
        exit.setBounds(350, 350, 300, 40);


        newGame.addActionListener(e -> {
            try {
                frame.canvas.removeAll();
                repaint();
                incercari = 7;
                gresite = 0;
                ghicite = 0;
                startGame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        exit.addActionListener(e -> frame.dispose());

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
    }

}
