package mauricioexe.com.regesc.service;

import jakarta.transaction.Transactional;
import mauricioexe.com.regesc.orm.Aluno;
import mauricioexe.com.regesc.orm.Disciplina;
import mauricioexe.com.regesc.orm.Professor;
import mauricioexe.com.regesc.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CRUDAlunoService {
    private AlunoRepository alunoRepository;

    public CRUDAlunoService (AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    @Transactional
    public void menu(Scanner scanner) {
        Boolean Istrue = true;

        while (Istrue) {
            System.out.println("qual ação voce que executar");
            System.out.println("0- voltar para o menu anterior");
            System.out.println("1- cadastrar novo Aluno");
            System.out.println("2- actualizar um Aluno");
            System.out.println("3- vizualizar todas os Alunos");
            System.out.println("4- deletar um Aluno");
            System.out.println("5- vizualizar um Aluno");
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
                case 5:
                    this.views1(scanner);
                    break;
                default:
                    Istrue = false;
                    break;

            }
        }
    }
    private void cadastrar(Scanner scanner) {
        System.out.print("Digite ome do Aluno");
        String nome = scanner.next();
        System.out.print("Digite a idade ");
        Integer idade = scanner.nextInt();
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);
        this.alunoRepository.save(aluno);
        System.out.println("salvo");
    }
    private void actualizar(Scanner scanner) {
        System.out.println("digite o id do Aluno a ser actualizado");
        long id = scanner.nextLong();

        Optional<Aluno> optional = this.alunoRepository.findById(id);


        if (optional.isPresent()) {
            Aluno aluno = optional.get();

            System.out.println("Digite o nome do Aluno");
            String nome = scanner.next();

            System.out.println("Digite a Idade");
            Integer idade = scanner.nextInt();

            aluno.setNome(nome);
            aluno.setIdade(idade);
            alunoRepository.save(aluno);
            System.out.println("Aluno actualizado");


        } else {
            System.out.println("o id do Aluno informado" + id + "é invalido");
        }
    }
    private void views(){
        Iterable<Aluno> alunos= this.alunoRepository.findAll();
        for (Aluno aluno : alunos){
            System.out.println(aluno);
        }
        System.out.println();
    }
    private void delete(Scanner scanner){
        System.out.println("digite o id do Aluno a ser apagado");
        long id = scanner.nextLong();
        this.alunoRepository.deleteById(id);//senão achar o id mostrara uma exception
        System.out.println("Aluno apagado");
    }
    @Transactional
    private void views1(Scanner scanner) {
        System.out.print("Digite o ID do Aluno: ");
        long id = scanner.nextLong();

        Optional<Aluno> optional = this.alunoRepository.findById(id);


        if (optional.isPresent()) {
            Aluno aluno = optional.get();

            System.out.println("Aluno {");
            System.out.println("ID  :" + aluno.getId());
            System.out.println("Nome :" + aluno.getNome());
            System.out.println("Idade  :" + aluno.getIdade());
            System.out.println("Disciplinas [");

            if (aluno.getDisciplinas() != null) {
                for (Disciplina disciplina : aluno.getDisciplinas()) {
                    System.out.println("Nome " + disciplina.getNome());
                    System.out.println("Semestre " + disciplina.getSemestre());
                }
            }
                System.out.println("]\n}");


        }
        else {
            System.out.println("O ID do Aluno informado " + id + " é inválido.");
        }
    }
}
