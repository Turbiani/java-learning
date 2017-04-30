package ola.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by lcunha on 30/04/17.
 */
public class Loops {
    public static void main(String[] args) {
        Usuario user1 = new Usuario("Paulo Silveira", 150);
        Usuario user2 = new Usuario("Rodrigo Turini", 120);
        Usuario user3 = new Usuario("Guilherme Silveira", 190);

        List<Usuario> usuarioList = Arrays.asList(user1, user2, user3);

        //FORMA CLASSICA JAVA5
        System.out.println("FORMA CLASSICA=====//");
        for (Usuario u : usuarioList){
            System.out.println(u.getNome());
        }

        //UTILIZANDO CONSUMER
        System.out.println("UTILIZANDO CONSUMER=====//");
        usuarioList.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        });

        //UTILIZANDO LAMBDA (ME LEMBRA MUITO ARROW FUNCTIONS DO JS)
        System.out.println("UTILIZANDO LAMBDA=====//");
        usuarioList.forEach(user -> System.out.println(user.getNome()));
    }
}
