package p2;

public class PlanPostPagoMinMeg extends PlanCelular {

    private int min;
    private double costoMin;
    private int gigas;
    private double costoGiga;

    public PlanPostPagoMinMeg(int mn, double costMin, int meg,
            double cg, String nomPro, String ced, String ciuPro,
            String marcaCelu, String modelCelu, String numCelu) {

        super(nomPro, ced, ciuPro, marcaCelu, modelCelu, numCelu);

        min = mn;
        costoMin = costMin;
        gigas = meg;
        costoGiga = cg;
        calcularPagoMensual();
    }

    @Override
    public void calcularPagoMensual() {
        pagoMensual = (min * costoMin) + (gigas * costoGiga);
    }

    public void establecerMin(int n) {
        min = n;
    }

    public void establecerCostoMin(double n) {
        costoMin = n;
    }

    public void establecerGigas(int n) {
        gigas = n;
    }

    public void establecerCostoGiga(double n) {
        costoGiga = n;
    }

    public int obtenerMin() {
        return min;
    }

    public double obtenerCostoMin() {
        return costoMin;
    }

    public int obtenerGigas() {
        return gigas;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    @Override
    public String toString() {

        String cadena = String.format("Plan Post Pago Minutos Megas\n"
                + "%s"
                + "\tMinutos: %d\n"
                + "\tCosto por Minuto: %.2f\n"
                + "\tGigas: %d\n"
                + "\tCosto por Giga: %.2f\n"
                + "\tPago Mensual: %.2f\n"
                + "--------------------------------\n",
                super.toString(),
                obtenerMin(), 
                obtenerCostoMin(), 
                obtenerGigas(), 
                obtenerCostoGiga(),
                obtenerPagoMensual());

        return cadena;
    }

}
