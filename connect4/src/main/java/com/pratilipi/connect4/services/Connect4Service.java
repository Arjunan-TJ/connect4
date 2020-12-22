package com.pratilipi.connect4.services;

import org.springframework.stereotype.Service;

@Service
public interface Connect4Service {

	char[][] newGame();

	String onGame(String column);

	char[][] viewGame();

}
