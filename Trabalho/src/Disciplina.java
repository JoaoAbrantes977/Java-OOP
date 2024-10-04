import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 * Classe Disciplina
 */
public class Disciplina {
    private int codigo;

    private String nome;
    private String lingua;
    private int ects;
    private ArrayList<String> profs;

    /**
     *  ArrayList com a lista de Disciplinas
      */
   static ArrayList<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

    /**
     * Construtor Disciplina
     * @param codigo codigo da Disciplina
     */
    public Disciplina(int codigo){this.codigo = codigo;}

    /**
     * Construtor Disciplina
     * @param codigo codigo da disciplina
     * @param nome nome da disciplina
     * @param lingua lingua da disciplina
     * @param etcs etcs da disciplina
     * @param profs profs da disciplina
     */
    public Disciplina(int codigo, String nome, String lingua, int etcs, ArrayList<String> profs){
        this.codigo = codigo;
        this.nome = nome;
        this.lingua = lingua;
        this.ects = etcs;
        this.profs = profs;
    }

    /**
     * Getter retorna o codigo da disciplina
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Getter retorna o nome da disciplina
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter lingua retorna o lingua da disciplina
     * @return lingua
     */
    public String getLingua() {
        return lingua;
    }

    /**
     * Getter retorna o ects da disciplina
     * @return ects
     */
    public int getEcts() {
        return ects;
    }

    /**
     * Getter retorna os professores da disciplina
     * @return profs
     */
    public  ArrayList<String> getProfs() {
        return profs;
    }

    /**
     * Setter
     * @param codigo define o codigo da disciplina
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Setter
     * @param nome define o nome da disciplina
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Setter
     * @param lingua define a lingua da disciplina
     */
    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    /**
     * Setter
     * @param ects define os ects da disciplina
     */
    public void setEcts(int ects) {
        this.ects = ects;
    }

    /**
     * Setter
     * @param profs define os professores da disciplina
     */
    public void setProfs(ArrayList<String> profs) {
        this.profs = profs;
    }

    /**
     *  Método para o utilizador criar um Objecto Disciplina, esta objeto será depois inserido no ArrayList Disciplinas
     */
    public static void criarDisciplina() {
        Scanner ler_input = new Scanner(System.in);
        String nome;
        String lingua;
        int ects = 6;
        String prof_funcao;
        String nome_prof;
        int n_profs;

        System.out.println("Inserir o nome da disciplina:");
        nome = ler_input.nextLine();
        System.out.println("Inserir a lingua:");
        lingua = ler_input.nextLine();
        System.out.println("Quantos professores quer inserir?");
        n_profs = ler_input.nextInt();
        ler_input.nextLine();


        /**
         *  ArrayList com os professores para inserir num Objecto Disciplina
         */
        ArrayList<String> profs = new ArrayList<>();

        /**
         *  Mostra a Lista de professores já criados
          */
        Professor.verProfessores();

        /**
         *  Ciclo "for" que insere professores na Disciplina
          */
        for (int i = 0; i < n_profs; i++) {
            System.out.println("Inserir nome do professor:");
            nome_prof = ler_input.nextLine();
            profs.add(nome_prof);
            System.out.println("Inserir a funcao do professor:");
            prof_funcao = ler_input.nextLine();
            profs.add(prof_funcao);
        }

        /**
         *  Gera um codigo random para o codigo da disciplina
          */
        int codigo = (int) (Math.random() * 9000) + 1000;

        /**
         *  Criar um objeto Disciplina com a informação criada
          */
        Disciplina d = new Disciplina(codigo, nome, lingua, ects, profs);
        // Adiciona a Disciplina ao Arraylist das Disciplinas
        listaDisciplinas.add(d);

        /**
         *  Mostrar todas as disciplinas dentro do Arraylist das Disciplinas
          */
        for (Disciplina s : listaDisciplinas) {
            System.out.println(s);
        }
        /**
         * Chamada do método guardar(), para guardar a informação do ArrayList num ficheiro .txt
         */
       guardar();
    }

    /**
     *  Escrever para um ficheiro .txt o conteudo do arraylist de Disciplinas
     * @throws RuntimeException exception de runtime
      */
    public static void guardar(){

        BufferedWriter writter;
        {
            try {
                writter = new BufferedWriter(new FileWriter("Disciplinas.txt", true));
                for(Disciplina s: listaDisciplinas){
                    writter.append(String.valueOf(s));
                    writter.append("\n");
                }
                System.out.println("Aluno guardado no ficheiro Disciplinas.txt");
                writter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }listaDisciplinas.clear();
    }

    /**
     *  Método para ver as Disciplinas existentes
     */
    public static void verDisciplinas(){
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("Disciplinas.txt"));

            while ((line = br.readLine()) != null ){
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método toString()
      * @return codigo, nome, lingua, ects, profs
     */
// toString
    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", lingua='" + lingua + '\'' +
                ", ects=" + ects +
                ", profs=" + profs +
                '}';
    }
}