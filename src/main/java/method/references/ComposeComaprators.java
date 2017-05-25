package method.references;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by lcunha on 25/05/17.
 */
public class ComposeComaprators {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);
        Usuario user6 = new Usuario(null, 400);
        Usuario user7 = new Usuario(null, 60);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        //COMPOSE COMPARATORS
        Comparator<Usuario> usuarioComparator =
                Comparator.comparingInt(Usuario::getPontos)
                .thenComparing(Usuario::getNome);

        //OUTROS EXEMPLOS
        //.reversed() - Ordena em ordem desc
        //.nullsFirst e .nullsLast - Trata os dados com valores nulos, o primeiro colocando-os no começo da lista e o segundo no fim

        usuarioList.sort(usuarioComparator);

        //ACESSANDO ATRIBUTO DA CLASSE USUARIO ATRAVÉS DE METHOD REFERENCE
        usuarioList.forEach(Usuario::whoAmi);
    }
}
