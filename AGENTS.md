# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Construcción de servidor API para panel de ordenes**.

| | |
|---|---|
| Tema | Panel web para consumir una API REST de ordenes |
| Nivel | senior-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar (domain, application, infrastructure) |
| Tiempo estimado | 20 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- com.h2database:h2
- org.hibernate.validator:hibernate-validator
- org.projectlombok:lombok
- org.springdoc:springdoc-openapi-starter-webmvc-ui 2.10.0
- org.springframework.boot:spring-boot-starter-actuator
- org.springframework.boot:spring-boot-starter-data-jpa
- org.springframework.boot:spring-boot-starter-validation

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición de endpoints y modelos de datos**: Documento que describe los endpoints y modelos de datos para la API REST.
- **Fase 2 — Implementación de endpoints y lógica de negocio**: Código fuente del servidor con los endpoints y lógica de negocio implementados.
- **Fase 3 — Pruebas y optimización**: Reporte de pruebas y optimizaciones realizadas, incluyendo código fuente actualizado.
- **Fase 4 — Documentación y despliegue**: Documentación de la API y evidencia de despliegue en un entorno de pruebas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/com/orders/infrastructure/OrderController.java` — La fase "Definición de endpoints y modelos de datos" se implementa aqui: este archivo es el ejercicio.
- [ ] `src/main/java/com/orders/application/exception/GlobalExceptionHandler.java` — La fase "Implementación de endpoints y lógica de negocio" se implementa aqui: este archivo es el ejercicio.
- [ ] `src/test/java/com/orders/application/OrderServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/orders/infrastructure/OrderControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (8)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/orders/application/OrderService.java` — `Order.setCustomerId`
      Se invoca `setCustomerId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/orders/application/OrderService.java` — `Order.setItems`
      Se invoca `setItems` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/orders/application/OrderService.java` — `Order.getItems`
      Se invoca `getItems` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/orders/application/OrderService.java` — `Order.getId`
      Se invoca `getId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/orders/application/OrderService.java` — `Order.getCustomerId`
      Se invoca `getCustomerId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/orders/application/OrderService.java` — `Order.getStatus`
      Se invoca `getStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/orders/application/OrderService.java` — `Order.getCreatedAt`
      Se invoca `getCreatedAt` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/orders/application/OrderService.java` — `Order.getUpdatedAt`
      Se invoca `getUpdatedAt` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Imports sin uso (3) — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos.

- `src/test/java/com/orders/application/OrderServiceTest.java` — `OrderStatus`
- `src/test/java/com/orders/infrastructure/OrderControllerTest.java` — `OrderItem`
- `src/test/java/com/orders/infrastructure/OrderControllerTest.java` — `OrderStatus`

### Presentes (16)

- `pom.xml`
- `src/main/java/com/orders/domain/Order.java`
- `src/main/java/com/orders/domain/OrderRepository.java`
- `src/main/java/com/orders/application/exception/OrderNotFoundException.java`
- `src/main/java/com/orders/application/exception/GlobalExceptionHandler.java`
- `src/main/java/com/orders/infrastructure/OrderJpaRepository.java`
- `src/main/java/com/orders/infrastructure/OrderController.java`
- `src/main/resources/application.yml`
- `src/main/java/com/orders/application/OrderService.java`
- `src/main/java/com/orders/Application.java`
- `src/test/java/com/orders/application/OrderServiceTest.java`
- `src/test/java/com/orders/infrastructure/OrderControllerTest.java`
- `src/main/java/com/orders/domain/OrderStatus.java`
- `src/main/java/com/orders/domain/OrderItem.java`
- `src/main/java/com/orders/application/dto/OrderRequest.java`
- `src/main/java/com/orders/application/dto/OrderResponse.java`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/java/com/orders/api/domain` (ausente)
- `src/main/java/com/orders/api/application` (ausente)
- `src/main/java/com/orders/api/infrastructure` (ausente)
- `src/main/java/com/orders/api/config` (ausente)
- `src/main/resources` (presente)
- `src/test/java/com/orders/api` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar (domain, application, infrastructure)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2
- Brecha que el reto ataca: Construir un panel web en React que consuma la API REST de ordenes, Construye una interfaz web en React que consume la API REST de ordenes con manejo de estado y errores
- Mision: Visualizar y filtrar ordenes

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
