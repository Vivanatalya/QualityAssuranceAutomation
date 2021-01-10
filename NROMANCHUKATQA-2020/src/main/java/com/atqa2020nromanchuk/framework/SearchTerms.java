package com.atqa2020nromanchuk.framework;

public enum SearchTerms {

    SHELF("lustigt"),
    BED("lozka"),
    CURTAINS("firanki"),
    FLOWERED_CURTAINS("leikny");

    private final String searchTerm;

    SearchTerms(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }
}
