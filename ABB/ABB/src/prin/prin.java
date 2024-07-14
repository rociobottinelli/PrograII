package prin;

import api.ABBTDA;
import imp.ABB;

public class prin {

	public static int altura(ABBTDA a) {
		if (a.ArbolVacio())
			return -1;
		else
			return (1 + Math.max(altura(a.HijoIzq()),altura(a.HijoDer())));
	}
	
	public static void main(String[] args) {
		ABBTDA arbol = new ABB();
		arbol.AgregarElem(28);
		arbol.AgregarElem(15);
		arbol.AgregarElem(43);
		arbol.AgregarElem(10);
		arbol.AgregarElem(22);
		arbol.AgregarElem(39);
		arbol.AgregarElem(55);
		arbol.AgregarElem(2);
		arbol.AgregarElem(12);
		arbol.AgregarElem(17);
		arbol.AgregarElem(25);
		arbol.AgregarElem(33);
		arbol.AgregarElem(42);
		arbol.AgregarElem(45);
		arbol.AgregarElem(77);
		System.out.println(altura(arbol));
		arbol.AgregarElem(99);
		System.out.println(altura(arbol));
	}

}
