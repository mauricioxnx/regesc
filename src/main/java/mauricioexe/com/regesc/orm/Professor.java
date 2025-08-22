package mauricioexe.com.regesc.orm;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true)
    private String prontuario;

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplina;

    public Professor(){ }

    public Professor(String nome, String prontuario) {
        this.nome = nome;
        this.prontuario = prontuario;
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

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public String toString() {
        return "professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", prontuario='" + prontuario + '\'' +
                '}';
    }
}
