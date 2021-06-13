# Processo Seletivo Orange Talents - ZUP

# Sobre o projeto

API REST que controla veículos de Usuários.

A.) CONTEXTO:
Você está fazendo uma API REST que precisará controlar veículos de usuários.

O primeiro passo deve ser a construção de um cadastro de usuários, sendo obrigatórios: nome, e-mail, CPF e data de nascimento, sendo que e-mail e CPF devem ser únicos.

O segundo passo é criar um cadastro de veículos, sendo obrigatórios: Marca, Modelo do Veículo e Ano. E o serviço deve consumir a API da FIPE (https://deividfortuna.github.io/fipe/) para obter os dados do valor do veículo baseado nas informações inseridas.

O terceiro passo é criar um endpoint que retornará um usuário com a lista de todos seus veículos cadastrados.

Você deve construir 3 endpoints neste sistema, o cadastro do usuário, o cadastro de veículo e a listagem dos veículos para um usuário específico.

No endpoint que listará seus veículos, devemos considerar algumas configurações a serem exibidas para o usuário final. Vamos criar dois novos atributos no objeto do carro, sendo eles:

1.) Dia do rodízio deste carro, baseado no último número do ano do veículo, considerando as condicionais:
<br>
Final 0-1: segunda-feira
<br>
Final 2-3: terça-feira
<br>
Final 4-5: quarta-feira
<br>
Final 6-7: quinta-feira
<br>
Final 8-9: sexta-feira

2.) Também devemos criar um atributo de rodízio ativo, que compara a data atual do sistema com as condicionais anteriores e, quando for o dia ativo do rodizio, retorna true; caso contrario, false.

Exemplo A: hoje é segunda-feira, o carro é da marca Fiat, modelo Uno do ano de 2001, ou seja, seu rodízio será às segundas-feiras e o atributo de rodízio ativo será TRUE.
Exemplo B: hoje é quinta-feira, o carro é da marca Hyundai, modelo HB20 do ano de 2021, ou seja, seu rodizio será às segundas-feiras e o atributo de rodízio ativo será FALSE.

- Caso os cadastros estejam corretos, é necessário voltar o Status 201. Caso hajam erros de preenchimento de dados, o Status deve ser 400.
- Caso a busca esteja correta, é necessário voltar o status 200. Caso haja erro na busca, retornar o status adequado e uma mensagem de erro amigável.


B.) SEU DESAFIO:
Dado que você fosse implementar esse sistema utilizando Java como linguagem e Spring + Hibernate como stacks de tecnologia fundamentais da aplicação: escreva um post de blog explicando de maneira detalhada tudo que você faria para implementar esse código (pense como se estivesse contando para alguém que não manja de programação) 🤓


No texto, queremos que você:

Explique qual linguagem e quais as tecnologias do mundo Spring você usaria.

Conte qual o papel das tecnologias escolhidas e quais benefícios elas trazem para a implementação do código;

Diga quais classes seriam criadas nesse processo e traga trechos autorais explicando a construção de cada classe do código;

Explique as etapas do processo de construção do seu código e como faria a implementação do sistema na Web;

Justifique o modelo de desenvolvimento escolhido em seu projeto;

Traga trechos de códigos autorais que justifiquem a implementação de cada tecnologia;
Evidencie o funcionamento da API (localmente);

Envie o link público do repositório do desafio para avaliação.

Os itens acima são obrigatórios. Mas não se limite! Se quiser escrever mais, fique à vontade. A quantidade mínima de páginas é 5 (cinco) e não existe limite máximo, apenas lembre-se que o seu poder de síntese e de ir direto ao ponto estará a seu favor!


D.) ITEM BÔNUS - Se ficou fácil, te desafiamos a:
Construir a aplicação sem utilizar Lombok;
Desafiamos você a integrar a API da FIPE usando Spring-Cloud-Feign.


C.) DICAS

Não precisamos saber como instalar cada ferramenta, queremos saber como você implementaria o seu código.

Ao justificar as tecnologias, mostre a sua visão e entendimento de cada uma e não conceitos prontos já conhecidos.

Cite as tecnologias que você utilizaria em seu projeto e porquê elas fazem parte do escopo/construção do seu código, pois ficaremos de olho nesse ponto.

Suas classes e atributos podem ser em português ou em inglês, não se apegue a isso, queremos um bom resultado final.

Não queremos um manual de programação e sim um post explicando como você faria a implementação da API passo a passo.

Mais do que respostas certas, queremos ver o quão nerd você consegue ser e o que considera relevante. O importante é mostrar que consegue aprender, se fazer entender e ainda transmitir conhecimento.





# Tecnologias utilizadas
## Back end
- Java 11
- Spring Boot
- JPA / Hibernate
- Maven
- Protocolo HTTP no padrão REST

# Autor

Carlos Augusto de Oliveira
- https://www.linkedin.com/in/carlos-augusto-47a1764a/
- https://oraculocs.github.io


