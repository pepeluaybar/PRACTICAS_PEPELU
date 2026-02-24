package practicapren2;

public class main {

    public static void main(String[] args) {

        JJOO jjoo = new JJOO("JJOO Invierno", 2026, "Milano-Cortina");

        // ===== 1) Crear deportes =====
        Deporte esqui = new Deporte("Esquí alpino", TipoDeporte.INDIVIDUAL, 2);
        Deporte hockey = new Deporte("Hockey hielo", TipoDeporte.EQUIPO, 2);

        System.out.println("Registrar deporte (esqui): " + jjoo.registrarNuevoDeporte(esqui));
        System.out.println("Registrar deporte (hockey): " + jjoo.registrarNuevoDeporte(hockey));
        System.out.println("Registrar deporte duplicado (esqui): " + jjoo.registrarNuevoDeporte(esqui)); // debe fallar

        // ===== 2) Crear pruebas =====
        Prueba slalom = new Prueba("P1", "Slalom", TipoDeporte.INDIVIDUAL, 2);
        Prueba partido = new Prueba("P2", "Partido Hockey", TipoDeporte.EQUIPO, 2);

        esqui.agregarPrueba(slalom);
        hockey.agregarPrueba(partido);

        // ===== 3) Crear deportistas =====
        Deportista d1 = new Deportista("Ana", "ESP", 101, 22, "Slalom");
        Deportista d2 = new Deportista("Luis", "ESP", 102, 24, "Slalom");
        Deportista d3 = new Deportista("John", "USA", 103, 23, "Slalom");

        System.out.println("Registrar deportista d1: " + jjoo.registrarNuevoDeportista(d1));
        System.out.println("Registrar deportista d2: " + jjoo.registrarNuevoDeportista(d2));
        System.out.println("Registrar deportista d3: " + jjoo.registrarNuevoDeportista(d3));
        System.out.println("Registrar deportista id duplicado (d1): " + jjoo.registrarNuevoDeportista(d1)); // debe fallar

        // ===== 4) Crear equipos (Opción A: equipo controla miembros) =====
        Deportista[] miembrosOk = new Deportista[2];
        miembrosOk[0] = d1; // ESP
        miembrosOk[1] = d2; // ESP

        Equipo teamESP = jjoo.crearEquipo("Team ESP", miembrosOk);
        System.out.println("Equipo creado: " + teamESP);

        Deportista[] miembrosMalPais = new Deportista[2];
        miembrosMalPais[0] = d1; // ESP
        miembrosMalPais[1] = d3; // USA

        Equipo teamMixto = jjoo.crearEquipo("Team MIXTO", miembrosMalPais); // debe fallar por país
        System.out.println("Equipo mixto (debe ser null): " + teamMixto);

        // ===== 5) Inscripción en pruebas (tipo compatible + no duplicado + máximo) =====

        // Individual OK
        System.out.println("Inscribir d1 en slalom: " + jjoo.inscribirEnPrueba(d1, slalom));
        System.out.println("Inscribir d2 en slalom: " + jjoo.inscribirEnPrueba(d2, slalom));

        // Duplicado (debe fallar)
        System.out.println("Inscribir d1 otra vez en slalom: " + jjoo.inscribirEnPrueba(d1, slalom));

        // Máximo alcanzado (slalom max=2, d3 debe fallar)
        System.out.println("Inscribir d3 en slalom (max alcanzado): " + jjoo.inscribirEnPrueba(d3, slalom));

        // Tipo incompatible: equipo en prueba individual (debe fallar)
        System.out.println("Inscribir equipo en slalom (incompatible): " + jjoo.inscribirEnPrueba(teamESP, slalom));

        // Equipo OK en prueba de equipo
        System.out.println("Inscribir teamESP en partido: " + jjoo.inscribirEnPrueba(teamESP, partido));

        // Tipo incompatible: deportista en prueba de equipo (debe fallar)
        System.out.println("Inscribir d1 en partido (incompatible): " + jjoo.inscribirEnPrueba(d1, partido));

        // ===== 6) Medallas: no asignar sin resultado =====
        System.out.println("Asignar oro sin resultado (debe false): " + partido.asignarMedalla(TipoMedalla.ORO, teamESP));

        // Registrar resultado final y asignar medallas
        partido.registrarResultadoFinal(new String[]{"Team ESP 3-1"});
        System.out.println("Asignar oro: " + partido.asignarMedalla(TipoMedalla.ORO, teamESP));
        System.out.println("Asignar plata: " + partido.asignarMedalla(TipoMedalla.PLATA, teamESP)); // (en la vida real no, pero sirve test)
        System.out.println("Asignar bronce: " + partido.asignarMedalla(TipoMedalla.BRONCE, teamESP));
        System.out.println("Asignar cuarta medalla (debe false): " + partido.asignarMedalla(TipoMedalla.BRONCE, teamESP));

        // ===== 7) Medallero por país =====
        System.out.println("\n" + jjoo.mostrarMedalleroPorPais());

        // ===== 8) Participante con más medallas =====
        Participante top = jjoo.participanteConMasMedallas();
        System.out.println("Participante con más medallas: " + top);

        // ===== 9) Total medallas otorgadas (static) =====
        System.out.println("Total medallas otorgadas (static Medalla): " + Medalla.getTotalOtorgadas());
    }
}