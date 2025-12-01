<%-- 
    Document   : Pelicula
    Created on : 30/11/2025, 05:58:46 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACCION COMPLETADA</title>
        <link rel="stylesheet" type="text/css" href="css/StyleSheet2.css">
    </head>
    <body>
        <%  
        String nombre = (String) request.getAttribute("jsp_nombre");
        String genero = (String) request.getAttribute("jsp_genero");
        String clasificacion = (String) request.getAttribute("jsp_clasificacion");
        String duracion = (String) request.getAttribute("jsp_duracion"); 
        String director = (String) request.getAttribute("jsp_director");
        String actores = (String) request.getAttribute("jsp_actores"); 
        String sinopsis = (String) request.getAttribute("jsp_sinopsis");
        
        %>
        <div id="content">
            <table class="mitabla" cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="2" class="grilla_cabecera"><h2> NUEVA PELICULA AGREGADA!</h2></td> </tr>
                <tr>
                    <td>Nombre:</td>
                    <td> <%= nombre %> </td>
                </tr>
                <tr>
                    <td>Genero:</td>
                    <td> <%= genero %> </td>
                </tr>
                <tr>
                    <td>Clasificación:</td>
                    <td><%= clasificacion %> </td>
                </tr>
                <tr>
                    <td>Duración:</td>
                    <td> <%= duracion %> </td>
                </tr>
                <tr>
                    <td>Director:</td>
                    <td> <%= director %> </td>
                </tr>
                
                <tr>
                    <td>Actores</td>
                    <td> <%= actores %> </td>
                </tr>
                <tr>
                    <td>Sinopsis</td>
                    <td> <%= sinopsis %> </td>
                </tr>
            </table>
        </div>
                
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" > </script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js" > </script>
        <script type="text/javascript">
            
            $(document).ready(function() {
                
                aparecer = true;
                $(".grilla_cabecera h2").hide();
                setInterval(function() {
                    if(aparecer) {
                        aparecer = false;
                        $(".grilla_cabecera h2").fadeIn("slow");
                        
                    } else {
                         aparecer = true;
                        $(".grilla_cabecera h2").fadeOut("slow");
                    }
                }, 1000);
            });
            
        </script>
    </body>
</html>