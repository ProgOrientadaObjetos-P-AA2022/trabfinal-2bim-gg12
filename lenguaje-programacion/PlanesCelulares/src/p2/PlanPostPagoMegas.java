package p2;

public class PlanPostPagoMegas extends PlanCelular {

    private int gigas;
    private double costoGiga;
    private double tarifaBase;

    public PlanPostPagoMegas(int gg, double cg,
            double tarifaB, String nomPro, String ced, String ciuPro,
            String marcaCelu, String modelCelu, String numCelu) {

        super(nomPro, ced, ciuPro, marcaCelu, modelCelu, numCelu);

        gigas = gg;
        costoGiga = cg;
        tarifaBase = tarifaB;
        calcularPagoMensual();
    }

    @Override
    public void calcularPagoMensual() {
        pagoMensual = tarifaBase + (costoGiga * gigas);
    }

    public void establecerGigas(int n) {
        gigas = n;
    }

    public void establecerCostoGiga(double n) {
        costoGiga = n;
    }

    public void establecerTarifaBase(double n) {
        tarifaBase = n;
    }

    public int obtenerGigas() {
        return gigas;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    public double obtenerTarifaBase() {
        return tarifaBase;
    }

    @Override
    public String toString() {

        String cadena = String.format("Plan Post Pago Megas\n"
                + "%s"
                + "\tTarifa Base: %.2f\n"
                + "\tGigas: %d\n"
                + "\tCosto por Giga: %.2f\n"
                + "\tPago Mensual: %.2f\n"
                + "--------------------------------\n",
                super.toString(), 
                obtenerTarifaBase(), 
                obtenerGigas(), 
                obtenerCostoGiga(),
                obtenerPagoMensual());

        return cadena;
    }

}
