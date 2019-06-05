
public class SimularRedMayorista {

	public static void main(String[] args) {
		Central c1 = new Central();
		c1.set_producto(0, 30, 10, 80);
		c1.set_producto(1, 40, 20, 90);
		c1.set_producto(2, 50, 30, 90);
		c1.set_producto(3, 60, 40, 90);
		c1.set_producto(4, 70, 50, 100);
		c1.set_sucursal(0);
		c1.set_sucursal(1);
		c1.set_sucursal(2);
		c1.set_producto_sucursal(0, 0, 20, 10, 30);
		c1.set_producto_sucursal(1, 0, 20, 10, 30);
		c1.set_producto_sucursal(3, 0, 30, 10, 79);
		c1.imprimir_productos_sucursales();
		c1.imprimir_productos_central();
	}

}
