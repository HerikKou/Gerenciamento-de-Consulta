public class Medico {
    private Long id;
    private String nome;
    private String especialidade;
    public Medico(Long id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }
    public Long getId() {
        return id;
    }
     public String getNome() {
        return nome;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    @Override
    public String toString() {
        return "ID:"+getId() +"||"+ "Nome:"+getNome() +"||" + "Especialidades:"+getEspecialidade();
    }
}
