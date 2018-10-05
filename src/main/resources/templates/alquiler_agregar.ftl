<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/alquiler/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Alquiler</em> - Agregar</h1></center>
    </div>
    <legend></legend>
    <div>
        <@spring.bind "equipo" />
        <form action="/alquiler/add" method="post">
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Cliente</label>
                    <#if opcion??>
                            <select name="opcioncli" style="width: 100%;" class="form-control" >
                                <#list opcion as op>
                                    <option value="${op.getId()}">${op.getCedula()} - ${op.getNombre()}</option>
                                </#list>
                            </select>
                    </#if>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Equipos(Por defecto 1 canidad)</label>
                    <#if opcion2??>
                            <select name="opcionequi" style="width: 100%;" class="form-control" multiple>
                                <#list opcion2 as op2>
                                    <option value="${op2.getId()}">${op2.getId()} - ${op2.getNombre()} - Cant: ${op2.getDisponibles()}</option>
                                </#list>
                            </select>
                    </#if>
                </div>
            </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Fecha del prestamo</label>
                    <@spring.formInput "equipo.extra1" "class='form-control' required" "date"/>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Fecha de entrega</label>
                    <@spring.formInput "equipo.extra2" "class='form-control' required" "date"/>
                </div>
            </div>
            <br/>
            <br/>
            <legend></legend>
            <div class="row2">
                <div class="col-md-12">
                    <fieldset>
                        <input type="submit" value="Agregar" class="btn-normal btn-extra">
                    </fieldset>
                </div>
            </div>
        </form>
    </div>
</section>
</#macro>