# Construcción de servidor API para panel de ordenes

Necesitas construir un servidor que exponga una API REST para un panel web de ordenes. El sistema debe permitir a los usuarios visualizar y filtrar ordenes. La API debe manejar estados y errores adecuadamente.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Panel web para consumir una API REST de ordenes |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 20 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición de endpoints y modelos de datos

**Objetivo:** Definir los endpoints y modelos de datos necesarios para el panel de ordenes.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Identifica los endpoints necesarios para visualizar y filtrar ordenes.
- Define los modelos de datos para las ordenes, incluyendo atributos como ID, fecha, estado y detalles.

**Entregable:** Documento que describe los endpoints y modelos de datos para la API REST.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la estructura de datos necesaria para representar ordenes.
- Piensa en cómo filtrar ordenes puede afectar la estructura de los endpoints.

</details>

### Fase 2: Implementación de endpoints y lógica de negocio

**Objetivo:** Implementar los endpoints definidos y la lógica de negocio para manejar ordenes.

**Tiempo estimado:** 8 horas

**Instrucciones:**

- Implementa los endpoints definidos en la fase anterior.
- Desarrolla la lógica de negocio para manejar la creación, lectura, actualización y eliminación de ordenes.
- Implementa el manejo de errores y estados.

**Entregable:** Código fuente del servidor con los endpoints y lógica de negocio implementados.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza patrones de diseño adecuados para la lógica de negocio.
- Considera cómo manejar errores y estados de manera efectiva.

</details>

### Fase 3: Pruebas y optimización

**Objetivo:** Realizar pruebas unitarias y de integración, y optimizar la API.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Escribe pruebas unitarias para la lógica de negocio.
- Realiza pruebas de integración para los endpoints.
- Identifica y optimiza puntos de rendimiento críticos.

**Entregable:** Reporte de pruebas y optimizaciones realizadas, incluyendo código fuente actualizado.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza frameworks de prueba adecuados para Java.
- Considera técnicas de optimización como caching y lazy loading.

</details>

### Fase 4: Documentación y despliegue

**Objetivo:** Documentar la API y desplegarla en un entorno de pruebas.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Documenta la API utilizando un formato estándar como OpenAPI.
- Despliega la API en un entorno de pruebas y verifica su funcionamiento.

**Entregable:** Documentación de la API y evidencia de despliegue en un entorno de pruebas.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza herramientas de documentación como Swagger.
- Asegúrate de que el despliegue sea seguro y estable.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una API REST y cuáles son sus componentes principales?
- **paraQueSirve**: ¿Para qué sirve la API REST en el contexto del panel de ordenes?
- **comoSeUsa**: ¿Cómo se usa la API REST para visualizar y filtrar ordenes?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar una API REST y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones de diseño implica la implementación de la API REST para el panel de ordenes?

## Criterios de Evaluacion

- Definición correcta de endpoints y modelos de datos.
- Implementación funcional de endpoints y lógica de negocio.
- Manejo adecuado de errores y estados.
- Pruebas unitarias y de integración efectivas.
- Optimización de rendimiento identificada y aplicada.
- Documentación clara y completa de la API.
- Despliegue seguro y estable de la API en un entorno de pruebas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
