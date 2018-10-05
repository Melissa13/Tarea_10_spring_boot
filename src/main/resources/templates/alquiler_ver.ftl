<#include "base.ftl">

<#macro page_body>
<section class="content-section alcance">
    <a href="/alquiler/lista" class="btn-normal btn-extra" style="float: left; margin-left: 20px">Volver</a>

    <#if alquiler??>
    <div class="section-heading separador">
        <center><h1><em>Alquiler ID:#${alquiler.getId()?string["0"]}</em> - Datos</h1></center>
    </div>
    <legend></legend>
    <div>
    <div class="row2">
        <div class="col-md-4 input-separador">
            <label>Cliente</label>
            <h4>${alquiler.getCliente().getCedula()?string["0"]} - ${alquiler.getCliente().getNombre()}</h4>
        </div>
        <div class="col-md-4 input-separadorb">
            <label>Cantidad de equipos alquilados</label>
            <h4>${alquiler.getEquipo()?size}</h4>
        </div>
    </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Dia del prestamo</label>
                    <h4>${alquiler.getExtra1()}</h4>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Dia limite devolucion</label>
                    <h4>${alquiler.getExtra2()}</h4>
                </div>
            </div>
            <div class="row2">
                <div class="col-md-4 input-separador">
                    <label>Pendiente de pago</label>
                    <h4>
                        <#if alquiler.isPendiente() ><span style="color: red">SI</span><#else ><span style="color: green">NO</span></#if>
                    </h4>
                </div>
                <div class="col-md-4 input-separadorb">
                    <label>Dias pendientes</label>
                    <h4>${alquiler.days(alquiler.getFecha_entrega())?string["0"]}</h4>
                </div>
            </div>
    <legend></legend>
    <legend></legend>
    <legend></legend>
    <div class="section-heading separador">
        <center><h1><em>Equipos asociados</em> - Datos</h1>
            <a href="/alquiler/agregar/${alquiler.getId()?string["0"]}" class="btn-normal btn-extra" >Agregar</a></center>
    </div>
        <#if alquiler.getEquipo()??>
            <#list alquiler.getEquipo() as esto>
            <br/>
            <legend></legend>
            <center><h4><em>Equipo ID:#${esto.getAsociado().getId()?string["0"]}</em> - Datos</h4>
                <a href="/alquiler/quitar/${esto.getId()?string["0"]}" class="btn-normal btn-extra2" >Eliminar</a></center>
            <br/>
                    <div class="row2">
                        <div class="col-md-4 input-separador">
                            <label>Nombre</label>
                            <h4>${esto.getAsociado().getNombre()}</h4>
                        </div>
                        <div class="col-md-4 input-separadorb">
                            <label>Costo por unidad ($RD)</label>
                            <h4>${esto.getAsociado().getCosto()?string["0"]}</h4>
                        </div>
                    </div>
                    <div class="row2">
                        <div class="col-md-4 input-separador">
                            <label>Cantidad</label>
                            <h4><a href="/alquiler/menos/${esto.getId()?string["0"]}" class="btn-normal btn-extra2" >-</a>
                                ${esto.getCantidad()?string["0"]}
                                <a href="/alquiler/mas/${esto.getId()?string["0"]}" class="btn-normal btn-extra2" >+</a></h4>
                        </div>
                        <div class="col-md-4 input-separadorb">
                            <label>Costo total de este equipo ($RD)</label>
                            <h4>${esto.getCantidad()*esto.getAsociado().getCosto()}</h4>
                        </div>
                    </div>
            </#list>
        <#else >
        <center>
            <h2> No hay equipos registrados en el Sistema</h2>
        </center>
        </#if>
    <legend></legend>
    <legend></legend>
    <div class="section-heading separador">
        <center><h1><em>Costo total</em> - ${alquiler.total()}</h1></center>
    </div>
    <br/>
    <br/>

    <#else >
        <center>
            <h2> No Existe tal alquiler</h2>
        </center>
    </div>
    </#if>
    <legend></legend>
    <br/>
    <br/>

</section>
</#macro>