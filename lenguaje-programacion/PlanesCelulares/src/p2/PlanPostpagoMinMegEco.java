package p2;

public class PlanPostpagoMinMegEco extends PlanCelular {

    private int min;
    private double costoMin;
    private int gigas;
    private double costoGiga;
    private int descuento;

    public PlanPostpagoMinMegEco(int m, double costoM, int meg,
            double costoG, int des, String nomPro, String ced,
            String ciuPro, String marcaCelu, String modelCelu, String numCelu) {

        super(nomPro, ced, ciuPro, marcaCelu, modelCelu, numCelu);
        min = m;
        costoMin = costoM;
        gigas = meg;
        costoGiga = costoG;
        descuento = des;
        calcularPagoMensual();
    }

    @Override
    public void calcularPagoMensual() {
        pagoMensual = ((min * costoMin) + (gigas * costoGiga));
        pagoMensual = pagoMensual - ((pagoMensual * descuento) / 100);
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

    public void establecerDescuento(int n) {
        descuento = n;
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

    public int obtenerDescuento() {
        return descuento;
    }

    @Override
    public String toString() {

        String porcentaje = "%";

        String cadena = String.format("Plan Post Pago MinutosMegas Económico\n"
                + "%s"
                + "\tMinutos: %d\n"
                + "\tCosto X Minuto: %.2f\n"
                + "\tGigas: %d\n"
                + "\tCosto X Giga: %.2f\n"
                + "\tPorcentaje descuento: %d%s\n"
                + "\tPago Mensual: %.2f\n"
                + "--------------------------------\n",
                super.toString(), 
                obtenerMin(), 
                obtenerCostoMin(), 
                obtenerGigas(), 
                obtenerCostoGiga(),
                obtenerDescuento(), porcentaje, 
                obtenerPagoMensual());

        return cadena;
    }

}
