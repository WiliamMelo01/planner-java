import java.time.Instant;
import java.util.*;

public class Usuario {

    private String idUsuario;
    private String nome;
    private String email;
    private String senha;
    private Instant dataCriacao;

    private Set<Tarefa> tarefas = new HashSet<>();
    private Set<Notificacao> notificacoes = new HashSet<>();

    public Usuario(String nome, String email, String senha) {
        this.idUsuario = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = Instant.now();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
        Notificacao notificacao = new Notificacao(this.idUsuario, tarefa.getIdTarefa(), tarefa.getDataLimite().minusHours(24));
        this.notificacoes.add(notificacao);
    }

    public void removerTarefa(Tarefa tarefa){
        this.tarefas.remove(tarefa);
        this.notificacoes.removeIf( notificacao -> notificacao.getIdTarefa() == tarefa.getIdTarefa());
    }

    public void moverTarefa(Tarefa tarefa, String coluna){
        this.tarefas.remove(tarefa);
        tarefa.setStatus(coluna.toUpperCase());
        this.tarefas.add(tarefa);
    }

    public void mostrarTarefas() {
        Map<String, ArrayList<Tarefa>> colunas = new TreeMap<>();
        for(Tarefa tarefa : tarefas){
            if(colunas.keySet().contains(tarefa.getStatus())){
                colunas.get(tarefa.getStatus()).add(tarefa);
                continue;
            }
            ArrayList<Tarefa> lista = new ArrayList<>();
            lista.add(tarefa);
            colunas.put(tarefa.getStatus(), lista);
        }

        colunas.forEach((titulo, tarefas) -> {
            System.out.println();
            System.out.println("----- " + titulo + "-----");
            tarefas.forEach(tarefa -> {
                System.out.println("[ID: " + tarefa.getIdTarefa() + "] " + tarefa.getTitulo());
                System.out.println(" - Descrição : " + tarefa.getDescricao());
                System.out.println(" - Prioridade: " + tarefa.getPrioridade());
                System.out.println(" - Status    : " + tarefa.getStatus());
                System.out.println(" - Limite    : " + tarefa.getDataLimite().toString());
                System.out.println(" - Criado em : " + tarefa.getDataCriacao().toString());
                System.out.println();
            });
        });

    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    public Set<Notificacao> getNotificacoes() {
        return notificacoes;
    }

}
