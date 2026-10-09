
public class Main {

    public static void main(String[] args) {

        // NIVEL 1: Creamos la empresa, que es la raiz del arbol.
        NodoGeneral<String> empresa =
                new NodoGeneral<>("Empresa");

        // NIVEL 2: Creamos el gerente general.
        NodoGeneral<String> gerente =
                new NodoGeneral<>("Gerente general");

        // Agregamos el gerente como hijo de la empresa.
        empresa.agregarHijo(gerente);

        // NIVEL 3: ADMINISTRACION
        NodoGeneral<String> administracion =
                new NodoGeneral<>("Administracion");

        gerente.agregarHijo(administracion);

        // Creamos el departamento de Finanzas.
        NodoGeneral<String> finanzas =
                new NodoGeneral<>("Finanzas");

        administracion.agregarHijo(finanzas);

        // Agregamos los hijos de Finanzas.
        finanzas.agregarHijo(
                new NodoGeneral<>("Contabilidad"));
        finanzas.agregarHijo(
                new NodoGeneral<>("Tesoreria"));
        finanzas.agregarHijo(
                new NodoGeneral<>("Facturacion"));

        // Creamos el departamento de Recursos Humanos.
        NodoGeneral<String> recursosHumanos =
                new NodoGeneral<>("Recursos Humanos");

        administracion.agregarHijo(recursosHumanos);

        // Agregamos los hijos de Recursos Humanos.
        recursosHumanos.agregarHijo(
                new NodoGeneral<>("Seleccion"));
        recursosHumanos.agregarHijo(
                new NodoGeneral<>("Capacitacion"));
        recursosHumanos.agregarHijo(
                new NodoGeneral<>("Nomina"));

        // Creamos el departamento de Area Legal.
        NodoGeneral<String> areaLegal =
                new NodoGeneral<>("Area Legal");

        administracion.agregarHijo(areaLegal);

        // Agregamos los hijos de Area Legal.
        areaLegal.agregarHijo(
                new NodoGeneral<>("Contratos"));
        areaLegal.agregarHijo(
                new NodoGeneral<>("Asesorias juridicas"));

        // NIVEL 3: PRODUCCION
        NodoGeneral<String> produccion =
                new NodoGeneral<>("Produccion");

        gerente.agregarHijo(produccion);

        // Creamos el departamento de Supervision.
        NodoGeneral<String> supervision =
                new NodoGeneral<>("Supervision");

        produccion.agregarHijo(supervision);

        // Agregamos los supervisores de area.
        supervision.agregarHijo(
                new NodoGeneral<>("Supervisores de area"));

        // Creamos el departamento de Calidad.
        NodoGeneral<String> calidad =
                new NodoGeneral<>("Calidad");

        produccion.agregarHijo(calidad);

        // Agregamos los inspectores de calidad.
        calidad.agregarHijo(
                new NodoGeneral<>("Inspectores de calidad"));

        // Creamos el departamento de Operaciones.
        NodoGeneral<String> operaciones =
                new NodoGeneral<>("Operaciones");

        produccion.agregarHijo(operaciones);

        // Agregamos los tecnicos de mantenimiento.
        operaciones.agregarHijo(
                new NodoGeneral<>("Tecnicos de mantenimiento"));

        // NIVEL 3: VENTAS
        NodoGeneral<String> ventas =
                new NodoGeneral<>("Ventas");

        gerente.agregarHijo(ventas);

        // Creamos el departamento de Marketing.
        NodoGeneral<String> marketing =
                new NodoGeneral<>("Marketing");

        ventas.agregarHijo(marketing);

        // Agregamos los hijos de Marketing.
        marketing.agregarHijo(
                new NodoGeneral<>("Publicidad"));
        marketing.agregarHijo(
                new NodoGeneral<>("Redes sociales"));

        // Creamos el departamento comercial.
        NodoGeneral<String> departamentoVentas =
                new NodoGeneral<>("Departamento comercial");

        ventas.agregarHijo(departamentoVentas);

        // Agregamos los cargos comerciales.
        departamentoVentas.agregarHijo(
                new NodoGeneral<>("Vendedores"));
        departamentoVentas.agregarHijo(
                new NodoGeneral<>("Ejecutivos comerciales"));

        // Creamos el area de Atencion al cliente.
        NodoGeneral<String> atencion =
                new NodoGeneral<>("Atencion al cliente");

        ventas.agregarHijo(atencion);

        // Agregamos los hijos de Atencion al cliente.
        atencion.agregarHijo(
                new NodoGeneral<>("Servicio al cliente"));
        atencion.agregarHijo(
                new NodoGeneral<>("Reclamos"));

        // Imprimimos el titulo del organigrama.
        System.out.println("ORGANIGRAMA EMPRESARIAL");
        System.out.println("=======================");

        // Mostramos el arbol desde la raiz, en el nivel cero.
        mostrarOrganigrama(empresa, 0);
    }

    // Metodo recursivo para mostrar el arbol sin utilizar for.
    public static void mostrarOrganigrama(
            NodoGeneral<String> nodo, int nivel) {

        // Contador para imprimir los espacios de la jerarquia.
        int i = 0;

        // Imprimimos cuatro espacios por cada nivel.
        while (i < nivel) {
            System.out.print("    ");
            i++;
        }

        // Imprimimos el nombre del nodo actual.
        System.out.println("|-- " + nodo.getDato());

        // Obtenemos la lista de hijos del nodo actual.
        java.util.List<NodoGeneral<String>> hijos =
                nodo.getHijos();

        // Contador para recorrer los hijos.
        int j = 0;

        // Recorremos los hijos utilizando while.
        while (j < hijos.size()) {

            // Obtenemos el hijo de la posicion actual.
            NodoGeneral<String> hijo = hijos.get(j);

            // Llamamos nuevamente al metodo para mostrar el hijo.
            // Aumentamos el nivel para conservar la jerarquia.
            mostrarOrganigrama(hijo, nivel + 1);

            // Avanzamos al siguiente hijo.
            j++;
        }
    }
}
