package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerDrawPixelCommandCreator("Foo");
        // OR
        // registry.registerDrawPixelCommandCreator("Foo", "bar");

        registry.registerDrawPixelCommandCreator("Canvas", "drawPixel");
        registry.registerIncreasePixelCommandCreator("Canvas", "increasePixel");
        registry.registerDecreasePixelCommandCreator("Canvas", "decreasePixel");
        registry.registerToUppercaseCommandCreator("Canvas", "toUpper");
        registry.registerToLowercaseCommandCreator("Canvas", "toLower");
        registry.registerFillHorizontalLineCommandCreator("Canvas", "fillHorizontalLine");
        registry.registerFillVerticalLineCommandCreator("Canvas", "fillVerticalLine");
        registry.registerClearCommandCreator("Canvas", "clear");
    }
}
