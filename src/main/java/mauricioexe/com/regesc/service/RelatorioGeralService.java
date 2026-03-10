package mauricioexe.com.regesc.service;

import mauricioexe.com.regesc.orm.Aluno;
import mauricioexe.com.regesc.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioGeralService {
    private AlunoRepository alunoRepository;

    public RelatorioGeralService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    public void menu(Scanner scanner) {
        Boolean Istrue = true;

        while (Istrue) {
            System.out.println("qual Relatorio voce deseja !!!");
            System.out.println("0- voltar para o menu anterior");
            System.out.println("1- Aluno por um dado Nome");
            System.out.println("2- Aluno por um dado Nome e idade menor ou igual");
            System.out.println("3- Aluno por um dado Nome e idade maior ou igual");
            System.out.println("4- Aluno Matriculados com um dado Nome e idade maior ou igual");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.AlunoporNome(scanner);
                    break;
                case 2:
                    this.AlunoporNomeIdadeMenorOuIgual(scanner);
                    break;
                case 3:
                    this.AlunoporNomeIdadeMaiorOuIgual(scanner);
                    break;
                case 4:
                    this.AlunoMatriculadosComNomeIdadeMaiorOuIgual(scanner);
                    break;

                default:
                    Istrue = false;
                    break;

            }
        }
    }
    private void AlunoporNome(Scanner scanner){
        System.out.print("Digite nome do Aluno");
        String nome = scanner.next();


        List<Aluno> alunos = this.alunoRepository.findByNome(nome);
        alunos.forEach(System.out::println);
        System.out.println();

        //alunos.forEach(System.out::println);

    }
    private void AlunoporNomeIdadeMenorOuIgual(Scanner scanner){
        System.out.print("Digite nome do Aluno");
        String nome = scanner.next();

        System.out.println("Digite a Idade");
        Integer idade = scanner.nextInt();


        List<Aluno> alunos = this.alunoRepository.findByNomeStartingWithAndIdadeLessThanEqual(nome,idade);
        alunos.forEach(System.out::println);
        System.out.println();

        //alunos.forEach(System.out::println);

    }

    private void AlunoporNomeIdadeMaiorOuIgual(Scanner scanner){
        System.out.print("Digite nome do Aluno");
        String nome = scanner.next();

        System.out.println("Digite a Idade");
        Integer idade = scanner.nextInt();


        List<Aluno> alunos = this.alunoRepository.findNomeIdadeIgualOuMaior(nome,idade);
        alunos.forEach(System.out::println);
        System.out.println();

        //alunos.forEach(System.out::println);

    }
    private void AlunoMatriculadosComNomeIdadeMaiorOuIgual(Scanner scanner){
        System.out.print("Digite nome do Aluno");
        String nomeAluno = scanner.next();

        System.out.println("Digite a Idade do Aluno");
        Integer idadeAluno = scanner.nextInt();

        System.out.print("Digite nome da Disciplina");
        String nomeDisciplina = scanner.next();

        List<Aluno> alunos = this.alunoRepository.findNomeIdadeIgualOuMaiorMatriculado(nomeAluno,idadeAluno,nomeDisciplina);
        alunos.forEach(System.out::println);
        System.out.println();

        //alunos.forEach(System.out::println);

    }

}
