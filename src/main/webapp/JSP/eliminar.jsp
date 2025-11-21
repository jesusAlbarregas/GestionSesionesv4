<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Eliminar sesi&oacute;n</title>
        <link rel="stylesheet" type="text/css" href="${estilos}" media="screen" />
    </head>
    <body>
        <div id="principal">
            <h2>¿Seguro que quieres eliminar este atributo de sesi&oacute;n?</h2>
            <div id="secundario">
                
                <form action="${contexto}/Gestion" method="post">
                    <table>
                        <tr>
                            <td><label for="ident">Id:</label></td>
                            <td>${sessionScope.cliente.idCliente}</td>
                        </tr>
                        <tr>
                            <td><label for="nb">Nombre:</label></td>
                            <td>${sessionScope.cliente.nombre}</td>
                        </tr>
                        <tr>
                            <td><label for="fc">Fecha:</label></td>
                            <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${sessionScope.cliente.fecha}" /></td>
                            
                        </tr> 

                        <tr>
                            <td><label for="cd">Tipo identificaci&oacute;n:</label></td>
                            <td>${sessionScope.cliente.tipoIdentificacion}</td>
                        </tr>

                        <tr>
                            <td><label for="ide">Identificaci&oacute;n:</label></td>
                            <td>${sessionScope.cliente.identificacion}</td>
                        </tr>
                        <tr>
                            <td style="text-align: center;"><input type="submit" name="enviar" value="Cancelar"></td>
                            <td style="text-align: center;"><input type="submit" name="enviar" value="Eliminar"></td>
                        </tr>
                    </table>

                </form>
            </div>
        </div>
    </body>
</html>
