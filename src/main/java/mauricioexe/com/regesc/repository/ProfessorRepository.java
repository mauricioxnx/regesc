package mauricioexe.com.regesc.repository;

import mauricioexe.com.regesc.orm.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long>{


}
