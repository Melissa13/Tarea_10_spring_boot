<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/equipo/lista" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <#if equipo??>
    <div class="section-heading separador">
        <center><h1><em>Equipo ID:#${equipo.getId()?string["0"]}</em> - Datos</h1></center>
    </div>
    <legend></legend>
    <div>
    <div class="row2">
        <div class="col-md-4 input-separador">
            <label>Nombre</label>
            <h4>${equipo.getNombre()}</h4>
        </div>
        <div class="col-md-4 input-separadorb">
            <label>Costo por unidad ($RD)</label>
            <h4>${equipo.getCosto()?string["0"]}</h4>
        </div>
    </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Familia</label>
                    <h4>${equipo.getFamilia()}</h4>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Sub - Familia</label>
                    <h4>${equipo.getSub_familia()}</h4>
                </div>
            </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Cantidad</label>
                    <h4>${equipo.getCantidad()?string["0"]}</h4>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Disponibles</label>
                    <h4>${equipo.getDisponibles()?string["0"]}</h4>
                </div>
            </div>
    <#else >
        <center>
            <h2> No Existe tal equipo</h2>
        </center>
    </div>
    </#if>
    <legend></legend>
    <br/>
    <br/>

</section>
</#macro>