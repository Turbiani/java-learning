package defaults.methods;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by lcunha on 30/04/17.
 */
public class UsandoAndThen {
    //QUANDO USAMOS DEFAULT METHODS NAS NOSSAS INTERFACES
    //AS CLASSES FILHAS GANHAM ESSE METODO, E NAO SAO OBRIGADAS A IMPLEMENTA-LO
    //DEFAULT METHODS NAO CONTAM QUANDO ANOTAMOS NOSSAS INTERFACES FUNCIONAIS COM @FunctionalInterface
    //ESSE METODO andThen TEM UM CONCEITO QUE ME LEMBRA O then() DAS PROMISSES DO JS
    //COM A DIFERENCA QUE ELE CHAMA O PROXIMO CONSUMER A CADA ITERACAO DA LISTA. JA EM PROMISSES EU DOU UM APPEND DE UMA
    //EXECUCAO APOS O FIM COMPLETO DA ANTERIOR.

    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3);

        Consumer<Usuario> mostraMensagem = u -> System.out.println("Rodei antes de imprimir os nomes");
        Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());

        usuarioList.forEach(mostraMensagem.andThen(imprimeNome));

    }
}
