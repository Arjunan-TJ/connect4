package com.pratilipi.connect4.services;

import org.springframework.stereotype.Component;

@Component
public class Connect4ServiceImpl implements Connect4Service{

	char[][] game = new char[6][7];
	char player = 'Y';
	boolean winner = false;
	
	@Override
	public char[][] newGame() {
		
		for(int i=0;i<game.length;i++) {
			for(int j=0;j<game[i].length;j++) {
				game[i][j] = ' ';
			}
		}
		
		player = 'Y';
		winner = false;
		return game;
		
	}

	@Override
	public String onGame(String str) {
		while(winner == false) {
			if(!str.isEmpty()) {
				String[] strval = str.split("=");
				int column = 0;
				try {
					column = Integer.parseInt(strval[1]);
				}catch(Exception e) {
					return "invalid column";
				}
				if(column >= 0 && column <=6) {
					if (game[0][column] != ' ') {
						return "invalid column";
					}else {
						for (int row = game.length-1; row >= 0; row--){
							if(game[row][column] == ' '){
								game[row][column] = player;
								break;
							}
						}
						
						winner = isWinner();
						
						if (winner){
							if (player=='R'){
								return "Red won";
							}else{
								return "Yellow won";
							}
						}else {
							if (player == 'Y'){
								player = 'R';
							}else{
								player = 'Y';
							}
						}
						break;
					}
				}else {
					return "invalid column";
				}
			}
		}
		return "game";
	}

	private boolean isWinner() {

		//check for 4 across
		for(int row = 0; row<game.length; row++){
			for (int col = 0;col < game[0].length - 3;col++){
				if (game[row][col] == player   && 
					game[row][col+1] == player &&
					game[row][col+2] == player &&
					game[row][col+3] == player){
					return true;
				}
			}			
		}
		//check for 4 up and down
		for(int row = 0; row < game.length - 3; row++){
			for(int col = 0; col < game[0].length; col++){
				if (game[row][col] == player   && 
					game[row+1][col] == player &&
					game[row+2][col] == player &&
					game[row+3][col] == player){
					return true;
				}
			}
		}
		//check upward diagonal
		for(int row = 3; row < game.length; row++){
			for(int col = 0; col < game[0].length - 3; col++){
				if (game[row][col] == player   && 
					game[row-1][col+1] == player &&
					game[row-2][col+2] == player &&
					game[row-3][col+3] == player){
					return true;
				}
			}
		}
		
		//check downward diagonal
		for(int row = 0; row < game.length - 3; row++){
			for(int col = 0; col < game[0].length - 3; col++){
				if (game[row][col] == player   && 
					game[row+1][col+1] == player &&
					game[row+2][col+2] == player &&
					game[row+3][col+3] == player){
					return true;
				}
			}
		}
		return false;
	
	}

	@Override
	public char[][] viewGame() {
		
		return game;
		
	}

	
	
}
