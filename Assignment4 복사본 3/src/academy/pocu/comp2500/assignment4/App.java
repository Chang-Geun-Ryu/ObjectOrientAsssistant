package academy.pocu.comp2500.assignment4;

import academy.pocu.comp2500.assignment4.registry.Registry;

public class App {
    public App(Registry registry) {

        registry.registerDrawPixelCommandCreator("DrawPixel");
        registry.registerIncreasePixelCommandCreator("IncreasePixel");
        registry.registerDecreasePixelCommandCreator("DecreasePixel");
        registry.registerToUppercaseCommandCreator("ToUpper");
        registry.registerToLowercaseCommandCreator("ToLower");
        registry.registerFillHorizontalLineCommandCreator("FillHorizontalLine");
        registry.registerFillVerticalLineCommandCreator("FillVerticalLine");
        registry.registerClearCommandCreator("Clear");

    }
}
