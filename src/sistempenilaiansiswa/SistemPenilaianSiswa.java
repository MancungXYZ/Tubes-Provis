/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistempenilaiansiswa;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Component;

/**
 *
 * @author Reihan & Adhira
 */
public class SistemPenilaianSiswa {

    /**
     * @param args the command line arguments
     */
    private static class JTatto extends Component {
            public JTatto () {
                
            }
        }
    
    public static void main(String[] args) {
        // TODO code application logic here
        frm_utama utama = new frm_utama();
        utama.setVisible(true);
        
        
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new JTatto());
        }catch (Exception e) {
            
        }
    }
    
}
