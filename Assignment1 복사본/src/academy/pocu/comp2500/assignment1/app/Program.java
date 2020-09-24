package academy.pocu.comp2500.assignment1.app;

import academy.pocu.comp2500.assignment1.App;
import academy.pocu.comp2500.assignment1.registry.Registry;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();


    }
}
