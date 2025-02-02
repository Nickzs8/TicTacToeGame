import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Logica {
	public int turnoJogador = 0;
	JFrame frame;
	
	Logica(JFrame frame){
		this.frame = frame;
	}
	
	public void passaTurno(GameTile gameLogica) {
		
		if(gameLogica.preview) return;
		
		checkVictory(gameLogica.jogo, gameLogica, gameLogica.x, gameLogica.y);
		
		if(turnoJogador == 0) {
			turnoJogador++;
		} else {
			turnoJogador--;
		}
	}
	
	public void checkVictory(GameTile[][] jogo, GameTile tile, int x, int y) {
		ArrayList<GameTile> tileList = new ArrayList<GameTile>();

		int xMatrix;
        int yMatrix;
		int adjacency = 1;
		
		for (int i = -1; i <= 1; i++) {
	        xMatrix = (x + i + jogo[0].length) % jogo[0].length;
	        
	        if (jogo[y][xMatrix] == tile) {
	        	tileList.add(jogo[y][xMatrix]);
	        	continue;
	        }
	        
	        if (jogo[y][xMatrix].formaMarcada == tile.formaMarcada) adjacency++;
	        tileList.add(jogo[y][xMatrix]);
	    }
	
		if(checkAdjacency(adjacency, tileList, 0)) return;;
		
		tileList.clear();
		adjacency = 1;
		
		for (int i = -1; i <= 1; i++) {
	        yMatrix = (y + i + jogo.length) % jogo.length;
	        
	        if (jogo[yMatrix][x] == tile) {
	        	tileList.add(jogo[yMatrix][x]);
	        	continue;
	        }
	        
	        if (jogo[yMatrix][x].formaMarcada == tile.formaMarcada) adjacency++;
	        tileList.add(jogo[yMatrix][x]);
	    }
		
		if(checkAdjacency(adjacency, tileList, 1)) return;;
		
		tileList.clear();
		adjacency = 1;
		
		for (int i = -1; i <= 1; i++) {
			xMatrix = (x + i + jogo[0].length) % jogo[0].length;
			yMatrix = (y + i + jogo.length) % jogo.length;
			
	        if (jogo[yMatrix][xMatrix] == tile) {
	        	tileList.add(jogo[yMatrix][xMatrix]);
	        	continue;
	        }
	        
	        if (jogo[yMatrix][xMatrix].formaMarcada == tile.formaMarcada) adjacency++;
	        tileList.add(jogo[yMatrix][xMatrix]);
	    }
		
		if(checkAdjacency(adjacency, tileList, 2)) return;;
		
		tileList.clear();
		adjacency = 1;
		
		for (int i = -1; i <= 1; i++) {
	        xMatrix = (x - i + jogo[0].length) % jogo[0].length;
	        yMatrix = (y + i + jogo.length) % jogo.length;
	        
	        if (jogo[yMatrix][xMatrix] == tile) {
	        	tileList.add(jogo[yMatrix][xMatrix]);
	        	continue;
	        }
	        
	        if (jogo[yMatrix][xMatrix].formaMarcada == tile.formaMarcada) adjacency++;
	        tileList.add(jogo[yMatrix][xMatrix]);
	    }
		
		if(checkAdjacency(adjacency, tileList, 3)) return;;
		tileList.clear();
	}

	public boolean checkAdjacency(int adjacency, ArrayList<GameTile> tileList, int typeOfWin) {
		if(adjacency == 3) {
			showVictory(tileList, typeOfWin);
			return true;
		}
		return false;
	}

	private void showVictory(ArrayList<GameTile> tileList, int typeOfWin) {
		if(turnoJogador == 1) {
			System.out.println("O jogador dois venceu.");
		} else {
			System.out.println("O jogador um venceu.");
		}
		frame.removeAll();
	}
}

