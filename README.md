
# Adoption Management System 

Literalmente um sistema de gerenciamento de adoções, seguindo o modelo organizacional existente na ONG SJPA. Obviamente não é o melhor modelo a ser adotado, mas é UM modelo mapeado e aqui informatizado (na sua grande maioria).
# Processos mapeados
##### Adoção
![Processo de adoção](https://lh3.googleusercontent.com/i3eaf4v-msEFBkYRLSeoQWtX3zuonFINkhZW0u0Q-WOCOlfYp2U-zziOcz3Psx69Ml0jKI7ItwbzhKr9vrfj-Xomz6egVYUF4IcRjxLgNYSsUgDp30rnrw3DTdt3mJlEmYkYjD5oyz-OaW3Qb8xIy75oEjPPDNsWANnJS9Zo-bYH28GIUfv14l3KnHLHuqSOXxDhhP0vZdfVw4L3f9MvxID_Puh1hulOkfs_omRqAij45VtAo0ExDd1U0k1XOO1nKKpCKRBy6Fswxxf2RihPg6OUXU4Ii4KVnD-ZGI2R5tkBjqak02gudIcAMmmFLiqPPp3AYsx9HMo1Qw0qAaQvEUH2v2vBR2tb4oLuDsT6GLuEdPAAPHCVF7H4JtqH1FyTpbfYdV5jJbFRh0KqbkPtUpmJf2FSni69UkS0v7ZdJURKwgz7p7BZBuyWkuARTymdVD1Jq1WlIpKePY687WKu3selqvJBcdL-bHfBY85y9JBRskt9YaKmHY-bq50GVDAgEa4FbsNTYskm0vO1cGcxdyVN8zaWBGfZgCADdqBkoq01QiG9uZRkP6BO4ymLfxtpfgFwtmH7tmqwLujYKeTPev6qMIRaSYSkPwKe4ZQ=w1366-h557-no)

##### Apadrinhamento
![Processo de apadrinhamento](https://lh3.googleusercontent.com/3pmDeiJvhDTnQnP_iG3RqHJLXh6L9WFJ-bs9rVb6ATLDS1XSe8k_6wW-dFA1t7uIOzXkfeDgFvkYM2Y4rp6SmggJTzGkXriJU3yvr24e6agSllYIrGc1jOUof90ISg8-AYdtI-G9h7uDOyhSI_Yofmshwkh6PFPji7L4kRonVdc5LtxDhlw2LpAMgDGZ0vIkd_5_IvWVtjj3H1Fh7SzvkeNkmaSiW2ZhzPWhSbGo8mgjHXFL_GGFtIyTepYnV7C0Sy3FK48r9cts6zrnp3C2dg4ewB1S8xEH_gruQ6z2P1teeS-iNmjmq1atJMckWOKQUTypuDwWFWtQi6-wOl-kn3cHebtGWRmTB5GjDlaqz74q8pINawniLLhYtoGtYIXsC1DLcBgGzZ_xVgAiYhXIMwrtvbODp_QhoV-H6VMZnpdzd05HkhCW2aVaYHxnFfojIZTU3gEsMngLRv8QZqIXP45HrTLqPFRhFkSjz5fi5FJbPHC33j-pUmdj-lvnl5416RBXPZAJXSiB282GM6ZQfhBy-wFlepLqytEiIf39bM-jSXnEh0ODAelsi2WM-_693w7YRQjfpeRrfDLNMpAP6SpfjBKOX9dezFF5WSM=w845-h655-no)

##### Pós adoção
![Processo de pós adoção](https://lh3.googleusercontent.com/m1hy0BjD0D0pkbizmLnpw1kV1FUEgR7HY-aJ80DPbOUuWWX4Hk_FsdhrMqYX0jpK0QSbw84K7qf78fPaYcAY_o02o1OBwv4QcFVttC7IxM88KUg9ZKHTfIUhcGN3MTSJea4xmRG2MuTjdVNrLLP7FA4vDOGt0cuMPFMyUiRPGt_jFT3g-q7h_b_8Dyp45rE5kiWTcBpNdgdDghuSvby9TlrILDWWfXa5xHH9h2mnB3TOWqvJwbxsM8lGxuMhvEsXOJ_Loxr3-NjDjv7pNP6u4dM2A6CIPjwoRn0RDnyN641O9kykKraZ88lMuyEnwmZEJ0-fwZHjow8Rbjny6NwyuPnNpERd0zsg4b56zRPzJ_Kqo-31rs0l4__ZHzOFumy3jI4mqQ3VrxjOifwkF0Hlmizq8Sdg9pt1dkEsbOAj-bU7SjZ00qxVrDLzh6nxQ5693hLbJlC_2tCGfLABcKQk1ywONBrkD7-kRqAed5fad8dKGEouqqK8A1Bsk1GSnCAhsqVT3eLKH4JxVq0dZ2440cteCAUVOctUSyWU6vRiFI5qorYLfa0SkBhBZA8AUfIOaBmNtKLdzeSulO8CK5gY9LJIT2WzqyHUqKcZ62U=w1060-h655-no)


##  What you'll need

 - JDK 1.8+
 - Maven 3+

## Stack
 - Spring Boot
 - Spring Machine State
 - Spring Security
 - Flyway
 - JUnit
 - MySQL
 - Freemarker
 - JWT

## Features

- Gerenciamento de adoção
-  Gerencia de pós adoção
-  Integração com Instagram

## Run

Para rodar a API do DogTech você precisa de poucos passos:

1. Criar os arquivos no diretório resources>env
    - Arquivo mail.properties:  
    ```bash
    mail.smtp.host=smtp.gmail.com  
    mail.smtp.port=587  
    mail.smtp.username=seuemail@gmail.com  
    mail.smtp.password=senha
    ```
    - Arquivo security.properties:  
    ```bash
    security.secret=senha  
    security.expiration_time=86_400_000  
    security.token_prefix=Bearer 
    security.header_string=Authorization  
    security.sign_up_url=/login/sign-up
    ```
2. Executar no terminal
    ```bash 
    mvn build 
    ```
3. Não se esqueça de adicionar permissão de acesso a aplicações menos seguras na sua conta do google veja o tutorial [aqui](https://support.google.com/accounts/answer/6010255?hl=pt-BR).



## TODO

- Traduzir esse arquivo
- Terminar de escrever esse arquivo
- Ignorar a ordem da lista
