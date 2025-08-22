package mauricioexe.com.regesc.repository;
import mauricioexe.com.regesc.orm.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
}
