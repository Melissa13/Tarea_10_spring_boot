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
                    <@spring.formSingleSelect "equipo.cliente", opcion, "class='form-control' style='width: 370px'"/>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Equipos(Por defecto 1 canidad)</label>
                    <@spring.formMultiSelect "equipo.equipo2", opcion2, "class='form-control' style='width: 370px'"/>
                </div>
            </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Fecha del prestamo</label>
                    <@spring.formInput "equipo.extra1" "class='form-control'" "date"/>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Fecha de entrega</label>
                    <@spring.formInput "equipo.extra2" "class='form-control'" "date"/>
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