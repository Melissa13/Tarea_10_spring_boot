<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <#if alq??>
    <a href="/alquiler/ver/${alq.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Alquiler ID:#${alq.getId()?string["0"]}</em> - Error</h1></center>
    </div>
    <legend></legend>
    <div>
        <center><h3><span style="color: darkorange"> <b>Advertencia:</b> No se puede ${msg1} la cantidad <br/>
            alquilada de este equipo debido a : <br/>
            ${ msg2 } </span></h3></center>
    <legend></legend>
    <br/>
    <center><a href="/alquiler/ver/${alq.getId()?string["0"]}" class="btn-normal btn-extra">Volver</a></center>
    <#else >
        <center>
            <h2> No Existe tal Alquiler</h2>
        </center>
    </div>

    <legend></legend>
    </#if>
    <br/>
    <br/>

</section>
</#macro>