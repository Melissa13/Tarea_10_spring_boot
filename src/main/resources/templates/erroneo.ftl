<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/equipo/lista" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <#if equipo??>
    <div class="section-heading separador">
        <center><h1><em>Equipo ID:#${equipo.getId()?string["0"]}</em> - Error</h1></center>
    </div>
    <legend></legend>
    <div>
        <center><h3><span style="color: darkorange"> <b>Advertencia:</b> Todos los datos modificados excepto la cantidad devido a <br/>
            problemas de persistencia con la cantidad actial y las existencias <br/>
            del equipo que han sido prestadas </span></h3></center>
    <#else >
        <center>
            <h2> No Existe tal equipo</h2>
        </center>
    </div>
    </#if>
    <legend></legend>
    <center><a href="/equipo/lista" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a></center>
    <br/>
    <br/>

</section>
</#macro>