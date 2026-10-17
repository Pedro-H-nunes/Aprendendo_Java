package Jogo_da_idosa; //Aqui diz qual pacote essa classe está pertencendo (toda vez que se cria uma classe dentro de uma pasta/pacote, o Java registra. Imagino eu que um dos motivos é evitar a confusão do usuário.)
import javax.swing.*; //Importei tudo (*) da classe Swing, daqui que surge o JFrame, JPanel, JButton... etc.
import java.awt.*; //Também importei tudo da awt (Abstract Window Toolkit) tradução: Kit de Ferramentas de Janela Abstrata.
import java.awt.event.*; // Entretanto tive que especificar que queria as ferramentas da .event para trazer a ActionListener e ActionEvent para meu código pois ActionListener e ActionEvent ficam no pacote 'event', que é separado do 'awt'.



public class Jogo { // Aqui revelo que a classe é pública (as outras podem acessar) e recebe o nome 'Jogo'.

    // ATRIBUTOS: São variáveis que pertecem ao objeto, estou fazendo a associação entre Tipo x Atributo (o private faz com que só essa classe manipule elas)
    // Detalhe: o boolean representa uma escolha entre true x false.
    private Tabuleiro tabuleiro;
    private Jogador jogadorX;
    private Jogador jogadorO;
    private Jogador jogadorAtual;
    private boolean jogoAcabou;


    // CONSTRUTOR: Este é um metodo especial, ele só roda uma vez quando o objeto é criado (new Jogo())
    //Detalhes: this aponta para o objeto atual; new cria um objeto novo onde jogadorAtual = jogadorX não tem new (demorei a entender que se trata de uma referência ao que já existe e não um 'jogador novo')
    // respectivamente: criei o Tabuleiro, criei os dois jogadores 'X e O', indiquei que o jogador atual é 'X' e revelei que o jogo não acabou.
    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        this.jogadorX = new Jogador('X');
        this.jogadorO = new Jogador('O');
        this.jogadorAtual = jogadorX;
        this.jogoAcabou = false;
    }


    // INICIADOR: Daqui em diante está toda parte mais gráfica, aqui entra JFrame e todas as ferramentas importadas anteriormente.
    //respectivamente: Criei a janela principal (sendo o JFrame que representa essa janela), defini o título da janela, defini seu tamanho (700x700)...
    // Peguei a área de conteúdos da janela para pintar de preto (embreve atualizarei esse projeto e o fundo terá sua devida função ).
    public void iniciar() {
        JFrame janela = new JFrame();
        janela.setTitle("Jogo da Idosa - Versão 1.0");
        janela.setSize(700, 700);
        janela.getContentPane().setBackground(new Color(0, 0, 0));

        JPanel painel = new JPanel(); // Criei um painel
        painel.setLayout(new GridLayout(3, 3)); // Defini o Layout do Painel com a grade: 3x3 (linha x coluna)
        for (int i = 0; i < 9; i++) { // Aqui fiz um loop que roda 9 vezes (uma para cada botão).
            final int posicao = i; // Copiei o valor de i para uma variável final
            // (devido de que usei o ActionListener, ele vai rodar depois (quando clicar). Nesse momento o i vai ter mudado, essa linha garante que cada posição tenha sua própia posicao.
            JButton botao = new JButton(); // Criei um botão vazio.
            painel.add(botao); // Adicionei no painel.

            botao.addActionListener(new ActionListener() { //botao.addAction Listener é uma ferramenta ouvinte, ele fica esperando o clique.
                @Override // É uma anotação que diz 'esse metodo sobrescreve um da interface.'
                public void actionPerformed(ActionEvent e) {  //Esse é o metodo que roda quando o botão é clicado, ActionEvent e (serve para atribuir informações sobre o clique)

                    if (jogoAcabou) return; //Aqui diz que se o jogo acabou, deve sair do metodo imediatamente.
// Detalhe: depois que um jogador ganha (ou dá velha), os cliques não devem fazer mais nada.
                    int linha = posicao / 3; // Converte a posição (0 a 8) em linha (0 a 2).
                    //Ex: posicão 4 -> 4 / 3 = 1 (linha 1)
                    int coluna = posicao % 3; // Converte a posição em coluna (0 a 2)
                    //Ex: posição 4 -> 4 % 3 = 1 (coluna 1)

                    char simbolo = jogadorAtual.getSimbolo(); //Pega o símbolo de quem tá jogando agora ('X' ou 'O') e chama o getter do Jogador.

                    if (tabuleiro.registrarJogada(linha, coluna, simbolo)) { // chama o metodo do Tabuleiro, retorna true se
                        // a jogada foi válida (posição vazia), retorna false se
                        // a posição estava ocupada
                        botao.setText(String.valueOf(simbolo)); // Muda o texto do botão pro símbolo.
                        // o String.valueOf(simbolo) converte char pra String. (E isso é devido de que o setText só aceita texto sendo que simbolo é char)

                        if (tabuleiro.verificarVitoria(simbolo)) { //Verifica se quem acabou de jogar venceu. (Recebe o simbolo porque o Tabuleiro precisa saber quem ele tá checando)

                            JOptionPane.showMessageDialog(null, "Vencedor: Jogador "+ simbolo); // Abre uma caixinha com uma mensagem, nesse caso: "Vencedor: Jogador " (+ simbolo)
                            // detalhe: O null não define a janela pai.
                            jogoAcabou = true; //Marca que o jogo terminou.
                        } else if (tabuleiro.verificarIdosa()) { //Se não houver vitória, verifica velha (tabuleiro cheio).
                            JOptionPane.showMessageDialog(null, "deu velha, digo... Idosa!"); // Mensagem de dar Velha... quer dizer, Idosa.
                            jogoAcabou = true; // Marca que o jogo terminou. (de outra maneira, dessa vez)
                        }


                      // Trocando de jogador com if loop.
                        if (jogadorAtual == jogadorX) { //Se jogador atual for igual ao jogador X
                            jogadorAtual = jogadorO; // Atribua o jogador atual ao jogador O
                        } else { // Ao contrário
                            jogadorAtual = jogadorX; // Atribua o jogador Atual ao jogador X mesmo.
                        }
                    }


                }
            });
        }




        janela.add(painel); // Adicionei o painel dentro da janela.
        janela.setVisible(true); //Deixei a janela visível (se não não vai dar para ver né (risos.txt))

    }

    public static void main(String[] args) { // public == visível para qualquer outra classe (a JVM precisa disso para chamar o main); static == não depende de objeto; void == não retorna nada; String[]args == argumentos da linha de comando.
        Jogo jogo = new Jogo(); //Criei um objeto jogo. Isso chama o construtor, que cria tabuleiro, jogadores... etc.
        jogo.iniciar(); //iniciar
    }
}

