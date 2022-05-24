# tecnica

Solución planteada (EJERCICIOS 2 y 3):

1) Descripción de ambiente:
Java versión 8
Base de dato: MariaDB
API de prueba: POSTMAN

2) IMPORTANTE
Dentro de la carpeta myhotel-docker se presenta un yaml que permite levantar una base de datos MariaDB con las tablas creadas para esta aplicación. Hay un archivo how-to.md donde se detalla los pasos a seguir para poder levantar el docker.

En caso de no poder levantar el docker en el directorio "dump" del proyecto esta el dump de la base de datos implementada para la solución del ejercicio.

En el directorio query existe un archivo llamado querysExercise2.txt, que contiene las querys que se realizaron para resolver el punto 2 de la prueba tecnica.

3) Ejecución de aplicación:
Ubicarse dentro del proyecto y correr los siguientes comandos:
mvn test
mvn spring-boot:run

4) DETALLE APIS:
* Obtener la cantidad de empleados por rango salarial

GET: 0.0.0.0:9515/api/employees/salary/{segment}

RequestParams: el parametro segment es de tipo String y los posibles valores son A, B y C:

SEGMENTO A: menor a USD 3.500
SEGMENTO B: mayor o igual a USD 3.500 y menor que USD 8.000
SEGMENTO C: mayor o igual a USD 8.000.

La api devolvera un json con el numero de empleados que se encuentran en el rango salarial.

* Obtener la cantidad de empleados por rango salarial, agrupados por departamento
GET: 0.0.0.0:9515/api/departments/salary

La api devolvera un json con los valores DEPARTMENT_ID, SALARY_GROUP, CANTIDAD

* Información del empleado con mayor sueldo de cada departamento.
GET: 0.0.0.0:9515/api/departments/employees/maxsalary

La api devolvera un json con los valores MAX_SALARY, EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID

* Información de los gerentes que hayan sido contratados hace más de 15 años.

GET: 0.0.0.0:9515/api/employees/moreexperience

La api devolvera un json con los datos de los empleados

* Salario promedio de todos los departamentos que tengan más de 10 empleados.

GET: 0.0.0.0:9515/api/departments/avgsalary

La api devolvera un json con los valores AVG_SALARY, DEPARTMENT_ID

* Obtener la siguiente información agrupada por país: cantidad empleados, salario promedio, salario más alto, salario más bajo, promedio años antigüedad

GET: 0.0.0.0:9515/api/countries

La api devolvera un json con los valores COUNTRY_ID, COUNTRY_NAME, REGION_ID, ANTIQUITY_AVG_YEARS, MAX_SALARY, EMPLOYEE_QUANTITY

