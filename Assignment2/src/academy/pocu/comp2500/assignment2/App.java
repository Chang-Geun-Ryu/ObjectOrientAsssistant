package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here

        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");
        registry.registerLandscapeBusinessCardCreator("BusinnessCard");
        registry.registerPortraitBusinessCardCreator("BusinnessCard");
        registry.registerIvoryBusinessCardCreator("BusinnessCard");
        registry.registerGrayBusinessCardCreator("BusinnessCard");
        registry.registerWhiteBusinessCardCreator("BusinnessCard");
        registry.registerLaidBusinessCardCreator("BusinnessCard");
        registry.registerLinenBusinessCardCreator("BusinnessCard");
        registry.registerSmoothBusinessCardCreator("BusinnessCard");
        registry.registerSingleSidedBusinessCardCreator("BusinnessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinnessCard");
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");
        registry.registerLandscapeBannerTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerGlossBannerTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerGlossBannerImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerScrimBannerTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerScrimBannerImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerMeshBannerTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerMeshBannerImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerLandscapeBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addAperture");

    }
}
