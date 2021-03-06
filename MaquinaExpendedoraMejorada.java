public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Cantidad de billetes vendidos
    private int cantidadDeBilletesVendidos;
    //M?quina con premio o sin premio
    private boolean billetePremio;
    //N?mero m?ximo de billetes disponibles
    private int numeroMaximoBilletes;
    //Tercer billete con premio
    private int tercerBillete;
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino,boolean premioono,int numeroMaximoDeBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        cantidadDeBilletesVendidos = 0;
        billetePremio = premioono;
        numeroMaximoBilletes = numeroMaximoDeBilletes ;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    
    public int vaciarDineroDeLaMaquina() {
        int dineroEnLaMaquina=totalDineroAcumulado;
        if(balanceClienteActual>0) {
            System.out.println("Operaci?n introducirDinero en curso");
            dineroEnLaMaquina=-1;
        }
        else {
            dineroEnLaMaquina= balanceClienteActual + totalDineroAcumulado;
            totalDineroAcumulado=0;
        }
        return dineroEnLaMaquina;
    }
    
    public int getNumeroBilletesVendidos() {
        return cantidadDeBilletesVendidos;
        
    
    }
    
    public void imprimeNumeroBilletesVendidos() {
         System.out.println(cantidadDeBilletesVendidos);
    
    }
    


    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadDeBilletesVendidos >= numeroMaximoBilletes){
            System.out.println("N?mero de billetes m?ximos agotado");

        }
    
        else {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            
            else if(cantidadIntroducida <0) {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
            
        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta= precioBillete - balanceClienteActual;
        if (cantidadDeBilletesVendidos >= numeroMaximoBilletes){
            System.out.println("N?mero de billetes m?ximos agotado");
            
        }
        else{
            // Simula la impresion de un billete
            if (cantidadDeDineroQueFalta<=0){
                if(billetePremio ==true){ 
                    if(tercerBillete==2){ 
                    System.out.println( ((precioBillete*10)/100)  + "? de descuento en Mercadona");
                }
                    
                }
            
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // Actualiza el n?mero de billetes vendidos
                cantidadDeBilletesVendidos= cantidadDeBilletesVendidos + 1;
                // Suma billete
                tercerBillete = tercerBillete + 1;
                if(tercerBillete ==3){
                    tercerBillete =0;
                }
            } 
            else if(cantidadDeDineroQueFalta >0) {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                    
            }                  
    
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
