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
      <h1 id="logo"><a href="index.jsp">Caronas</a></h1>
      <nav id="menu">
        <ul>
            <% 
                Usuario objUsuarioBean = (Usuario)request.getAttribute("usuarioBean");
                if (objUsuarioBean!=null){
                 if(objUsuarioBean.getUsuario().equals("adm")){
              %>
            <li><a href="#.jsp" class="active">Autorização de usuário</a></li>
            <li><a href="#.jsp">Cadastro de Rotas</a></li>
            <%
                 }
                }
            %>
        </ul>
      </nav>
    </header>
    <section class="container">
      <article id="form">
        <header>
          <%
          if(objUsuarioBean!=null){
            %>
          <h1>Bem vindo ao sistema de caronas <%= objUsuarioBean.getUsuario() %></h1>
           <%   
            }else {
            %>
            <h1>Erro no login!</h1>
            <p> <a href="index.jsp"> Voltar ao Login</a></p>
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