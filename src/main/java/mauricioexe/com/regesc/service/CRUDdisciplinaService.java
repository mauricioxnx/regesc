package mauricioexe.com.regesc.service;

import mauricioexe.com.regesc.orm.Disciplina;
import mauricioexe.com.regesc.orm.Professor;
import mauricioexe.com.regesc.repository.DisciplinaRepository;
import mauricioexe.com.regesc.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CRUDdisciplinaService {
    private DisciplinaRepository disciplinaRepository;
    private ProfessorRepository professorRepository;
    public  CRUDdisciplinaService ( DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository){
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }
    public void menu(Scanner scanner) {
        Boolean Istrue = true;

        while (Istrue) {
            System.out.println("qual ação voce que executar");
            System.out.println("0- voltar para o menu anterior");
            System.out.println("1- cadastrar nova Disciplina");
            System.out.println("2- actualizar uma Disciplina");
            System.out.println("3- vizualizar todas as Disciplinas");
            System.out.println("4- deletar uma Disciplina");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrar(scanner);
                    break;
                case 2:
                    this.actualizar(scanner);
                    break;
                case 3:
                    this.views();
                    break;
                case 4:
                    this.delete(scanner);
                    break;
                default:
                    Istrue = false;
                    break;

            }
        }
    }
    private void cadastrar(Scanner scanner) {
        System.out.print("Digite um novo Disciplina");
        String nome = scanner.next();

        System.out.print("Digite o semestre");
        Integer semestre = scanner.nextInt();

        System.out.print("Digite o id do professor");
        Long professor = scanner.nextLong();

        Optional<Professor> optionalProfessor = this.professorRepository.findById(professor);
        if (optionalProfessor.isPresent()) {
            Professor professorEntity = optionalProfessor.get();
            Disciplina disciplina = new Disciplina(nome, semestre, professorEntity);
            this.disciplinaRepository.save(disciplina);
            System.out.println("Salvo!");
        } else {
            System.out.println("O id do professor informado " + professor + " é inválido");
        }

    }

    private void actualizar(Scanner scanner) {
        System.out.print("Digite o ID da Disciplina a ser actualizada: ");
        long id = scanner.nextLong();

        Optional<Disciplina> optional = this.disciplinaRepository.findById(id);
        if (optional.isPresent()) {
            Disciplina disciplina = optional.get();

            System.out.print("Digite o novo nome da Disciplina: ");
            String nome = scanner.next();

            System.out.print("Digite o novo semestre: ");
            Integer semestre = scanner.nextInt();

            System.out.print("Digite o ID do novo Professor: ");
            long professor = scanner.nextLong();

            Optional<Professor> optionalProfessor = this.professorRepository.findById(professor);
            if (optionalProfessor.isPresent()) {
                Professor professorEntity = optionalProfessor.get();

                disciplina.setNome(nome);
                disciplina.setSemestre(semestre);
                disciplina.setProfessor(professorEntity);

                this.disciplinaRepository.save(disciplina);

                System.out.println("Disciplina actualizada com sucesso!");
            } else {
                System.out.println("O ID do professor informado " + professor+ " é inválido.");
            }
        } else {
            System.out.println("O ID da disciplina informado " + id + " é inválido.");
        }
    }

    private void views() {
        Iterable<Disciplina> Disciplinas = this.disciplinaRepository.findAll();
        for (Disciplina disciplina : Disciplinas)
            System.out.println(disciplina);
        }

        private void delete (Scanner scanner){
            System.out.println("Digite o id da disciplina a ser apagada");
            long id = scanner.nextLong();
            this.disciplinaRepository.deleteById(id);//senão achar o id mostrara uma exception
            System.out.println("Disciplina apagada");
        }




}
