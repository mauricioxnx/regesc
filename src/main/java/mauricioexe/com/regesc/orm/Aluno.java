package mauricioexe.com.regesc.orm;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String Nome;
    private  Integer Idade;
    @ManyToMany(mappedBy = "alunos", fetch = FetchType.LAZY)
    List<Disciplina>disciplinas;

    public Aluno(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Aluno(long id, String nome, Integer idade, List<Disciplina> disciplinas) {
        this.id = id;
        Nome = nome;
        Idade = idade;
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", Idade=" + Idade +
                '}';
    }
}
