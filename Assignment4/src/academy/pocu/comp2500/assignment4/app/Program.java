package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.App;
import academy.pocu.comp2500.assignment4.registry.Registry;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
