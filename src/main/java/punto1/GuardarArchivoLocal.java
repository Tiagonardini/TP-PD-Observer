package punto1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class GuardarArchivoLocal implements Observer{
    @Override
    public void notificar(String temperatura) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fecha.format(formatter);
        String registro = String.format("%s - Temperatura: %s\n", fechaFormateada, temperatura);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lecturas_temperatura.txt", true))) {
            writer.write(registro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
