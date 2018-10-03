<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/client/" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <div class="section-heading separador">
        <center><h1><em>Clientes</em> - Agregar</h1></center>
    </div>
    <legend></legend>
    <div>
        <form action="/client/add" method="post">
            <@spring.bind "cliente" />
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Cedula</label>
                    <@spring.formInput "cliente.cedula" "placeholder='0'" "number"/>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Nombre</label>
                    <@spring.formInput "cliente.nombre" "placeholder='nombre'" "text"/>
                </div>
            </div>
            <br/>
            <br/>
            <legend></legend>
            <div class="row2">
                <div class="col-md-12">
                    <fieldset>
                        <input type="submit" value="Submit">
                    </fieldset>
                </div>
            </div>
        </form>
    </div>
</section>
</#macro>