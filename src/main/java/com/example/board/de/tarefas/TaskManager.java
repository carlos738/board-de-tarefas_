package com.example.board.de.tarefas;
import com.example.board.de.tarefas.entity.Board;
import com.example.board.de.tarefas.entity.Task;
import com.example.board.de.tarefas.enums.Status;
import com.example.board.de.tarefas.services.BoardService;
import com.example.board.de.tarefas.services.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TaskManager {
    private final Scanner scanner = new Scanner(System.in);
    private final BoardService boardService;
    private final TaskService taskService;

    public TaskManager(BoardService boardService, TaskService taskService) {
        this.boardService = boardService;
        this.taskService = taskService;
    }

    public void run() {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar um board");
            System.out.println("2. Selecionar board");
            System.out.println("3. Excluir board");
            System.out.println("4. Criar task");
            System.out.println("5. Excluir task");
            System.out.println("6. Selecionar task");
            System.out.println("7. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Limpar buffer

            switch (choice) {
                case 1:
                    criarBoard();
                    break;
                case 2:
                    selecionarBoard();
                    break;
                case 3:
                    excluirBoard();
                    break;
                case 4:
                    criarTask();
                    break;
                case 5:
                    excluirTask();
                    break;
                case 6:
                    selecionarTask();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void criarBoard() {
        System.out.print("Digite o nome do board: ");
        String name = scanner.nextLine();
        Board board = boardService.createBoard(name);
        System.out.println("Board criado com ID: " + board.getId());
    }

    private void selecionarBoard() {
        List<Board> boards = boardService.getAllBoards();
        if (boards.isEmpty()) {
            System.out.println("Nenhum board encontrado.");
            return;
        }

        System.out.println("Boards disponíveis:");
        boards.forEach(board -> System.out.println(board.getId() + " - " + board.getName()));

        System.out.print("Digite o ID do board: ");
        Long boardId = scanner.nextLong();
        scanner.nextLine();

        Optional<Board> selectedBoard = boards.stream().filter(b -> b.getId().equals(boardId)).findFirst();
        if (selectedBoard.isPresent()) {
            System.out.println("Board selecionado: " + selectedBoard.get().getName());
        } else {
            System.out.println("Board não encontrado!");
        }
    }

    private void excluirBoard() {
        System.out.print("Digite o ID do board a excluir: ");
        Long boardId = scanner.nextLong();
        scanner.nextLine();

        boardService.deleteBoard(boardId);
        System.out.println("Board excluído com sucesso.");
    }

    private void criarTask() {
        System.out.print("Digite o nome da task: ");
        String name = scanner.nextLine();

        System.out.println("Escolha um status:");
        for (Status status : Status.values()) {
            System.out.println(status.ordinal() + " - " + status);
        }
        int statusIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o ID do board para a task: ");
        Long boardId = scanner.nextLong();
        scanner.nextLine();

        Task task = taskService.createTask(name, Status.values()[statusIndex], boardId);
        System.out.println("Task criada com ID: " + task.getId());
    }

    private void excluirTask() {
        System.out.print("Digite o ID da task a excluir: ");
        Long taskId = scanner.nextLong();
        scanner.nextLine();

        taskService.deleteTask(taskId);
        System.out.println("Task excluída com sucesso.");
    }

    private void selecionarTask() {
        System.out.print("Digite o ID do board para visualizar as tasks: ");
        Long boardId = scanner.nextLong();
        scanner.nextLine();

        List<Task> tasks = taskService.getTasksByBoard(boardId);
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma task encontrada.");
            return;
        }

        System.out.println("Tasks disponíveis:");
        tasks.forEach(task -> System.out.println(task.getId() + " - " + task.getName() + " [" + task.getStatus() + "]"));
    }
}
