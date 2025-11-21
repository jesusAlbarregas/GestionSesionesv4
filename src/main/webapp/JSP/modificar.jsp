<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="/INC/metas.inc"/>
        <title>Modificar sesi&oacute;n</title>
        <link rel="stylesheet" type="text/css" href="${estilos}" media="screen" />
    </head>
    <body>
        <div id="principal">
            <h2>Modificar atributo de sesión</h2>
            <div id="secundario">

                <form action="${contexto}/Gestion" method="post">
                    <table>
                        <tr>
                            <td colspan="2" class="error">${requestScope.error}</td>
                        </tr>
                        <tr>
                            <td><label for="ident">Id:</label></td>
                            <td><input name="idCliente" id="ident" value="${sessionScope.cliente.idCliente}" readonly=""></td>
                        </tr>
                        <tr>
                            <td><label for="nb">Nombre:</label></td>
                            <td><input name="nombre" id="nb" value="${sessionScope.cliente.nombre}"></td>
                        </tr>
                        <tr>
                            <td><label for="fc">Fecha:</label></td>
                            
                            <td>
                                <input type="date" name="fecha" id="fc" 
                                       value='<fmt:formatDate pattern = "yyyy-MM-dd" value = "${sessionScope.cliente.fecha}" />'>
                            </td>
                        </tr> 

                        <tr>
                            <td><label for="cd">Tipo identificaci&oacute;n:</label></td>
                            <td>
                                
                                <select name="tipoIdentificacion">
                                    <c:forEach var="elemento" items="${sessionScope.cliente.tipoIdentificacion.values}">
                                        <c:set var="seleccionado" value=""/>
                                        <c:if test="${elemento == sessionScope.cliente.tipoIdentificacion}">
                                            <c:set var="seleccionado" value="selected"/>
                                        </c:if>
                                        <option value="${elemento}" ${seleccionado}>${elemento}</option>
                                    </c:forEach>    
                                    
                                </select>

                            </td>
                        </tr>

                        <tr>
                            <td><label for="ide">Identificaci&oacute;n:</label></td>
                            <td><input name="identificacion" id="ide" value="${sessionScope.cliente.identificacion}"></td>
                        </tr>
                        <tr>
                            <td style="text-align: center;"><input type="submit" name="enviar" value="Cancelar"></td>
                            <td style="text-align: center;"><input type="submit" name="enviar" value="Modificar"></td>
                        </tr>
                    </table>

                </form>
            </div>
        </div>
    </body>
</html>
