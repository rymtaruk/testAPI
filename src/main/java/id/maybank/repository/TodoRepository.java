package id.maybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.maybank.model.TodoList;

@Repository("todoRepository")
public interface TodoRepository extends JpaRepository<TodoList,Integer> {
	TodoList findTodoListById(int id);
}
