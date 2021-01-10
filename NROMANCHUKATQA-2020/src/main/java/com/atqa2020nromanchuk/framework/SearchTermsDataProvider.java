package com.atqa2020nromanchuk.framework;

public class SearchTermsDataProvider {
    public static Object[][] getAllSearchTerms() {

        Object[][] searchTerms = new Object[4][1];
        searchTerms[0][0] = SearchTerms.SHELF.getSearchTerm();
        searchTerms[1][0] = SearchTerms.BED.getSearchTerm();
        searchTerms[2][0] = SearchTerms.CURTAINS.getSearchTerm();
        searchTerms[3][0] = SearchTerms.FLOWERED_CURTAINS.getSearchTerm();
        return searchTerms;
    }

//    public static Object[][] getAllURLs() {
//
//        Object[][] urls = new Object[3][3];
//        urls[0][0] = AmazonURLs.ABOUT_US_URL.getClazz();
//        urls[0][1] = AmazonURLs.ABOUT_US_URL.getUrl();
//        urls[0][2] = AmazonURLs.ABOUT_US_URL.getXpath();
//        urls[1][0] = AmazonURLs.CAREERS_URL.getClazz();
//        urls[1][1] = AmazonURLs.CAREERS_URL.getUrl();
//        urls[1][2] = AmazonURLs.CAREERS_URL.getXpath();
//        urls[2][0] = AmazonURLs.SELL_ON_AMAZON_URL.getClazz();
//        urls[2][1] = AmazonURLs.SELL_ON_AMAZON_URL.getUrl();
//        urls[2][2] = AmazonURLs.SELL_ON_AMAZON_URL.getXpath();
//        return urls;
//    }
}
