package method.references;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import static java.util.Comparator.comparing;

/**
 * Created by lcunha on 25/05/17.
 */
public class ConstructorReference {
    public static void main(String[] args) {
        //AGORA MOSTRAREI COMO PODEMOS USAR METHOD REFERENCES COM CONSTRUTORES
        //PARA CRIAR UMA INSTÂNCIA DE USUÁRIO, PRECISAMOS GUARDAR A REFERÊNCIA DA LINHA DEBAIXO EM UMA INTERFACE FUNCIONAL
        //Usuario usuario = Usuario::new;
        //SE TIRAR O COMENTÁRIO DA LINHA DE CIMA A IDE IRÁ DIZER Usuario is not a functional interface
        //PARA ISSO USAREMOS UM RECURSO DA API CHAMADO SUPPLY
        Supplier<Usuario> usuarioSupplier = Usuario::new;
        Usuario novoUsuario = usuarioSupplier.get();

        //SUPPLIER SO CONSEGUE INVOCAR O CONSTRUTOR DEFAULT, PARA USAR CONSTURTORES COM PARÂMETROS SEGUE CODIGO
        BiFunction<String, Integer, Usuario> criaUsuarioFromNomeAndPontos = Usuario::new;
        Usuario novoUsuario2 = criaUsuarioFromNomeAndPontos.apply("Zezinho", 190);
        Runnable rodarExpressao = novoUsuario2::whoAmi;
        rodarExpressao.run();

        //SE EU QUISESSE CRIAR APENAS COM UM PARÂMETRO DE CONSTRUTOR
        Function<Integer, Usuario> criaUsuarioFromPontos = Usuario::new;
        Usuario usuarioNovo3 = criaUsuarioFromPontos.apply(190);
        Runnable rodarExpressao2 = usuarioNovo3::whoAmi;
        rodarExpressao2.run();
    }
}
