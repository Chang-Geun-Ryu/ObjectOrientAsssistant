package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");
        registry.registerWallCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
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
        registry.registerCartCreator("ShoppingCart");
        registry.registerProductAdder("ShoppingCart", "addItem");
        registry.registerProductRemover("ShoppingCart", "removeItem");
        registry.registerTotalPriceGetter("ShoppingCart", "getTotalPrice");
        registry.registerLandscapeBannerTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerLandscapeBannerImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerPortraitBannerTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerPortraitBannerImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerGlossBannerTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerGlossBannerImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerScrimBannerTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerScrimBannerImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerMeshBannerTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerMeshBannerImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerLandscapeBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ProductWithApertures", "addTextAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ProductWithApertures", "addImageAperture");
    }
}
