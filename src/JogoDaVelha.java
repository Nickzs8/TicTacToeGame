import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JogoDaVelha{
	int numeroLinhas, numeroColunas;
	
	JogoDaVelha(JFrame frame, int numeroLinhas, int numeroColunas){
		this.numeroLinhas = numeroLinhas;
		this.numeroColunas = numeroColunas;
		
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(new GridLayout(3,3,10,10));
		final Logica logicaOriginal = new Logica();
		GameTile[][] jogo = new GameTile[numeroLinhas][numeroColunas];
		
		for (int i = 0; i<3;i++) {
			for(int j = 0; j<3;j++) {
				jogo[i][j] = new GameTile(logicaOriginal, jogo, i, j);
			
				frame.add(jogo[i][j]);		
				frame.revalidate();
	        	frame.repaint();	
				}
			}
	}
}
