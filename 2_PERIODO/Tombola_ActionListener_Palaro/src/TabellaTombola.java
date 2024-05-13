import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;


public class TabellaTombola extends JFrame {

    private ArrayList<Casella> tabellone;
    private JButton btnRipristina;

    public TabellaTombola() {
        super("Tabella Tombola");
        setSize(550, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponenti();
        initPannelli();
        initAscoltatori();

        setVisible(true);
        setResizable(false);
    }

    private void initComponenti(){
        tabellone = new ArrayList<>();
        for(int i=0;i<90;i++)
            tabellone.add(new Casella(i+1));
        btnRipristina = new JButton("RIPRISTINA");
      
    }
        
    private void initPannelli(){
        JPanel pnlTabellone = new JPanel(new GridLayout(9,10,5,5) );
        pnlTabellone.setBackground(Color.YELLOW);
        for(int i=0;i<90;i++)
            pnlTabellone.add(tabellone.get(i));
        
        JPanel pnlSud = new JPanel();
        pnlSud.add(btnRipristina);
        this.getContentPane().add(pnlTabellone,BorderLayout.CENTER);
        this.getContentPane().add(pnlSud,BorderLayout.SOUTH);
        
    }

    private void initAscoltatori(){

        ListenMouse mouseListener = new ListenMouse();
        //AscoltaBottoni_2 ascoltatore = new AscoltaBottoni_2();
        
        for(int i=0;i<90;i++){
            // tabellone[i].addActionListener(new AscoltBottoni_1(i));
            tabellone.get(i).addMouseListener(mouseListener);
        }


        
        btnRipristina.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                  for (Casella c:tabellone)
                                                      if (c.isEstratta())
                                                        c.reset();
                                            }
                                        });
        
        
        
    }

    // private class AscoltaBottoni_2 implements ActionListener {

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         ((Casella) e.getSource()).depenna();
    //         System.out.println("Su ascoltatore 2");

    //     }
    // }

    private class ListenMouse extends MouseAdapter{

        public void mouseClicked(MouseEvent e){

            ((Casella) e.getSource()).depenna();
            System.out.println("Mouse Clicked");
            
        }
    }

    
    

} /* FINE classe TabellaTombola */