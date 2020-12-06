package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerDrawPixelCommandCreator("Foo");
        // OR
        // registry.registerDrawPixelCommandCreator("Foo", "bar");
        registry.registerClearCommandCreator("CommandClear");
        registry.registerDecreasePixelCommandCreator("CommandDecreasePixel");
        registry.registerDrawPixelCommandCreator("CommandDrawPixel");
        registry.registerFillHorizontalLineCommandCreator("CommandFillHorizontalLine");
        registry.registerFillVerticalLineCommandCreator("CommandFillVerticalLine");
        registry.registerToLowercaseCommandCreator("CommandToLower");
        registry.registerIncreasePixelCommandCreator("CommandIncreasePixel");
        registry.registerToUppercaseCommandCreator("CommandToUpper");
    }
}
