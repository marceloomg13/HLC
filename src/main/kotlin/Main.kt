package un4.eje4_2

data class Tienda(val nombre: String, val clientes: List<Clientes>) {
    fun obtenerConjuntoDeClientes(): Set<Clientes> {
        return clientes.toSet()
    }

    fun obtenerCiudadesDeClientes(): Set<Ciudad> {
        var ciudades: Set<Ciudad> = setOf()
        val clientes: List<Clientes> = clientes
        for (i in clientes) {
            ciudades.plus(i.ciudad)
        }
        return ciudades
    }

    fun obtenerClientesPor(ciudad: Ciudad): List<Clientes> {
        val clientesCiudad: List<Clientes> = listOf()
        for (i in clientes) {
            if (i.ciudad.nombre == ciudad.nombre) {
                clientesCiudad.plus(i)
            }
        }
        return clientesCiudad
    }

    fun checkTodosClientesSonDe(ciudad: Ciudad): Boolean {
        var check: Boolean = true
        for (i in clientes) {
            if (i.ciudad != ciudad) {
                check = false
            }
        }
        return check
    }

    fun hayClientesDe(ciudad: Ciudad): Boolean {
        var check: Boolean = false
        for (i in clientes) {
            if (i.ciudad == ciudad) {
                check = true
            }
        }
        return check
    }
    fun cuentaClientesDe(ciudad: Ciudad): Int {
        var contador=0
        for (i in clientes) {
            if (i.ciudad == ciudad) {
                contador++
            }
        }
        return contador
    }
    fun Tienda.encuentraClienteDe(ciudad: Ciudad): Clientes? {
        for (i in clientes) {
            if (i.ciudad == ciudad) {
                return i
            }
        }
        return null
    }
    fun obtenerClientesOrdenadosPorPedidos(): List<Clientes> {
        val clientesorder: List<Clientes> = clientes.sortedByDescending{it.pedidos.size}
        return clientesorder
    }
    fun Tienda.obtenerClientesConPedidosSinEntregar(): Set<Clientes> {
        val clientesPartition: List<Clientes> = clientes
        var particionados=clientesPartition.partition {  }
    }
    fun obtenerProductosPedidos(): Set<Producto> {
        var Producto: Set<Producto> = setOf()
            var pedidos: List<Pedido> = it.pedidos
            for(x in pedidos){
               var  productos: List<Producto> = x.productos
                for (j in productos){
                    Producto.plus(j)
                }
            }
        return Producto
    }
    fun obtenerProductosPedidosPorTodos(): Set<Producto> {
        val client: List<Clientes> = clientes
        var Producto: Set<Producto> = setOf()
        for(i in client){
            var pedidos: List<Pedido> = i.pedidos
            for(x in pedidos){
                var  productos: List<Producto> = x.productos
                for (j in productos){
                    Producto.plus(j)
                }
            }
        }
        return Producto
    }
    fun obtenerNumeroVecesProductoPedido(producto: Producto): Int {
        var cont=0
        val client: List<Clientes> = clientes
        var Producto: Set<Producto> = setOf()
        for(i in client){
            var pedidos: List<Pedido> = i.pedidos
            for(x in pedidos){
                var  productos: List<Producto> = x.productos
                for (j in productos){
                    if (j.nombre==producto.nombre){cont++}
                }
            }
        }
        return cont
    }
    fun agrupaClientesPorCiudad(): Map<Ciudad, List<Clientes>>  {
        var clientesCiudad: Map<Ciudad, List<Clientes>> = clientes.groupBy { it.ciudad }
        return clientesCiudad
    }
    fun Tienda.mapeaClienteACiudad(): Map<Clientes, Ciudad> {
        var mapeo:Map<Clientes, Ciudad>
        clientes.associate { it.ciudad,Ciudad }
    }
}

data class Clientes(val nombre: String, val ciudad: Ciudad, val pedidos: List<Pedido>) {
    override fun toString() = "$nombre from ${ciudad.nombre}"

    fun obtenerProductosPedidos(): List<Producto> {
        var Lista:List<Producto> = listOf()
        for(i in pedidos){
            Lista.plus(i.productos)
        }
        return Lista
    }
    fun encuentraProductoMasCaro(): Producto? {
        var producto = Producto("cc",0.0)
        for(i in pedidos){
            var productos: List<Producto> = i.productos
            for (j in productos){
                if(i.estaEntregado){
                    if (j.precio>producto.precio){producto=j}
                }
            }
        }
        return producto
    }
}

data class Pedido(val productos: List<Producto>, val estaEntregado: Boolean)

data class Producto(val nombre: String, val precio: Double) {
    override fun toString() = "'$nombre' for $precio"
}

data class Ciudad(val nombre: String) {
    override fun toString() = nombre
}