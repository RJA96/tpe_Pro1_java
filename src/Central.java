public class Central {
	//declaracion de constantes
	private final static int MaxCol = 5;
	private final static int MaxFil = 3;
	private final static int MaxSuc = 10;
	
	//declaracion de variables
	private int [][]Mat = new int [MaxFil][MaxCol];
	private Sucursal []Arr_suc = new Sucursal [MaxSuc];
	private int ocupados = 0;
	
	//constructor de central
	public  Central() {
		iniciar_matriz(Mat);
	}
	
	//crea la instancia de sucursal en el arreglo
	public void set_sucursal(int sucursal){
		if ((sucursal< MaxSuc)&&(Arr_suc[sucursal]==null)) {
			Arr_suc[sucursal] = new Sucursal();
			ocupados +=1;
		}
		
	}
	
	//inicia la matriz en 0
	private  void iniciar_matriz(int[][]M) {
		for (int i = 0; i < MaxFil; i++) {
			for (int j = 0; j < MaxCol; j++) {
				M[i][j]=0;
			}
		}
	}
	
	//setea un producto en la Matriz de la sentral
	public void set_producto(int producto, int cantidad, int min, int max) {
		if (producto<MaxCol) {
			Mat[0][producto]=cantidad;
			Mat[1][producto]=min;
			Mat[2][producto]=max;
		}	
	}
	
	//setea un producto a una sucursal determinada
	public void set_producto_sucursal(int sucursal,int producto, int cantidad, int min, int max) {
		if (sucursal<ocupados) {
			Arr_suc[sucursal].set_producto(producto, cantidad, min, max);
		}
		else System.out.println("la sucursal no existe");
		
	}
	
	//imprime la matriz de la central
	public void imprimir_productos_central() {
		int j = 0;
		System.out.println("Central");
		for (int i = 0;  i< MaxCol; i++) {
			System.out.println("id producto: "+i+ " cantidad: "+Mat[j][i]+" min: "
					+Mat[j+1][i]+" max: "+Mat[j+2][i]);
		}
	}
	
	//imprime los productos de todas las sucursales
	public void imprimir_productos_sucursales() {
		for (int i = 0; i < ocupados; i++) {
			if (Arr_suc[i]!=null) {
				System.out.println("Sucursal "+ i);
				Arr_suc[i].imprimir_productos();
			}
		}
	}
	//provee de productos faltantes a una sucursal si es que 
	public void proveer_sucursal (int sucursal) {
		int aux, j;
		for (int i = 0;i<Arr_suc[sucursal].cant_prod_faltantes();i++) {
			if (Arr_suc[sucursal].producto_faltante()!=-1) {
				j = Arr_suc[sucursal].producto_faltante();
				aux = Arr_suc[sucursal].cantidad_faltante(j);
				if (Mat[0][j]>=aux) {
					Arr_suc[sucursal].sumar_stock_producto(j, aux);
					Mat[0][j]-=aux;
				}
				else System.out.println("cantidad en central menor a la requerida");
			}
			else System.out.println("stock correcto");
		}
	}
	
	//vende productos de una sucursal dada
	public void vender_producto_sucursal(int suc, int prod, int cant) {
		if (suc<ocupados) {
			Arr_suc[suc].vender_producto(prod, cant);
		}
		else System.out.println("la sucursal no existe");
	}
	
	//provee los productos que todas las sucursales existentes necesitan
	public void proveer_todas_sucursales () {
		for (int i = 0; i < ocupados; i++) {
			proveer_sucursal(i);
		}
	}
	
	//para reponer hace la diferencia de si mismo con la diferencia de cada sucursal
	public int cantidad_maxima_a_adquirir(int producto) {
		int aux = 0;
		for (int i = 0; i < ocupados; i++) {
			aux += Arr_suc[i].get_diferencia_max_actual(producto);
		}
		return aux+(Mat[2][producto]-Mat[0][producto]);
	}
}
