import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class Notificacao {

    private String idNotificacao;
    private String idUsuario;
    private String idTarefa;
    private LocalDateTime dataNotificacao;
    private StatusNotificacao status;
    private Instant dataCriacao;

    public Notificacao(String idUsuario, String idTarefa, LocalDateTime dataNotificacao) {
        this.idNotificacao = UUID.randomUUID().toString();
        this.idUsuario = idUsuario;
        this.idTarefa = idTarefa;
        this.dataNotificacao = dataNotificacao;
        this.status = StatusNotificacao.PENDENTE;
        this.dataCriacao = Instant.now();
    }

    public void enviar(){
        System.out.println("✅ Notificação enviada com sucesso!");
        this.status = StatusNotificacao.ENVIADO;
        System.out.println(this);
    }

    public String getIdNotificacao() {
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

    public String getIdTarefa() {
        return idTarefa;
    }

    public String getIdUsuario() {
        return idUsuario;
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
