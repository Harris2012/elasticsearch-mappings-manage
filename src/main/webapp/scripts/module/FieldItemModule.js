function FieldItemModule(ElasticsearchManageService) {

    function function_link(scope, element, attrs) {

        function field_item_callback(response) {
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
            ElasticsearchManageService.field_item(request).then(field_item_callback);
        }
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/FieldItemModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {}
    }
}
