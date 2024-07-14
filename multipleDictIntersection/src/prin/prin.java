package prin;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import imp.ConjuntoLD;
import imp.DicMultipleLD;

public class prin {

	public static void mostrarDiccionario(DiccionarioMultipleTDA A) {
		ConjuntoTDA claves = A.Claves();
		ConjuntoTDA valores;
		int x;
		while(!claves.ConjuntoVacio()) {
			x = claves.Elegir();
			claves.Sacar(x);
			System.out.print("Clave: " + x + " ");
			valores = A.Recuperar(x);
			mostrarConjunto(valores);
		}
	}
	
	public static ConjuntoTDA interseccion(ConjuntoTDA A, ConjuntoTDA B) {
		ConjuntoTDA C = new ConjuntoLD();
		C.InicializarConjunto();
		int x;
		while(!A.ConjuntoVacio()) {
			x = A.Elegir();
			A.Sacar(x);
			if(B.Pertenece(x))
				C.Agregar(x);
		}
		return C;
	}
	
	public static void mostrarConjunto(ConjuntoTDA A) {
		System.out.print("{");
		int x;
		while(!A.ConjuntoVacio()) {
			x = A.Elegir();
			A.Sacar(x);
			System.out.print(x);
			if(!A.ConjuntoVacio())
				System.out.print(", ");
		}
		System.out.println("}");
	}
	
	public static DiccionarioMultipleTDA interseccionDiccionarios(DiccionarioMultipleTDA A, DiccionarioMultipleTDA B) {
		DiccionarioMultipleTDA C = new DicMultipleLD();
		C.InicializarDiccionario();
		ConjuntoTDA K1 = A.Claves();
		ConjuntoTDA K2 = B.Claves();
		ConjuntoTDA K = interseccion(K1, K2);
		ConjuntoTDA V;
		int clave;
		int valor;
		while(!K.ConjuntoVacio()) {
			clave = K.Elegir();
			K.Sacar(clave);
			K1 = A.Recuperar(clave);
			K2 = B.Recuperar(clave);
			V = interseccion(K1, K2);
			while(!V.ConjuntoVacio()) {
				valor = V.Elegir();
				V.Sacar(valor);
				C.Agregar(clave, valor);
			}
		}
		return C;
	}
	
	public static void main(String[] args) {
		DiccionarioMultipleTDA A = new DicMultipleLD();
		A.InicializarDiccionario();
		DiccionarioMultipleTDA B = new DicMultipleLD();
		B.InicializarDiccionario();
		A.Agregar(1,2);
		A.Agregar(1,3);
		A.Agregar(1,5);
		A.Agregar(1,7);
		A.Agregar(1, 9);
		A.Agregar(2, 1);
		A.Agregar(2, 2);
		A.Agregar(2, 5);
		A.Agregar(3, 2);
		A.Agregar(3, 4);
		A.Agregar(3, 6);
		A.Agregar(3, 8);
		A.Agregar(3, -11);
		A.Agregar(5, 3);
		A.Agregar(7, 1);
		A.Agregar(7, 2);
		A.Agregar(7, 3);
		A.Agregar(7, 5);
		A.Agregar(7, 8);
		B.Agregar(1, 2);
		B.Agregar(1, 3);
		B.Agregar(1, 4);
		B.Agregar(2, 1);
		B.Agregar(2, 3);
		B.Agregar(2, 5);
		B.Agregar(2, 7);
		B.Agregar(3, 1);
		B.Agregar(3, 3);
		B.Agregar(3, 5);
		B.Agregar(3, 7);
		B.Agregar(4, 2);
		B.Agregar(4, 4);
		B.Agregar(4, 6);
		B.Agregar(4, 8);
		B.Agregar(5, 3);
		DiccionarioMultipleTDA C = interseccionDiccionarios(A, B);
		System.out.println("Diccionario 1");
		mostrarDiccionario(A);
		System.out.println("Diccionario 2");
		mostrarDiccionario(B);
		System.out.println("Intersección");
		mostrarDiccionario(C);
	}

}
