<!DOCTYPE html>
<head>
    <title>Troca de senha</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
            text-align: center;
        }

        table {
            font-size: 17px;
            border-collapse: collapse;
            background-color: #f8f8f8;
            color: black;
        }

        a, span {
            text-decoration: none;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;color:black;">
<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="color: black;">
    <tr>
        <td style="text-align: center;">
            <h3>DogTech</h3>
            <h4>Pedido de alteração de senha</h4>
        </td>
    </tr>
    <tr>
        <td>
            <p>Olá ${name},</p>
            <p>Obrigado por entrar em contato sobre a alteração da sua senha no <b>DogTech!</b>
                <br/>
                Basta <a href="${link}">clicar aqui</a> e seguir as instruções.
                Não se esqueça que sua senha diferencia minúsculas de maiúsculas e que deve ter pelo menos oito
                caracteres.
            </p>
            <p>Você não requisitou alteração da sua senha? ಠ~ಠ<br/>
                Então por gentileza ignore esse e-mail.
            <p>Caso tenha qualquer dúvida entre em contato conosco pelo e-mail <span>ongsjpa@gmail.com</span>.</p>
        </td>
    </tr>
    <tr>
        <td>
            <p>-Galera da SJPA</p>
        </td>
    </tr>
</table>
</body>
</html>