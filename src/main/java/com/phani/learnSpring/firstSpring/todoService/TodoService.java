package com.phani.learnSpring.firstSpring.todoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.phani.learnSpring.firstSpring.todoModel.Todo;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 4;
	
	static {
		todos.add(new Todo(1, "krishna", "Learn Spring", new Date(), false));
		todos.add(new Todo(2, "krishna", "Learn Java", new Date(), false));
		todos.add(new Todo(3, "krishna", "Learn Docker", new Date(), false));
		todos.add(new Todo(4, "krishna", "Learn AWS", new Date(), false));
	}
	
	public List<Todo> retreiveTodos(String user) {
		List<Todo> filteredTodo = new ArrayList<Todo>();
		for(Todo todo : todos)
		{
			if(todo.getUser().equals(user)) 
			{
				filteredTodo.add(todo);
			}
		}
		return filteredTodo;
	}
	
	public void addTodo(String user, String desc, Date date, boolean isDone)
	{
		todos.add(new Todo(todoCount + 1, user, desc, date, isDone));
	}
	
	public void deleteTodo(int id) 
	{
		for(Todo t : todos)
		{
			if(t.getId() == id)
			{
				todos.remove(t);
				return;
			}
		}
	}
	
	public Todo retreiveTodoById(int id) 
	{
		for(Todo todo : todos)
		{
			if(todo.getId() ==id) 
			{
				return todo;
			}
		}
		return null;
	}
	
	public void updateTodo(Todo todo) 
	{
		for(Todo t : todos)
		{
			if(t.getId() == todo.getId())
			{
				t.setDesc(todo.getDesc());
				t.setDate(todo.getDate());
			}
		}
	}
		
}
