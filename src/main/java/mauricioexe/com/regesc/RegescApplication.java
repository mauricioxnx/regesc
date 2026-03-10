package mauricioexe.com.regesc;

import mauricioexe.com.regesc.service.CRUDAlunoService;
import mauricioexe.com.regesc.service.CRUDdisciplinaService;
import mauricioexe.com.regesc.service.CRUDprofessorService;
import mauricioexe.com.regesc.service.RelatorioGeralService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RegescApplication implements CommandLineRunner {
	private CRUDprofessorService professorservice;
	private CRUDdisciplinaService disciplinaService;
	private CRUDAlunoService alunoService;
	private RelatorioGeralService relatorioGeralService;

	//os objetos passados por parametro são integrados diretamente pelo spring
	//porque suas classes possuem anotação @service
	public RegescApplication(CRUDprofessorService professorservice, CRUDdisciplinaService disciplinaService, CRUDAlunoService alunoService, RelatorioGeralService relatorioGeralService)
	{
		this.professorservice = professorservice;
		this.disciplinaService = disciplinaService;
		this.alunoService = alunoService;
		this.relatorioGeralService = relatorioGeralService;
	}
	public static void main(String[] args) {
		SpringApplication.run(RegescApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean Istrue = true;
		Scanner scanner = new Scanner(System.in);

		while (Istrue){
			System.out.println("qual entidade voce deseja interagir?");
			System.out.println("0- Sair");
			System.out.println("1- Professor");
			System.out.println("2- Disciplina");
			System.out.println("3- Alunos");
			System.out.println("4-  Reletorio Alunos");
			int opcao = scanner.nextInt();

			switch (opcao){
				case 1:
					this.professorservice.menu(scanner);
					break;
				case 2:
					this.disciplinaService.menu(scanner);
					break;
				case 3:
					this.alunoService.menu(scanner);
					break;
				case 4:
					this.relatorioGeralService.menu(scanner);
					break;
				default:
					Istrue=false;
					break;
			}
		}
	}

}
