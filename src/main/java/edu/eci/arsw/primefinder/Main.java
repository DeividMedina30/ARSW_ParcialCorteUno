package edu.eci.arsw.primefinder;

import java.util.ArrayList;

public class Main {

	private static PrimeFinderThread pft;
	private static PrimeFinderThread pft2;
	private static PrimeFinderThread pft3;

	/**
	 * Función que me permite iniciar los hilos apra buscar primos.
	 * @param totalNumeros - Int, La cantidad total de números a revisar.
	 * @param divisionUno - Int, Primera subdivisión del total de números.
	 * @param divisionDos - Int, Segund subdivisión del total de números.
	 * @param numerosPrimos - ArrayList<Integer>, ArrayList donde se van a guardar los primos encontrados.
	 * @throws InterruptedException
	 */
	private static void iniciarHilos(int totalNumeros,int divisionUno,int divisionDos, ArrayList<Integer> numerosPrimos) throws InterruptedException {
		pft = new PrimeFinderThread(0, divisionUno, numerosPrimos);
		pft2 = new PrimeFinderThread(divisionUno + 1, divisionDos, numerosPrimos);
		pft3 = new PrimeFinderThread(divisionDos + 1, totalNumeros, numerosPrimos);
		pft.start();
		pft2.start();
		pft3.start();
		pft.join();
		pft2.join();
		pft3.join();
	}

	/**
	 * Función que me permite imprimir los números primos del ArrayList de primos.
	 * @param numerosPrimos - ArrayList<Integer>, ArrayList que contiene los primos encontrados.
	 */
	private static void imprimirPrimos(ArrayList<Integer> numerosPrimos){
		System.out.println("Números encontrados: "+numerosPrimos.size());
		for (Integer numero : numerosPrimos) {
			System.out.println(numero);
		}
		System.out.println("Total de numeros: "+numerosPrimos.size());
	}

	public static void main(String[] args) throws InterruptedException {
		//No debe modificar el tipo de objeto "numerosPrimos"
		ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();
		int totalNumeros = 30000000;
		int divisionUno = (totalNumeros/3);
		int divisionDos = (totalNumeros/3) + divisionUno;
		iniciarHilos(totalNumeros,divisionUno,divisionDos, numerosPrimos);
		imprimirPrimos(numerosPrimos);
	}


}
