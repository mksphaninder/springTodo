package com.phani.learnSpring.firstSpring.todoController;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phani.learnSpring.firstSpring.todoModel.Todo;
import com.phani.learnSpring.firstSpring.todoService.TodoService;

@Controller
public class TodoController {

	
	@Autowired
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	private String getLoggedinUserName() 
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails)
		{
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
	
	@GetMapping("/")
	public String showHomePage(ModelMap model)
	{
		model.put("todos", service.retreiveTodos(getLoggedinUserName()));
		return "list-todos";
	}
	
	@GetMapping("/list-todos")
	public String getTodos(ModelMap model) 
	{
		model.put("todos", service.retreiveTodos(getLoggedinUserName()));
		return "list-todos";
	}
	
	@GetMapping("/add-todo")
	public String getAddTodo(ModelMap model)
	{
		model.put("todo", new Todo(0, getLoggedinUserName(), "", new Date(), false));
		return "todo";
	}
	
	@PostMapping("/add-todo")
	public String putTodo(@Valid Todo todo, BindingResult validatorResult, ModelMap model)
	{
		if(validatorResult.hasErrors())
		{
			return "todo";
		}
		service.addTodo(getLoggedinUserName(), todo.getDesc(), new Date(), false);
		return "redirect:list-todos";
	}
	@GetMapping("/update-todo")
	public String updateTodo(Todo todo, ModelMap model)
	{
		Todo gettodo = service.retreiveTodoById(todo.getId());
		model.put("todo", gettodo);
		return "todo";
	}
	
	@PostMapping("/update-todo")
	public String updateTodo(@Valid Todo todo, BindingResult validatorResult, ModelMap model)
	{
		System.out.println("here");
		if(validatorResult.hasErrors())
		{
			return "todo";
		}
		todo.setUser(getLoggedinUserName());
		service.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	
}
