package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here

        // stamp
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");

        // calendar
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");

        // banner
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");

        // businesscard
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");

        // cart
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");

        // add aperture to banner
        registry.registerLandscapeBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGlossBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGlossBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerScrimBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerScrimBannerImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerMeshBannerTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerMeshBannerImageApertureAdder("CustomizableProduct", "addAperture");

        // add aperture to businesscard
        registry.registerLandscapeBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("CustomizableProduct", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("CustomizableProduct", "addAperture");
    }
}
