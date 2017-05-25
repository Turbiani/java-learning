package method.references;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lcunha on 25/05/17.
 */
public class Main {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        //ACESSANDO ATRIBUTO DA CLASSE USUARIO ATRAVÉS DE METHOD REFERENCE
        usuarioList.forEach(Usuario::whoAmi);
    }
}
