import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Status {
    PENDENTE,
    EM_ANDAMENTO,
    CONCLUIDA
}

class Tarefa {
    private int id;
    private String titulo;
    private Status status;

    public Tarefa(int id, String titulo, Status status) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{id=" + id + ", titulo='" + titulo + "', status=" + status + "}";
    }
}

public class GerenciadorTarefas {
    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    public void adicionar(String titulo) {
        Tarefa tarefa = new Tarefa(proximoId++, titulo, Status.PENDENTE);
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada: " + tarefa);
    }

    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        tarefas.forEach(System.out::println);
    }

    public void filtrarPorStatus(Status status) {
        List<Tarefa> filtradas = tarefas.stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());

        if (filtradas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }

        filtradas.forEach(System.out::println);
    }

    public void atualizarStatus(int id, Status novoStatus) {
        Tarefa tarefaEncontrada = tarefas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tarefa com id " + id + " não encontrada."));

        tarefaEncontrada.setStatus(novoStatus);
    }

    public static void main(String[] args) {
        GerenciadorTarefas gm = new GerenciadorTarefas();
        gm.adicionar("Estudar Java");
        gm.adicionar("Fazer exercícios");
        gm.adicionar("Revisar código");
        
        gm.atualizarStatus(1, Status.CONCLUIDA);
        gm.atualizarStatus(2, Status.EM_ANDAMENTO);
        
        System.out.println("\n--- Todas as tarefas ---");
        gm.listar();
        
        System.out.println("\n--- Tarefas pendentes ---");
        gm.filtrarPorStatus(Status.PENDENTE);
    }
}
