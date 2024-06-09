package punto1;

public class EscrituraEnConsola implements Observer {

    @Override
    public void notificar(String temperatura) {
        temperatura = temperatura.replace(",", ".");
        double temp = Double.parseDouble(temperatura.split(" ")[0]);
        if (temp < 12) {
            System.out.println("Hace frío, se encenderá la caldera");
        } else if (temp > 17) {
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        } else {
            System.out.println("Temperatura agradable");
        }
    }
}
