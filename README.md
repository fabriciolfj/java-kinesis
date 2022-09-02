# Kineses
- é uma plataforma de dados de streaming (fluxo de dados continuo)
- gerenciada para processamento

## Kinesis especializados

#### Kinesis data streams(KDS)
- captura dados produzidos por diversas fontes em tempo real
- aplicativos consumidores se conectam ao fluxo para leem tais dados

#### Kinesis data firehouse(KDF)
- não precisamos gerenciar recursos e criar produtores
- configuramos o mesmo para produzir dados e este os envia ao destino configurado
- ideal para pegar dados, transformar os mesmos, e envia ao destino 
  - simular ao processing do quarkus ou a function do spring cloud stream

#### Kinesis data analytics(KDA)
- consome dados de um streaming
- fornece operadores para serem utilizados no fluxo de dados

#### Kinesis video streams(KVS)
- destino a reprodução de midia.

## Uso do kinesis
- configuramos um fluxo de dados (seria o topic do kafka)
- criamos os aplicativos produtores para enviarem dados a este fluxo
- aplicativos consumidores leen e processam dados deste fluxo
- ele e composo por fragmentos sequencias (similar as partições do kafka) e dentro destes estão os registros (records) também sequencias
- a capacidade do fluxo e a soma total de dados de todos os fragmentos
- ja os registros possuem:
  - uma número de sequência - identificador exclusivo do registro (similar ao offset do kafka)
  - uma chave de partição - usada para segregar e rotear registros para diferentes fragmentos
  - um blob com os dados (tamanho máximo 1 mb)