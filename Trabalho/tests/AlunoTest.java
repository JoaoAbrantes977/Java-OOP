import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class AlunoTest {

    @Test
    public void verAlunos() {
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
