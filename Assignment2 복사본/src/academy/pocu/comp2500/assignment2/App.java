package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");
        // ##########################################################################################
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");
        // ##########################################################################################
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");
        // ----------------------------------------------------------------------
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");
        // ##########################################################################################
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        // ----------------------------------------------------------------------
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        // ----------------------------------------------------------------------
        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        // ----------------------------------------------------------------------
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");
        // ##########################################################################################
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");
        // ##########################################################################################
        registry.registerLandscapeBannerTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerPortraitBannerTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerGlossBannerTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerGlossBannerImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerScrimBannerTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerScrimBannerImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerMeshBannerTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerMeshBannerImageApertureAdder("CustomizingProduct", "addAperture");
        // ##########################################################################################
        registry.registerLandscapeBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerPortraitBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerIvoryBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerGrayBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerWhiteBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerLaidBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerLinenBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerSmoothBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerSingleSidedBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
        // ----------------------------------------------------------------------
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("CustomizingProduct", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("CustomizingProduct", "addAperture");
    }
}
