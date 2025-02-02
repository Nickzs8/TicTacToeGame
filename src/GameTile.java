import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GameTile extends JPanel implements MouseListener{
	int formaMarcada, x, y;
	boolean preview = true, marcado = false, iniciar = true;
	Logica logica;
	GameTile[][] jogo;
	
	GameTile(Logica logica, GameTile[][] jogo, int i, int j){
		this.addMouseListener(this);
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(100,100));
		this.setLayout(new BorderLayout());
		this.logica = logica;
		this.jogo = jogo;
		this.x = j;
		this.y = i;
		
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		if(marcado || iniciar){
			return;
		}
			
		Graphics2D grafico2D = (Graphics2D) g;
		grafico2D.setStroke(new BasicStroke(4));
		
		if(!preview){
			grafico2D.setPaint(Color.black);
			marcado = true;
		} else {
			grafico2D.setPaint(Color.darkGray);
		}
		
		int coordenadaX = (getWidth() - 100)/2;
		int coordenadaY = (getHeight() - 100)/2;
		
		if(logica.turnoJogador == 0) {
			grafico2D.drawLine(30, 30, 120, 120);
			grafico2D.drawLine(120, 30, 30, 120);
			logica.passaTurno(this);
		} else {
			grafico2D.drawOval(coordenadaX, coordenadaY, 100, 100);
			logica.passaTurno(this);
		}
		
	}
	
	
			
	@Override
	public void mouseClicked(MouseEvent e) {
		if(marcado == true) return;
		
		preview = false;
		
		this.setBackground(Color.WHITE);
		repaint();
		
		if(logica.turnoJogador == 0) {
			formaMarcada = 1;
		} else {
			formaMarcada = 2;
		}
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
		if(marcado) {
			return;
		}
		this.setBackground(Color.LIGHT_GRAY);
		iniciar = false;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (marcado) return;
		
		this.setBackground(Color.white);
		iniciar = true;
		
		repaint();
	}
}

