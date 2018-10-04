<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/alquiler/lista" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Alquiler</em> - Editar datos basicos</h1></center>
    </div>
    <legend></legend>
    <div>
        <@spring.bind "equipo" />
        <form action="/alquiler/edit/${equipo.getId()?string["0"]}" method="post">
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Cliente</label>
                    <#if opcion??>
                            <select name="opcioncli" style="width: 100%;" class="form-control" >
                                <#list opcion as op>
                                    <#if op.getId()==equipo.getCliente().getId()>
                                        <option value="${op.getId()}" selected>${op.getCedula()} - ${op.getNombre()}</option>
                                    <#else >
                                        <option value="${op.getId()}">${op.getCedula()} - ${op.getNombre()}</option>
                                    </#if>
                                </#list>
                            </select>
                    </#if>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Pendiente a pagar</label>
                    <@spring.formCheckbox "equipo.pendiente" "class='form-control'"/>
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