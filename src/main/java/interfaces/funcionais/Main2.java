package interfaces.funcionais;

/**
 * Created by lcunha on 30/04/17.
 */
public class Main2 {
    //VARIAVEIS LOCAIS PODEM SER USADAS DENTRO DA EXPRESSAO LAMBDA
    //NAO PRECISO COLOCAR NA ASSINATURA A PALAVRA final
    //POREM NAO POSSO ALTERAR O VALOR DA VARIAVEL, SE NAO NAO COMPILA

    public static void main(String[] args) {
        String campeao = "Anderson Silva";

        new Thread(()->{
            System.out.println(campeao);
        }).start();

        //SE EU DESCOMENTAR ESSA LINHA DA PAU
        //campeao = "teste";
    }
}
