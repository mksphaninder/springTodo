package com.phani.learnSpring.firstSpring.todoController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phani.learnSpring.firstSpring.todoService.TodoService;

@Controller
public class TodoController {

	
	@Autowired
	TodoService service;
	
	@GetMapping("/list-todos")
	public String getTodos(ModelMap model) {
		
		model.put("todos", service.retreiveTodos("Krishna"));
		return "list-todos";
	}
	
	@GetMapping("/add-todo")
	public String getAddTodo()
	{
		return "todo";
	}
	
	@PostMapping("/add-todo")
	public String putTodo(@RequestParam String desc, ModelMap model)
	{
		service.addTodo("Krishna", desc, new Date(), false);
		return "redirect:list-todos";
	}
	
	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	
}
