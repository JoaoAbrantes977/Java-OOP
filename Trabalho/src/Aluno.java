import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Classe Aluno
 * Extende a Classe Pessoa
 */

public class Aluno extends Pessoa  {

    private static int ultimo = 0;
    private int numero;
    private String pais;
    private String universidadeOrigem;
    private String curso;
    private ArrayList<String> listaDisciplinas;

    //ArrayList para guardar alunos criados
    static ArrayList<Aluno> listaAlunos = new ArrayList<>();


    /**
     * Construtor do Objeto Aluno
     * @param nome varivael nome do Aluno
     * @param idade varivael idade do Aluno
     * @param genero varivael genero do Aluno
     * @param pais varivael pais do Aluno
     * @param curso varivael curso do Aluno
     * @param universidadeOrigem varivael universidade de origem do Aluno
     * @param listaDisciplinas varivael lista de disciplinas do Aluno
     */
    public Aluno(String nome, int idade, String genero, String pais, String curso, String universidadeOrigem, ArrayList<String> listaDisciplinas) {
        super(nome, idade, genero);
        this.pais = pais;
        this.universidadeOrigem = universidadeOrigem;
        this.curso = curso;
        this.listaDisciplinas = listaDisciplinas;
        numero = ultimo + 1;
        ultimo++;
    }

    /**
     * Getter retorna pais do Aluno
     * @return pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Getter retorna universidade de origem do Aluno
     * @return universidadeOrigem
     */
    public String getUniversidadeOrigem() {
        return universidadeOrigem;
    }

    /**
     *  Setter
     * @param pais define pais do Aluno
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Setter
     * @param universidadeOrigem define universidade de origem do Aluno
     */
    public void setUniversidadeOrigem(String universidadeOrigem) {
        this.universidadeOrigem = universidadeOrigem;
    }

    /**
     *
     * @return numero, pais, genero, idade, pais, universidadeOrigem, curso, listaDisciplinas
     *
     */
    @Override
    public String toString() {
        return "Aluno{" +
                "numero=" + numero +
                ", nome='" + getNome() + '\'' +
                ", pais='" + pais + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", idade='" + getIdade() + '\'' +
                ", pais='" + pais + '\'' +
                ", universidadeOrigem='" + universidadeOrigem + '\'' +
                ", curso='" + curso + '\'' +
                ", listaDisciplinas=" + listaDisciplinas +
                '}';
    }

    /**
     * Método para o utilizador criar um Objecto Aluno, esta objeto será depois inserido no ArrayList de alunos
     */
    public static void criarAluno() {
        Scanner ler_input = new Scanner(System.in);
        String _nome;
        int _idade;
        String _genero;
        String _pais;
        String _universidade;
        String curso_escolhido;
        String nome_disciplina;
        int total_ects = 12;

        System.out.println("Inserir o nome do aluno");
        _nome = ler_input.nextLine();
        System.out.println("Inserir o genero");
        _genero = ler_input.nextLine();
        System.out.println("Inserir país");
        _pais = ler_input.nextLine();
        System.out.println("Inserir Universidade");
        _universidade = ler_input.nextLine();
        System.out.println("Inserir a idade");
        _idade = ler_input.nextInt();
        ler_input.nextLine();

        /**
         * Mostra lista de cursos disponivéis
         */
        Curso.verCursos();

        System.out.println("Qual é o curso que se quer inscrever");
        curso_escolhido = ler_input.nextLine();

        /**
         * ArrayList com as disciplinas
         */
        ArrayList<String> disciplinas = new ArrayList<>();

        /**
         * Ciclo "for" para introduzir obrigatoriamente 2 (12 ects) disciplinas no Aluno
         */
        for (int i = 1; i <= 2; i++) {
            System.out.println("Inserir nome da disciplina " + i + ":");
            nome_disciplina = ler_input.nextLine();
            disciplinas.add(nome_disciplina);
        }
        /**
         * Ciclo "for" para inserir as restantes disciplinas até um total de 30 ects
         * "if statement" para verificar se o utilizador digita "sair" parar de adicionar disciplinas
         * e o segundo "if" para quando o total de ects for atingido (30 ects) o "for loop" para
         */
        for (int j = 3; j <= 5; j++) {
            System.out.println("Inserir nome da disciplina " + j + ":   Digite 'sair' para sair ");
            nome_disciplina = ler_input.nextLine();
            if (nome_disciplina.equals("sair")) {
                break;
            }
            if (total_ects >= 30) {
                break;
            }
            disciplinas.add(nome_disciplina);
            total_ects = total_ects + 6;

        }
        System.out.println("Atingiu o limite de 30 ECTS");

        /**
         * Criar um objeto Aluno com a informação criada
         */
        Aluno p = new Aluno(_nome, _idade, _genero, _pais, curso_escolhido, _universidade, disciplinas);

        /**
         * Adiciona um objecto Aluno ao arraylist dos Alunos
         */
        listaAlunos.add(p);

        /**
         * Mostrar todos os Alunos dentro do Arraylist dos Alunos
         */
        for (Aluno s : listaAlunos) {
            System.out.println(s);
        /**
         * Chamada do método guardar(), para guardar a informação do ArrayList num ficheiro .txt
         */
            guardar();
        }
    }

    /**
     * Escrever para um ficheiro .txt o conteudo do arraylist de Alunos
     * @throws RuntimeException exception de runtime
     */
    public static void guardar(){

    BufferedWriter writter;
    {
            try {
                writter = new BufferedWriter(new FileWriter("Alunos.txt",true));
                for(Aluno s: listaAlunos){
                    writter.append(String.valueOf(s));
                    writter.append("\n");
                }
                System.out.println("Aluno guardado no ficheiro Alunos.txt");
                writter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }listaAlunos.clear();
    }

    /**
     * Método para ver os Alunos Inscritos
     *
     */
    public static void verAlunos(){
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("Alunos.txt"));

            while ((line = br.readLine()) != null ){
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

