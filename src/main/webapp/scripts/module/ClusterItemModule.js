function ClusterItemModule(ElasticsearchManageService) {

    function function_link(scope, element, attrs) {

        function cluster_item_callback(response) {
            scope.loaded = true;
            if (response.status != 1) {
                return;
            }
            scope.item = response.item;
        }

        scope.id = Number(attrs.id);
        {
            var request = {};
            request.id = scope.id;
            ElasticsearchManageService.cluster_item(request).then(cluster_item_callback);
        }
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/ClusterItemModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        scope: {}
    }
}
