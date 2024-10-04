/**
 * Classe Pessoa
 * Super classe
 */
public class Pessoa {

    private String nome;
    private int idade;
    private String genero;

    /**
     * Construtor Vazio
      */
    public Pessoa() {

      }

    /**
     * Construtor Pessoa
     * @param nome nome da Pessoa
     * @param idade idade da Pessoa
     * @param genero genero da Pessoa
     */
    public Pessoa(String nome, int idade, String genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    /**
     * Getter retorna nome da Pessoa
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter retorna idade da Pessoa
     * @return idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Getter retorna genero da Pessoa
     * @return genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Setter
     * @param nome define nome da Pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Setter
     * @param idade define idade da Pessoa
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Setter
     * @param genero define genero da Pessoa
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Método toString()
      * @return nome, idade, genero
     */
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", genero='" + genero + '\'' +
                '}';
    }
}
