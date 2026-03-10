package mauricioexe.com.regesc.orm;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    private   Integer idade;
    @ManyToMany(mappedBy = "alunos", fetch = FetchType.LAZY)
    Set<Disciplina> disciplinas;

    public Aluno(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        idade = idade;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Aluno(long id, String nome, Integer idade, Set<Disciplina> disciplinas) {
        this.id = id;

        idade = idade;
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", Nome='" + nome + '\'' +
                ", Idade=" + idade +
                '}';
    }
}
