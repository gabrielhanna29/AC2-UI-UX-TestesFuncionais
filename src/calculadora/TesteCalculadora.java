package calculadora;

/**
 * Classe de testes unitários simples para a classe {@link Calculadora}.
 * Não exige bibliotecas externas: os testes são executados pelo método main.
 *
 * @author FinançApp
 * @version 1.0
 */
public class TesteCalculadora {

    private final Calculadora calculadora = new Calculadora();
    private int testesExecutados;
    private int testesAprovados;

    /** Cria a suíte de testes e sua calculadora. */
    public TesteCalculadora() {
        // Os campos são inicializados junto com a instância.
    }

    /** Executa todos os cenários de teste da calculadora. */
    public void executarTestes() {
        testarSoma();
        testarSubtracao();
        testarMultiplicacao();
        testarDivisao();
        testarDivisaoPorZero();
        testarOperacaoInvalida();

        System.out.printf("%nResumo: %d/%d testes aprovados.%n",
                testesAprovados, testesExecutados);
    }

    /** Testa a operação de soma: 10 + 5 deve resultar em 15. */
    private void testarSoma() {
        verificarResultado("Soma", 10, 5, "+", 15.0);
    }

    /** Testa a operação de subtração: 10 - 5 deve resultar em 5. */
    private void testarSubtracao() {
        verificarResultado("Subtração", 10, 5, "-", 5.0);
    }

    /** Testa a operação de multiplicação: 10 * 5 deve resultar em 50. */
    private void testarMultiplicacao() {
        verificarResultado("Multiplicação", 10, 5, "*", 50.0);
    }

    /** Testa a divisão: 10 / 4 deve resultar em 2,5. */
    private void testarDivisao() {
        verificarResultado("Divisão", 10, 4, "/", 2.5);
    }

    /** Verifica se a divisão por zero gera a exceção esperada. */
    private void testarDivisaoPorZero() {
        verificarExcecao("Divisão por zero", ArithmeticException.class,
                () -> calculadora.calc(10, 0, "/"));
    }

    /** Verifica se um operador não suportado gera a exceção esperada. */
    private void testarOperacaoInvalida() {
        verificarExcecao("Operação inválida", IllegalArgumentException.class,
                () -> calculadora.calc(10, 5, "%"));
    }

    /**
     * Compara o resultado obtido com o resultado esperado e imprime os dados.
     *
     * @param nome nome do cenário de teste
     * @param a primeiro valor informado
     * @param b segundo valor informado
     * @param operador operação utilizada
     * @param esperado resultado esperado
     */
    private void verificarResultado(String nome, int a, int b,
                                    String operador, double esperado) {
        testesExecutados++;
        try {
            double obtido = calculadora.calc(a, b, operador);
            boolean aprovado = Math.abs(esperado - obtido) < Calculadora.TOLERANCIA;
            registrarResultado(nome, aprovado,
                    String.format("Entrada: %d %s %d | Esperado: %s | Obtido: %s",
                            a, operador, b, esperado, obtido));
        } catch (RuntimeException erro) {
            registrarResultado(nome, false,
                    "Era esperado um resultado, mas ocorreu: " + erro.getMessage());
        }
    }

    /**
     * Verifica se a execução produz o tipo de exceção esperado.
     *
     * @param nome nome do cenário de teste
     * @param tipoEsperado classe da exceção esperada
     * @param acao operação que deverá lançar a exceção
     */
    private void verificarExcecao(String nome,
                                  Class<? extends RuntimeException> tipoEsperado,
                                  AcaoTeste acao) {
        testesExecutados++;
        try {
            acao.executar();
            registrarResultado(nome, false,
                    "Esperado: " + tipoEsperado.getSimpleName() + " | Obtido: nenhuma exceção");
        } catch (RuntimeException erro) {
            boolean aprovado = tipoEsperado.isInstance(erro);
            registrarResultado(nome, aprovado,
                    "Esperado: " + tipoEsperado.getSimpleName()
                            + " | Obtido: " + erro.getClass().getSimpleName()
                            + " — " + erro.getMessage());
        }
    }

    /**
     * Registra e apresenta o resultado de um cenário.
     *
     * @param nome nome do teste
     * @param aprovado indica se o teste passou
     * @param detalhes informações sobre entrada e resultado
     */
    private void registrarResultado(String nome, boolean aprovado, String detalhes) {
        if (aprovado) {
            testesAprovados++;
        }
        System.out.printf("[%s] %s%n  %s%n",
                aprovado ? "APROVADO" : "FALHOU", nome, detalhes);
    }

    /**
     * Executa a suíte de testes.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        new TesteCalculadora().executarTestes();
    }

    /** Representa uma ação que pode lançar uma exceção durante o teste. */
    @FunctionalInterface
    private interface AcaoTeste {
        void executar();
    }
}
