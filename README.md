# Sistema Bancario

### 1. Cadastra PessoaS com os seguintes dados:
		Nome
        Tipo: Pessoa Física(PF) ou Juridica(PJ)
        Numero de documento (Tamanho 11 caso PF e tamanho 14 caso PJ)
        Score da pessoa (Valor randômico de 0 a 9)

### 2. Ao cadastrar uma pessoa, automaticamente, abrirá um conta corrente vinculada a essa pessoa, com os seguinte dados:
        Numero (6 digitos gerados únicos e gerados automaticamente)
        Agência (Parametrizavél via configuração)
        Tipo: Corrente (C) ou Empresarial (E) -> Selecinado automaticamente conforme a pessoa recebida
        Vinculo com a pessoa a qual a conta se refere

### 3. Após o cadastro da conta, serÁ criados o limite de cheque especial e um cartão de crédito, vinculados a conta criada, caso atendam os seguintes critérios:
        Se score for 0 ou 1, o limite de cheque especial estará desabilitado e não irá gerar cartão de crédito.
        Se score for entre 2 e 5 o limite de cheque especial será de R$ 1000,00 e o limite do cartão de crédito criado será de R$ 200,00
        Se score for entre 6 e 8 o limite de cheque especial será de R$ 2000,00 e o limite do cartão de crédito criado será de R$ 2000,00
        Se score for 9 o limite de cheque especial será de R$ 5000,00 e o limite do cartão de crédito criado será de R$ 15000,00
        *As faixas de limite poder ser parametrizaveis
    
### 4. DisponibilizaDO um endpoint em REST que liste as pessoas e outro que liste as contas e seus respectivos limites / cartões.]
        http://localhost:8080/contas
        http://localhost:8080/pessoas
