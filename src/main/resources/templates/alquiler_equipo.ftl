<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <#if alq??>
    <a href="/alquiler/ver/${alq.getId()?string["0"]}" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Alquiler ID:#${alq.getId()?string["0"]}</em> - equipos</h1></center>
    </div>
    <legend></legend>
    <div>

    <form action="/alquiler/agregar/${alq.getId()?string["0"]}" method="post">
        <label>Equipos que no estan(Por defecto 1 canidad)</label>
        <#if opcion2??>
            <#if opcion2?has_content>
                           <center> <select name="opcionequi" style="width: 70%;" class="form-control" multiple>
                                <#list opcion2 as op2>
                                    <option value="${op2.getId()}">${op2.getId()} - ${op2.getNombre()} - Cant: ${op2.getDisponibles()}</option>
                                </#list>
                            </select> </center>
        <br/>

        <legend></legend>
        <br/>
        <div class="row2">
            <div class="col-md-12">
                <fieldset>
                    <input type="submit" value="Agregar" class="btn-normal btn-extra">
                </fieldset>
            </div>
        </div>
        <#else >
        <center>
            <h2> No hay equipos disponibles</h2>
            <br/>
            <legend></legend>
            <br/>
            <a href="/alquiler/ver/${alq.getId()?string["0"]}" class="btn-normal btn-extra" >Volver</a>
        </center>
        </#if>
    </#if>
    </form>
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