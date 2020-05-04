function stateProviderConfig($stateProvider) {

    $stateProvider.state('app', { url: '/', template: '<ui-view></ui-view>' });

    $stateProvider.state('app.layout', {
        templateUrl: 'scripts/view/view_layout.html?v=' + window.releaseNo
    });

    $stateProvider.state('app.layout.default', {
        views: {
            'header': { templateUrl: 'scripts/view/view_header.html?v=' + window.releaseNo, controller: HeaderController },
            'main-menu': { templateUrl: 'scripts/view/view_menu.html?v=' + window.releaseNo },
            'main-body': { template: '<ui-view></ui-view>' }
        }
    });

    $stateProvider.state('app.layout.default.welcome', { url: 'welcome', templateUrl: 'scripts/view/view_welcome.html?v=' + window.releaseNo });

    $stateProvider.state('app.layout.default.cluster-list', { url: 'cluster-list', templateUrl: 'scripts/page/ClusterListPage.html?v=' + window.releaseNo, controller: ClusterListPage });

    $stateProvider.state('app.layout.default.document-list', { url: 'document-list/:clusterId', templateUrl: 'scripts/page/DocumentListPage.html?v=' + window.releaseNo, controller: DocumentListPage });

    $stateProvider.state('app.layout.default.field-list', { url: 'field-list/:clusterId/:documentId', templateUrl: 'scripts/page/FieldListPage.html?v=' + window.releaseNo, controller: FieldListPage });

    $stateProvider.state('app.layout.default.alias-list', { url: 'alias-list/:clusterId/:documentId', templateUrl: 'scripts/page/AliasListPage.html?v=' + window.releaseNo, controller: AliasListPage });

    $stateProvider.state('app.otherwise', {
        url: '*path',
        templateUrl: 'views/view_404.html?v=' + window.releaseNo
    });
}
