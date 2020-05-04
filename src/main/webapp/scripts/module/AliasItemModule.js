function AliasItemModule(ElasticsearchManageService) {

    function function_link(scope, element, attrs) {

        function alias_item_callback(response) {
            scope.loaded = true;
            if (response.status != 1) {
                return;
            }
            scope.item = response.item;
        }

        scope.clusterId = attrs.clusterId;
        scope.documentId = attrs.documentId;
        scope.id = Number(attrs.id);
        {
            var request = {};
            request.id = scope.id;
            ElasticsearchManageService.alias_item(request).then(alias_item_callback);
        }
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/AliasItemModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {}
    }
}
