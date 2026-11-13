# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/orders/infrastructure/OrderController.java` — La fase "Definición de endpoints y modelos de datos" se implementa aqui: este archivo es el ejercicio.
- `src/main/java/com/orders/application/exception/GlobalExceptionHandler.java` — La fase "Implementación de endpoints y lógica de negocio" se implementa aqui: este archivo es el ejercicio.
- `src/test/java/com/orders/application/OrderServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/orders/infrastructure/OrderControllerTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/orders/application/OrderService.java` — `Order.setCustomerId`: Se invoca `setCustomerId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/orders/application/OrderService.java` — `Order.setItems`: Se invoca `setItems` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/orders/application/OrderService.java` — `Order.getItems`: Se invoca `getItems` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/orders/application/OrderService.java` — `Order.getId`: Se invoca `getId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/orders/application/OrderService.java` — `Order.getCustomerId`: Se invoca `getCustomerId` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/orders/application/OrderService.java` — `Order.getStatus`: Se invoca `getStatus` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/orders/application/OrderService.java` — `Order.getCreatedAt`: Se invoca `getCreatedAt` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/orders/application/OrderService.java` — `Order.getUpdatedAt`: Se invoca `getUpdatedAt` sobre `Order`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Imports sin uso — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos:

- `src/test/java/com/orders/application/OrderServiceTest.java` — `OrderStatus`
- `src/test/java/com/orders/infrastructure/OrderControllerTest.java` — `OrderItem`
- `src/test/java/com/orders/infrastructure/OrderControllerTest.java` — `OrderStatus`

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2

### Brecha de conocimiento
Construir un panel web en React que consuma la API REST de ordenes, Construye una interfaz web en React que consume la API REST de ordenes con manejo de estado y errores

### Misión / candidato
Visualizar y filtrar ordenes

### Reto
- Tema: Panel web para consumir una API REST de ordenes
- Seniority: senior-l2
- Tipo: practical
- Título: Construcción de servidor API para panel de ordenes
- Tiempo estimado: 20 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición de endpoints y modelos de datos — objetivo: Definir los endpoints y modelos de datos necesarios para el panel de ordenes. — entregable (NO resolver): Documento que describe los endpoints y modelos de datos para la API REST.
- Fase 2: Implementación de endpoints y lógica de negocio — objetivo: Implementar los endpoints definidos y la lógica de negocio para manejar ordenes. — entregable (NO resolver): Código fuente del servidor con los endpoints y lógica de negocio implementados.
- Fase 3: Pruebas y optimización — objetivo: Realizar pruebas unitarias y de integración, y optimizar la API. — entregable (NO resolver): Reporte de pruebas y optimizaciones realizadas, incluyendo código fuente actualizado.
- Fase 4: Documentación y despliegue — objetivo: Documentar la API y desplegarla en un entorno de pruebas. — entregable (NO resolver): Documentación de la API y evidencia de despliegue en un entorno de pruebas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.10.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/orders/domain/Order.java ===
package com.orders.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    private String id;

    @NotNull
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Order() {
        this.id = UUID.randomUUID().toString();
        this.status = OrderStatus.PENDING;
    }

    public Order(String customerId, List<OrderItem> items) {
        this();
        this.customerId = customerId;
        this.items = items;
    }

    public void addItem(OrderItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Order item cannot be null");
        }
        this.items.add(item);
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public void updateStatus(OrderStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        this.status = newStatus;
    }
}

// === ARCHIVO: src/main/java/com/orders/domain/OrderRepository.java ===
package com.orders.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByCreatedAtBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
    Optional<Order> findByIdAndCustomerId(String id, String customerId);
}

// === ARCHIVO: src/main/java/com/orders/application/exception/OrderNotFoundException.java ===
package com.orders.application.exception;


import com.orders.domain.Order;
import java.util.Map;

public class OrderNotFoundException extends RuntimeException {
    private final String orderId;
    private final String customerId;
    private final Map<String, String> context;

    public OrderNotFoundException(String orderId) {
        super(String.format("Order with id %s not found", orderId));
        this.orderId = orderId;
        this.customerId = null;
        this.context = Map.of("orderId", orderId);
    }

    public OrderNotFoundException(String orderId, String customerId) {
        super(String.format("Order with id %s not found for customer %s", orderId, customerId));
        this.orderId = orderId;
        this.customerId = customerId;
        this.context = Map.of(
            "orderId", orderId,
            "customerId", customerId
        );
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Map<String, String> getContext() {
        return context;
    }
}

// === ARCHIVO: src/main/java/com/orders/application/exception/GlobalExceptionHandler.java ===
package com.orders.application.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request) {
        // TODO(reto): Implementar manejo de excepciones para OrderNotFoundException
        // Debe retornar un ResponseEntity con un cuerpo que incluya:
        // - timestamp: LocalDateTime.now()
        // - status: HttpStatus.NOT_FOUND.value()
        // - error: "Not Found"
        // - message: ex.getMessage()
        // - path: request.getDescription(false).replace("uri=", "")
        // - context: ex.getContext()
        Map<String, Object> body = new LinkedHashMap<>();
        return ResponseEntity.ok(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        // TODO(reto): Implementar manejo de excepciones para IllegalArgumentException
        // Debe retornar un ResponseEntity con un cuerpo similar al anterior pero con status 400
        Map<String, Object> body = new LinkedHashMap<>();
        return ResponseEntity.ok(body);
    }
}

// === ARCHIVO: src/main/java/com/orders/infrastructure/OrderJpaRepository.java ===
package com.orders.infrastructure;

import com.orders.domain.Order;
import com.orders.domain.OrderRepository;
import com.orders.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderJpaRepository extends OrderRepository, JpaRepository<Order, String> {
    @Override
    default List<Order> findByStatus(OrderStatus status) {
        return findAll().stream()
                .filter(order -> order.getStatus() == status)
                .toList();
    }

    @Override
    default List<Order> findByCreatedAtBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return findAll().stream()
                .filter(order -> !order.getCreatedAt().isBefore(dateFrom) && !order.getCreatedAt().isAfter(dateTo))
                .toList();
    }

    @Override
    default Optional<Order> findByIdAndCustomerId(String id, String customerId) {
        return findById(id)
                .filter(order -> order.getCustomerId().equals(customerId));
    }
}

// === ARCHIVO: src/main/java/com/orders/infrastructure/OrderController.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package com.orders.infrastructure;

import com.orders.application.OrderService;
import com.orders.domain.OrderStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrders(
            @RequestParam(required = false) OrderStatus status,
            @RequestParam(required = false) String dateFrom,
            @RequestParam(required = false) String dateTo) {
        throw new UnsupportedOperationException("TODO(reto): getOrders");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id) {
        throw new UnsupportedOperationException("TODO(reto): getOrderById");
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        throw new UnsupportedOperationException("TODO(reto): createOrder");
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable String id, @RequestBody OrderRequest request) {
        throw new UnsupportedOperationException("TODO(reto): updateOrder");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        throw new UnsupportedOperationException("TODO(reto): deleteOrder");
    }
}

record OrderRequest(String customerId, List<OrderItemRequest> items, OrderStatus status) {
    record OrderItemRequest(String productId, int quantity, double price) {}
}

record OrderResponse(String id, String customerId, List<OrderItemResponse> items, OrderStatus status, String createdAt, String updatedAt) {
    record OrderItemResponse(String productId, int quantity, double price) {}
}

// === ARCHIVO: src/main/resources/application.yml ===
server:
  port: ${SERVER_PORT:8080}

spring:
  application:
    name: orders-api
  datasource:
    url: ${DB_URL:jdbc:h2:mem:ordersdb}
    driver-class-name: ${DB_DRIVER:org.h2.Driver}
    username: ${DB_USERNAME:sa}
    password: ${DB_PASSWORD:}
    hikari:
      maximum-pool-size: 10
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  h2:
    console:
      enabled: ${H2_CONSOLE_ENABLED:true}
      path: ${H2_CONSOLE_PATH:/h2-console}
  jpa:
    database-platform: ${JPA_DATABASE_PLATFORM:org.hibernate.dialect.H2Dialect}
    hibernate:
      ddl-auto: ${JPA_HIBERNATE_DDL_AUTO:update}
    show-sql: ${JPA_SHOW_SQL:false}
    properties:
      hibernate:
        format_sql: ${JPA_FORMAT_SQL:true}
        use_sql_comments: ${JPA_USE_SQL_COMMENTS:false}
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
    open-in-view: false
  sql:
    init:
      mode: ${SQL_INIT_MODE:never}
      schema-locations: classpath:schema.sql
      data-locations: classpath:data.sql

springdoc:
  api-docs:
    path: /api-docs
    enabled: true
  swagger-ui:
    path: /swagger-ui.html
    enabled: true
    tags-sorter: alpha
    operations-sorter: alpha
    tryItEnabled: true

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
      base-path: /actuator
  endpoint:
    health:
      show-details: when_authorized
      probes:
        enabled: true
  health:
    db:
      enabled: true
    diskspace:
      enabled: true
  metrics:
    export:
      prometheus:
        enabled: true

logging:
  level:
    root: ${LOG_LEVEL_ROOT:INFO}
    com.orders: ${LOG_LEVEL_APP:DEBUG}
    org.springframework.web: INFO
    org.springframework.security: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

app:
  cors:
    allowed-origins: ${CORS_ALLOWED_ORIGINS:http://localhost:3000,http://localhost:8080}
    allowed-methods: GET,POST,PUT,DELETE,OPTIONS
    allowed-headers: "*"
    allow-credentials: true
    max-age: 3600
  pagination:
    default-page-size: 20
    max-page-size: 100
  api:
    version: v1
    base-path: /api

// === ARCHIVO: src/main/java/com/orders/application/OrderService.java ===
package com.orders.application;

import com.orders.application.dto.OrderRequest;
import com.orders.application.dto.OrderResponse;
import com.orders.application.exception.OrderNotFoundException;
import com.orders.domain.Order;
import com.orders.domain.OrderItem;
import com.orders.domain.OrderRepository;
import com.orders.domain.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> getOrders(OrderStatus status, String dateFrom, String dateTo) {
        List<Order> orders;

        if (status != null && dateFrom != null && dateTo != null) {
            LocalDateTime from = LocalDateTime.parse(dateFrom, DATE_FORMATTER);
            LocalDateTime to = LocalDateTime.parse(dateTo, DATE_FORMATTER);
            orders = orderRepository.findByCreatedAtBetween(from, to)
                    .stream()
                    .filter(o -> o.getStatus() == status)
                    .collect(Collectors.toList());
        } else if (status != null) {
            orders = orderRepository.findByStatus(status);
        } else if (dateFrom != null && dateTo != null) {
            LocalDateTime from = LocalDateTime.parse(dateFrom, DATE_FORMATTER);
            LocalDateTime to = LocalDateTime.parse(dateTo, DATE_FORMATTER);
            orders = orderRepository.findByCreatedAtBetween(from, to);
        } else {
            orders = orderRepository.findAll();
        }

        return orders.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse getOrderById(String id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toResponse(order);
    }

    public OrderResponse createOrder(OrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        List<OrderItem> items = mapItems(request.items());
        Order order = new Order(request.customerId(), items);

        if (request.status() != null) {
            order.updateStatus(request.status());
        }

        Order savedOrder = orderRepository.save(order);
        return toResponse(savedOrder);
    }

    public OrderResponse updateOrder(String id, OrderRequest request) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        existingOrder.setCustomerId(request.customerId());

        List<OrderItem> newItems = mapItems(request.items());
        existingOrder.setItems(newItems);

        if (request.status() != null) {
            existingOrder.updateStatus(request.status());
        }

        Order updatedOrder = orderRepository.save(existingOrder);
        return toResponse(updatedOrder);
    }

    public void deleteOrder(String id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    private OrderResponse toResponse(Order order) {
        List<OrderResponse.OrderItemResponse> itemResponses = order.getItems().stream()
                .map(item -> new OrderResponse.OrderItemResponse(
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()))
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getId(),
                order.getCustomerId(),
                itemResponses,
                order.getStatus(),
                order.getCreatedAt() != null ? order.getCreatedAt().format(DATE_FORMATTER) : null,
                order.getUpdatedAt() != null ? order.getUpdatedAt().format(DATE_FORMATTER) : null);
    }

    private List<OrderItem> mapItems(List<OrderRequest.OrderItemRequest> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        return items.stream()
                .map(item -> new OrderItem(item.productId(), item.quantity(), item.price()))
                .collect(Collectors.toList());
    }
}

// === ARCHIVO: src/main/java/com/orders/Application.java ===
package com.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.orders"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// === ARCHIVO: src/test/java/com/orders/application/OrderServiceTest.java ===
package com.orders.application;

import com.orders.domain.OrderRepository;
import com.orders.domain.OrderStatus;
import com.orders.infrastructure.OrderController.OrderRequest;
import com.orders.infrastructure.OrderController.OrderResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void getOrders_withStatus_returnsFilteredOrders() {
        // TODO(reto): Implementar test para getOrders con filtro de status
        // Given: un estado de orden y una lista de orders en el repositorio mock
        // When: se llama a getOrders con ese estado
        // Then: verificar que retorna solo las orders con ese estado
    }

    @Test
    void getOrderById_existingId_returnsOrder() {
        // TODO(reto): Implementar test para getOrderById cuando existe
        // Given: un ID existente y una orden en el repositorio mock
        // When: se llama a getOrderById con ese ID
        // Then: verificar que retorna la orden correcta
    }

    @Test
    void getOrderById_nonExistingId_throwsOrderNotFoundException() {
        // TODO(reto): Implementar test para getOrderById cuando no existe
        // Given: un ID que no existe en el repositorio mock
        // When: se llama a getOrderById con ese ID
        // Then: verificar que lanza OrderNotFoundException
    }

    @Test
    void createOrder_validRequest_createsAndReturnsOrder() {
        // TODO(reto): Implementar test para createOrder
        // Given: una OrderRequest válida
        // When: se llama a createOrder
        // Then: verificar que se guarda en el repositorio y retorna la orden creada
    }

    @Test
    void updateOrder_existingId_updatesAndReturnsOrder() {
        // TODO(reto): Implementar test para updateOrder
        // Given: un ID existente y una OrderRequest con nuevos datos
        // When: se llama a updateOrder
        // Then: verificar que se actualiza en el repositorio y retorna la orden actualizada
    }

    @Test
    void updateOrder_nonExistingId_throwsOrderNotFoundException() {
        // TODO(reto): Implementar test para updateOrder cuando no existe
        // Given: un ID que no existe en el repositorio mock
        // When: se llama a updateOrder con ese ID
        // Then: verificar que lanza OrderNotFoundException
    }

    @Test
    void deleteOrder_existingId_deletesOrder() {
        // TODO(reto): Implementar test para deleteOrder
        // Given: un ID existente
        // When: se llama a deleteOrder
        // Then: verificar que se elimina del repositorio
    }

    @Test
    void deleteOrder_nonExistingId_throwsOrderNotFoundException() {
        // TODO(reto): Implementar test para deleteOrder cuando no existe
        // Given: un ID que no existe en el repositorio mock
        // When: se llama a deleteOrder
        // Then: verificar que lanza OrderNotFoundException
    }
}

// === ARCHIVO: src/test/java/com/orders/infrastructure/OrderControllerTest.java ===
package com.orders.infrastructure;

import com.orders.application.OrderService;
import com.orders.domain.OrderItem;
import com.orders.domain.OrderStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("GET /api/orders returns all orders when no filters")
    void getOrders_returnsAllOrders_whenNoFilters() throws Exception {
        // TODO(reto): Implementar test que verifica que GET /api/orders retorna todas las ordenes sin filtros
    }

    @Test
    @DisplayName("GET /api/orders filters by status")
    void getOrders_filtersByStatus() throws Exception {
        // TODO(reto): Implementar test que verifica el filtrado por status
    }

    @Test
    @DisplayName("GET /api/orders filters by date range")
    void getOrders_filtersByDateRange() throws Exception {
        // TODO(reto): Implementar test que verifica el filtrado por rango de fechas
    }

    @Test
    @DisplayName("GET /api/orders/{id} returns order when exists")
    void getOrderById_returnsOrder_whenExists() throws Exception {
        // TODO(reto): Implementar test que verifica que se retorna una orden existente por ID
    }

    @Test
    @DisplayName("GET /api/orders/{id} returns 404 when not exists")
    void getOrderById_returns404_whenNotExists() throws Exception {
        // TODO(reto): Implementar test que verifica que se retorna 404 para orden inexistente
    }

    @Test
    @DisplayName("POST /api/orders creates new order")
    void createOrder_createsNewOrder() throws Exception {
        // TODO(reto): Implementar test que verifica la creación de una nueva orden
    }

    @Test
    @DisplayName("POST /api/orders returns 400 for invalid request")
    void createOrder_returns400_forInvalidRequest() throws Exception {
        // TODO(reto): Implementar test que verifica que se retorna 400 para request inválido
    }

    @Test
    @DisplayName("PUT /api/orders/{id} updates existing order")
    void updateOrder_updatesExistingOrder() throws Exception {
        // TODO(reto): Implementar test que verifica la actualización de una orden existente
    }

    @Test
    @DisplayName("PUT /api/orders/{id} returns 404 when not exists")
    void updateOrder_returns404_whenNotExists() throws Exception {
        // TODO(reto): Implementar test que verifica que se retorna 404 al actualizar orden inexistente
    }

    @Test
    @DisplayName("DELETE /api/orders/{id} deletes existing order")
    void deleteOrder_deletesExistingOrder() throws Exception {
        // TODO(reto): Implementar test que verifica la eliminación de una orden existente
    }

    @Test
    @DisplayName("DELETE /api/orders/{id} returns 404 when not exists")
    void deleteOrder_returns404_whenNotExists() throws Exception {
        // TODO(reto): Implementar test que verifica que se retorna 404 al eliminar orden inexistente
    }
}

// === ARCHIVO: src/main/java/com/orders/domain/OrderStatus.java ===
package com.orders.domain;

public enum OrderStatus {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}

// === ARCHIVO: src/main/java/com/orders/domain/OrderItem.java ===
package com.orders.domain;

import java.util.Objects;

public class OrderItem {
    private String id;
    private String productId;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return quantity * price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity &&
                Double.compare(orderItem.price, price) == 0 &&
                Objects.equals(productId, orderItem.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

// === ARCHIVO: src/main/java/com/orders/application/dto/OrderRequest.java ===
package com.orders.application.dto;

import com.orders.domain.OrderStatus;

import java.util.List;

public record OrderRequest(
    String customerId,
    List<OrderItemRequest> items,
    OrderStatus status
) {
    public record OrderItemRequest(String productId, int quantity, double price) {}
}

// === ARCHIVO: src/main/java/com/orders/application/dto/OrderResponse.java ===
package com.orders.application.dto;

import com.orders.domain.OrderStatus;

import java.util.List;

public record OrderResponse(
    String id,
    String customerId,
    List<OrderItemResponse> items,
    OrderStatus status,
    String createdAt,
    String updatedAt
) {
    public record OrderItemResponse(String productId, int quantity, double price) {}
}
```
