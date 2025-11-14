import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Cria Tarefas
        Tarefa tarefa1 = new Tarefa("Primeira tarefa", "Descricao da tarefa lorem ipsum dolor sit amet", Prioridade.MEDIA, LocalDateTime.of(2025, 11, 14, 12, 00));
        Tarefa tarefa2 = new Tarefa("Segunda tarefa", "Descricao da segunda tarefa lorem ipsum dolor sit amet", Prioridade.ALTA, LocalDateTime.of(2025, 11, 14, 06, 00));
        Tarefa tarefa3 = new Tarefa("Terceira tarefa", "Descricao da terceira tarefa lorem ipsum dolor sit amet", Prioridade.ALTA, LocalDateTime.of(2025, 11, 14, 10, 30), "PENDENTE");

        // Cria usuario
        Usuario usuario1 = new Usuario("Wiliam", "wiliam.mota@gmail.com", "Senha123");
        usuarios.add(usuario1);

        // Adiciona tarefas
        usuario1.adicionarTarefa(tarefa1);
        usuario1.adicionarTarefa(tarefa2);
        usuario1.adicionarTarefa(tarefa3);

        // Move tarefa
        usuario1.moverTarefa(tarefa1, "PENDENTE");

        // Mostra tarefas
        usuario1.mostrarTarefas();

        ScheduledExecutorService scheduler =  Executors.newScheduledThreadPool(1);

        System.out.println("--------- Buscando notificações pendentes para o dia: " + LocalDate.now().toString() + " ---------");

        scheduler.scheduleAtFixedRate(() -> {
            usuarios.forEach(u -> {
                Set<Notificacao> notificacoes = u.getNotificacoes();
                System.out.println(notificacoes.size() + " notificações encontradas para o usuario: " + u.getNome());

                List<Notificacao> notificacoesDeHoje = notificacoes.stream()
                        .filter( n -> {
                            var dataNotificacao = n.getDataNotificacao().toLocalDate();
                            var dataHoje = LocalDate.now();
                            return dataHoje.equals(dataNotificacao) && n.getStatus() != StatusNotificacao.ENVIADO;
                        })
                        .toList();
                System.out.println(notificacoesDeHoje.size() + " notificações PENDENTES encontradas para o usuario: " + u.getNome());

                notificacoesDeHoje.forEach(Notificacao::enviar);
            });
        }, 0, 1, TimeUnit.DAYS);

    }

}
