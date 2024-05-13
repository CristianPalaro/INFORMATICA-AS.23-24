import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ExternalListener implements ActionListener{
    private GraphicCounter counter;
    private JLabel lblCont;
    private JTextField txtCont;
    private JCheckBox cbInc;
    private JCheckBox cbDec;
    private JButton btnGo;

    public ExternalListener(GraphicCounter counter, JLabel lblCont, JTextField txtCont, JCheckBox cbInc,
            JCheckBox cbDec, JButton btnGo) {
        this.counter = counter;
        this.lblCont = lblCont;
        this.txtCont = txtCont;
        this.cbInc = cbInc;
        this.cbDec = cbDec;
        this.btnGo = btnGo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(cbInc.isSelected()){
            counter.increase();
        }
        if(cbDec.isSelected()){
            counter.decrease();
        }
        if((cbInc.isSelected())&&(cbDec.isSelected())){
            counter.reset();
        }

        lblCont.setText(counter.toString());
        txtCont.setText(counter.toString());;
    }

    

    
}
