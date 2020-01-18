package com.phani.learnSpring.firstSpring.todoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phani.learnSpring.firstSpring.todoService.TodoService;

@Controller
public class TodoController {

	
	@Autowired
	TodoService service;
	
	
}
