/* Faça um programa para ler dois valores inteiros e depois
 mostrar na tela a soma desses números com mensagem explicativa, conforme exemplos.

 EXEMPLO:
 10 - Entrada
 20 - Entrada
 SOMA = 30 - Saída


 */

import java.util.Locale;
import java.util.Scanner;

public class Exercicio01_Calcula {
    static void main(String[] args) {

        Locale.setDefault(Locale.US); /* Isso aqui serve para deixar a separação das casas decimais americanizado (US) */

        Scanner sc = new Scanner(System.in); /* Adicionei o Scanner (e abreviei para sc) que pega o valor digitado pela máquina do usuário */

        int v1, v2, soma; /* Declarei as variáveis de valor inteiro */
        System.out.println("Digite o valor 01"); /* Esse comando serve para imprimir uma mensagem, tipo um print do Python */
        v1 = sc.nextInt(); /* Esse comando faz o valor 1 ser digitado */
        System.out.println("Digite o valor 02"); /* abreviação disso é "sout" */
        v2 = sc.nextInt(); /* Esse comando faz o valor 2 ser digitado */

        soma = v1 + v2; /* Fiz a soma entre as variáveis */

        System.out.println("SOMA = "+ soma); /* Mostrei a soma contatenando uma string com a variável de mesmo nome) */

        sc.close(); /* Fechei o Scanner */


    }
}
