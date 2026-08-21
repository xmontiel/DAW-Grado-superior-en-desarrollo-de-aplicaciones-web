/* 1. */

select clientes.nombre_cliente, count(pedidos.codigo_pedido) as numero_de_pedidos

from clientes

inner join pedidos on clientes.id_cliente = pedidos.id_cliente

group by clientes.nombre_cliente

having numero_de_pedidos > 5;

/* 2. */

select clientes.nombre_cliente

from clientes

inner join pedidos on clientes.id_cliente = pedidos.id_cliente

where pedidos.valor_total > 1000

group by clientes.nombre_cliente;

/* o tambien */

select distinct clientes.nombre_cliente

from clientes

inner join pedidos on clientes.id_cliente = pedidos.id_cliente

where pedidos.valor_total > 1000;

/* para que sea más diferente de la consulta del punto 1 */