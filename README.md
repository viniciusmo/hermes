Hermes
======

## O que é ?
  É a implementação de um aplicativo com interface específica que funciona como intermediário na comunicação entre portadores de necessidades especiais verbal e auditiva e pessoas ouvintes e falantes.
  
## O projeto

O logotipo do aplicativo representa a letra H feita em libras.

!["Imagem 1"][1]

O aplicativo **Hermes** tem a proposta de auxiliar a comunicação entre pessoas com necessidades especiais, para isso o sistema esta dividido em três módulos: **libras,texto e imagens**.
Na tela inicial, exibem-se botões grandes e com ícones de forma gráfica, para facilitar o entendimento dos usuários que possuem necessidades especiais. Na imagem a seguir, mostra-se a tela inicial do aplicativo.

!["Imagem 2"][2]

O primeiro botão da tela inicial direciona para a tela correspondente ao módulo **Áudio para Libras** , que exibe uma tela com a opção de capturar o áudio. O usuário, ao selecionar o botão localizado no centro da tela deve dizer claramente e próximo ao microfone do dispositivo utilizado, a palavra ou a sentença que deseja que seja convertida para Libras. Na figura a seguir, é mostrado o módulo **Áudio para Libras**.

!["Imagem 3"][3]

O áudio é enviado via Stream para o serviço da API de áudio do Google®. e o retorno dessa chamada é um objeto do tipo String, que será tratado dentro do 
aplicativo. As letras desse retorno são tratadas individualmente e para cada uma,é exibida a libra correspondente, as imagens ficam localizadas no banco de dados local do próprio aplicativo, como mostra a figura a seguir. 

!["Imagem 4"][4]


Quando a palavra obtida do retorno tiver um vídeo, ele será exibido no canto inferior direito. Ao selecionar o botão com o ícone de vídeo, o usuário entrará no aplicativo do YouTube© e o vídeo relacionado será exibido, como mostra a figura a seguir. 

!["Imagem 5"][5]

O segundo botão da tela inicial, direciona o usuário para o módulo **Texto para Áudio**.Esse módulo contém uma simples caixa de 
texto, na qual, utilizando o teclado do dispositivo, o usuário informa uma palavra  ou sentença e, ao selecionar o botão de reprodução de áudio, a API de áudio do Google® envia um objeto do tipo String e recebe como retorno uma stream com o áudio, que é reproduzida pelo dispositivo utilizando as caixas de som internas. Caso o dispositivo esteja conectado a uma fonte de som externa, o áudio será reproduzido no dispositivo externo. Na a seguir, é mostrado tela do módulo **Texto para Áudio**.  
  
!["Imagem 6"][6]

O segundo botão da tela inicial, direciona o usuário para o módulo **Texto para Áudio**. Esse módulo contém uma simples caixa de 
texto, na qual, utilizando o teclado do dispositivo, o usuário informa uma palavra ou sentença e, ao selecionar o botão de reprodução de áudio, a API de áudio do Google® envia um objeto do tipo String e recebe como retorno uma stream com o áudio, que é reproduzida pelo dispositivo utilizando as caixas de som internas. Caso o dispositivo esteja conectado a uma fonte de som externa, o áudio será reproduzido no dispositivo externo. Na imagem a  seguir, é mostrado tela do módulo **Texto para Áudio**.
  
!["Imagem 7"][7]

Ao selecionar o pronome, é reproduzido um áudio referente ao pronome selecionado. O próximo passo é selecionar um verbo entre os três disponíveis:vou, quero e estou, e assim como na tela anterior, o áudio do verbo selecionado é reproduzido instantaneamente. Na imagem a seguir, são mostrados os verbos do módulo **Imagem para Áudio**.  
  
!["Imagem 8"][8]

No último passo do módulo, o usuário escolhe a ação concluindo a frase desejada.Essas ações são obtidas utilizando o Web Service implementado no Hermes,ou seja, para inserir novas ações neste módulo, a aplicação não necessita ser atualizada ou recompilada: ao abrir o aplicativo essa tela é automaticamente atualizada caso exista uma conexão com a internet ativa. Na imagem a seguir, é mostrada a ação que o usuário escolheu.

!["Imagem 9"][9]

Com base nas informações de acessibilidade digital para pessoas especiais, o projeto de interface do aplicativo Hermes busca atender e facilitar a interação entre usuário e máquina.
  

  [1]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image1.jpg
  [2]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image2.png
  [3]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image3.png
  [4]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image4.png
  [5]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image5.png
  [6]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image6.png
  [7]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image7.png
  [8]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image8.png
  [9]: https://raw.githubusercontent.com/viniciusmo/viniciusmo.github.com/master/images/blog/opensource/hermes/image9.png
