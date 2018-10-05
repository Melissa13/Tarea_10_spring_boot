<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/alquiler/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Alquileres pendientes a devolucion</em> - Lista</h1></center>
    </div>
    <legend></legend>
    <div >

    <#if lista??>
        <center>
            <div style="overflow-x:auto;">
                <table>
                    <tr><th>ID</th>
                        <th>Cliente</th>
                        <th>Equipos</th>
                        <th>Pendiente</th>
                        <th>Ver</th>
                        <th>Editar</th>
                        <th>Borrar</th>
                    </tr>
                                <#list lista as equipo>
                                <tr><td>${equipo.getId()?string["0"]}</td>
                                    <td>${equipo.getCliente().getNombre()}</td>
                                    <th>
                                    <#if lista??>
                                    <#list equipo.getEquipo() as estos>
                                        ${estos.getAsociado().getNombre()},
                                    </#list>
                                    </#if>
                                    </th>
                                    <th>${equipo.isPendiente()?string('Si','No')}</th>
                                    <td><a href="/alquiler/ver/${equipo.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Ver Factura</a></td>
                                    <td><a href="/alquiler/edit/${equipo.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Editar</a></td>
                                    <td><a href="/alquiler/delete/${equipo.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Borrar</a></td>
                                </tr>
                                </#list>
                </table>
            </div>
        </center>
    <#else >
        <center>
            <h2> No hay alquileres registrados en el Sistema</h2>
        </center>
    </#if>
        <legend></legend>
        <br/>
        <br/>

    </div>
</section>
</#macro>