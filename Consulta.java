import java.time.LocalDate;

public class Consulta {
    private Long id;
    private Medico medico;
    private Paciente paciente;
    private LocalDate dataConsulta;
    private StatusConsulta status;
    private double valor;

    public Consulta(Long id, Medico medico, Paciente paciente, LocalDate dataConsulta, StatusConsulta status,
            double valor) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.status = status;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ID:" + getId() +
                "\n" + "Medico:" + getMedico().getNome()
                + "\n" + "Paciente:" + getPaciente().getNome() + "\n"
                + "Data da Consulta:" + getDataConsulta() + "\n"
                + "Status:" + getStatus() + "\n"
                + "Valor:" + getValor();
    }
}
