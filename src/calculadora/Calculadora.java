package calculadora;

/**
 * Classe responsável por realizar operações matemáticas básicas.
 *
 * @author FinançApp
 * @version 1.0
 */
public class Calculadora {

    /**
     * Cria uma calculadora.
     */
    public Calculadora() {
        // Não há estado interno para inicializar.
    }

    /** Precisão utilizada na comparação de resultados decimais nos testes. */
    public static final double TOLERANCIA = 0.000001;

    /**
     * Executa uma operação matemática entre dois números inteiros.
     * A divisão pode produzir um resultado decimal.
     *
     * @param a primeiro número da operação
     * @param b segundo número da operação
     * @param op operador: "+", "-", "*" ou "/"
     * @return resultado da operação como número decimal
     * @throws IllegalArgumentException quando o operador for nulo ou inválido
     * @throws ArithmeticException quando houver tentativa de divisão por zero
     */
    public double calc(int a, int b, String op) {
        String operador = normalizarOperador(op);

        return switch (operador) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> (double) a * b;
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException(
                    "Operação inválida: '" + operador + "'. Utilize +, -, * ou /."
            );
        };
    }

    /**
     * Normaliza o operador removendo espaços desnecessários.
     *
     * @param operador operador informado pelo usuário
     * @return operador sem espaços nas extremidades
     * @throws IllegalArgumentException se o operador for nulo ou vazio
     */
    private String normalizarOperador(String operador) {
        if (operador == null || operador.isBlank()) {
            throw new IllegalArgumentException("O operador não pode ser nulo ou vazio.");
        }
        return operador.trim();
    }

    /**
     * Realiza a divisão após verificar se o divisor é diferente de zero.
     *
     * @param dividendo número que será dividido
     * @param divisor número pelo qual será feita a divisão
     * @return resultado da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    private double dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
        return (double) dividendo / divisor;
    }

    /**
     * Executa exemplos de operações e demonstra o tratamento de erros.
     * As exceções são tratadas para que uma operação inválida não encerre
     * inesperadamente a execução do programa.
     *
     * @param args argumentos recebidos pela linha de comando
     */
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        String[][] exemplos = {
                {"10", "5", "+"},
                {"10", "5", "-"},
                {"10", "5", "*"},
                {"10", "4", "/"},
                {"10", "0", "/"},
                {"10", "5", "%"}
        };

        for (String[] exemplo : exemplos) {
            int a = Integer.parseInt(exemplo[0]);
            int b = Integer.parseInt(exemplo[1]);
            String operador = exemplo[2];

            try {
                double resultado = calculadora.calc(a, b, operador);
                System.out.printf("%d %s %d = %s%n", a, operador, b, resultado);
            } catch (IllegalArgumentException | ArithmeticException erro) {
                System.out.println("Erro: " + erro.getMessage());
            }
        }
    }
}
