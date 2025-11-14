import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;

public class Notificacao {

    private int idNotificacao;
    private int idUsuario;
    private int idTarefa;
    private LocalDateTime dataNotificacao;
    private StatusNotificacao status;
    private Instant dataCriacao;

    public Notificacao(int idUsuario, int idTarefa, LocalDateTime dataNotificacao) {
        this.idNotificacao = new Random().hashCode();
        this.idUsuario = idUsuario;
        this.idTarefa = idTarefa;
        this.dataNotificacao = dataNotificacao;
        this.status = StatusNotificacao.PENDENTE;
        this.dataCriacao = Instant.now();
    }

    public void enviar(){
        if(new Random().nextBoolean()){
            System.out.println("✅ Notificação enviada com sucesso!");
            this.status = StatusNotificacao.ENVIADO;
            System.out.println(this);
            return;
        }

        System.out.println("❌ Ocorreu um erro ao enviar a notificação!");
        this.status = StatusNotificacao.FALHA;
        System.out.println(this);
    }

    public int getIdNotificacao() {
        return idNotificacao;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public StatusNotificacao getStatus() {
        return status;
    }

    public LocalDateTime getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(LocalDateTime dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Notificacao{" +
                "idNotificacao=" + idNotificacao +
                ", idUsuario=" + idUsuario +
                ", idTarefa=" + idTarefa +
                ", dataNotificacao=" + dataNotificacao +
                ", status=" + status +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
