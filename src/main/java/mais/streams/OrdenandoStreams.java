package mais.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by lcunha on 25/05/17.
 */
public class OrdenandoStreams {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);
        Usuario user4 = new Usuario("Guilherme Almeida", 290);
        Usuario user5 = new Usuario("Leoanardo Silveira", 40);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3, user4, user5);

        //SABEMOS QUE O sort EM UMA LISTA RECEBE UM COMPARATOR PARA PODER ORDENAR
        //MAS EM STREAM ? FICA ASSSIM, COM O sorted
        Stream<Usuario> usuarioOrdenadosStream = usuarioList
                .stream()
                .filter(usuario -> usuario.getPontos() > 100)
                .sorted(Comparator.comparing(Usuario::getNome));

        //BORA GERAR UMA LISTA MAROTA
        List<Usuario> usuariosOrdenadosViaStream = usuarioOrdenadosStream.collect(Collectors.toList());
        usuariosOrdenadosViaStream.forEach(System.out::println);
    }
}
