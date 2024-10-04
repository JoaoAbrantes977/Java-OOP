import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe Curso
 */
public class Curso {

    private String nome_curso;
    private  ArrayList<String> disciplinas;
    static ArrayList<Curso> listaCursos = new ArrayList<>();

    /**
     * Construtor Curso Vazio
     */
    //Construtores
    public Curso(){
    }

    /**
     * Construtor Curso
     * @param nome_curso nome do curso
     * @param disciplinas nome das disciplinas
     */
    public Curso(String nome_curso,ArrayList<String> disciplinas){
    this.nome_curso = nome_curso;
    this.disciplinas = disciplinas;
    }

    /**
     * Getter retorna nome do curso
     * @return nome_curso
     */
    public String getNome_curso() {
        return nome_curso;
    }

    /**
     * Getter retorna nome das disciplinas
     * @return disciplinas
     */
    public ArrayList<String> getDisciplinas() {
        return disciplinas;
    }

    /**
     * Setter
     * @param nome_curso define nome do curso
     */
    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    /**
     * Setter
     * @param disciplinas define disciplinas
     */
    public void setDisciplinas(ArrayList<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

    /**
     * Método para o utilizador criar um Objecto Curso, esta objeto será depois inserido no ArrayList de Cursos
     */
    public static void criarCurso(){
        Scanner ler_input = new Scanner(System.in);
        String nome ;
        String nome_disciplina;
        int n_disciplinas;

        System.out.println("Inserir o nome do Curso");
        nome=ler_input.nextLine();
        System.out.println("Quantas disciplinas quer inserir?");
        n_disciplinas = ler_input.nextInt();
        ler_input.nextLine();

        /**
         *  ArrayList com as Disciplinas do Curso
         */
         ArrayList<String> disciplinas = new ArrayList<>();

        /**
         *  Mostra a Lista de Disciplinas já criadas
         */
        Disciplina.verDisciplinas();

        /**
         *   Insere disciplinas no curso
          */
        for(int i =0; i<n_disciplinas; i++){
            System.out.println("Inserir o nome da disciplina");
            nome_disciplina=ler_input.nextLine();
            disciplinas.add(nome_disciplina);
        }

        /**
         *  Criar um objeto Curso com a informação criada
          */
        Curso p = new Curso(nome,disciplinas);

        /**
         * Adiciona o curso ao arraylist de Cursos
          */
        listaCursos.add(p);

        /**
         *  Mostrar todas os cursos dentro do Arraylist dos Cursos
         */
        for (Curso s : listaCursos) {
            System.out.println(s);
        }
        /**
         * Chamada do método guardar(), para guardar a informação do ArrayList num ficheiro .txt
         */
        guardar();
    }

    /**
     *  Escrever para um ficheiro .txt o conteudo do arraylist de Alunos
     * @throws  RuntimeException exception de runtime
     */
    public static void guardar(){

        BufferedWriter writter;
        {
            try {
                writter = new BufferedWriter(new FileWriter("Cursos.txt", true));
                for(Curso s: listaCursos){
                    writter.append(String.valueOf(s));
                    writter.append("\n");
                }
                System.out.println("Aluno guardado no ficheiro Cursos.txt");
                writter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }listaCursos.clear();
    }

    /**
     *  Método para ver os os Cursos existentes
     */
    public static void verCursos(){
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("Cursos.txt"));

            while ((line = br.readLine()) != null ){
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método toString()
     * @return nome_curso; disciplinas
     */
    @Override
    public String toString() {
        return "Curso{" +
                "nome do curso='" + nome_curso + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
