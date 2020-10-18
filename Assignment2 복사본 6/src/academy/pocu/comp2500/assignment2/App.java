package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        registry.registerRedStampCreator("RedStamp");
        registry.registerGreenStampCreator("GreenStamp");
        registry.registerBlueStampCreator("BlueStamp");

        registry.registerWallCalendarCreator("WallCalendar");
        registry.registerDeskCalendarCreator("DeskCalendar");
        registry.registerMagnetCalendarCreator("MagnetCalendar");

        registry.registerLandscapeBannerCreator("LandscapeBanner");
        registry.registerPortraitBannerCreator("PortraitBanner");
        registry.registerGlossBannerCreator("GlossBanner");
        registry.registerScrimBannerCreator("ScrimBanner");
        registry.registerMeshBannerCreator("MeshBanner");

        registry.registerLandscapeBusinessCardCreator("LandscapeBusinessCard");
        registry.registerPortraitBusinessCardCreator("PortraitBusinessCard");
        registry.registerIvoryBusinessCardCreator("IvoryBusinessCard");
        registry.registerGrayBusinessCardCreator("GrayBusinessCard");
        registry.registerWhiteBusinessCardCreator("WhiteBusinessCard");
        registry.registerLaidBusinessCardCreator("LaidBusinessCard");
        registry.registerLinenBusinessCardCreator("LinenBusinessCard");
        registry.registerSmoothBusinessCardCreator("SmoothBusinessCard");
        registry.registerSingleSidedBusinessCardCreator("SingleSideBusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("DoubleSideBusinessCard");

        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");

        registry.registerLandscapeBannerTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerGlossBannerTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerGlossBannerImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerScrimBannerTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerScrimBannerImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerMeshBannerTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerMeshBannerImageApertureAdder("ProductWithImage", "addAperture");

        registry.registerLandscapeBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerIvoryBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerLaidBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ProductWithImage", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ProductWithImage", "addAperture");
    }
}
