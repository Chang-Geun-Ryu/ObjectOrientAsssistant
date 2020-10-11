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
        registry.registerLandscapeBannerImageApertureAdder("ApertureProduct", "addImage");
        registry.registerPortraitBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerPortraitBannerImageApertureAdder("ApertureProduct", "addImage");
        registry.registerGlossBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerGlossBannerImageApertureAdder("ApertureProduct", "addImage");
        registry.registerScrimBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerScrimBannerImageApertureAdder("ApertureProduct", "addImage");
        registry.registerMeshBannerTextApertureAdder("ApertureProduct", "addText");
        registry.registerMeshBannerImageApertureAdder("ApertureProduct", "addImage");
        registry.registerLandscapeBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerPortraitBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerPortraitBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerIvoryBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerIvoryBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerGrayBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerGrayBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerWhiteBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerWhiteBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerLaidBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerLaidBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerLinenBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerLinenBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerSmoothBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerSmoothBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addImage");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addText");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addImage");


    }
}
