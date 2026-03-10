package mauricioexe.com.regesc.repository;

import mauricioexe.com.regesc.orm.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    List<Aluno> findByNome(String nome);
    List<Aluno> findByNomeStartingWithAndIdadeLessThanEqual(String nome, Integer idade);
    @Query("SELECT a FROM Aluno a INNER JOIN a.disciplinas d WHERE a.nome like :nomeAluno% AND a.idade>=:idadeAluno AND d.nome like :nomeDisciplina")
List<Aluno>findNomeIdadeIgualOuMaiorMatriculado(String nomeAluno, Integer idadeAluno, String nomeDisciplina);

    //busca por JPQL  or inject spring data QL
@Query("SELECT a FROM Aluno a WHERE a.nome like :nome% AND a.idade >= :idade")
    List<Aluno>findNomeIdadeIgualOuMaior(String nome,Integer idade);
}

