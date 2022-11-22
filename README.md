# Citas clínicas 

Sistema para creación de citas y manejo de doctores y pacientes

## Instalación

Se puede utilizar el .jar para la ejecución del programa.

## Uso del programa

#### Para la creación de los archivos que se utilizaran como BD (donde se almacenará la información) se utilizan los siguientes formatos

###### Usuarios.txt

```python
# Identificador unico, nombre, especialidad, Usuario(0) o Admin(1), usuario, contraseña
1,Maurizio,Pediatra,1,mau,1234
```

###### Citas.txt

```python
# Identificador unico, fecha, motivo
1,11/22/2022:11:00:00,Necesito llevar a mi hijo
```

###### Pacientes.txt

```python
# Identificador unico, nombre
1,Maurizio
```
##### *Se tendrá que crear por defecto un usuario de tipo admin (1) en el archivo Usuarios.txt para poder iniciar el programa


## Créditos

Creador: Maurizio Patiño

## Licencia

[MIT](https://choosealicense.com/licenses/mit/)