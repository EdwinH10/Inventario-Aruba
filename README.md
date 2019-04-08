# Inventario Aruba

## 1 Resumen ejecutivo
[1. Descripción](https://github.com/EdwinH10/Inventario-Aruba/wiki/Descripción)

[2. Problema identificado](https://github.com/EdwinH10/Inventario-Aruba/wiki/Problema-identificado)

[3. Solución](https://github.com/EdwinH10/Inventario-Aruba/wiki/Solución)

[4. Arquitectura](https://utmedu-my.sharepoint.com/:b:/g/personal/al02816936_tecmilenio_mx/Ef9yK74FtWxHrSUgT5YNiN0BWRRk8UwQ4JZE7qrmKVAAvg?e=Srsqdw)

## 2 Requerimientos
- Windows server 2012
- Apache Tomcat
- Servidor MySQL
- Aplicación en formato war desplegada en apache tomcat
- JDK y JRE 8.0

## 3 Instalación
1. Descargar JDK y JRE de página oficial de Oracle, instalarlos siguiendo el wizard
2. Descargar e instalar Apache Tomcat 8.5 de la página oficial de Apache
3. Descargar e instalar Wamp server coomo servidor de base de datos MySQL


## 4 Configuración
1. Importar base de datos en servidor MySQL que contendrá el inventario de elementos Aruba
2. Desplegar archivo war en Apache Tomcat e ingresar a la dirección especificada por la aplicación

## 5 Uso
### Usuario final
1. Iniciar sesión con usuario y contraseña proporcionados
2. Ir a la pestaña de consulta para corroborar que se pueda ver la base de datos
3. En la pestaña de insertar llenar todos los campos con la información solocitada para insertar un registro, corroborar registro en pestaña de consulta
4. En la pestaña de editar llenar todos los campos con la información solocitada para editar un registro, corroborar edición de registro en pestaña de consulta
5. En la pestaña de eliminar llenar todos los campos con la información solocitada para eliminar un registro, corroborar regisque se haya eliminado el registro en pestaña de consulta

### Administrador
Se prooverá de todo el código fuente de la aplicación al administrador para que este pueda seguir con el desarrollo de la aplicación, edición y/o agregar funcionalidades

## 6 Contribución
- Dar clic en clonar repositorio
- Crear un nuevo branch para trabajar sobre desarrollo
- Contactar al administrador para revisar pull request
- Revisar merge

## 7 Roadmap
1. Hora de consulta de la base de datos
2. Registro auditable de quien y que modificó que registros
