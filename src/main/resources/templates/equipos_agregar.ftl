<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/equipo/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Equipos</em> - Agregar</h1></center>
    </div>
    <legend></legend>
    <div>
        <@spring.bind "equipo" />
        <form action="/equipo/add" method="post">
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Nombre</label>
                    <@spring.formInput "equipo.nombre" "placeholder='Nombre...' class='form-control'" "text"/>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Cantidad</label>
                    <@spring.formInput "equipo.cantidad" "placeholder='0' class='form-control'" "number"/>
                </div>
            </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Familia</label>
                    <@spring.formInput "equipo.familia" "placeholder='Familia...' class='form-control'" "text"/>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Sub-Familia</label>
                    <@spring.formInput "equipo.sub_familia" "placeholder='Sub-familia...' class='form-control'" "text"/>
                </div>
            </div>
            <br/>
            <div class="row2">
                <center>
                    <div style="margin-left: 510px; margin-top: 20px">
                        <label>Costo por unidad ($RD)</label>
                        <@spring.formInput "equipo.costo" "placeholder='0' class='form-control'" "number"/>
                    </div>
                </center>
            </div>
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