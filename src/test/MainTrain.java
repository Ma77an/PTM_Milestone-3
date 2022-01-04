package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainTrain {

	public static void check(String outputFile,String expectedOutputFile){
		try {
			int chk[]={31,58,59,70,71,82,83,94,95,106,107};			
			BufferedReader st=new BufferedReader(new FileReader(outputFile));
			BufferedReader ex=new BufferedReader(new FileReader(expectedOutputFile));
			int i=1,j=0;
			String lst,lex;
			while((lst=st.readLine())!=null && (lex=ex.readLine())!=null){
				if(i<13 && lst.compareTo(lex)!=0){ // 12
					System.out.println("line "+i+" expected: "+lex+" you got "+lst);
					System.out.println("wrong output (-1)");
				}else
				if(j<11 && i==chk[j]){
					if(lst.compareTo(lex)!=0){ // 88
						System.out.println("line "+i+" expected: "+lex+" you got "+lst);
						System.out.println("wrong output (-8)");
					}
					j++;
				}
				i++;
			}
			if(j<11)
				System.out.println("wrong output size (-"+((11-j)*8)+")");
			st.close();
			ex.close();
		}catch(IOException e) {
			System.out.println("an exception has occured (-100)");
		}
	}

	public static class Stdio implements Commands.DefaultIO{
		Scanner reader;
		public Stdio(){
			reader = new Scanner(System.in);
		};


		@Override
		public String readText() {
			// Reading data using readLine
			String name = reader.next();
			return name;
		}

		@Override
		public void write(String text) {
			System.out.print(text);
		}

		@Override
		public float readVal() {
			return reader.nextFloat();
		}

		@Override
		public void write(float val) {
			System.out.println(val);
		}
	}
	
	
	public static void main(String[] args) {
//		FileIO fio=new FileIO("input.txt", "output.txt");
//		CLI cli=new CLI(fio);
//		cli.start();
//		fio.close();
//		check("output.txt","expectedOutput.txt");
//		System.out.println("done");
		Stdio stdio = new Stdio();
		CLI cli = new CLI(stdio);
		cli.start();
	}

}