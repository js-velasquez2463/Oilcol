/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(ng)
{
var mod = ng.module("AppPozo");
mod.service("pozoSVC", ["$http", "contextoPozo",function ($http, context)
   {
       var pozo = [];

        this.fetchRecords = function () {
               console.log("Se recupero"+$http.get(context));
                return $http.get(context);
            };

            /**
             * Obtener un registro de authors.
             * Hace una petición GET a /authors/:id para obtener
             * el objeto de un registro específico de authors
             * @param {number} id del registro a obtener
             * @returns {promise} promise para leer la respuesta del servidor.
             * Se recibe un objeto instancia de authors.
             */
            this.fetchRecord = function (id) {
                return $http.get(context + "/" + id);
            };

            /**
             * Guardar un registro de authors.
             * Si currentRecord tiene la propiedad id, hace un PUT a /authors/:id con los
             * nuevos datos de la instancia de authors.
             * Si currentRecord no tiene la propiedad id, se hace un POST a /authors
             * para crear el nuevo registro de authors
             * @param {object} currentRecord instancia de authors a guardar/actualizar
             * @returns {promise} promise para leer la respuesta del servidor.
             * Se recibe un objeto de authors con su nuevo id
             */
            this.saveRecord = function (currentRecord) {
                if (currentRecord.id) {
                    return $http.put(context + "/" + currentRecord.id, currentRecord);
                } else {
                    return $http.post(context, currentRecord);
                }
            };

            /**
             * Hace una petición DELETE a /authors/:id para eliminar un author
             * @param {number} id identificador de la instancia de author a eliminar
             * @returns {promise} promise para leer la respuesta del servidor.
             * No se recibe cuerpo en la respuesta.
             */
            this.deleteRecord = function (id) {
                return $http.delete(context + "/" + id);
            };


//        this.fetchRecords = function () {
//            console.log("Entro a fetch records service");
//                return $http.get(context);
//            };

       this.agregarPozo = function (pozo) {

           /*if (ciudad.nombre) {
                   return $http.post(context, ciudad);
                } else {
                    return $http.post(context, ciudad);
                }
           */
          console.log("El contexto es " + context);
          return $http.post(context,pozo);
            };

/*
       this.agregarCiudad = function(ciudad)
       {
           console.log("entra a metodo agregar ciudad Servicio");

           itinerario.push(ciudad);
       };
       */

       this.borrarPozo = function(pozo)
       {
           console.log(pozo + "que e es es o "+ pozo.nombre)

                return $http.delete(context + "/" + pozo);
       };

       this.darIpozo= function()
        {
           return pozo;
       };

   }
    ]);
})(window.angular);
