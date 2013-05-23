<!DOCTYPE html>
<%@page import="model.Usuario" %>
<html>
  <head>
    <title>Caronas | Inicio</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="estilo.css">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  </head>
  <body>
    <header class="container">
      <h1 id="logo"><a href="index.html">Caronas</a></h1>
      <nav id="menu">
        <ul>
            <% 
                Usuario objUsuarioBean= (Usuario)request.getAttribute("usuarioBean");
                if (objUsuarioBean!=null){
                 String usuario=objUsuarioBean.getUsuario();

              %>
            <li><a href="#.html" class="active">Autorização de usuário</a></li>
            <li><a href="#.html">Cadastro de Rotas</a></li>
                     
        </ul>
      </nav>
    </header>
    <section class="container">
      <article id="form">
        <header>
          <h1>Bem vindo ao sistema de caronas <%= usuario%></h1>
           <%            }    
                else {      
            %>
            <h1>Erro no login!</h1>
            <p> <a href="index.html"> Voltar ao Login</a></p>
             <%      }         %>
        </header>
       </article>
    </section>
    <footer class="container">
      <p>Desenvolvimento Web - UFSCar Sorocaba - 2013</p>
    </footer>
    <script>
      $(document).ready(function(){

      });
    </script>
  </body>
</html>