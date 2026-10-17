package Jogo_da_idosa; // Já explicado em Jogo.java
import javax.swing.*; // Já explicado Jogo.java
import java.awt.*; // Já explicado Jogo.java

public class Tabuleiro { // Dessa vez a classe é Tabuleiro.

    private char[][] matriz; // private == só o tabuleiro acessa; char[][] é uma matriz de
    // arrays, guarda caracteres em linhas e colunas

// CONSTRUTOR: (relembrando, só é rodada uma vez quando o objeto é criado)
    public Tabuleiro() { // Está pública para a classe Jogo manipular
        this.matriz = new char[3][3]; // Cria matriz 3x3. Sem isso a matriz seria nula (qualquer acesso quebraria o programa)
        for (int i = 0; i < matriz.length; i++) { // 1° for: Percorre entre linhas (Loop externo)
            for (int j = 0; j < matriz[i].length; j++) { // 2° for: Percorre entre colunas (Loop interno) -> percorre as colunas de cada linha
                matriz[i][j] = ' '; // Coloca espaço na posição.
                // Detalhe: Por que preenchi com ' '? Resposta: Porque quando se cria um char[][] em Java, ele vem com
                // \u0000 (caractere nulo), não com espaço vazio. É necessário preencher.


            }
        }
    }
    /*
    O fechamento das chaves deve ser feito corretamente. (experiência própria)
*/
    // METODO de exibição do Tabuleiro: Ele percorre a matriz igual ao construtor
    public void exibirTabuleiro() { // void: não retorna nada, só imprime.
        for (int i = 0; i < matriz.length; i++) { // 1° for: Percorre entre as linhas
            for (int j = 0; j < matriz[i].length; j++) { //2° for: Percorre entre as colunas
                System.out.print(matriz[i][j] + " "); //imprime sem pular linha. Mostra o caractere + espaço.
            }
            System.out.println(); // atalho: sout (no intellij), função de imprimir pulando linha no fim de cada linha da matriz.

        }


    }


    // METODO de registro de Jogada: Recebe linha, coluna e simbolo.

    public boolean registrarJogada(int linha, int coluna, char simbolo) { //Booleano pois é sobre escolha: true x false.
        if (matriz[linha][coluna] == ' ') { // verifica se a posição tá vazia
            matriz[linha][coluna] = simbolo; // Atribui o simbolo a linha e a coluna
            return true; // se os critérios forem verdadeiro, retorna true
        } else {
            return false; //se falso, false.
        }
    }


    // METODO Verificação de vitória: Em resumo, recebe um símbolo ('X' ou 'O'), verifica as 8 linhas possíveis
    // (3 horizontais, 3 verticais e 2 diagonais), se qualquer uma tiver 3 simbolos iguais -> return true.
    // Se nenhuma: return false.
    // Detalhe: os ifs são separados por que cada linha é uma condição diferente.
    public boolean verificarVitoria(char simbolo) {
        if (matriz[0][0] == simbolo && matriz[0][1] == simbolo && matriz[0][2] == simbolo) {
            return true;
        }

        if (matriz[1][0] == simbolo && matriz[1][1] == simbolo && matriz[1][2] == simbolo) {
            return true;
        }

        if (matriz[2][0] == simbolo && matriz[2][1] == simbolo && matriz[2][2] == simbolo) {
            return true;
        }

        if (matriz[0][0] == simbolo && matriz[1][0] == simbolo && matriz[2][0] == simbolo) {
            return true;

        }
        if (matriz[0][1] == simbolo && matriz[1][1] == simbolo && matriz[2][1] == simbolo) {
            return true;

        }
        if (matriz[0][2] == simbolo && matriz[1][2] == simbolo && matriz[2][2] == simbolo) {
            return true;

        }
        if (matriz[0][0] == simbolo && matriz[1][1] == simbolo && matriz[2][2] == simbolo) {
            return true;

        }
        if (matriz[0][2] == simbolo && matriz[1][1] == simbolo && matriz[2][0] == simbolo) {
            return true;
        }
        return false;
    }


    // METODO de verificação de Idosa (o nome ficou estranho): Percorre a matriz inteira, se encontrar qualquer ' ' (espaços)
    // return false traduzindo: se encontrar qualquer ' ' (espaço vazio), return false: ainda tem espaço, então não deu Idosa.
    public boolean verificarIdosa() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true; // Detalhe: esse return true está fora pois só dará idosa se todos estiverem preenchidos. E se sabe disso depois de percorrer tudo.
    }
}