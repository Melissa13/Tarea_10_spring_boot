<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/client/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Clientes</em> - Agregar</h1></center>
    </div>
    <legend></legend>
    <div>
        <@spring.bind "cliente" />
        <form action="/client/add" method="post">
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Cedula</label>
                    <@spring.formInput "cliente.cedula" "placeholder='0' class='form-control'" "number"/>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Nombre</label>
                    <@spring.formInput "cliente.nombre" "placeholder='nombre...' class='form-control'" "text"/>
                </div>
            </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Fecha de Nacimiento(dd/mm/yyyy)</label>
                    <@spring.formInput "cliente.extra" "class='form-control'" "date"/>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Lugar de nacimiento</label>
                    <@spring.formInput "cliente.birth_place" "placeholder='Lugar...' class='form-control'" "text"/>
                </div>
            </div>
            <br/>
            <div class="row2">
                <center>
                    <div style="margin-left: 510px; margin-top: 20px">
                        <label>Genero</label>
                        <@spring.formSingleSelect "cliente.genero", opcion, "class='form-control' style='width: 200px'"/>
                    </div>
                </center>
            </div>
            <br/>
            <br/>
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
        <br/>
        <br/>
    </div>
</section>
</#macro>