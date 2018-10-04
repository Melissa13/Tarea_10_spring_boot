<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/client/lista" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <#if cliente??>
    <div class="section-heading separador">
        <center><h1><em>Clientes ID:#${cliente.getId()?string["0"]}</em> - Datos</h1></center>
    </div>
    <legend></legend>
    <div>
    <div class="row2">
        <div class="col-md-4 input-separador">
            <label>Cedula</label>
            <h4>${cliente.getCedula()?string["0"]}</h4>
        </div>
        <div class="col-md-4 input-separadorb">
            <label>Nombre</label>
            <h4>${cliente.getNombre()}</h4>
        </div>
    </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Fecha de Nacimiento</label>
                    <h4>${cliente.getBirth_date()}</h4>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Lugar de nacimiento</label>
                    <h4>${cliente.getBirth_place()}</h4>
                </div>
            </div>
            <div class="row2">
                <center>
                    <div style="margin-left: 560px; margin-top: 20px">
                        <label>Genero</label>
                        <h4>${cliente.getExtra()}</h4>
                    </div>
                </center>
            </div>
    <#else >
        <center>
            <h2> No Existe tal cliente</h2>
        </center>
    </div>
    </#if>
        <legend></legend>
        <br/>
        <br/>

</section>
</#macro>