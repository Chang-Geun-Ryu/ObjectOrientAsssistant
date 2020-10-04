package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here
        /// 2개 가능
        registry.registerRedStampCreator("Stamp");//, "createRed");
        registry.registerBlueStampCreator("Stamp");//, "createBlue");
        registry.registerGreenStampCreator("Stamp");//, "createGreen");
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

        registry.registerLandscapeBannerTextApertureAdder("Option", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("Option", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("Option", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("Option", "addAperture");
        registry.registerGlossBannerTextApertureAdder("Option", "addAperture");
        registry.registerGlossBannerImageApertureAdder("Option", "addAperture");
        registry.registerScrimBannerTextApertureAdder("Option", "addAperture");
        registry.registerScrimBannerImageApertureAdder("Option", "addAperture");
        registry.registerMeshBannerTextApertureAdder("Option", "addAperture");
        registry.registerMeshBannerImageApertureAdder("Option", "addAperture");
        registry.registerLandscapeBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("Option", "addAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("Option", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("Option", "addAperture");
    }
}
