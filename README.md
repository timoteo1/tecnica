# Técnica - Prueba técnica Backend Engineer


## Ejercicio 3: de PRUEBA TÉCNICA BACKEND ENGINEER

Solución planteada (EJERCICIOS 2 y 3):

 Descripción de ambiente:

- **Descripción de ambiente:** Java versión 8 
- **Base de datos:** MariaDB 
- **APIs de prueba:** POSTMAN
- Docker & Docker-Compose instalados

##### IMPORTANTE!
Los scripts correspondientes a las querys del ejercicio 2, se encuentra dentro de la carpeta `query`. Archivo `querysExecise2.txt`.

Dentro de la carpeta `myhotel-docker` se presenta un `.yaml` que permite levantar una base de datos `MariaDB` con las tablas creadas para esta aplicación. 
Hay un archivo `how-to.md` donde se detalla los pasos a seguir para poder levantar el docker.

En caso de no poder levantar el docker en el directorio `"dump"` del proyecto esta el dump de la base de datos implementada para la solución del ejercicio.

En el directorio `diagrama-bd` del proyecto se encuentra el diagrama de la base de datos diseñada para la aplicación.

En el directorio `postman` dentro del proyecto se encuentra un `.json` con una collection de apis que se puede importar en POSTMAN y poder probar las apis del proyecto.

##### Ejecución de aplicación

- Ubicarse dentro la carpeta `my-hotel-docker` y ejecutar: `docker compose up`
- Ubicarse dentro la carpeta `proyecto` y ejecutar:
	- `mvn test`
	- `mvn spring-boot:run`

##### Detalle APIs

* Obtener el numero de empleados por rango salarial

GET -> URL {{urlTecnica}}/api/employees/salary/{segment}

RequestParams: 

`{segment}` es de tipo String. Los posibles valores son A, B y C:

- SEGMENTO A: menor a USD 3.500
- SEGMENTO B: mayor o igual a USD 3.500 y menor que USD 8.000
- SEGMENTO C: mayor o igual a USD 8.000.

La api devolvera un json con el numero de empleados que se encuentran en el rango salarial.
```json
{
    countEmployees
}
```
* Obtener la cantidad de empleados por rango salarial, agrupados por departamento

GET -> URL {{urlTecnica}}/api/departments/salary

La api devolvera estructura json con los valores: 

```json
{ 
	DEPARTMENT_ID, 
    SALARY_GROUP, 
    CANTIDAD
}
```
* Información del empleado con mayor sueldo de cada departamento.

GET -> URL {{urlTecnica}}/api/departments/employees/maxsalary

La api devolvera una estructura json con los valores: 

```json
{ 
	MAX_SALARY, 
    EMPLOYEE_ID, 
    JOB_ID, 
    DEPARTMENT_ID
}
```


* Información de los gerentes que hayan sido contratados hace más de 15 años.

GET -> URL {{urlTecnica}}/api/employees/moreexperience

La api devolvera una estructura json con la lista de empleados.
```json
    {
        email,
        salary,
        EMPLOYEE_ID,
        FIRST_NAME,
        LAST_NAME,
        PHONE_NUMBER,
        HIRE_DATE,
        JOB_ID,
        COMMISSION_PCT,
        MANAGER_ID,
        DEPARTMENT_ID
    }
]
```
* Salario promedio de todos los departamentos que tengan más de 10 empleados.

GET -> URL {{urlTecnica}}/api/departments/avgsalary

La api devolvera una estructura json con los valores: 
```json
[
    {
        AVG_SALARY: 3475.555556,
        DEPARTMENT_ID: 50
    }
]
```
* Obtener la siguiente información agrupada por país: cantidad empleados, salario promedio, salario más alto, salario más bajo, promedio años antigüedad

GET -> URL {{urlTecnica}}/api/countries

La api devolvera una estructura json con los valores: 
```json
[
    {
        COUNTRY_ID: US,
        COUNTRY_NAME,
        REGION_ID,
        ANTIQUITY_AVG_YEARS,
        MAX_SALARY,
        MIN_SALARY,
        EMPLOYEE_QUANTITY
    }
]
```