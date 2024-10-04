import java.io.FileNotFoundException;
import java.util.Scanner;

/** Trabalho Prático Java 2022
 * @author  João Abrantes 47621
 * @author  Henrique Reis 48650
 * @version 1.0
 */

/**
 * Classe Main
 */
public class Main {
    /**
     * Método Main
     * @param args main
     * @throws FileNotFoundException ficheiro nao encontrado
     */
    public static void main(String[] args) throws FileNotFoundException {
/**
 * Menu principal para o Utilizador escolher a sua opção
 * @param opt guarda a opção escolhida pelo utilizador e passa-a para o switch case
 */
        Scanner ler_input = new Scanner(System.in);
        int opt;
        while(true) {
                System.out.println("Escolha uma das seguintes opções: ");
                System.out.println("1 - Inserir Professor");
                System.out.println("2 - Inserir Disciplina");
                System.out.println("3 - Inserir Curso");
                System.out.println("4 - Inserir Aluno");
                System.out.println("5 - Ver Professores");
                System.out.println("6 - Ver Disciplinas");
                System.out.println("7 - Ver Cursos");
                System.out.println("8 - Ver Alunos");
                System.out.println("0 - Sair \n");

                opt = ler_input.nextInt();

            switch (opt) {
                case 1 -> Professor.criarProfessor();
                case 2 -> Disciplina.criarDisciplina();
                case 3 -> Curso.criarCurso();
                case 4 -> Aluno.criarAluno();
                case 5 -> Professor.verProfessores();
                case 6 -> Disciplina.verDisciplinas();
                case 7 -> Curso.verCursos();
                case 8 -> Aluno.verAlunos();
                case 0 -> {
                    System.out.println("A fechar o programa...");
                    System.exit(0);
                }
                default -> System.out.println("Introduza um valor valido entre 0 e 8");
            }
        }
    }
}


