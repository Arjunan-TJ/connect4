package com.pratilipi.connect4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pratilipi.connect4.services.Connect4Service;

@Controller
public class Connect4Controller {

	@Autowired
	private Connect4Service connect4Service;
	
	@RequestMapping("/")
	public String viewHome() {
		return "home";
	}
	
	@RequestMapping("/newGame")
	public @ResponseBody char[][] newGame(){
		return connect4Service.newGame();
	}
	
	@PostMapping("/onGame")
	public @ResponseBody String onGame(@RequestBody String column) {
		return connect4Service.onGame(column);
	}
	
	@GetMapping("/viewGame")
	public @ResponseBody char[][] viewGame(){
		return connect4Service.viewGame();
	}
	
}
