/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Default;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.swing.*;
import busca.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static javax.swing.text.StyleConstants.setIcon;

/**
 *
 * @author andreellias18
 */
public class Tabuleiro extends JFrame{

    JPanel pTela = new JPanel(new GridLayout(4, 4));
    JPanel pBottom = new JPanel(new GridLayout(1,4,10,10));

    Bloco[] blocos = new Bloco[16];
    String[][] MatrizCarregada = new String[4][4];

    JButton carregar = new JButton("Carregar");
    JButton lagrgura = new JButton("Largura");
    JButton profundidade = new JButton("Profundidade");
    JButton sobre = new JButton("Sobre");

    String fase = "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0";

    public Tabuleiro() {

            configurarJanela();
            configurarTela(fase);
    }

    public void configurarTela(String matriz) {
            add(BorderLayout.CENTER,pTela);
            add(BorderLayout.SOUTH,pBottom);
            pBottom.add(carregar);
            pBottom.add(lagrgura);
            pBottom.add(profundidade);
            pBottom.add(sobre);
            pTela.setBackground(Color.WHITE);
            pTela.setBorder(BorderFactory.createLineBorder(Color.black));

            String[] matrisSplit = matriz.split(",");
            for(int i=0;i<16;i++) {
                    Bloco bloco = new Bloco(matrisSplit[i]);
                    bloco.setBorder(BorderFactory.createLineBorder(Color.black));
                    blocos[i] = bloco;
                    pTela.add(bloco);
            }
            acaoCarregar(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser JFileChooser = new JFileChooser();
                    int resposta = JFileChooser.showOpenDialog(null);
                    if (resposta == JFileChooser.APPROVE_OPTION){
                        File arquivo = JFileChooser.getSelectedFile();
                        Path caminho = Path.of(arquivo.getPath());
                        try {
                            fase = Files.readString(caminho);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    carregarFase(fase);
                }
            });

            acaoBuscaLargura(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BuscaSolucao inicial = new BuscaSolucao(MatrizCarregada);
                    Nodo n;
                    n = new BuscaLargura<BuscaSolucao>(new MostraStatusConsole()).busca(inicial);
                    if (n == null){
                        System.out.println("sem solução");
                    }else{
                        System.out.println("Profundidade: "+n.getProfundidade());
                        System.out.println("Solucao:\n" + n.montaCaminho() + "\n\n");
                    }
                }
            });

            acaoBuscaProfundidade(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //
                }
            });
    }

    public void carregarFase(String dados){
        String[] matrisSplit = dados.split(",");
        for(int i=0;i<16;i++) {
            blocos[i].setTipo(matrisSplit[i]);
        }

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrisSplit[index] == "0"){
                    MatrizCarregada[i][j] = "00000";
                }else{
                    MatrizCarregada[i][j] = matrisSplit[index];
                }
                index++;
            }
        }
    }

    public void configurarJanela() {
            setTitle("Conecte-me");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(500,500);
            setLocationRelativeTo(null);
            setVisible(true);
    }

    public void acaoCarregar(ActionListener acao){
        carregar.addActionListener(acao);
    }

    public void acaoBuscaLargura(ActionListener acao){
        lagrgura.addActionListener(acao);
    }

    public void acaoBuscaProfundidade(ActionListener acao){
        profundidade.addActionListener(acao);
    }
}
