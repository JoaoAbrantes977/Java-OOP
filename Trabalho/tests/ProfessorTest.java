import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class ProfessorTest {

    @Test
    public void guardar() {

        BufferedWriter writter;

        {
            try {
                writter = new BufferedWriter(new FileWriter("Professores.txt"));
                for(Professor s: Professor.listaProfessores){
                    writter.write("\n");
                    writter.write(String.valueOf(s));
                }
                System.out.println("Professor guardado no ficheiro.txt");
                writter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }
