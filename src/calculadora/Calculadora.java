package calculadora;

/**
 * Versão inicial da calculadora do FinançApp.
 *
 * @author FinançApp
 * @version 1.0
 */
public class Calculadora {

    /**
     * Cria uma calculadora.
     */
    public Calculadora() {
        // Não há inicializações adicionais nesta versão.
    }

    /**
     * Executa uma operação matemática básica.
     *
     * @param a primeiro número
     * @param b segundo número
     * @param op operador (+, -, * ou /)
     * @return resultado da operação
     * @throws IllegalArgumentException se o operador for inválido
     * @throws ArithmeticException se houver divisão por zero
     */
    public double calc(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException("O operador não pode ser nulo.");
        }

        switch (op.trim()) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return (double) a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Não é possível dividir por zero.");
                }
                return (double) a / b;
            default:
                throw new IllegalArgumentException("Operação inválida. Utilize +, -, * ou /.");
        }
    }

    /**
     * Demonstra as operações e o tratamento de erros.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        String[][] exemplos = {{"10", "5", "+"}, {"10", "5", "-"},
                {"10", "5", "*"}, {"10", "4", "/"}, {"10", "0", "/"},
                {"10", "5", "%"}};

        for (String[] exemplo : exemplos) {
            int a = Integer.parseInt(exemplo[0]);
            int b = Integer.parseInt(exemplo[1]);
            try {
                System.out.println(a + " " + exemplo[2] + " " + b + " = "
                        + calculadora.calc(a, b, exemplo[2]));
            } catch (IllegalArgumentException | ArithmeticException erro) {
                System.out.println("Erro: " + erro.getMessage());
            }
        }
    }
}
