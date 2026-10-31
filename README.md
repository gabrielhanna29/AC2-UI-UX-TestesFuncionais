# FinançApp — Projeto Calculadora

## 1. Descrição do projeto

O projeto consiste em uma calculadora desenvolvida em Java para compor um módulo básico do aplicativo fictício FinançApp, voltado ao controle de finanças pessoais. A aplicação realiza operações matemáticas fundamentais e apresenta tratamento para entradas inválidas e divisão por zero.

## 2. Objetivo da atividade

Aplicar conceitos de desenvolvimento Java e boas práticas de qualidade de software, incluindo implementação, testes, tratamento de erros, refatoração, documentação JavaDoc e versionamento com Git e GitHub.

## 3. Tecnologias utilizadas

- Java (JDK 21 ou compatível)
- Visual Studio Code ou Eclipse
- Git e GitHub
- JavaDoc

## 4. Estrutura do projeto

```text
projeto_calculadora/
├── src/
│   └── calculadora/
│       ├── Calculadora.java
│       └── TesteCalculadora.java
├── docs/
│   └── index.html
├── README.md
└── .gitignore
```

## 5. Operações disponíveis

| Operação | Símbolo | Exemplo | Resultado |
|---|---|---:|---:|
| Soma | + | 10 + 5 | 15 |
| Subtração | - | 10 - 5 | 5 |
| Multiplicação | * | 10 * 5 | 50 |
| Divisão | / | 10 / 4 | 2,5 |

A divisão por zero é impedida por uma verificação que lança `ArithmeticException`. Operadores inválidos ou vazios são tratados com `IllegalArgumentException`. A aplicação de demonstração captura essas exceções e exibe mensagens sem encerrar inesperadamente o programa.

## 6. Como executar

Com o JDK instalado, abra o terminal na pasta raiz do projeto e execute:

```bash
javac -d out src/calculadora/*.java
java -cp out calculadora.Calculadora
```

## 7. Testes

Para executar os testes:

```bash
java -cp out calculadora.TesteCalculadora
```

A classe `TesteCalculadora` verifica os seguintes cenários:

1. Soma: entrada `10 + 5`; esperado `15`.
2. Subtração: entrada `10 - 5`; esperado `5`.
3. Multiplicação: entrada `10 * 5`; esperado `50`.
4. Divisão: entrada `10 / 4`; esperado `2,5`.
5. Divisão por zero: esperado `ArithmeticException`.
6. Operação inválida (`%`): esperado `IllegalArgumentException`.

Os testes exibem a entrada, o resultado esperado e o resultado obtido. A suíte usa verificações próprias em Java e não depende de bibliotecas externas.

### Evidência da execução dos testes

> **Substitua este espaço por uma captura de tela real** do terminal mostrando a execução de `TesteCalculadora` e os seis testes aprovados.

**Imagem a inserir:** captura de tela do terminal com os seis testes aprovados.

## 8. Refatoração

A branch `Refatoracao` organiza a lógica em métodos menores, com responsabilidades específicas: normalização do operador, validação do divisor e execução da operação. Também utiliza nomes mais claros, documentação JavaDoc e uma estrutura `switch` para selecionar a operação.

Após a refatoração, a suíte de testes deve ser executada novamente para confirmar que o comportamento permaneceu correto.

## 9. Documentação JavaDoc

A documentação HTML é gerada a partir dos comentários JavaDoc presentes nas classes e métodos.

Para gerar novamente a documentação, execute na raiz do projeto:

```bash
javadoc -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 -d docs src/calculadora/Calculadora.java src/calculadora/TesteCalculadora.java
```

Abra `docs/index.html` no navegador para consultar a documentação.

### Evidência da documentação

> **Substitua este espaço por uma captura de tela real** da documentação JavaDoc aberta no navegador.

**Imagem a inserir:** captura de tela do arquivo `docs/index.html` aberto no navegador.

## 10. Repositório remoto

**Link do GitHub:** [INSIRA AQUI A URL DO SEU REPOSITÓRIO]

O repositório deve conter a branch principal (`main`) e a branch `Refatoracao`, além dos commits que registram as etapas de desenvolvimento.

## 11. Autor

Nome: [SEU NOME]
