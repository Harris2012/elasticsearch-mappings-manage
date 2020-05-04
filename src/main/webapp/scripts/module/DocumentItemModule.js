function DocumentItemModule(ElasticsearchManageService) {

    function function_link(scope, element, attrs) {

        function document_item_callback(response) {
            scope.loaded = true;
            if (response.status != 1) {
                return;
            }
            scope.item = response.item;
        }

        scope.clusterId = attrs.clusterId;
        scope.id = Number(attrs.id);
        {
            var request = {};
            request.id = scope.id;
            ElasticsearchManageService.document_item(request).then(document_item_callback);
        }
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/DocumentItemModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {}
    }
}
