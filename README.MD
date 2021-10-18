# API-RESTfull-SpringBoot

API RESTfull con Spring Boot+Gradle 

### API Entrada: 

 localhost:9001/users/register
 
### Ejemplo JSON de entrada:
  
  {
    "name": "Juan Rodriguez",
    "email": "jasdgaf3o@driguefz.com",
    "password": "H3nt3r2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        },
        {
            "number": "1234565",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}

### Ejemplo JSON de salida:

{
    "user": {
        "id": "be8e4750-cf04-4a10-af84-80bea9d470c9",
        "name": "Juan Rodriguez",
        "email": "jasd@asdiguefz.com",
        "password": "Hunt3r2",
        "creationDate": "2021-10-17",
        "modificationDate": null,
        "lastLogin": "2021-10-17",
        "active": true,
        "phones": [
            {
                "phoneid": "c19cc89b-22dc-4562-b412-0c2880cffe71",
                "id": "be8e4750-cf04-4a10-af84-80bea9d470c9",
                "number": "1234567",
                "citycode": "1",
                "countrycode": null
            },
            {
                "phoneid": "d440c2bd-10a4-4ceb-8824-45c2d9e9b031",
                "id": "be8e4750-cf04-4a10-af84-80bea9d470c9",
                "number": "1234565",
                "citycode": "1",
                "countrycode": null
            }
        ],
        "apiToken": "44a4c561-ee4a-4c8e-8cff-de2c7f3ce357"
    },
    "message": "Usuario creado correctamente"
}

### Validaciones:

Correo debe mantener formato de correo
Contraseña debe contener 2 numeros, 1 mayuscula y letras minusculas.

### Persistencia

Se mantienen los datos en una base en memoria con HyperSQL.
