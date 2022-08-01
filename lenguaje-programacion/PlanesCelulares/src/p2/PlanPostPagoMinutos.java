
package p2;

public class PlanPostPagoMinutos extends PlanCelular {
    
    private int minN;
    private double costoMinN;
    private int minInt;
    private double costoMinInt;

    public PlanPostPagoMinutos(int min, double costMinN, int mInt, 
            double costMInt, String nomPro, String ced, String ciuPro, 
            String marcaCelu, String modelCelu, String numCelu) {
        
        super(nomPro, ced, ciuPro, marcaCelu, modelCelu, numCelu);
        minN = min;
        costoMinN = costMinN;
        minInt = mInt;
        costoMinInt = costMInt;
        calcularPagoMensual();
    }
    
    @Override
    public void calcularPagoMensual() {
        pagoMensual = (minN * costoMinN) + 
                (minInt * costoMinInt);
    }
    
    public void establecerMinN(int n) {
        minN = n;
    }

    public void establecerCostoMinN(double n) {
        costoMinN = n;
    }

    public void establecerMinInt(int n) {
        minInt = n;
    }

    public void establecerCostoMinInt(double n) {
        costoMinInt = n;
    }

    public int obtenerMinN() {
        return minN;
    }

    public double obtenerCostoMinN() {
        return costoMinN;
    }

    public int obtenerMinInt() {
        return minInt;
    }

    public double obtenerCostoMinInt() {
        return costoMinInt;
    }
    
    @Override
    public String toString() {
        
        String cadena = String.format("Plan Post Pago Minutos\n"
                + "%s"
                + "\tMinutos (Nacional): %d\n"
                + "\tCosto por Minuto(Nacional): %.2f\n"
                + "\tMinutos (Internacional): %d\n"
                + "\tCosto por Minuto(Internacional): %.2f\n"
                + "\tPago Mensual: %.2f\n"
                + "--------------------------------\n",
                super.toString(), 
                obtenerMinN(), 
                obtenerCostoMinN(), 
                obtenerMinInt(), 
                obtenerCostoMinInt(), 
                obtenerPagoMensual());
        
        return cadena;
    }
    
}
