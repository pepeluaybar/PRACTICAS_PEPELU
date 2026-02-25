# Práctica Programación Entrega nº2 (PracticaPrEn2)

## 1. Contexto del trabajo
Esta práctica modela de forma **orientada a objetos** una versión simplificada de unos Juegos Olímpicos de invierno.

El objetivo principal es representar:
- la organización general del evento (`JJOO`),
- los deportes y sus pruebas (`Deporte`, `Prueba`),
- los participantes individuales y por equipo (`Deportista`, `Equipo`),
- y la gestión de medallas (`Medalla`).

Se ha trabajado con una estructura clara de clases, usando herencia cuando tiene sentido (`Participante` como clase base), validaciones básicas y pruebas de funcionamiento desde `main`.

---

## 2. Estructura general del proyecto
Paquete principal: `practicapren2`

Clases y enums:
- `Participante` (base común)
- `Deportista` (participante individual)
- `Equipo` (participante colectivo)
- `Deporte` (contiene pruebas)
- `Prueba` (inscripciones, resultados y medallas)
- `Medalla` (registro de medallas)
- `JJOO` (núcleo de gestión)
- `TipoDeporte` (INDIVIDUAL / EQUIPO)
- `TipoMedalla` (ORO / PLATA / BRONCE)
- `main` (escenario de prueba completo)

---

## 3. Cómo funcionan las clases (resumen por clase)

### `Participante`
**Rol:** clase padre para cualquier entidad que pueda competir.

**Qué contiene:**
- datos comunes: `nombre`, `pais`, `idOlimpico`, `totalMedallas`;
- constructores (vacío, con parámetros y copia);
- getters/setters;
- `mostrarInformacion()` y `toString()`.

**Idea clave:** evita duplicar atributos entre deportistas y equipos.

---

### `Deportista` (extiende `Participante`)
**Rol:** representa a un atleta individual.

**Qué añade respecto a `Participante`:**
- `edad`,
- `especialidad`,
- `equipo` (referencia opcional al equipo al que pertenece).

**Métodos importantes:**
- getters/setters de sus propios atributos,
- `setEquipo(...)` para vincularlo a un equipo,
- `toString()` adaptado al deportista.

---

### `Equipo` (extiende `Participante`)
**Rol:** representa un participante de tipo equipo.

**Qué contiene:**
- array de miembros `Deportista[] miembros`;
- contador `numMiembros`;
- límite interno `MAX_MIEMBROS`.

**Método clave: `agregarMiembro(Deportista d)`**
Valida que:
1. el deportista no sea nulo,
2. haya espacio en el equipo,
3. no esté ya asignado a otro equipo.

Si todo es correcto, lo añade y enlaza `d.setEquipo(this)`.

---

### `Deporte`
**Rol:** agrupa pruebas de un mismo deporte.

**Qué contiene:**
- `nombre`, `tipo` (`INDIVIDUAL`/`EQUIPO`),
- `maxParticipantesPorPrueba`,
- array de `Prueba` con límite `MAX_PRUEBAS`.

**Método clave: `agregarPrueba(Prueba p)`**
- comprueba nulos y capacidad,
- valida que el tipo de la prueba coincida con el tipo del deporte,
- registra la prueba si todo es correcto.

---

### `Prueba`
**Rol:** es la unidad donde compiten participantes, se registran resultados y se otorgan medallas.

**Qué contiene:**
- identidad: `codigo`, `nombre`, `tipo`, `maxParticipantes`;
- inscritos: `Participante[] participantes` + contador;
- resultados: `String[] resultados` y flag `resultadoFinalRegistrado`;
- medallas: `Medalla[] medallas` (máximo 3) + contador.

**Métodos clave:**
- `inscribirParticipante(Participante p)`
  - valida participante, capacidad y tipo compatible;
  - evita duplicados por `idOlimpico`;
  - impide superar el máximo de inscritos.
- `registrarResultadoFinal(String[] resultados)`
  - marca oficialmente que ya hay resultado final.
- `asignarMedalla(TipoMedalla tipo, Participante ganador)`
  - solo permite asignar medallas si hay resultado final,
  - exige tipo y ganador válidos,
  - limita el total a 3 medallas por prueba.

---

### `Medalla`
**Rol:** representa una medalla concreta otorgada en una prueba.

**Qué contiene:**
- `tipo` (`ORO`, `PLATA`, `BRONCE`),
- `ganador` (`Participante`),
- `prueba` asociada,
- contador estático `totalOtorgadas`.

**Idea clave:** cada vez que se crea una medalla, aumenta el acumulado global.

---

### `JJOO`
**Rol:** clase principal de negocio. Coordina deportes, participantes y consultas globales.

**Qué contiene:**
- datos del evento: `nombre`, `anio`, `sede`;
- catálogo de deportes (`Deporte[]`);
- registro de participantes (`Participante[]`);
- límites máximos para ambos.

**Métodos más importantes:**
- `registrarNuevoDeporte(Deporte d)`
  - evita nulos, exceso de capacidad y nombres duplicados.
- `registrarNuevoParticipante(Participante p)`
  - evita nulos, exceso de capacidad e IDs olímpicos repetidos.
- `registrarNuevoDeportista(Deportista d)`
  - reutiliza la lógica de registro de participante.
- `crearEquipo(String nombreEquipo, Deportista[] miembros)`
  - valida nombre y lista de miembros,
  - exige que todos sean del mismo país,
  - crea un ID para el equipo,
  - registra el equipo como participante,
  - vincula cada deportista con su equipo.
- `inscribirEnPrueba(Participante par, Prueba pr)`
  - delega la validación en `Prueba.inscribirParticipante(...)`.
- `mostrarMedalleroPorPais()`
  - recorre pruebas finalizadas y cuenta medallas por país.
- `participanteConMasMedallas()`
  - calcula qué participante registrado acumula más medallas.

---

### `TipoDeporte` y `TipoMedalla`
Son enums para restringir valores y evitar errores por textos “libres”:
- `TipoDeporte`: `INDIVIDUAL`, `EQUIPO`
- `TipoMedalla`: `ORO`, `PLATA`, `BRONCE`

---

## 4. ¿Qué has hecho en el `main`?
En `main` has montado un **flujo de prueba completo** que simula casos reales y casos de error.

Resumen del recorrido:
1. Creas unos JJOO (`JJOO Invierno 2026, Milano-Cortina`).
2. Registras deportes (uno individual y otro de equipo), incluyendo intento duplicado.
3. Creas pruebas y las asocias a su deporte.
4. Creas deportistas y los registras, incluyendo intento de ID duplicado.
5. Creas un equipo válido (mismo país) y otro inválido (país mezclado).
6. Pruebas inscripciones válidas e inválidas:
   - duplicados,
   - superar máximo,
   - incompatibilidad de tipo (deportista/equipo según la prueba).
7. Verificas que no se asignen medallas sin resultado final.
8. Registras resultado final y asignas medallas, incluyendo intento de cuarta medalla.
9. Muestras el medallero por país.
10. Consultas el participante con más medallas.
11. Consultas el total global de medallas con el atributo estático de `Medalla`.

En otras palabras: el `main` sirve como **demo funcional + batería manual de validaciones** del sistema.

---

## 5. Diagrama de clases
El diagrama ya está incluido en el repositorio dentro del documento de entrega:

- [`1TDAW_PR_Entrega5.pdf`](./1TDAW_PR_Entrega5.pdf)

> En GitHub no siempre se renderiza el PDF embebido dentro del README, por eso se enlaza directamente al archivo.

### Comentario del diagrama
A nivel de diseño, el diagrama refleja correctamente la estructura del proyecto:
- **Herencia:** `Participante` es la superclase y `Deportista` / `Equipo` son especializaciones.
- **Agregación principal:** `JJOO` centraliza el registro de deportes y participantes.
- **Composición funcional:** `Deporte` agrupa varias `Prueba`.
- **Relaciones de ejecución:** `Prueba` gestiona inscripciones de `Participante` y crea `Medalla` al cerrar resultados.
- **Tipado fuerte:** `TipoDeporte` y `TipoMedalla` restringen valores válidos y simplifican validaciones.

Este diseño permite separar bien responsabilidades: la lógica global está en `JJOO`, la lógica de competición en `Prueba`, y el modelo de dominio en las entidades (`Participante`, `Deportista`, `Equipo`, `Deporte`, `Medalla`).

---

## 6. Posibles mejoras futuras
- Sustituir arrays fijos por colecciones dinámicas (`ArrayList`) para mayor flexibilidad.
- Mantener `totalMedallas` sincronizado automáticamente al asignar medallas.
- Ordenar el medallero por número de medallas.
- Evitar asignar dos medallas del mismo tipo en una misma prueba.
- Añadir tests unitarios para validar reglas de negocio críticas.
