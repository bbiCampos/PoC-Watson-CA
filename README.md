#PoC-Watson-CA
 
Olá!
Após rodar esse projeto, copie o conteúdo do arquivo "cURL request.txt" no seu terminal e no campo "message" digite o que vc espera que seja testado pela IA, considerando que o contexto para essa aplicação é um canal de cobrança da sky (ativo).


Até o momento a IA entende sobre:

*script inicial

*justificativa de ausência

*pesquisa de satisfação

*finalização de atendimento

*identifica palavras ofensivas

*identifica cpf, cnpj, email, valores monetários, datas

*registra as duas principais intenções de cada mensagem


Todo o aprendizado de máquina não é possivel de ser exportado, contudo, as skills, intents e entities podem ser exportadas.

O projeto considera que a cada nova mensagem enviada para análise, seja ela do cliente ou do operador, é criado um novo contexto. Na linguagem do Customer Analytics, a cada posição dentro de "sentences" tem seu proprio contexto, mas isso pode ser alterado.
