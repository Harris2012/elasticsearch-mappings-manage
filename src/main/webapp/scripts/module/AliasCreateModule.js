function AliasCreateModule(ElasticsearchManageService, $convertor) {

    function function_link(scope, element, attrs) {

        function alias_empty_callback(response, callback) {
            if (response.status != 1) {
                return;
            }
            if (callback != null) {
                callback();
            }
        }

        scope.clusterId = Number(attrs.clusterId);
        scope.documentId = Number(attrs.documentId);

        ElasticsearchManageService.alias_empty({}).then(alias_empty_callback);
    }

    function function_controller($scope) {

        function api_confirm_create(createSuccessCallback) {

            $scope.waiting = true;
            $scope.message = null;

            var request = {};
            var requestItem = request.item = {};
            request.clusterId = $scope.clusterId;
            request.documentId = $scope.documentId;
            requestItem.name = $scope.item.name;

            ElasticsearchManageService.alias_create(request).then(function (response) {
                alias_create_callback(response, createSuccessCallback);
            });
        }

        function alias_create_callback(response, createSuccessCallback) {

            $scope.waiting = false;

            if (response.status != 1) {
                $scope.message = response.message;
                return;
            }

            if (createSuccessCallback != null) {
                createSuccessCallback();
            }
        }

        $scope.api = {};
        $scope.api.confirmCreate = api_confirm_create;
    }

    return {
        restrict: 'E',
        templateUrl: 'scripts/module/AliasCreateModule.html?v=' + window.releaseNo,
        replace: true,
        link: function_link,
        controller: function_controller,
        scope: {
            api: '='
        }
    }
}
