package mauricioexe.com.regesc.service;

import mauricioexe.com.regesc.orm.Professor;
import mauricioexe.com.regesc.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CRUDprofessorService {
    private ProfessorRepository professorRepository;// dependencia da classe CRUDprofessorService

    //isso é uma injeção de dependencia
    public CRUDprofessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void menu(Scanner scanner) {
        Boolean Istrue = true;

        while (Istrue) {
            System.out.println("qual ação voce que executar");
            System.out.println("0- voltar para o menu anterior");
            System.out.println("1- cadastrar novo Professor");
            System.out.println("2- actualizar um Professor");
            System.out.println("3- vizualizar todos os professores");
            System.out.println("4- deletar um professor");
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
        System.out.print("Digite um novo professor");
        String nome = scanner.next();
        System.out.print("Digite o prontuario do professor");
        String prontuario = scanner.next();
        Professor professor = new Professor(nome, prontuario);
        this.professorRepository.save(professor);
        System.out.println("salvo");
    }

    private void actualizar(Scanner scanner) {
        System.out.println("digite o id do professor a ser actualizado");
        long id = scanner.nextLong();

        Optional<Professor> optional = this.professorRepository.findById(id);
        if (optional.isPresent()) {
            System.out.println("Digite o nome do professor");
            String nome = scanner.next();

            System.out.println("Digite o  prontiario");
            String prontiario = scanner.next();

            Professor professor = optional.get();
            professor.setNome(nome);
            professor.setProntuario(prontiario);
            professorRepository.save(professor);
            System.out.println("professor actualizado");
        } else {
            System.out.println("o id do professor informado" + id + "é invalido");
        }


    }

    private void actualizar2(Scanner scanner) {
        System.out.println("digite o id do professor a ser actualizado");
        long id = scanner.nextLong();
        System.out.println("Digite o nome do professor");
        String nome = scanner.next();
        System.out.println("Digite o  prontiario");
        String prontiario = scanner.next();

        Professor professor = new Professor();
        professor.setId(id);
        professor.setNome(nome);
        professor.setProntuario(prontiario);
        professorRepository.save(professor);
        System.out.println("professor actualizado");

    }
    private void views(){
        Iterable<Professor> professors= this.professorRepository.findAll();
        for (Professor professor : professors){
            System.out.println(professor);
        }

    }
    private void delete(Scanner scanner){
        System.out.println("digite o id do professor a ser apagado");
        long id = scanner.nextLong();
        this.professorRepository.deleteById(id);//senão achar o id mostrara uma exception
        System.out.println("professor apagado");
    }
}