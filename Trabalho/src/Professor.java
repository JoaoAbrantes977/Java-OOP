import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Professor
 * Extende a Classe Pessoa
 */
public class Professor extends Pessoa {
        private String funcao;
        private int codigo;

    /**
     * Construtor Professor
     * @param funcao funcao do professor
     * @param codigo codigo do professor
     */
    public Professor(String funcao,int codigo){
            this.funcao=funcao;
            this.codigo = codigo;
        }

    /**
     * Construtor Professor
     * @param nome nome do professor
     * @param idade idade do professor
     * @param genero genero do professor
     * @param codigo codigo do professor
     */
        public Professor(String nome, int idade, String genero, int codigo){
            super(nome, idade, genero);
            this.codigo = codigo;
        }

    /**
     * Getter retorna funcao do professor
     * @return  funcao
     */
    public String getFuncao() {
            return funcao;
        }

    /**
     * Getter retorna codigo do professor
     * @return codigo
     */
    public int getCodigo() {
            return codigo;
        }

    /**
     * Setter
     * @param funcao define funcao do professor
     */
        public void setFuncao(String funcao) {
            this.funcao = funcao;
        }

    /**
     * Setter
     * @param codigo define codigo do professor
     */
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

    /**
     * ArrayList para guardar os professores
     */
    static ArrayList<Professor> listaProfessores = new ArrayList<>();

    /**
     *  Método para o utilizador criar um Objecto Professor, esta objeto será depois inserido no ArrayList de Professores
     */
    public static void criarProfessor(){
        Scanner ler_input = new Scanner(System.in);
        String _nome ;
        int _idade ;
        String _genero ;

        System.out.println("Inserir o nome do Professor");
        _nome=ler_input.nextLine();
        System.out.println("Inserir genero");
        _genero=ler_input.nextLine();
        System.out.println("Inserir a idade");
        _idade=ler_input.nextInt();
        int codigo= (int)(Math.random()*9000)+1000;

        /**
         * Cria um objeto Professor com a informação inserida pelo utilizador
         */
        Professor p = new Professor(_nome,_idade,_genero,codigo);

        /**
         *   Adiciona o aluno ao arraylist
         */
        listaProfessores.add(p);

        /**
         *   Mostrar todas os professores dentro do Arraylist dos Professores
         */
        for (Professor s : listaProfessores) {
            System.out.println(s);
        }

        /**
         *  Chamada do método guardar()
         */
        guardar();
    }

    /**
     *  Método para escrever para um ficheiro .txt o conteudo do Arraylist de Professores
     * @throws RuntimeException exception runtime
     */
    public static void guardar(){

        BufferedWriter writter;

        {
            try {
                writter = new BufferedWriter(new FileWriter("Professores.txt",true));
                for(Professor s: listaProfessores){
                    writter.write("\n");
                    writter.write(String.valueOf(s));
                }
                System.out.println("Professor guardado no ficheiro.txt");
                writter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }listaProfessores.clear();
    }

    /**
     *  Método para ver os Alunos Inscritos
     */
    public static void verProfessores(){
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader("Professores.txt"));

            while ((line = br.readLine()) != null ){
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Método toString()
     * @return nome, idade, genero, codigo
     */
    @Override
    public String toString() {
        return "Professor{" +
                " nome=" + getNome() +
                " idade=" + getIdade() +
                " genero=" + getGenero() +
                " codigo='" + codigo + '\'' +
                '}';
    }
}
