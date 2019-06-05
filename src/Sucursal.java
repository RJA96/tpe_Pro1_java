
public class Sucursal {
	private final static int MaxCol = 5;
	private final static int MaxFil = 3;
	private static int [][]Mat = new int [MaxFil][MaxCol];
	
	public Sucursal(){
		iniciar_matriz(Mat);
	}
	private static void iniciar_matriz(int[][]M) {
		for (int i = 0; i < MaxFil; i++) {
			for (int j = 0; j < MaxCol; j++) {
				M[i][j]=-1;
			}
		}
	}
	
	public static void imprimir_productos() {
		int j = 0;
		for (int i = 0;  i< MaxCol; i++) {
			if(Mat[0][i]!= -1) {
				System.out.println("id producto: "+i+ " cantidad: "+Mat[j][i]+" min: "
						+Mat[j+1][i]+" max: "+Mat[j+2][i]);
			}
			
		}
	}
	
	public static void set_producto(int producto, int cantidad, int min, int max) {
		if (producto<MaxCol) {
			Mat[0][producto]=cantidad;
			Mat[1][producto]=min;
			Mat[2][producto]=max;
		}
		else System.out.println("producto incorrecto");
	}
	public static void vender_producto(int producto, int cantidad) {
		if (Mat[0][producto]>0) {
			Mat[0][producto]-=cantidad;
		}
		else {
			System.out.println("cantidad insuficiente");
		}
	}
	
}
