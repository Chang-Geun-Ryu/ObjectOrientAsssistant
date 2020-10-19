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
        registry.registerProductAdder("Cart", "addCart");
        registry.registerProductRemover("Cart", "removeCart");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");

        registry.registerLandscapeBannerTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerGlossBannerTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerGlossBannerImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerScrimBannerTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerScrimBannerImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerMeshBannerTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerMeshBannerImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerLandscapeBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("OrientationProduct", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("OrientationProduct", "addAperture");


    }
}
