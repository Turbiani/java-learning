package ordenando.java8;

import java.util.*;
import java.util.function.Function;

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

        //USANDO ORDER NATURAL - OS OBJETOS PRECISAM IMPLEMENTAR Comparable, POR ISSO USAREI STRING
        //POIS USUARIO NAO IMPLEMENTA
        //O uso do comparing só funciona passando um lambda que, dado um tipoT(usuário),
        //devolve algo queseja Comparable<U>.No nosso exemplo, devolvemos uma String, o nome do usuário, que é Comparable<String>
        usuarioList.sort(Comparator.comparing(usuario -> usuario.getNome()));

        //OUTRO EXEMPLO DIRETO COM USO DE STRING
        List<String> palavras = Arrays.asList("Casa do Código", "Alura", "Caelum");
        palavras.sort(Comparator.naturalOrder());

        //AGORA VAMOS MOSTRAR PASSO A PASSO COMO FUNCIONA O DEFAULT METHOD Sort EM List
        Function<Usuario, String> extraiNomeDoUsuario = u -> u.getNome();
        Comparator<Usuario> comparatorName = Comparator.comparing(extraiNomeDoUsuario);
        usuarioList.sort(comparatorName);

        usuarioList.stream()
                .forEach(System.out::println);
    }
}
