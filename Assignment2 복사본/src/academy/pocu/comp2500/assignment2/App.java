package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        // register your classes or methods here

        //registerRedStampCreator(): 빨강 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerRedStampCreator("Stamp");
        //registerBlueStampCreator(): 파랑 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerBlueStampCreator("Stamp");
        //registerGreenStampCreator(): 녹색 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGreenStampCreator("Stamp");


        //registerWallCalendarCreator(): 벽걸이 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWallCalendarCreator("Calendar");
        //registerMagnetCalendarCreator(): 자석 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMagnetCalendarCreator("Calendar");
        //registerDeskCalendarCreator(): 탁상 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDeskCalendarCreator("Calendar");


        //registerLandscapeBannerCreator(): 가로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBannerCreator("Banner");
        //registerPortraitBannerCreator(): 세로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBannerCreator("Banner");
        //registerGlossBannerCreator(): 반사 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGlossBannerCreator("Banner");
        //registerScrimBannerCreator(): 스크림 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerScrimBannerCreator("Banner");
        //registerMeshBannerCreator(): 메쉬 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMeshBannerCreator("Banner");


        //registerLandscapeBusinessCardCreator(): 가로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        //registerPortraitBusinessCardCreator(): 세로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        //registerIvoryBusinessCardCreator(): 아이보리 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        //registerGrayBusinessCardCreator(): 회색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGrayBusinessCardCreator("BusinessCard");
        //registerWhiteBusinessCardCreator(): 흰색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWhiteBusinessCardCreator("BusinessCard");
        //registerLaidBusinessCardCreator(): 레이드지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLaidBusinessCardCreator("BusinessCard");
        //registerLinenBusinessCardCreator(): 린넨커버 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLinenBusinessCardCreator("BusinessCard");
        //registerSmoothBusinessCardCreator(): 스노우지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSmoothBusinessCardCreator("BusinessCard");
        //registerSingleSidedBusinessCardCreator(): 단면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        //registerDoubleSidedBusinessCardCreator(): 양면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");

        //registerCartCreator(): 장바구니를 만드는 생성자를 등록한다.
        registry.registerCartCreator("ProductBasket");
        //registerProductAdder(): 장바구니에 상품을 추가하는 메서드를 등록한다.
        registry.registerProductAdder("ProductBasket", "addProduct");
        //registerProductRemover(): 장바구니에서 상품을 제거하는 메서드를 등록한다.
        registry.registerProductRemover("ProductBasket", "removeProduct");
        //registerTotalPriceGetter(): 장바구니에서 총액을 구해오는 메서드를 등록한다.
        registry.registerTotalPriceGetter("ProductBasket", "getTotalPrice");

        //registerLandscapeBannerTextApertureAdder(): 가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerLandscapeBannerImageApertureAdder(): 가로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerPortraitBannerTextApertureAdder(): 세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerPortraitBannerImageApertureAdder(): 세로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerGlossBannerTextApertureAdder(): 반사 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerGlossBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerGlossBannerImageApertureAdder(): 반사 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerGlossBannerImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerScrimBannerTextApertureAdder(): 스크림 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerScrimBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerScrimBannerImageApertureAdder(): 스크림 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerScrimBannerImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerMeshBannerTextApertureAdder(): 메쉬 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerMeshBannerTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerMeshBannerImageApertureAdder(): 메쉬 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerMeshBannerImageApertureAdder("ApertureProduct", "addImageAperture");

        //registerLandscapeBusinnessCardTextApertureAdder(): 가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerLandscapeBusinnessCardImageApertureAdder(): 가로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerPortraitBusinnessCardTextApertureAdder(): 세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerPortraitBusinnessCardImageApertureAdder(): 세로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerIvoryBusinnessCardTextApertureAdder(): 아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerIvoryBusinnessCardImageApertureAdder(): 아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerGrayBusinnessCardTextApertureAdder(): 회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerGrayBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerGrayBusinnessCardImageApertureAdder(): 회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerGrayBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerWhiteBusinnessCardTextApertureAdder(): 흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerWhiteBusinnessCardImageApertureAdder(): 흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerLaidBusinnessCardTextApertureAdder(): 레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLaidBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerLaidBusinnessCardImageApertureAdder(): 레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLaidBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerLinenBusinnessCardTextApertureAdder(): 린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerLinenBusinnessCardImageApertureAdder(): 린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLinenBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerSmoothBusinnessCardTextApertureAdder(): 스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerSmoothBusinnessCardImageApertureAdder(): 스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerSingleSidedBusinnessCardTextApertureAdder(): 단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerSingleSidedBusinnessCardImageApertureAdder(): 단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
        //registerDoubleSidedBusinnessCardTextApertureAdder(): 양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ApertureProduct", "addTextAperture");
        //registerDoubleSidedBusinnessCardImageApertureAdder(): 양면 명함에 사진을 추s가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ApertureProduct", "addImageAperture");
    }
}
