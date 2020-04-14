import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.String;
import java.util.HashMap;


public class secundario {

static int numero;
static int numbertwo;
static int total ;
static int contador;

	

		public secundario(int number) {
		numero = number;
		}
		
		void numerodos(int number) {
			numbertwo = number;
			}
		
		void multiplicacion () {
		numbertwo = 25;
		total = numero * numbertwo;
		}
		
          void multiplicacionstatic () {
			int total = 5;
			System.out.println(total);	
			}
		
		
		void imprimir () {
		multiplicacion();
		total = 90;
		System.out.println(this.total);
		System.out.println(total);	
		}

	

}
