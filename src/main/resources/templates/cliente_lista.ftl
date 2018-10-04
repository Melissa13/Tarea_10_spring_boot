<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/client/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Clientes</em> - Lista</h1></center>
    </div>
    <legend></legend>
    <div >

    <#if lista??>
        <center>
            <div style="overflow-x:auto;">
            <table>
                <tr><th>Cedula</th>
                    <th>Nombre</th>
                    <th>Ver</th>
                    <th>Editar</th>
                    <th>Borrar</th>
                </tr>
                                <#list lista as cliente>
                                <tr><td>${cliente.getCedula()?string["0"]}</td>
                                    <td>${cliente.getNombre()}</td>
                                    <td><a href="/client/ver/${cliente.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Ver</a></td>
                                    <td><a href="/client/edit/${cliente.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Editar</a></td>
                                    <td><a href="/client/delete/${cliente.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Borrar</a></td>
                                </tr>
                                </#list>
            </table>
            </div>
        </center>
    <#else >
        <center>
            <h2> No hay clientes registrados en el Sistema</h2>
        </center>
    </#if>
        <legend></legend>
        <br/>
        <br/>

    </div>
</section>
</#macro>