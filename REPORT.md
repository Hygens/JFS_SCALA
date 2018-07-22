# Comentários da Solução

A solução desenhada propõe em algumas partes uma abordagem um pouco
diferente da proposta não apresentando apenas as parcelas selecionadas
como menor Perda, mas, um agrupamento de parcelas com a visualização
crescente de perdas onde sempre em cada bloco o primeiro conjunto de
parcelas representa em valores nominais a menor perda.

O agrupamento além de permitir uma visualização melhor dos dados atenta
para uma massa de dados preparada como insumo para ML.

Não há uma distribuição normal nas parcelas, mas, uma correlação entre
o número de parcelas e total de parcelas geradas em cada caso de forma 
randômica também na geração de valores.

# Tempos de execução

* Foram armazenados os tempos de execução do processo em segundos com a geração do arquivo 
csv de cada processo.

Arquivo Gerado                  Tempo de execução(s) 
Resultado_Perdas_1.csv                 31.85s
Resultado_Perdas_2.csv                 32.157s
Resultado_Perdas_3.csv                 31.433s
Resultado_Perdas_4.csv                 32.198s
Resultado_Perdas_5.csv                 32.382s     

Tempo Médio de Execução: 32.004s                      

 
# Análise

* Numa análise preliminar observei uma certa tendência onde em grande parte dos casos ocorre mais 
de um conjunto de dados representativos da "menor perda" e/ou a "repetição de valores nominais" para 
outros conjuntos de parcelas.

* Em literalmente todos os casos a parcela única detém a maior perda não importando seu valor.

* O aumento da perda é quase linear no conjunto de perdas representando dados com baixa dispersão.


