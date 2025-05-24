package com.example.board.de.tarefas;

import com.example.board.de.tarefas.services.BoardService;
import com.example.board.de.tarefas.services.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BoardApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BoardApplication.class, args);

		// Criar instância do TaskManager com serviços gerenciados pelo Spring
		BoardService boardService = context.getBean(BoardService.class);
		TaskService taskService = context.getBean(TaskService.class);
		TaskManager taskManager = new TaskManager(boardService, taskService);

		taskManager.run(); // Executar a aplicação interativa no terminal
	}
}
