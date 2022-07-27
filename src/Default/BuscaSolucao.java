package Default;

import busca.Estado;

import java.util.ArrayList;
import java.util.List;

public class BuscaSolucao implements Estado {

    private String[][] tabuleiro;

    public BuscaSolucao(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String getDescricao() {
        return "Resolver Busca";
    }

    @Override
    public boolean ehMeta() {
        Boolean isMeta = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (isMeta){
                    if (tabuleiro[i][j].charAt(0) != '0') {
                        if (i == 0 && j == 0) { //canto superior esquerdo
                            if (tabuleiro[i][j].charAt(1) == '0') {
                                if (tabuleiro[i][j].charAt(4) == '0') {
                                    if (tabuleiro[i][j].charAt(2) == tabuleiro[i][j+1].charAt(4)) {
                                        if (tabuleiro[i][j].charAt(3) != tabuleiro[i+1][j].charAt(1)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        } else if (i == 0 && j == 3) { //canto superior direito
                            if (tabuleiro[i][j].charAt(1) == '0') {
                                if (tabuleiro[i][j].charAt(2) == '0') {
                                    if (tabuleiro[i][j].charAt(3) == tabuleiro[i+1][j].charAt(1)) {
                                        if (tabuleiro[i][j].charAt(4) != tabuleiro[i][j-1].charAt(2)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        } else if (i == 3 && j == 0) { //canto inferior esquerdo
                            if (tabuleiro[i][j].charAt(3) == '0') {
                                if (tabuleiro[i][j].charAt(4) == '0') {
                                    if (tabuleiro[i][j].charAt(1) == tabuleiro[i-1][j].charAt(3)) {
                                        if (tabuleiro[i][j].charAt(2) != tabuleiro[i][j+1].charAt(4)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        } else if (i == 3 && j == 3) { //canto inferior direito
                            if (tabuleiro[i][j].charAt(2) == '0') {
                                if (tabuleiro[i][j].charAt(3) == '0') {
                                    if (tabuleiro[i][j].charAt(1) == tabuleiro[i-1][j].charAt(3)) {
                                        if (tabuleiro[i][j].charAt(4) != tabuleiro[i][j-1].charAt(2)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        } else if (i == 0) { //lado superior
                            if (tabuleiro[i][j].charAt(1) == '0') {
                                if (tabuleiro[i][j].charAt(2) == tabuleiro[i][j+1].charAt(4)) {
                                    if (tabuleiro[i][j].charAt(3) == tabuleiro[i+1][j].charAt(1)) {
                                        if (tabuleiro[i][j].charAt(4) != tabuleiro[i][j-1].charAt(2)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        } else if (i == 3) { //lado inferior
                            if (tabuleiro[i][j].charAt(3) == '0') {
                                if (tabuleiro[i][j].charAt(1) == tabuleiro[i-1][j].charAt(3)) {
                                    if (tabuleiro[i][j].charAt(2) == tabuleiro[i][j+1].charAt(4)) {
                                        if (tabuleiro[i][j].charAt(4) != tabuleiro[i][j-1].charAt(2)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        } else if (j == 0) { //lado esquerdo
                            if (tabuleiro[i][j].charAt(4) == '0') {
                                if (tabuleiro[i][j].charAt(1) == tabuleiro[i-1][j].charAt(3)) {
                                    if (tabuleiro[i][j].charAt(2) == tabuleiro[i][j+1].charAt(4)) {
                                        if (tabuleiro[i][j].charAt(3) != tabuleiro[i+1][j].charAt(1)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        } else if (j == 3) { //lado direito
                            if (tabuleiro[i][j].charAt(2) == '0') {
                                if (tabuleiro[i][j].charAt(1) == tabuleiro[i-1][j].charAt(3)) {
                                    if (tabuleiro[i][j].charAt(3) == tabuleiro[i+1][j].charAt(1)) {
                                        if (tabuleiro[i][j].charAt(4) != tabuleiro[i][j-1].charAt(2)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        } else {
                            if (tabuleiro[i][j].charAt(1) == tabuleiro[i-1][j].charAt(3)) {
                                if (tabuleiro[i][j].charAt(2) == tabuleiro[i][j+1].charAt(4)) {
                                    if (tabuleiro[i][j].charAt(3) == tabuleiro[i+1][j].charAt(1)) {
                                        if (tabuleiro[i][j].charAt(4) != tabuleiro[i][j-1].charAt(2)) {
                                            isMeta = false;
                                        }
                                    } else {
                                        isMeta = false;
                                    }
                                } else {
                                    isMeta = false;
                                }
                            } else {
                                isMeta = false;
                            }
                        }
                    }
                }
            }
        }
        return isMeta;
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public List<BuscaSolucao> sucessores() {

        List<BuscaSolucao> succ = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tabuleiro[i][j].charAt(0) != '0' && tabuleiro[i][j].charAt(0) != '1'){
                    if (tabuleiro[i][j].charAt(0) == '2'){
                        String[][] cop = clonar();
                        cop[i][j] = girar(cop[i][j]);
                        succ.add(new BuscaSolucao(cop));
                    }
                }
            }
        }
        return null;
    }

    private String[][] clonar(){
        String[][] copia = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copia[i][j] = tabuleiro[i][j];
            }
        }
        return copia;
    }

    private String girar(String valor){
        String retorno = valor.substring(0,1).concat(valor.substring(4,5).concat(valor.substring(1,4)));
        return retorno;
    }
}
