import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicial implements MouseListener {
    JFrame frame;
    JLabel inicio;
    JPanel panel;
    
    TelaInicial() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Jogo da Velha");
        frame.setLocationRelativeTo(null);
        
        inicio = new JLabel("Iniciar");
        inicio.setForeground(Color.black);
        inicio.setFont(new Font("Times new Roman", Font.PLAIN, 40));
        inicio.addMouseListener(this);
        
        Dimension labelDimension = inicio.getPreferredSize();        
        
        inicio.setBounds(250-(labelDimension.width/2), 250-(labelDimension.height), labelDimension.width, labelDimension.height);	
        
        frame.add(inicio); 
        frame.setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	 frame.getContentPane().removeAll();
    	 frame.revalidate();
         frame.repaint();
         new JogoDaVelha(frame,3,3);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        inicio.setForeground(Color.LIGHT_GRAY);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        inicio.setForeground(Color.black);
    }
}
