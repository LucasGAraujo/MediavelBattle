import com.mycompany.medievalbattle.RelatorioDeJogador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Testarvaloresescrito {

    private RelatorioDeJogador relatorio;

    @BeforeEach
    void setUp() {
        relatorio = new RelatorioDeJogador();
    }

    @Test
    void testObterHeroiMaisJogado() {
        String heroimaisenfrentado = relatorio.getHeroiMaisJogado();
        assertEquals(heroimaisenfrentado, relatorio.obterHeroiMaisJogado());
    }

    @Test
    void testObterMonstroMaisEnfrentado() {
        String expectedMonstro = relatorio.getMonstroEnfrentado();
        assertEquals(expectedMonstro, relatorio.obterMonstroMaisEnfrentado());
    }
}