import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Tarefa {

    private int idTarefa;
    private String titulo;
    private String descricao;
    private LocalDateTime dataLimite;
    private Prioridade prioridade;
    private String status;
    private Instant dataCriacao;

    public Tarefa(String titulo, String descricao, Prioridade prioridade, LocalDateTime dataLimite) {
        this.idTarefa = new Random().hashCode();
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = "A FAZER";
        this.dataLimite = dataLimite;
        this.dataCriacao = Instant.now();
    }

    public Tarefa(String titulo, String descricao, Prioridade prioridade, LocalDateTime dataLimite, String status) {
        this.idTarefa = new Random().hashCode();
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataLimite = dataLimite;
        this.dataCriacao = Instant.now();
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "idTarefa:" + idTarefa +
                ", titulo:'" + titulo + '\'' +
                ", descricao:'" + descricao + '\'' +
                ", dataLimite:" + dataLimite +
                ", prioridade:" + prioridade +
                ", status:'" + status + '\'' +
                ", dataCriacao:" + dataCriacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return idTarefa == tarefa.idTarefa && Objects.equals(titulo, tarefa.titulo) && Objects.equals(descricao, tarefa.descricao) && Objects.equals(dataLimite, tarefa.dataLimite) && prioridade == tarefa.prioridade && Objects.equals(status, tarefa.status) && Objects.equals(dataCriacao, tarefa.dataCriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarefa, titulo, descricao, dataLimite, prioridade, status, dataCriacao);
    }
}

