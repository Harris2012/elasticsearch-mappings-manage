var app = angular.module('app', ['ngResource', 'ui.router', 'ui.bootstrap', 'ui.sortable', 'ngCanos']);

app.factory(httpInterceptor);
app.config(httpProviderConfig);
app.config(stateProviderConfig);
app.config(urlRouterProviderConfig);

app.directive('buttonClusterCreateDialog', ButtonClusterCreateDialog);
app.directive('clusterItemModule', ClusterItemModule);
app.directive('clusterCreateModule', ClusterCreateModule);
app.directive('clusterUpdateModule', ClusterUpdateModule);
app.directive('clusterSimpleTable', ClusterSimpleTable);
app.directive('buttonDocumentCreateDialog', ButtonDocumentCreateDialog);
app.directive('documentItemModule', DocumentItemModule);
app.directive('documentCreateModule', DocumentCreateModule);
app.directive('documentUpdateModule', DocumentUpdateModule);
app.directive('documentSimpleTable', DocumentSimpleTable);
app.directive('buttonFieldCreateDialog', ButtonFieldCreateDialog);
app.directive('fieldItemModule', FieldItemModule);
app.directive('fieldCreateModule', FieldCreateModule);
app.directive('fieldUpdateModule', FieldUpdateModule);
app.directive('fieldSimpleTable', FieldSimpleTable);
app.directive('buttonAliasCreateDialog', ButtonAliasCreateDialog);
app.directive('aliasItemModule', AliasItemModule);
app.directive('aliasCreateModule', AliasCreateModule);
app.directive('aliasUpdateModule', AliasUpdateModule);
app.directive('aliasSimpleTable', AliasSimpleTable);

app.service('ElasticsearchManageService', ['$resource', '$q', '$state', ElasticsearchManageService]);
