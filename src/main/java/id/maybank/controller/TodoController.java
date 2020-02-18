package id.maybank.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.maybank.model.TodoList;
import id.maybank.service.TodoService;

@RestController
public class TodoController {
	@Autowired
	private TodoService todoServices;

	@GetMapping("/mvvm/list")
	Iterable<TodoList> getList() {
        return todoServices.findAllList();
    }
	
	@PostMapping("/mvvm/todo/add")
	TodoList addList(@RequestBody TodoList todoList){
		return todoServices.saveList(todoList);
	}
	
	@PutMapping("/mvvm/todo/edit")
	TodoList editList(@RequestBody TodoList todoList){
		return todoServices.saveList(todoList);
	}
	
	@GetMapping(value = "/mvvm/todo")
	public ResponseEntity<Map<String, Object>> getListById(@RequestParam int id) throws IOException {
		Map<String,Object> response = new HashMap<>();
		TodoList data = todoServices.findListById(id);
		if(data != null) {
			response.put("data", data);
			response.put("Status", "Success");
		}else {
			response.put("Status", "Error");
			response.put("data", "NULL");
		}
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

}
