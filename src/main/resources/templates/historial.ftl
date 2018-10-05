<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">

    <a href="/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Historial</em> - Clientes</h1></center>
    </div>
    <legend></legend>
    <div>

    <form action="/historial/" method="post">
        <label>Elija el cliente del cual desea ver el historial</label>
        <#if opcion??>
            <#if opcion?has_content>
                           <center> <select name="opcioncli" style="width: 60%;" class="form-control" >
                                <#list opcion as op>
                                    <option value="${op.getId()}">${op.getCedula()} - ${op.getNombre()}</option>
                                </#list>
                           </select></center>
        <br/>

        <legend></legend>
        <br/>
        <div class="row2">
            <div class="col-md-12">
                <fieldset>
                    <input type="submit" value="Elegir" class="btn-normal btn-extra">
                </fieldset>
            </div>
        </div>
            <#else >
        <center>
            <h2> No se ha registrado ningun cliente</h2>
            <br/>
            <legend></legend>
            <br/>
            <a href="/" class="btn-normal btn-extra" >Volver</a>
        </center>
            </#if>
        </#if>
    </form>
    <br/>
    <br/>

</section>
</#macro>