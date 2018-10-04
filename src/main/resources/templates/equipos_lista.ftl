<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/equipo/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Equipos</em> - Lista</h1></center>
    </div>
    <legend></legend>
    <div >

    <#if lista??>
        <center>
            <div style="overflow-x:auto;">
                <table>
                    <tr><th>ID</th>
                        <th>Nombre</th>
                        <th>Ver</th>
                        <th>Editar</th>
                        <th>Borrar</th>
                    </tr>
                                <#list lista as equipo>
                                <tr><td>${equipo.getId()?string["0"]}</td>
                                    <td>${equipo.getNombre()}</td>
                                    <td><a href="/equipo/ver/${equipo.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Ver</a></td>
                                    <td><a href="/equipo/edit/${equipo.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Editar</a></td>
                                    <td><a href="/equipo/delete/${equipo.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Borrar</a></td>
                                </tr>
                                </#list>
                </table>
            </div>
        </center>
    <#else >
        <center>
            <h2> No hay equipos registrados en el Sistema</h2>
        </center>
    </#if>
        <legend></legend>
        <br/>
        <br/>

    </div>
</section>
</#macro>