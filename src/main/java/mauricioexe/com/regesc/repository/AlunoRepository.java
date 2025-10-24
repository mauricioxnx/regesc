package mauricioexe.com.regesc.repository;

import mauricioexe.com.regesc.orm.Aluno;
import mauricioexe.com.regesc.orm.Disciplina;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
}

