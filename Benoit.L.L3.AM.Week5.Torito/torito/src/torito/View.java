package torito;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {


    JFrame fenetre;
    public static JButton[][] CaseJeu;
    public static JButton reset;

    View() {


        fenetre = new JFrame("el_torito");
        CaseJeu = new JButton[5][4];
        reset = new JButton("tu as 0 / 5");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(new Dimension(400, 550));
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        JPanel jeuPanel = new JPanel(new FlowLayout());
        JPanel Grille_du_jeu = new JPanel(new GridLayout(5, 4));

        jeuPanel.add(Grille_du_jeu, BorderLayout.CENTER);
        jeuPanel.setBackground(Color.black);
        JPanel menu = new JPanel(new FlowLayout());
        menu.add(reset);
        menu.setBackground(Color.black);
        fenetre.add(jeuPanel, BorderLayout.NORTH);
        fenetre.add(menu, BorderLayout.CENTER);

        for (int ligne = 0; ligne < 5; ligne++) {
            for (int colonne = 0; colonne < 4; colonne++) {
                String[] arr = {"mort", "Melancolie", "horreur", "tristesse", "peur", "desole", "desole", "desole", "desole", "desole", "desole"};
                Random random = new Random();
                int select = random.nextInt(arr.length);

                CaseJeu[ligne][colonne] = new JButton("");
                CaseJeu[ligne][colonne].setPreferredSize(new Dimension(90, 90));
                int finalLigne = ligne;
                int finalColonne = colonne;
                CaseJeu[ligne][colonne].addActionListener(e -> CaseJeu[finalLigne][finalColonne].setText(arr[select]));
                CaseJeu[ligne][colonne].getText();
                Grille_du_jeu.add(CaseJeu[ligne][colonne]);
            }
        }
        fenetre.setVisible(true);
    }
}

