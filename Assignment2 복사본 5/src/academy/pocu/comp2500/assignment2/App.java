package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // 1~ Stamp
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");

        // 4~ Calendar
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");

        // 7~ Banner
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");

        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");

        // 12~ BusinessCard
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

        // 22~ Cart
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");

        // 26~ Banner
        registry.registerLandscapeBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerPortraitBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("ApertureProduct", "addImageAperture");

        registry.registerGlossBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerScrimBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerMeshBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("ApertureProduct", "addImageAperture");

        // 36~ BusinessCard
        registry.registerLandscapeBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");

        registry.registerIvoryBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");

        registry.registerLaidBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");

        registry.registerSingleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
    }
}
