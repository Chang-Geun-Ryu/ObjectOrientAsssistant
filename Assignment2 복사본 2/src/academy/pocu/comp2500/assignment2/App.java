package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
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
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");
        registry.registerLandscapeBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerLandscapeBannerImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerPortraitBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerPortraitBannerImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerGlossBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerGlossBannerImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerScrimBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerScrimBannerImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerMeshBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerMeshBannerImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerLandscapeBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerPortraitBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerPortraitBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerIvoryBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerIvoryBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerGrayBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerGrayBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerWhiteBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerWhiteBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerLaidBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerLaidBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerLinenBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerLinenBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerSmoothBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerSmoothBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addImagePath");
    }
}
