import Scanner.*;
import Parser.sym;
import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java.io.*;

public class MiniJava {
	
	public static void main(String[] args) {
		try {
			if(args[0].contentEquals("-S")) {
				RunScanner(args[1]);
			}
			
		} catch (Exception e) {
			System.err.println("Unexpected Compiler Error: " + e.toString());
			//prints stack dump
			e.printStackTrace();
		}
	}
	
	public static void RunScanner(String fname) {
		try {
			ComplexSymbolFactory sf = new ComplexSymbolFactory();
			Reader in = new BufferedReader(new FileReader(fname));
			scanner s = new scanner(in, sf);
			Symbol t = s.next_token();
			while(t.sym != sym.EOF) {
				//print each token scanned
				System.out.println(s.symbolToString(t) );
				t = s.next_token();
			} System.out.print("\nLexical analysis completed");
		} catch (Exception e) {
			System.err.println("Unexpected Compiler Error: " + e.toString());
			//prints stack dump
			e.printStackTrace();
		}
	}
	
}