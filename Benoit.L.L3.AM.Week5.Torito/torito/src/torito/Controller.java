package torito;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;

public class Controller implements ActionListener{
    Model model;
    View view;

    Controller(Model model , View view){
        this.model = model;
        this.view = view;

        for (int ligne = 0; ligne < 5; ligne++) {
            for (int colonne = 0; colonne < 4; colonne++) {
                View.CaseJeu[ligne][colonne].addActionListener( this);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(((AbstractButton) e.getSource()).getText().equals("")){
            if(Model.getC() == 5){
                for (int ligne = 0; ligne < 5; ligne++) {
                    for (int colonne = 0; colonne < 4; colonne++) {
                        View.CaseJeu[ligne][colonne].setEnabled(false);

//                fenetre.dispatchEvent(new WindowEvent(fenetre, WindowEvent.WINDOW_CLOSING));
                    }
                }
            }

            else if(Model.getC() > 5){
                new View();
            }
            Model.setC(Model.getC()+1);
            ArrayList<String> resultat2 = new ArrayList<String>();
            for (int ligne = 0; ligne < 5; ligne++) {
                for (int colonne = 0; colonne < 4; colonne++) {

                    ArrayList<String> resultat = new ArrayList<String>();
                    resultat.add(View.CaseJeu[ligne][colonne].getText());
                    if (resultat.get(Model.getCompteur()) == "peur" || resultat.get(Model.getCompteur()) == "Melancolie" || resultat.get(Model.getCompteur()) == "mort" || resultat.get(Model.getCompteur()) == "tristesse" || resultat.get(Model.getCompteur()) == "horreur") {
                        resultat2.add(resultat.get(Model.getCompteur()));
                        System.out.println(resultat2.get(Model.getCompteur()));
                        Model.setI(Model.getI()+1);
                    }

                }
            }

            View.reset.setText("tu as " + resultat2.size()+ " / 5");

        }

    }
    }

