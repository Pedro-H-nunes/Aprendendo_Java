package Jogo_da_idosa; //Já explicado em Jogo.java
public class Jogador { // publico, nome da classe é Jogador


    private char simbolo; // somente essa classe acessa esse simbolo que é um caractere único.

    // CONSTRUTOR: Tem o mesmo nome da classe, roda uma vez quando se faz new Jogador('X')
    public Jogador(char simbolo) {
        this.simbolo = simbolo;
    }  // O char simbolo é um parâmetro. Valor que vem de fora.
 // this.simbolo é o atributo da classe, está dizendo acima que "o atributo da classe recebe o valor do parâmetro"

    public char getSimbolo() {
        return simbolo;
    } //Getter é o metodo que devolve o valor
// Basicamente essa linha diz: pegue o valor que está associado ao simbolo e devolva em formato char.
}