<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/historial/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <#if cli??>
    <div class="section-heading separador">
        <center><h1><em>Cliente ${cli.getNombre()}</em> - Lista</h1></center>
    </div>
    <legend></legend>
    <div >

    <#if lista??>
        <#if lista?has_content>
        <center>
            <div style="overflow-x:auto;">
                <table>
                    <tr><th>ID</th>
                        <th>Cliente</th>
                        <th>Equipos</th>
                        <th>Cant. T.</th>
                        <th>Pendiente</th>
                        <th>Costo T.</th>
                        <th>Fecha prestamo</th>
                        <th>Fecha entrega</th>
                    </tr>
                                <#list lista as equipo>
                                <tr><td>${equipo.getId()?string["0"]}</td>
                                    <td>${equipo.getCliente().getNombre()}</td>
                                    <td>
                                    <#if lista??>
                                    <#list equipo.getEquipo() as estos>
                                        ${estos.getAsociado().getNombre()} ${estos.getCantidad()},
                                    </#list>
                                    </#if>
                                    </td>
                                    <td>${equipo.cantidade()?string["0"]}</td>
                                    <td>${equipo.isPendiente()?string('Si','No')}</td>
                                    <td>${equipo.total()?string["0"]}</td>
                                    <td>${equipo.getExtra1()}</td>
                                    <td>${equipo.getExtra2()}</td>
                                </tr>
                                </#list>
                </table>
            </div>
        </center>
    <#else >
        <center>
            <h2> No hay alquileres registrados en el Sistema de este cliente</h2>
        </center>
    </#if>
    </#if>
        <#else>
    <center>
        <h2> Cliente no se encuentra en el sistema</h2>
    </center>
        </#if>
        <legend></legend>
        <br/>
        <br/>

    </div>
</section>
</#macro>