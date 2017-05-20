package ordenando.java8;

import java.util.*;

/**
 * Created by lcunha on 08/05/17.
 */
public class Comparators {

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3);

        //COMPARATOR A MODA ANTIGA
        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };

        Collections.sort(usuarioList, comparator);
        usuarioList.forEach(user -> System.out.println(user.getNome()));

        //COMPARATOR COM LAMBDA
        Collections.sort(usuarioList, (u1, u2) -> new Integer(u1.getPontos()).compareTo(u2.getPontos()));
        usuarioList.forEach(user -> System.out.println(user.getNome()));

        //USANDO O DEFAULT METHOD EM List QUE INVOCA O Collections.sort
        usuarioList.sort((u1, u2) -> String.CASE_INSENSITIVE_ORDER.compare(u1.getNome(), u2.getNome()));
        usuarioList.forEach(user -> System.out.println(user.getNome()));

        //AGORA TUDO ISSO COM STREAM
        usuarioList.stream()
            .sorted((u1, u2) -> String.CASE_INSENSITIVE_ORDER.compare(u1.getNome(), u2.getNome()))
            .forEach(System.out::println);

        //USANDO 
    }
}
