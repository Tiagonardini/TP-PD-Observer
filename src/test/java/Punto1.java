import org.junit.Test;
import punto1.*;

import java.util.List;

public class Punto1 {
    @Test
    public void intento1(){
        ClimaOnline clima = new WeatherChannelService();
        Observer observer = new EscrituraEnConsola();
        Observer observer1 = new GuardarArchivoLocal();
        Medidor medidor = new Medidor(clima,List.of(observer1, observer));

        medidor.leerTemperatura();


    }
}
