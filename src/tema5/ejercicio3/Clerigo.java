package tema5.ejercicio3;

import java.util.Random;

public class Clerigo extends Personaje implements IRezable {

    public static final int CLERIGO_MIN_FUERZA = 18;
    public static final int CLERIGO_MIN_INTEL = 12;
    public static final int CLERIGO_MAX_INTEL = 16;
    public static final int CLERIGO_PUNTOS_CURACION = 10;

    private String dios;
    public int puntosExtra;


    public Clerigo(String nombre, Raza raza, int fuerza, int inteligencia, int puntos_vida_max, String dios) throws InvalidValueException {
        super(nombre, raza, fuerza, inteligencia, puntos_vida_max);
        this.dios = dios;
        this.puntosExtra = 0;
    }

    @Override
    public void setFuerza(int f) throws InvalidValueException {
        if (f < Clerigo.CLERIGO_MIN_FUERZA) {
            throw new InvalidValueException("La fuerza mínima del clérigo es " + Clerigo.CLERIGO_MIN_FUERZA);
        }
        super.setFuerza(f);
    }

    @Override
    public void setInteligencia(int inteligencia) throws InvalidValueException {
        if (checkValidStat(inteligencia, Clerigo.CLERIGO_MIN_INTEL, Clerigo.CLERIGO_MAX_INTEL)) {
            super.setInteligencia(inteligencia);
        }
    }

    public void curar(Personaje p) {
        p.setPuntos_vida_actuales(p.getPuntos_vida_actuales() + Clerigo.CLERIGO_PUNTOS_CURACION + this.puntosExtra);

    }

    @Override
    public String toString() {

        return super.toString() + System.lineSeparator() + "Clerigo [dios=" + dios + "]";
    }

    @Override
    public void rezar() {
        Random r = new Random();
        this.puntosExtra += r.nextInt(2) + 1;
    }


}
