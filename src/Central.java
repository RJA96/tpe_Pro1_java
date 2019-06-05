public class Central {
	private final static int MaxCol = 5;
	private final static int MaxFil = 3;
	private final static int MaxSuc = 10;
	private static int [][]Mat = new int [MaxFil][MaxCol];
	private static Sucursal []Arr_suc = new Sucursal [MaxSuc];
	public  Central() {
		iniciar_matriz(Mat);
	}
	
	private static void iniciar_matriz(int[][]M) {
		for (int i = 0; i < MaxFil; i++) {
			for (int j = 0; j < MaxCol; j++) {
				M[i][j]=0;
			}
		}
	}
	
	public static void set_producto(int producto, int cantidad, int min, int max) {
		if (producto<MaxCol) {
			Mat[0][producto]=cantidad;
			Mat[1][producto]=min;
			Mat[2][producto]=max;
		}	
	}
	
	public static void set_producto_sucursal(int sucursal,int producto, int cantidad, int min, int max) {
		Arr_suc[sucursal].set_producto(producto, cantidad, min, max);
	}
	public static void imprimir_productos_central() {
		int j = 0;
		for (int i = 0;  i< MaxCol; i++) {
			System.out.println("id producto: "+i+ " cantidad: "+Mat[j][i]+" min: "
					+Mat[j+1][i]+" max: "+Mat[j+2][i]);
		}
	}
	
	public static void imprimir_productos_sucursales() {
		for (int i = 0; i < MaxSuc; i++) {
			
			Sucursal.imprimir_productos();
		}
	}
	
}
