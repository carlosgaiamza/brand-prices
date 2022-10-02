La aplicación por default iniciará en el puerto 8081. En base a eso encontramos las siguientes URLs de interes:

1. http://localhost:8081/swagger-ui/index.html#/prices-controller/determinePrice
2. http://localhost:8081/h2-console (User: "admin", Password: "password")

Mejoras que podrían realizarse en una próxima iteración:
- Utilizar Flyway or Liquibase.
- Crear un contexto de pruebas para separar la inicialización de la base de datos 
productiva del inicio del contexto para pruebas de integración.
- Mejorar validaciones y excepciones.
- Mejorar el modelo de base de datos.
- Filtrar el orden de prioridad en la base de datos para evitar el mapeo 
de datos que no seran utilizados.
- Aumentar la cobertura de unit tests.
- Mejorar la documentación generada por Swagger.