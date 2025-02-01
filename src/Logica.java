
public class Logica {
	public int turnoJogador = 0;
	
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
		int xMatrix;
        int yMatrix;
		int adjacency = 1;
		
		for (int i = -1; i <= 1; i++) {
	        xMatrix = (x + i + jogo[0].length) % jogo[0].length;
	        if (jogo[y][xMatrix] == tile) continue;
	        if (jogo[y][xMatrix].formaMarcada == tile.formaMarcada) adjacency++;
	    }
	
		if(checkAdjacency(adjacency)) return;;
		
		adjacency = 1;
		
		for (int i = -1; i <= 1; i++) {
	        yMatrix = (y + i + jogo.length) % jogo.length;
	        if (jogo[yMatrix][x] == tile) continue;
	        if (jogo[yMatrix][x].formaMarcada == tile.formaMarcada) {
	           adjacency++;
	        }
	    }
		
		if(checkAdjacency(adjacency)) return;;
		
		adjacency = 1;
		
		for (int i = -1; i <= 1; i++) {
			xMatrix = (x + i + jogo[0].length) % jogo[0].length;
			yMatrix = (y + i + jogo.length) % jogo.length;
			
	        if (jogo[yMatrix][xMatrix] == tile) continue;
	        if (jogo[yMatrix][xMatrix].formaMarcada == tile.formaMarcada) {
	            adjacency++;
	        }
	    }
		
		if(checkAdjacency(adjacency)) return;;
		
		adjacency = 1;
		
		for (int i = -1; i <= 1; i++) {
	        xMatrix = (x - i + jogo[0].length) % jogo[0].length;
	        yMatrix = (y + i + jogo.length) % jogo.length;
	        if (jogo[yMatrix][xMatrix] == tile) continue;
	        if (jogo[yMatrix][xMatrix].formaMarcada == tile.formaMarcada) {
	            adjacency++;
	        }
	    }
		
		if(checkAdjacency(adjacency)) return;;
	}

	public boolean checkAdjacency(int adjacency) {
		if(adjacency == 3) {
			showVictory();
			return true;
		}
		return false;
	}

	private void showVictory() {
		if(turnoJogador == 1) {
			System.out.println("O jogador dois venceu.");
		} else {
			System.out.println("O jogador um venceu.");
		}
	}
}

