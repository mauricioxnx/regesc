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
    @ManyToMany(mappedBy = "alunos")
    List<Disciplina>disciplinas;
}
