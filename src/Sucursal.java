
public class Sucursal {
	private final static int MaxCol = 5;
	private final static int MaxFil = 3;
	private  int [][]Mat = new int [MaxFil][MaxCol];
	
	//constructor sucursal
	public Sucursal(){
		iniciar_matriz(Mat);
	}
	
	//inicia la matriz de sucursal en -1
	private void iniciar_matriz(int[][]M) {
		for (int i = 0; i < MaxFil; i++) {
			for (int j = 0; j < MaxCol; j++) {
				M[i][j]=-1;
			}
		}
	}
	
	//imprime los productos que la sucursal trabaja
	public  void imprimir_productos() {
		int j = 0;
		for (int i = 0;  i< MaxCol; i++) {
			if(Mat[0][i]!= -1) {
				System.out.println("id producto: "+i+ " cantidad: "+Mat[j][i]+" min: "
						+Mat[j+1][i]+" max: "+Mat[j+2][i]);
			}
			
		}
	}
	
	//setea el producto en la matriz
	public  void set_producto(int producto, int cantidad, int min, int max) {
		if (producto<MaxCol) {
			Mat[0][producto]=cantidad;
			Mat[1][producto]=min;
			Mat[2][producto]=max;
		}
		else System.out.println("producto incorrecto");
	}
	
	//vende el poducto si esta sucursal lo travbaja y si tiene en disponible
	public  void vender_producto(int producto, int cantidad) {
		if (Mat[0][producto]!=-1) {
			if (Mat[0][producto]>0) {
				Mat[0][producto]-=cantidad;
			}
			else {
				System.out.println("cantidad insuficiente");
			}
		}
		else System.out.println("producto no trabajado por esta sucursal");
	}
	
	//devuelve la cantidad de productos faltantes
	public  int cant_prod_faltantes() {
		int aux = 0;
		for (int i = 0; i < MaxCol; i++) {
			if ((Mat[0][i]!=-1)&&(Mat[0][i]<Mat[1][i])) {
				aux++;
			}
		}
		return aux;
	}
	
	//devuelve el producto faltante
	public  int producto_faltante() {
		int i = 0;
		boolean encontrado=false;
		while ((i<MaxCol)&&(encontrado==false)) {
			if ((Mat[0][i]!=-1)&&(Mat[0][i]<Mat[1][i])) {
				encontrado = true;
			}
			else i++;
		}
		if (i<MaxCol) {
			return i;
		}
		else return -1;
	}
	
	//devuelve la cantidad de productos faltantes
	public  int cantidad_faltante(int producto) {
		return ((Mat[2][producto]-Mat[1][producto])/2)-Mat[0][producto];
	}
	
	//suma al stock acutal en la matriz de dicho producto la cantidad ingresada
	public  void sumar_stock_producto (int producto, int cantidad) {
		Mat[0][producto]+= cantidad;
	}
	
	//devuelve la diferencia entre la cantidad maxima y la minima, si no trabaja dicho producto devuelve 0
	public  int get_diferencia_max_actual(int producto) {
		if (Mat[0][producto]!=-1) {
			 return Mat[2][producto]-Mat[0][producto];
		}
		else return 0;
	 }
}
