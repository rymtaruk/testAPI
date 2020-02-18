package id.maybank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.maybank.model.TodoList;
import id.maybank.repository.TodoRepository;

@Service("todoService")
public class TodoService {
	private TodoRepository todoRepository;

	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	/* Profile */
	
	public List<TodoList> findAllList(){
		return todoRepository.findAll();
	}
	
	public TodoList findListById(int TodoList) {
		return todoRepository.findTodoListById(TodoList);
	}
	
	public TodoList saveList(TodoList todoList) {
		return todoRepository.save(todoList);
	}
	

}
