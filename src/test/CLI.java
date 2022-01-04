package test;

import java.util.ArrayList;

import test.Commands.Command;
import test.Commands.DefaultIO;

public class CLI {

	ArrayList<Command> commands;
	DefaultIO dio;
	Commands c;
	
	public CLI(DefaultIO dio) {
		this.dio=dio;
		c=new Commands(dio); 
		commands=new ArrayList<>();
		// example: commands.add(c.new ExampleCommand());
		// implement
		commands.add(c.new ExampleCommand());
		commands.add(c.new Command1());
		commands.add(c.new Command2());
		commands.add(c.new Command3());
		commands.add(c.new Command4());
		commands.add(c.new Command5());
	}
	
	public void start() {
		commands.get(0).execute();
		commands.get(1).execute();
		commands.get(2).execute();
		commands.get(3).execute();
		commands.get(4).execute();
		commands.get(5).execute();
	}
}
