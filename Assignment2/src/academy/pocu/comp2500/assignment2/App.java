package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        //빨강 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerRedStampCreator("Stamp");
        // 파랑 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerBlueStampCreator("Stamp");
        // 녹색 잉크 스탬프를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGreenStampCreator("Stamp");
        // 벽걸이 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWallCalendarCreator("Calendar");
        // 자석 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMagnetCalendarCreator("Calendar");
        // 탁상 달력을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDeskCalendarCreator("Calendar");
        // 가로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBannerCreator("Banner");
        // 세로 방향 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBannerCreator("Banner");
        // 반사 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGlossBannerCreator("Banner");
        // 스크림 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerScrimBannerCreator("Banner");
        // 메쉬 배너를 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerMeshBannerCreator("Banner");
        // 가로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLandscapeBusinessCardCreator("Card");
        // 세로 방향 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerPortraitBusinessCardCreator("Card");
        // 아이보리 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerIvoryBusinessCardCreator("Card");
        // 회색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerGrayBusinessCardCreator("Card");
        // 흰색 종이에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerWhiteBusinessCardCreator("Card");
        // 레이드지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLaidBusinessCardCreator("Card");
        // 린넨커버 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerLinenBusinessCardCreator("Card");
        // 스노우지 인쇄용지에 찍는 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSmoothBusinessCardCreator("Card");
        // 단면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerSingleSidedBusinessCardCreator("Card");
        // 양면 명함을 만드는 생성자나 메서드를 등록한다. 2개의 오버로딩된 메서드가 있으니 본인의 설계에 적합한 버전을 사용할 것.
        registry.registerDoubleSidedBusinessCardCreator("Card");
        // 장바구니를 만드는 생성자를 등록한다.
        registry.registerCartCreator("ShoppingCart");
        // 장바구니에 상품을 추가하는 메서드를 등록한다.
        registry.registerProductAdder("ShoppingCart", "addProduct");
        // 장바구니에서 상품을 제거하는 메서드를 등록한다.
        registry.registerProductRemover("ShoppingCart", "removeProduct");
        // 장바구니에서 총액을 구해오는 메서드를 등록한다.
        registry.registerTotalPriceGetter("ShoppingCart", "getAllPrice");
        // 가로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerTextApertureAdder("Banner", "addAperture");
        // 가로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBannerImageApertureAdder("Banner", "addAperture");
        // 세로 방향 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerTextApertureAdder("Banner", "addAperture");
        // 세로 방향 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBannerImageApertureAdder("Banner", "addAperture");
        // 반사 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerGlossBannerTextApertureAdder("Banner", "addAperture");
        // 반사 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerGlossBannerImageApertureAdder("Banner", "addAperture");
        // 스크림 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerScrimBannerTextApertureAdder("Banner", "addAperture");
        // 스크림 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerScrimBannerImageApertureAdder("Banner", "addAperture");
        // 메쉬 배너에 문구를 추가하는 메서드를 등록한다.
        registry.registerMeshBannerTextApertureAdder("Banner", "addAperture");
        // 메쉬 배너에 사진을 추가하는 메서드를 등록한다.
        registry.registerMeshBannerImageApertureAdder("Banner", "addAperture");
        // 가로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinnessCardTextApertureAdder("Card", "addAperture");
        // 가로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLandscapeBusinnessCardImageApertureAdder("Card", "addAperture");
        // 세로 방향 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinnessCardTextApertureAdder("Card", "addAperture");
        // 세로 방향 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerPortraitBusinnessCardImageApertureAdder("Card", "addAperture");
        // 아이보리 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinnessCardTextApertureAdder("Card", "addAperture");
        // 아이보리 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerIvoryBusinnessCardImageApertureAdder("Card", "addAperture");
        // 회색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerGrayBusinnessCardTextApertureAdder("Card", "addAperture");
        // 회색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerGrayBusinnessCardImageApertureAdder("Card", "addAperture");
        // 흰색 종이에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinnessCardTextApertureAdder("Card", "addAperture");
        // 흰색 종이에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerWhiteBusinnessCardImageApertureAdder("Card", "addAperture");
        // 레이드지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLaidBusinnessCardTextApertureAdder("Card", "addAperture");
        // 레이드지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLaidBusinnessCardImageApertureAdder("Card", "addAperture");
        // 린넨커버 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerLinenBusinnessCardTextApertureAdder("Card", "addAperture");
        // 린넨커버 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerLinenBusinnessCardImageApertureAdder("Card", "addAperture");
        // 스노우지 인쇄용지에 찍는 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinnessCardTextApertureAdder("Card", "addAperture");
        // 스노우지 인쇄용지에 찍는 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSmoothBusinnessCardImageApertureAdder("Card", "addAperture");
        // 단면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinnessCardTextApertureAdder("Card", "addAperture");
        // 단면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerSingleSidedBusinnessCardImageApertureAdder("Card", "addAperture");
        // 양면 명함에 문구를 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("Card", "addAperture");
        // 양면 명함에 사진을 추가하는 메서드를 등록한다.
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("Card", "addAperture");
    }
}
