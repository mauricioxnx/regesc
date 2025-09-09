package mauricioexe.com.regesc.orm;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    private Integer semestre;
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = true)
    private Professor professor;
    @ManyToMany
            @JoinTable(
                    name = "disciplina_aluno",
                    joinColumns =@JoinColumn(name="disciplina_fk"),
                  inverseJoinColumns =@JoinColumn(name= "aluno_fk"))
    List<Aluno>alunos;

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Deprecated
    public Disciplina() {
    }

    public Disciplina(String nome, Integer semestre, Professor professor) {
        this.nome = nome;
        this.semestre = semestre;
        this.professor = professor;
    }


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
        this.nome = nome;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", semestre=" + semestre +
                ", professor=" + professor +
                '}';
    }
}
