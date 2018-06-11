# BancoXYZ
Repositorio para desarrollar el proyecto de Persistencia y Datos transaccionales
DEFINICIÓN DEL PROYECTO

El banco XYZ, requiere que se desarrolle un prototipo transaccional, para simular la ejecución de tres transacciones a saber, una consulta, una consignación y un retiro. 

Para el desarrollo del proyecto, se requiere:
<ul>
<li>Hacer un modelo entidad relación sencillo del banco XYZ, con las entidades de saldo, cliente, ciudad, país y movimientos. (El propósito es académico).</li>
<li>Implementar el modelo en una base de datos libre como Oracle 11g R2 Express, por ejemplo.</li>
<li>Desarrollar los sockets server y cliente respectivos para hacer una consignación (insert), un retiro (update) y una consulta (Select).</li>
<li>Probar las operaciones desde el socket cliente con el socket server iniciado.</li>


<h2>MODELO BASE DE DATOS</h2>
Como el objetivo académico establecido en este proyecto se centra en la persistencia y datos transaccionales y no en el modelado de base de datos, y debido a la anuncia de detalles para el estudio del caso, pasaremos directamente a Identificar las entidades y los subsiguientes pasos.  

<h2>IDENTIFICACIÓN DE ENTIDADES</h2>

Para identificar las entidades se hace una lista de sustantivos, así:
<table>
<tr>
<th>Sustantivo</th>
<th>Aplica</th>
<th>Relación</th>
<th>Tipo de Relación</th>
<th>Observación</th>
</tr>
<tr>
<td>Cliente</td>
<td>Si</td>
<td>Cuenta</td>
<td>Cuenta: n-1:Cliente</td>
<td>Cliente es una entidad del problema.</td>
</tr>
<tr>
<td>Cuenta</td>
<td>Si</td>
<td>Cliente - Ciudad – Movimientos</td> 
<td>Cliente:1-n:Cuenta 
Ciudad: n-1:Cuenta 
Movimientos:1-n:Cuenta</td>
<td>Cuenta es una entidad del problema.</td> 
</tr>
<tr>
<td>Movimientos</td>
<td>Si</td>
<td>Saldo – Cuenta</td> 
<td>Saldo: 1-n : movimientos
Cuenta: 1-n:Movimientos</td>
<td>Entidad del problema</td>
</tr>
<tr>
<td>Saldo</td>
<td>Si</td>
<td>Movimientos</td>
<td>Movimientos: n-1:Saldo</td>
<td>Entidad del problema</td>
</tr>
<tr>
<td>Consignación</td>
<td>NO</td>
<td> </td>
<td> </td>
<td>transacción</td>
</tr>
<td>Consulta</td>
<td>NO</td>
<td> </td>
<td> </td>
<td>transacción</td>
</tr>
<tr>
<td>Retiro</td>
<td>NO</td>
<td> </td>
<td> </td>
<td>transacción</td>
</tr>
<tr>
<td>Ciudad</td>
<td>Si</td>
<td>Cuenta-Pais</td>
<td>Cuenta: n-1:Ciudad
Pais: 1-n:Cuenta</td>
<td>Entidad del problema</td>
</tr>
<tr>
<td>Pais</td>
<td>Si</td>
<td>Ciudad</td>
<td>Ciudad: n-1: Pais</td>
<td>Entidad del problema</td>
</tr>
<img src ="Bancoxyz.png" alt "Diagrama EER Banco XYZ" width = 200px height=200px>
<br>
<h2>IDENTIFICACIÓN DE ATRIBUTOS</h2>
Se identifican los atributos de cada entidad, y se definen las llaves primarias, esta se resaltará con subrayado azul y las llaves foráneas roja, aplicando las formas de normalización quedaría así:
Cliente (Id_Cliente;  Nombre;  Apellidos;  id_cuenta; clave;  teléfono;  dirección, Ciudad).
Cuenta (Id_cuenta;  id_cliente;  saldo)
Movimiento (Id_movimiento; Id_cuenta; Tipo_movimiento; valor; saldo_final; fecha_registro).
Pais (Id_pais; nombre_pais;)
Ciudad (Cod_ciudad; Id_pais; nombre_ciudad).

ESTABLECER LAS RELACIONES ENTRE LAS ENTIDADES

Por politicas del banco establecemos que un cuenta solo puede pertenecer a un cliente estaremos estableciendo la relación: cliente 1 - N cuentas.
Una cuenta puede hacer varios movimientos, pero un movimiento pertenece a una cuenta, cuenta 1 - n movimientos.
Una cuenta pertenece a una ciudad, cuenta 1 - 1 ciudad 
Una ciudad pertenece a un país, ciudad 1 - 1 pais.
Una cliente pertenece a una ciudad, cliente 1 - 1 ciudad
