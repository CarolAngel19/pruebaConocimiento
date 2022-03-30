import java.util.InputMismatchException;
import java.util.Scanner;

public class CodigoMorse {
	
	public static void main(String[] arg) {
		
		String[] espa�ol= {"A", "B", "C", "D", "E","F","G","H","I","J","K","L","M","N","�","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] morse= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		
		boolean fin = false;
		Scanner s = new Scanner(System.in);
		int opc = 0;
		System.out.println("Codigo Morse");
		
		do {
		System.out.println("Ingrese una opcioin");
		System.out.println("1) Traducir de Espa�ol a Morse");
		System.out.println("2) Traducir de Morse a Espa�ol");
		System.out.println("3) Salir");
		opc = comprobarDatoEnteroIngresado(s,1,3);
		s.nextLine();
		fin = procesarOpcion(opc, s, espa�ol, morse);
		}while(!fin);

 }
	public static boolean procesarOpcion(int opc, Scanner s, String[] espa�ol, String[] morse) {
		if(opc==1) {
			System.out.println("Ingrese una frase");
			String frase = s.nextLine();
			String fraseATraducir = frase.toUpperCase();
			String mensajeTraducido = fraseMorse(fraseATraducir, espa�ol, morse);
			System.out.println("Traduccion de mensaje a codigo morse");
			System.out.println(mensajeTraducido);
		}else if (opc==2) {
			System.out.println("Ingrese una frase en morse");
			String frase = s.nextLine();
			String fraseATraducir = frase.toUpperCase();
			String mensajeTraducido = morseFrase(fraseATraducir, espa�ol, morse);
			System.out.println("Traduccion de mensaje a Espa�ol");
			System.out.println(mensajeTraducido);
			
		}else if(opc==3) {
			return true;
		}
		return false;
	}
	
	public static String morseFrase(String fraseATraducir, String[] espa�ol, String[] morse) {
		String mensajeEspa�ol="";
		String caracterMorse="";
		int i = 0;
		
		do {
			boolean terminarCaracter = false;
			
			do {
				if(Character.toString(fraseATraducir.charAt(i)).equals(" ")) {
				} else {
					caracterMorse+=Character.toString(fraseATraducir.charAt(i));
					i++;
				}
			}while((!terminarCaracter)&&(i<fraseATraducir.length()));
			
			int j = 0;
			boolean termina = false;
			
			do {
				if(caracterMorse.equals(morse[i])) {
					mensajeEspa�ol += espa�ol[j];
					termina = true;
				}
				j++;
				if(j==morse.length) {
					if(!termina) {
						termina = true;
					}
				}
			}while(!termina);
			
		caracterMorse="";
		i++;
		
		try {
			if(Character.toString(fraseATraducir.charAt(i)).equals(" ")) {
				if(Character.toString(fraseATraducir.charAt(i+1)).equals(" ")) {
					i+=2;
				}
			}
		}catch(StringIndexOutOfBoundsException e) {
			
		}catch(Exception e) {
			
		}
		}while(i<fraseATraducir.length());
		
		return mensajeEspa�ol;
	}
	public static String fraseMorse(String fraseATraducir, String[] espa�ol, String[] morse) {
		String mensajeMorse= "";
		
		for(int i = 0; i < fraseATraducir.length(); i++) {
			int j = 0;
			boolean terminar = false;
			if(Character.toString(fraseATraducir.charAt(i)).equals(" ")) {
				mensajeMorse += " ";
			
			} else {
				do {
					if(Character.toString(fraseATraducir.charAt(i)).equals(espa�ol[j])) {
						mensajeMorse += morse[j] + " ";
						terminar = true;
					}
					j++;
					if(j==espa�ol.length) {
						if(!terminar) {
							terminar = true;
							
						}
					}
				}while(!terminar);
					
			}
		}
		
		return mensajeMorse;
	}
	
	public static int comprobarDatoEnteroIngresado(Scanner s, int min, int max) {
		int valor = 0;
		boolean error = false;
		do {
			error = false;
			try {
				
				valor = s.nextInt();
				if(!((valor>=min) && (valor<=max))) {
					System.out.println("Valor mal ingresado");
					System.out.println("El valor debe estar entre" + min + " y " + max);
					error = true;
			}
		}catch (InputMismatchException e) {
			System.out.println("Tipo de datos mal ingresados. Se esperaba un numero");
			error = true;
			s.nextLine();
			
		}catch(Exception e) {
			System.out.println("Error inesperado" +e);
			error = true;
		}
	}while(error);
	return valor;
	
	}
}
	
